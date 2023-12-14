import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        Stack<String> stack = new Stack<>();
        stack.push("");
        for (int i = 0; i < q; i++) {
            int m = sc.nextInt();
            if (m == 1) {
                String s1 = sc.next();
                stack.push(stack.peek() + s1);
            } else if (m == 2) {
                int k = sc.nextInt();
                stack.push(stack.peek().substring(0, stack.peek().length() - k));
            } else if (m == 3) {
                int k = sc.nextInt();
                System.out.println(stack.peek().charAt(k - 1));
            } else {
                stack.pop();
            }
        }
    }
}