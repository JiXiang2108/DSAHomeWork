import edu.princeton.cs.algs4.*;

public class Sum1 {
    public static void main(String[] args) {
        In in = new In("C:\\Users\\cattu\\DSA\\algs4-data\\8Kints.txt");
        int[] a = in.readAllInts();
        int n = a.length;
        for (int i = 0; i < n; i ++) {
            if (a[i] > 0) {
                for (int k = 0; k < n; k ++) {
                    if (a[i] + a[k] == 0) {
                        System.out.println(a[i] + " " + a[k]);
                    }
                }
            }
        }
    }
}