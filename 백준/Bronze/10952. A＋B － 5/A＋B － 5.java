import java.util.*;

class Pair {
    int A;
    int B;

    Pair(int A, int B) {
        this.A = A;
        this.B = B;
    }

    int Sum() {
        return A + B;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string;
        while(true){
            string = scanner.nextLine();
            String[] strings = string.split(" ");

            int A = Integer.parseInt(strings[0]);
            int B = Integer.parseInt(strings[1]);
            
            Pair pair = new Pair(A, B);
            if(pair.Sum() == 0)
                break;
            System.out.println(pair.Sum());
        }
    }
}