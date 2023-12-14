/*

class Node
    int data;
    Node left;
    Node right;
*/
public static void levelOrder(Node root) {
        List<Node> q = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
        System.out.print(q.get(0).data + " ");
        if (q.get(0).left != null) q.add(q.get(0).left);
        if (q.get(0).right != null) q.add(q.get(0).right);
        q.remove(0);
        }
        }