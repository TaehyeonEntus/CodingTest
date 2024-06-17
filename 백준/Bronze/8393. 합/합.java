import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += i;
        }
        System.out.println(answer);
    }
}
