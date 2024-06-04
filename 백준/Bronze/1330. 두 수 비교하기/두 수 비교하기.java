import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] strings = string.split(" ");
        int A = Integer.parseInt(strings[0]);
        int B = Integer.parseInt(strings[1]);

        System.out.println(A>B?">":A<B?"<":"==");
    }
}