import java.util.Scanner;

public class Main {
    public static int[] root = new int[1000];

    public static int get_root(int x) {
        if (root[x] < 0) return x;
        return get_root(root[x]);
    }

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int res = v;
        for (int i = 1; i <= v; i ++) {
            root[i] = -1;
        }
        for (int i = 1; i <= e; i ++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            x = get_root(x);
            y = get_root(y);
            if (x != y) {
                if (root[x] < root[y]) {
                    int m = root[x];
                    root[x] = root[y];
                    root[y] = m;
                }
                root[y] += root[x];
                root[x] = y;
                res--;
            }
        }
        System.out.println(res);
    }
}