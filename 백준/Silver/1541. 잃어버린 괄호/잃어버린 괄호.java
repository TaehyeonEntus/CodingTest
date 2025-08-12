import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splitByMinus = br.readLine().split("-");

        List<Integer> list = new ArrayList<>();
        for(String s : splitByMinus) {
            String[] numbers = s.split("\\+");
            int total = 0;
            for(String number : numbers) {
                total += Integer.parseInt(number);
            }
            list.add(total);
        }
        int sum = 0;

        for(Integer i : list) {
            sum -= i;
        }

        System.out.println(sum+(2*list.get(0)));
    }
}
