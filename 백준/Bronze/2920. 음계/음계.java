import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Integer[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).boxed().toArray(Integer[]::new);

        Integer[] asc = arr.clone();
        Integer[] desc = arr.clone();

        Arrays.sort(asc, Comparator.naturalOrder());
        Arrays.sort(desc, Comparator.reverseOrder());

        if(Arrays.equals(arr, asc))
            System.out.println("ascending");
        else if(Arrays.equals(arr, desc))
            System.out.println("descending");
        else
            System.out.println("mixed");
    }
}

