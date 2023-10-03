import com.sun.jdi.connect.IllegalConnectorArgumentsException;

public class MyQueue<Item> {
    private Item[] a = (Item[]) (new Object[1]);
    private int head = 0, n = 0;

    public MyQueue() {
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void enqueue (Item item) {
        if (item == null) throw new IllegalConnectorArgumentsException();
        if (n == a.length) resize (2 *a.length);
        a[rankToIndex(n)] = item;
        n ++;
    }
}
