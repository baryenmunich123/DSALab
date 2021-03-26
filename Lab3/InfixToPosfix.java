package DSA.Lab3;

import java.util.ArrayList;
import java.util.Stack;

public class InfixToPosfix {
    private String s;
    Stack<Integer> operandStack = new Stack<>();
    Stack<Character> operatorStack = new Stack<>();
    char[] numInChar = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    int[] num = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    char[] operator = { '+', '-', '*', '/' };

    public InfixToPosfix(String str) {
        this.s = str;
    }

    private void Computing() {
        int value = 0;
        int a = operandStack.pop();
        int b = operandStack.pop();
        char x = operatorStack.pop();
        switch (x) {
        case '+':
            value = b + a;
            break;
        case '-':
            value = b - a;
            break;
        case '*':
            value = b * a;
            break;
        case '/':
            value = b / a;
            break;
        default:
        }
        operandStack.push(value);
    }

    static int precedence(char c) {
        switch (c) {
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        case '^':
            return 3;
        }
        return -1;
    }

    public int Calculate() {
        int finalValue = 0;
        int digitNumber = 0;
        ArrayList<Integer> numDigit = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            // if character is a value
            if (Character.isDigit(s.charAt(i))) {
                for (int j = 0; j < 10; j++) {
                    if (s.charAt(i) == numInChar[j]) {
                        operandStack.push(num[j]);
                    }
                }
            } else {
                // if character is a operator
                for (int j = 0; j < 4; j++) {
                    if (s.charAt(i) == operator[j]) {
                        if (operatorStack.isEmpty() == true) {
                            operatorStack.push(operator[j]);
                        } else {
                            if (precedence(s.charAt(i)) >= precedence(operatorStack.peek())) {
                                operatorStack.push(s.charAt(i));
                            } else {
                                while (precedence(s.charAt(i)) < precedence(operatorStack.peek())
                                        && operatorStack.isEmpty() == false) {
                                    Computing();
                                    operatorStack.push(s.charAt(i));
                                }
                            }
                        }
                    }
                }
                if (s.charAt(i) == '(') {
                    operatorStack.push(s.charAt(i));
                }
                if (s.charAt(i) == ')') {
                    while (operatorStack.peek() != '(') {
                        Computing();
                    }
                    operatorStack.pop();
                }
            }
        }
        while (operatorStack.isEmpty() == false) {
            Computing();
        }
        finalValue = operandStack.pop();
        return finalValue;

    }
}
