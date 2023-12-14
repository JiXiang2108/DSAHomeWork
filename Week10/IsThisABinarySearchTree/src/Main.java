/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
static List<Integer> a = new ArrayList<Integer>();
        boolean checkBST(Node root) {
        check(root);
        for (int i = 0; i < a.size() - 1; i++) if (a.get(i) >= a.get(i + 1)) return false;
        return true;
        }
public static void check(Node root) {
        if (root == null) return;
        check(root.left);
        a.add(root.data);
        check(root.right);
        }