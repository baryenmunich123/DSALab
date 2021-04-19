package Lab5;

import java.util.Scanner;

public class problem7 {
    public static int findsum (int a[], int n){
        if (n == 0)
            return 0;
        else 
            return n + findsum(a,n - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int [n];
        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        System.out.println(findsum(a, n));
    }
}
