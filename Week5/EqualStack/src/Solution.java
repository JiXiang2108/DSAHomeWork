import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        int n1 = h1.size();
        int n2 = h2.size();
        int n3 = h3.size();
        int s1 = 0, s2 = 0, s3 = 0;
        for (int i = 0; i < n1; i++) s1 += h1.get(i);
        for (int i = 0; i < n2; i++) s2 += h2.get(i);
        for (int i = 0; i < n3; i++) s3 += h3.get(i);
        int n = 0;
        int l1 = 0, l2 = 0, l3 = 0;
        while (true) {
            if (l1 == n1 || l2 == n2 || l3 == n3) {
                n = 0;
                break;
            }
            if (s1 == s2 && s2 == s3) {
                n = s1;
                break;
            }
            if (s1 >= s2 && s1 >= s3) {
                s1 -= h1.get(l1);
                l1++;
            } else if (s2 >= s3 && s2 >= s1) {
                s2 -= h2.get(l2);
                l2++;
            } else if (s3 >= s1 && s3 >= s2) {
                s3 -= h3.get(l3);
                l3++;
            }

        }
        return n;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
