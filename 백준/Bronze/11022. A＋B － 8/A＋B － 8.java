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
        String string = scanner.nextLine();
        int arrayLength = Integer.parseInt(string);

        ArrayList<Pair> list = new ArrayList<>();

        for (int i = 0; i < arrayLength; i++) {
            string = scanner.nextLine();
            String[] strings = string.split(" ");

            int A = Integer.parseInt(strings[0]);
            int B = Integer.parseInt(strings[1]);
            Pair pair = new Pair(A, B);
            list.add(pair);
        }
        for(int i = 0; i<arrayLength; i++){
            System.out.println("Case #"+(i+1)+": "+list.get(i).A+" + "+list.get(i).B+" = "+list.get(i).Sum());
        }
    }
}