import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] string = s.split(" ");
        long answer = 0;

        for(String a : string)
            answer += Long.parseLong(a);

        System.out.println(answer);
    }
}