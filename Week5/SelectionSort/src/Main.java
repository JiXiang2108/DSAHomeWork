import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        int[] a = new int[1000];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int min;
        int q;
        for (int i = 0; i < n; i++) {
            min = a[i];
            q = i;
            for (int j = i; j < n ; j++) {
                if (a[j] < min) {
                    min = a[j];
                    q = j;
                }
            }
            int k = a[i];
            a[i] = min;
            a[q] = k;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}