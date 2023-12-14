/* Class node is defined as :
class Node
    int val;    //Value
    int ht;        //Height
    Node left;    //Left child
    Node right;    //Right child

*/
static int get_height(Node root) {
        if (root == null) return -1;
        return root.ht;
        }
static Node rotate_left(Node root) {
        Node temp = root.left;
        root.left = temp.right;
        temp.right = root;
        update_height(root);
        update_height(temp);
        return temp;
        }
static Node rotate_right(Node root) {
        Node temp = root.right;
        root.right = temp.left;
        temp.left = root;
        update_height(root);
        update_height(temp);
        return temp;
        }
static void update_height(Node root) {
        root.ht = Math.max(get_height(root.left), get_height(root.right)) + 1;
        }
static Node insert(Node root,int val)
        {
        if (root == null) {
        root = new Node();
        root.val = val;
        root.left = null;
        root.right = null;
        root.ht = 0;
        } else if (val < root.val) {
        root.left = insert(root.left, val);
        if (get_height(root.left) - get_height(root.right) == 2) {
        if (val > root.left.val) {
        root.left = rotate_right(root.left);
        }
        root = rotate_left(root);
        }
        } else {
        root.right = insert(root.right, val);
        if (get_height(root.right) - get_height(root.left) == 2) {
        if (val < root.right.val) {
        root.right = rotate_left(root.right);
        }
        root = rotate_right(root);
        }
        }
        update_height(root);
        return root;
        }