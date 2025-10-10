import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> stack = new ArrayDeque<>();
    static List<Integer> lis = new ArrayList<>();
    static List<Wire> wires = new ArrayList<>();
    static int[] index;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            wires.add(new Wire(arr[0], arr[1]));
        }

        wires.sort(Comparator.comparingInt(Wire::getStart));
        index = new int[n];

        for (int i = 0; i < n; i++) {
            Wire wire = wires.get(i);
            int start = wire.getStart();
            int end = wire.getEnd();

            if (lis.isEmpty() || lis.get(lis.size() - 1) < end) {
                lis.add(end);
                index[i] = lis.size() - 1;
            } else {
                int idx = Collections.binarySearch(lis, end);

                if (idx < 0)
                    idx = -(idx + 1);

                index[i] = idx;

                lis.set(idx, end);
            }
        }


        List<Wire> remove = new ArrayList<>();
        int count = lis.size()-1;
        for(int i = n-1; i>=0; i--){
            if(index[i] == count){
                remove.add(wires.get(i));
                count--;
            }
        }

        wires.removeAll(remove);

        System.out.println(wires.size());
        for(Wire wire : wires){
            sb.append(wire.start).append("\n");
        }
        System.out.println(sb);
    }

    public static class Wire {
        int start;
        int end;

        public Wire(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
}