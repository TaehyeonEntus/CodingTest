import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stars = scanner.nextInt();
        for(int j = 0; j<stars; j++){
            for(int i = 0; i<=j; i++)
                System.out.print("*");
            System.out.println("");
        }
    }
}