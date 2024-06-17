import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] strings = string.split(" ");
        int hour = Integer.parseInt(strings[0]);
        int minute = Integer.parseInt(strings[1]);
        int cookingMinute = scanner.nextInt();
        
        minute += cookingMinute;
        hour += minute/60;
        minute %= 60;
        
        hour%=24;
        System.out.println(hour+" "+minute);
    }
}