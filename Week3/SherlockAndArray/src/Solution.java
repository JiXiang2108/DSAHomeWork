/* Watson gives Sherlock an array of integers.
His challenge is to find an element of the array such that the sum of all elements
to the left is equal to the sum of all elements to the right.
 */
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'balancedSums' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static String balancedSums(List<Integer> arr) {
        int n = arr.size();
        int sum = 0;
        for (int i = 0; i < n; i ++) {
            sum += arr.get(i);
        }
        sum = sum / 2;
        int s = 0;
        int k = 0;
        for (int i = 0; i < n; i ++) {
            if (s <= sum) {
                s += arr.get(i);
                k ++;
            }
            else {
                break;
            }
        }
        for (int i = k - 1; i < n; i ++) {
            s -= arr.get(i);
        }
        if (s == 0) return "YES";
        else return "NO";

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = Result.balancedSums(arr);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
