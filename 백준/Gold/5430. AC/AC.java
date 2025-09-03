import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> queue = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            queue.clear();
            boolean reversed = false;
            String commands = br.readLine();
            int length = Integer.parseInt(br.readLine());
            String strNumbers =  br.readLine();
            int[] numbers = new int[length];
            if(length>0){
                numbers = Arrays.stream(strNumbers.substring(1, strNumbers.length() - 1).split(",")).mapToInt(Integer::parseInt).toArray();
                for (int N : numbers)
                    queue.add(N);
            }
            boolean error = false;
            for(char c : commands.toCharArray()){
                if(c == 'R') {
                    reversed = !reversed;
                }
                else if(c == 'D') {
                    if (queue.isEmpty()) {
                        error = true;
                        break;
                    }
                    if(!reversed)
                        queue.pollFirst();
                    else
                        queue.pollLast();
                }
            }
            if(error)
                sb.append("error\n");
            else {
                sb.append("[");
                while (!queue.isEmpty()) {
                    if(!reversed)
                        sb.append(queue.pollFirst()).append(",");
                    else
                        sb.append(queue.pollLast()).append(",");
                }
                if(sb.charAt(sb.length()-1) == ',')
                    sb.setCharAt(sb.length()-1, ']');
                else 
                    sb.append("]");
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}