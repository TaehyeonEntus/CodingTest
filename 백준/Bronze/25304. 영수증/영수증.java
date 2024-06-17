import java.util.*;

class Pair {
    int Price;
    int Count;

    Pair(int Price, int Count) {
        this.Price = Price;
        this.Count = Count;
    }

    int Sum() {
        return Price * Count;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string;
        int myPrice = 0;
        
        string = scanner.nextLine();
        int totalPrice = Integer.parseInt(string);

        string = scanner.nextLine();
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
            myPrice += list.get(i).Sum();
        }
        if(myPrice == totalPrice)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}