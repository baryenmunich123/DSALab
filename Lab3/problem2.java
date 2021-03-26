package DSA.Lab3;

public class problem2 {
    public static void main(String[] args) {
        String str = "1+1+1";
        InfixToPosfix obj = new InfixToPosfix(str);
        System.out.println(String.format("The result of (%s) is: %d", str, obj.Calculate()));
    }
}
