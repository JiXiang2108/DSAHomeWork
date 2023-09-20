public class MyNode {
    String data;
    MyNode next;

    public MyNode (String data) {
        this.data = data;
    }

    public MyNode (String data, MyNode next) {
        this.data = data;
        this.next = next;
    }
}
