import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] distances = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] cities = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sumDistance = 0;
        int minPrice = cities[0];
        int total = 0;
        for(int i = 0; i<n-1; i++) {
            if(cities[i] < minPrice) {
                total+=sumDistance;
                minPrice = cities[i];
                sumDistance = 0;
            }
            sumDistance += minPrice*distances[i];
        }
        total+=sumDistance;
        System.out.println(total);
    }
}
