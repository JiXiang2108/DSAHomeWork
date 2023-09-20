public class MyList {
    MyNode head;

    public void removeFirst (String data) {
        if (head == null) return;
        if (head.data.equals(data)) {
            head = head.next;
            return;
        }
        MyNode p = head;
        while (p.next != null && !p.next.data.equals(data)) {
            p = p.next;
        }
        if (p.next != null) {
            p.next = p.next.next;
        }
    }

    public String toString() {
        return "[" + toString(head) +"]";
    }

    private String toString(MyNode node) {
        if (node == null) return "";
        return node.data + " " + toString(node.next);
    }

    public void append(String data) {
        head = append(data,head);
    }

    public MyNode append(String data, MyNode node) {
        if (node == null) return new MyNode(data, null);
        else {
            node.next = append(data, node.next);
            return node;
        }
    }
    public void old_append(String data) {
        if (head == null) head = new MyNode(data, null);
        else {

        }
    }

    public void removeLast() {
        if (head != null) head = removeLast(head);
    }

    private MyNode removeLast (MyNode node) {
        if (node.next == null) return null;
        node.next = removeLast(node.next);
        return node;
    }
}
