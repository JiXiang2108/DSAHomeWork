import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Union {
    int v;
    int weight;
    public Union(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }
}

class UnionComparator implements Comparator<Union> {
    @Override
    public int compare(Union o1, Union o2) {
        if (o1.weight == -1) return 1;
        if (o2.weight == -1) return -1;
        if (o1.weight < o2.weight) return -1;
        if (o1.weight == o2.weight) return 0;
        return 1;
    }
}

class Result {

    /*
     * Complete the 'shortestReach' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER s
     */
    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        // Write your code here
        Queue<Union> q = new PriorityQueue<Union>(n, new UnionComparator());
        ArrayList<HashMap<Integer, Integer>> e = new ArrayList<>();
        boolean[] min = new boolean[n + 1];
        int[] reach = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            reach[i] = -1;
        }
        reach[s] = 0;
        for (int i = 0; i < n + 1; i++) e.add(new HashMap<>());
        for (int i = 0; i < edges.size(); i++) {
            int v1 = edges.get(i).get(0);
            int v2 = edges.get(i).get(1);
            int weight = edges.get(i).get(2);
            if (!e.get(v1).containsKey(v2) || e.get(v1).get(v2) > weight) e.get(v1).put(v2, weight);
            if (!e.get(v2).containsKey(v1) || e.get(v2).get(v1) > weight) e.get(v2).put(v1, weight);
        }
        Union union = new Union(s, reach[s]);
        q.add(union);
        while (!q.isEmpty()) {
            union = q.poll();
            if (min[union.v] == true) continue;
            HashMap<Integer, Integer> map = e.get(union.v);
            for (Integer neighbor : map.keySet()) {
                int road = map.get(neighbor);
                if(reach[neighbor] == -1 || road + union.weight < reach[neighbor]) {
                    reach[neighbor] = road + union.weight;
                    q.add(new Union(neighbor, reach[neighbor]));
                }
            }
            min[union.v] = true;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++)
        {
            if (i != s) list.add(reach[i]);
        }
        return list;
    }


}

public class Solution {



    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int m = Integer.parseInt(firstMultipleInput[1]);

            Set<List<Integer>> edges = new HashSet<>();

            IntStream.range(0, m).forEach(i -> {
                try {
                    edges.add(
                            Stream.of(bufferedReader.readLine().split(" "))
                                    .map(Integer::parseInt)
                                    .collect(toList())
                    );
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            int s = Integer.parseInt(bufferedReader.readLine().trim());

            List<List<Integer>> edgeList = new ArrayList<>();
            edgeList.addAll(edges);
            List<Integer> result = Result.shortestReach(n, edgeList, s);

            for (int i = 0; i < result.size(); i++) {
                bufferedWriter.write(String.valueOf(result.get(i)));

                if (i != result.size() - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
