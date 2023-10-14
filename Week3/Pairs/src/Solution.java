/*Given an array of integers and a target value,
determine the number of pairs of array elements that have a difference
equal to the target value.
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.Collections;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'pairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

    public static int pairs(int k, List<Integer> arr) {
        // Write your code here
        int sum = 0;
        int n = arr.size();
        Collections.sort(arr);
        int d = 1;
        for (int i = 0; i < n - 1; i ++) {
            int num = k + arr.get(i);
            int c = n - 1;
            while (d <= c) {
                int mid = (d + c) / 2;
                if (arr.get(mid) == num) {
                    sum ++;
                    d = mid;
                    break;
                }
                else if (arr.get(mid) < num) {
                    d = mid + 1;
                }
                else {
                    c = mid - 1;
                }
            }
        }
        return sum;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
