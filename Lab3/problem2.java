package Lab3;

public class problem2 {
    public static void main(String[] args) {
        String str = "1 + 2 - 2 * 3 *4 -5";
        InfixToPosfix obj = new InfixToPosfix(str);
        System.out.println(String.format("The result of (%s) is: %d", str, obj.Calculate()));
        // obj.Calculate();
    }
}
