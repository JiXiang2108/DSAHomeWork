import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int[] a = new int[100005];
    public static List<Integer> b = new ArrayList<Integer>();
    public static void mergeSort(int[] a, int l, int r) {
        if (l == r) return;
        else {
            int mid = l + (l - r) / 2;
            mergeSort(a, l, mid);
            mergeSort(a, mid + 1, r);
            while (l <= mid && mid + 1 <= r) {
                if (a[l] <= a[mid]) {
                    b.add(a[l]);
                    l++;
                } else {
                    b.add(a[mid]);
                    mid++;
                }
            }
            while (l <= a[mid]) {
                b.add(a[l]);
                l++;
            }
            while (mid <= r) {
                b.add(a[mid]);
                mid++;
            }
            for (int i = 0; i < l - r + 1; i++) {
                a[l + i] = b.get(i);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i ++) {
            a[i] = sc.nextInt();
        }
        mergeSort(a, 1, n);
        for (int i = 1; i <= n; i ++) {
            System.out.println(a[i]);
        }
    }
}