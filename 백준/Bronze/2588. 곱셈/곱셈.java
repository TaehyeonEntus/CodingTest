import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int answer = a * b;
        System.out.println(a * (b % 10));
        b /= 10;
        System.out.println(a * (b % 10));
        b /= 10;
        System.out.println(a * (b % 10));
        System.out.println(answer);
    }
}