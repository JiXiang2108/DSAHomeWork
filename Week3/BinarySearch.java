import java.util.Scanner;
import java.util.Arrays;

public class BinarySearch {
    public static int binarySearch(int[] a, int number) {
        int n = a.length;
        int d = 0;
        int c = n - 1;
        while (d <= c) {
            int mid = (d + c) / 2;
            if (a[mid] == number)
                return mid;
            else if (a[mid] < number) {
                d = mid + 1;
            } else {
                c = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Nhập number, n và mảng a");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        Arrays.sort(a);
        System.out.println(binarySearch(a, number));
    }
}
