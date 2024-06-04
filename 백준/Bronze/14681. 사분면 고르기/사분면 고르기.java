import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        System.out.println(x>0&&y>0?1:x<0&&y>0?2:x<0&&y<0?3:4);
    }
}