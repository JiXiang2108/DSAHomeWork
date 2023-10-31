import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */
    public static int myQ(List<Integer> A) {
        int value = A.get(0);
        int index = 0;
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) < value) {
                value = A.get(i);
                index = i;
            }
        }
        return index;
    }
    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        int ans = 0;
        while(true) {
            Integer u = A.remove(myQ(A));
            if (u >= k) {
                break;
            } else {
                if (A.size() == 0) {
                    ans = -1;
                    break;
                } else {
                    Integer v = A.remove(myQ(A));
                    A.add(2*v + u);
                    ans++;
                }
            }
        }
        return ans;
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
