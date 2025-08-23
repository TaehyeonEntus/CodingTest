import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //큰 value를 가지는 jewel 우선 정렬
        PriorityQueue<Jewel> jewelPQ = new PriorityQueue<>(Comparator.comparingInt(Jewel::getPrice).reversed());

        TreeMap<Integer, Integer> bagMap = new TreeMap<>();

        int[] arr;
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        int k = arr[1];
        for (int i = 0; i < n; i++) {
            int[] jewel = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            jewelPQ.add(new Jewel(jewel[0], jewel[1]));
        }

        for (int i = 0; i < k; i++) {
            int bag = Integer.parseInt(br.readLine());
            bagMap.put(bag, bagMap.getOrDefault(bag, 0) + 1);
        }


        long total = 0;
        while (!jewelPQ.isEmpty()) {
            Jewel jewel = jewelPQ.poll();
            Integer bag = bagMap.ceilingKey(jewel.weight); // jewel.weight 이상인 최소 가방 키
            if (bag != null) {
                total += jewel.price;
                int count = bagMap.get(bag);
                if (count == 1)
                    bagMap.remove(bag);
                else
                    bagMap.put(bag, count - 1);
            }
        }
        System.out.println(total);
    }

    public static class Jewel {
        int weight;
        int price;

        public Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        public int getPrice() {
            return price;
        }
    }
}

