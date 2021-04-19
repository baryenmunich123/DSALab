package Lab5;



import java.util.Scanner;

public class problem6 {
    public static int findmin(int a[], int n){
        int min = a[n - 1];
        if (n == 1){
            return min; // min = a[0]
        } else{
            int remainMin = findmin(a, n - 1);
            if (remainMin < min)
                return remainMin;
        }
            return min;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int a[] = new int [n];
        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        System.out.println(findmin(a, n));
    }
}
