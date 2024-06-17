import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Byte = scanner.nextInt();
        int longCount = Byte/4;
        for(int i = 0; i<longCount; i++)
            System.out.print("long ");
        System.out.println("int");
    }
}