import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[100];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int p = a[n - 1];
        int i = 0;
        for (int j = 0; j < n - 1; j++) {
            if (a[j] < p) {
                int m = a[i];
                a[i] = a[j];
                a[j] = m;
                i++;
                for (int q = 0; q < n - 1; q++) {
                    System.out.print(a[q] + " ");
                }
                System.out.println();
            }
        }
        int m = a[n - 1];
        a[n - 1] = a[i];
        a[i] = m;
        for (int q = 0; q < n - 1; q++) {
            System.out.print(a[q] + " ");
        }
        System.out.println();
    }
}
