public class Main {
    public static void main(String[] args) {
        MyList list = new MyList();
        list.append("One");
        list.append("Two");
        list.append("Three");
        list.append("One");
        System.out.println(list); //One Two Three One

        list.removeFirst("One");
        System.out.println(list);  //Two Three One
        list.removeFirst("One");
        System.out.println(list);  //Two Three
        list.removeFirst("One");
        System.out.println(list);  //Two Three

        list.removeFirst("Two");
        System.out.println(list);  //Three
        list.removeFirst("Three");
        System.out.println(list);  //[]
        list.removeFirst("Three");
        System.out.println(list);
    }
}