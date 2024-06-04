import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();
        System.out.println(answer>=90?"A":answer>=80?"B":answer>=70?"C":answer>=60?"D":"F");
    }
}