import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */





public class Solution {
    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        int N = a.size();
        Queue<Double> maxPQ = new PriorityQueue<Double>(N/2 + 1, Collections.reverseOrder());
        Queue<Double> minPQ = new PriorityQueue<Double>(N/2 + 1);
        List<Double> b = new ArrayList<Double>();
        for (int i = 0; i < N; i++) {
            int j = (int)a.get(i);
            double l = (double)j;
            maxPQ.add(l);
            if (maxPQ.size() > minPQ.size() + 1) {
                minPQ.add(maxPQ.remove());
            }
            if (minPQ.size() > 0 && maxPQ.peek() > minPQ.peek()) {
                double u = minPQ.remove();
                double v = maxPQ.remove();
                maxPQ.add(u);
                minPQ.add(v);
            }
            if (i % 2 == 0) b.add(maxPQ.peek());
            else {
                b.add((maxPQ.peek() + minPQ.peek()) / 2);
            }
        }
        return b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            a.add(k);
        }
        List<Double> b = new ArrayList<Double>();
        b = runningMedian(a);
        for (int i = 0; i < b.size(); i++) System.out.println(b.get(i));
    }
}
