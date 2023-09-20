import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.UF;
import java.util.Scanner;

public class UFClient2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a = N;
        int b = 0;
        UF uf = new UF(N);
        while (!sc.hasNextInt()) {
            if (a > 1) {
                int p = sc.nextInt();
                int q = sc.nextInt();
                if (!uf.connected(p, q)) {
                    uf.union(p, q);
                    a --;
                    b ++;
                }
            }
            else {
                StdOut.println(b);
                System.exit(0);
            }
        }
        StdOut.println("FAILED");
    }
}
