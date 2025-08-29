import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int m;
    static List<Node>[] graph;


    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];
        int target = arr[2];

        graph = new List[n + 1];
        for (int i = 0; i < n + 1; i++)
            graph[i] = new ArrayList<>();

        for(int i = 0; i < m; i++){
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = arr[0];
            int y = arr[1];
            int cost = arr[2];

            graph[x].add(new Node(y, cost));
        }

        int[][] go = new int[n+1][n+1];
        for (int i = 1; i <= n; i++)
            go[i] = dijkstra(i);

        int[] back = new int[n + 1];
        back = dijkstra(target);

        int max = 0;
        for (int i = 1; i <= n; i++)
            max = Math.max(max, go[i][target] + back[i]);

        System.out.println(max);
    }

    public static int[] dijkstra(int start) {
        int[] dist = new int[n + 1]; //해당 정점까지의 최단 거리를 기록해놓을 메모이제이션(dp)
        Arrays.fill(dist, Integer.MAX_VALUE);    //기본적으로 MAX초기화
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost)); //작은 경로부터 순서대로, 왜? -> 최적화를 위해서, 큰값을 넣으면 결과도 큰 값이 나올 가능성이 높음. 최소값을 찾아야하는데
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();

            //현재 정점까지의 비용이 원래 발견했던 거보다 큼 (비효율적)
            if (currentNode.cost > dist[currentNode.number])
                continue;

            //현재 정점에서 뻗을 수 있는 간선
            for (Node nextNode : graph[currentNode.number]) {
                //현재 정점까지의 최소 거리 + 다음 정점까지의 거리가 dist[다음정점] 보다 작아야함, 크면 할 이유가 없음
                //현재 정점까지의 거리 + 다음 정점 까지의 거리 = dist[currentNode.number] + nextNode.cost;
                //원래 등록 되어있던 다음 정점의 최소 거리 = dist[nextNode.number]

                //이번에 검색한 경로가 더 작을 때 -> 등록 해야함
                if(dist[nextNode.number] > dist[currentNode.number] + nextNode.cost) {
                    dist[nextNode.number] = dist[currentNode.number] + nextNode.cost;
                    //해당 정점을 다시 등록
                    pq.add(new Node(nextNode.number, dist[nextNode.number]));
                }
            }
        }
        return dist;
    }

    public static class Node {
        int number;
        int cost;

        public Node(int number, int cost) {
            this.number = number;
            this.cost = cost;
        }
    }
}


