import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> upperPq = new PriorityQueue<>();
        PriorityQueue<Integer> lowerPq = new PriorityQueue<>(Collections.reverseOrder());
        int[] arr = new int[t];

        for(int i = 0; i < t; i++) {
            int a = Integer.parseInt(br.readLine());
            upperPq.add(a);

            if(upperPq.size() - 1 > lowerPq.size()) {
                lowerPq.add(upperPq.poll());
            }

            if(!upperPq.isEmpty() && !lowerPq.isEmpty() && (upperPq.peek() < lowerPq.peek())){
                int temp1 = upperPq.poll();
                int temp2 = lowerPq.poll();
                upperPq.add(temp2);
                lowerPq.add(temp1);
            }

            if(i%2==0){
                System.out.println(upperPq.peek());
            }else {
                System.out.println(lowerPq.peek());
            }
        }

    }
}