package Lab3;

import java.util.ArrayList;
import java.util.Stack;

public class InfixToPosfix {
    private String s;
    Stack<Integer> operandStack = new Stack<>();
    Stack<String> operatorStack = new Stack<>();
    String[] operator = { "+", "-", "*", "/" };
    ArrayList<String> arr = new ArrayList<>();

    public InfixToPosfix(String str) {
        this.s = str;
        String value = "";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                value += s.charAt(i);
            } else if (s.charAt(i) != ' ') {
                arr.add(value);
                value = "";
                arr.add(String.valueOf(s.charAt(i)));
            }
        }
        arr.add(value);
    }

    private void Computing() {
        int value = 0;
        int a = operandStack.pop();
        int b = operandStack.pop();
        String x = operatorStack.pop();
        switch (x) {
        case "+":
            value = b + a;
            break;
        case "-":
            value = b - a;
            break;
        case "*":
            value = b * a;
            break;
        case "/":
            value = b / a;
            break;
        default:
        }
        operandStack.push(value);
    }

    static int precedence(String c) {
        switch (c) {
        case "+":
        case "-":
            return 1;
        case "*":
        case "/":
            return 2;
        case "^":
            return 3;
        }
        return -1;
    }

    public boolean CheckInteger(String a) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (Character.isDigit(a.charAt(i))) {
                count++;
            }
        }
        if (count == a.length()) {
            return true;
        }
        return false;
    }

    public int Calculate() {
        int finalValue = 0;
        for (int i = 0; i < arr.size(); i++) {
            // if character is a value
            if (CheckInteger(arr.get(i)) == true) {
                operandStack.push(Integer.parseInt(arr.get(i)));
            } else {
                // if character is a operator
                if (operatorStack.isEmpty() == true) {
                    operatorStack.push(arr.get(i));
                } else {
                    if (precedence(arr.get(i)) >= precedence(operatorStack.peek())) {
                        operatorStack.push(arr.get(i));
                    } else {
                        while (precedence(arr.get(i)) < precedence(operatorStack.peek())
                                && operatorStack.isEmpty() == false) {
                            Computing();
                            operatorStack.push(arr.get(i));
                        }
                    }
                }
            }
            if (arr.get(i) == "(") {
                operatorStack.push(arr.get(i));
            }
            if (arr.get(i) == ")") {
                while (operatorStack.peek() != "(") {
                    Computing();
                }
                operatorStack.pop();
            }
        }
        while (operatorStack.isEmpty() == false && operandStack.isEmpty() == false) {
            Computing();
        }
        finalValue = operandStack.pop();
        return finalValue;
    }
}
