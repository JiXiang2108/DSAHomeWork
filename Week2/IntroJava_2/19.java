import java.util.random;
import java.util.Scanner;
public class random {
    public static void main(String[]args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int ranNum = rand.nextInt(b) + a;
        System.out.println(ranNum);
    }
}
