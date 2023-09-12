import edu.princeton.cs.algs4.*;
import java.util.Arrays;
public class Sum3 {
    public static void main(String[]args) {
        In in = new In("C:\\Users\\cattu\\DSA\\algs4-data\\8Kints.txt");
        int[] a = in.readAllInts();
        int n = a.length;
        Arrays.sort(a);
        int q = 0;
        while (q < n - 1) {
            if (a[q] == a[q + 1]) {
                for (int k = q + 1; k < n - 1; k ++) a[k] = a[k + 1];
                n --;
                q --;
            }
            q ++;
        }
        for (int i = 0; i < n - 2; i ++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int x = a[i] + a[j] + a[k];
                if (x == 0) {
                    System.out.println(a[i] + " " + a[j] + " " + a[k]);
                    j += 1;
                    k -= 1;
                }
                else if (x < 0) {
                    j += 1;
                }
                else {
                    k -= 1;
                }
            }
        }
    }
}
