package Lab5;

import java.util.Scanner;

public class problem8 {
    public static int gcd (int p , int q){
        if (q == 0){
            return p;
        } else{
            return gcd(q,p % q);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        System.out.println(gcd(p, q));
    }
}
