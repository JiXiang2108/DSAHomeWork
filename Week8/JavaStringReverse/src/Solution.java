import java.util.*;

public class Solution {
    public static String check(String A) {
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != (A.charAt(A.length() - 1 - i))) return "No";
        }
        return "Yes";
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        System.out.print(check(A));
    }
}



