/*Given a sorted list with an unsorted number  in the rightmost cell,
can you write some simple code to insert  into the array so that it remains sorted?
 */
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        for (int i = 1; i < arr.size(); i++) {
            int value = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j) > value) {
                arr.set(j + 1, arr.get(j));
                j--;
                for (int k = 0; k < arr.size(); k++) {
                    System.out.print(arr.get(k) + " ");
                }
                System.out.println();
            }
            arr.set(j + 1, value);
        }
        for (int k = 0; k < arr.size(); k++) {
            System.out.print(arr.get(k) + " ");
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
