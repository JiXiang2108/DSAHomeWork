/*Sorting is useful as the first step in many different tasks.
The most common task is to make finding things easier,
but there are other uses as well. In this case,
it will make it easier to determine which pair or pairs of
elements have the smallest absolute difference between them.
 */
import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.Collections;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        int n = arr.size();
        int min = arr.get(n - 1);
        for (int i = 1; i < n; i ++) {
            if (arr.get(i) - arr.get(i - 1) < min) min = arr.get(i) - arr.get(i - 1);
        }
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < n - 1; i ++) {
            if (arr.get(i + 1) - arr.get(i) == min) {
                a.add(arr.get(i));
                a.add(arr.get(i + 1));
            }
        }
        return a;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.closestNumbers(arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
