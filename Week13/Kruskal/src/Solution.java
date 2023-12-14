import java.util.*;


class Union {
    int v1;
    int v2;
    int weight;
    public Union(int v1, int v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }
}

class UnionComparator implements Comparator<Union> {
    @Override
    public int compare(Union o1, Union o2) {
        if (o1.weight < o2.weight) return -1;
        else if (o1.weight == o2.weight) return 0;
        else return 1;
    }
}
class Result {
    public static int root[] = new int[1000005];
    public static int get_root(int x){
        if(root[x] < 0) return x;
        return root[x] = get_root(root[x]);
    }

    /*
     * Complete the 'kruskals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts WEIGHTED_INTEGER_GRAPH g as parameter.
     */

    /*
     * For the weighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i]. The weight of the edge is <name>Weight[i].
     *
     */
    public static long kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        Queue<Union> q = new PriorityQueue<Union>(new UnionComparator());
        for(int i = 0; i <= gNodes; i++){
            root[i] = -1;
        }
        for (int i = 0; i < gFrom.size(); i++) {
            Union union = new Union(gFrom.get(i), gTo.get(i), gWeight.get(i));
            q.add(union);
        }
        long s = 0;
        int e = 0;
        while (e < gNodes - 1) {
            Union union = q.poll();
            if (get_root(union.v1) != get_root(union.v2)) {
                int x = get_root(union.v1);
                int y = get_root(union.v2);
                if(x != y) {
                    if (root[x] < root[y]) {
                        int z = x;
                        x = y;
                        y = z;
                    }
                    root[y] += root[x];
                    root[x] = y;
                    s += union.weight;
                    e++;
                }
            }
        }
        return s;
    }

}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int gNodes = sc.nextInt();
        int gEdges = sc.nextInt();

        List<Integer> gFrom = new ArrayList<>();
        List<Integer> gTo = new ArrayList<>();
        List<Integer> gWeight = new ArrayList<>();

        for (int i = 0; i < gEdges; i++) {
            gFrom.add(sc.nextInt());
            gTo.add(sc.nextInt());
            gWeight.add(sc.nextInt());
        }

        long res = Result.kruskals(gNodes, gFrom, gTo, gWeight);
        System.out.println(res);
    }
}