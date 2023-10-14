/*It is New Year's Day and people are in line for the Wonderland rollercoaster ride.
Each person wears a sticker indicating their initial position in the queue from  to .
 Any person can bribe the person directly in front of them to swap positions,
 but they still wear their original sticker.
 One person can bribe at most two others.
 Determine the minimum number of bribes that took place to get to a given queue order.
 Print the number of bribes, or, if anyone has bribed more than two people,
 print Too chaotic
 */


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int n = q.size();
        for (int i = 0; i < n; i ++) {
            if (q.get(i) - i > 3) {
                System.out.println("Too chaotic");
                return;
            }
        }
        int i = 0;
        int count = 0;
        while (i < n) {
            if (q.get(i) > i + 1) {
                int c = q.get(i);
                q.set(i, q.get(i + 1));
                q.set(i + 1, c);
                i --;
                count ++;
            }
            i ++;
        }
        System.out.println(count);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
