import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        sc.nextLine();

        String b = sc.nextLine();
        String[] s = b.split(" ");

        int c = sc.nextInt();
        sc.nextLine();

        int count = 0;
        for(String str : s){
            if(Integer.parseInt(str)==c)
                count++;
        }
        System.out.println(count);
    }
}