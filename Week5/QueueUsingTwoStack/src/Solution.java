import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < n; i++) {
            k = sc.nextInt();
            if (k == 1) {
                k = sc.nextInt();
                a.add(k);
            } else if (k == 2) {
                a.remove(0);
            } else if (k == 3) System.out.println(a.get(0));
        }
    }
}
