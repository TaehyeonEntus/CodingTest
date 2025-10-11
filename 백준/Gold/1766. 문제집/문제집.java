import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Problem> pq = new PriorityQueue<>(Comparator.comparingInt(Problem::getNumber));
    static List<Problem> problems = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        
        for (int i = 0; i < n; i++) {
            Problem problem = new Problem(i);
            problems.add(problem);
        }

        int m = arr[1];
        for (int i = 0; i < m; i++) {
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Problem parent = problems.get(arr[0] - 1);
            Problem child = problems.get(arr[1] - 1);

            parent.children.add(child);
            child.parents.add(parent);
        }

        for (Problem problem : problems)
            if (problem.parents.isEmpty())
                pq.add(problem);

        while (!pq.isEmpty()) {
            Problem problem = pq.poll();
            for (Problem child : problem.children) {
                child.parents.remove(problem);
                if (child.parents.isEmpty())
                    pq.add(child);
            }
            sb.append(problem.number + 1).append(" ");
        }
        System.out.println(sb);
    }

    public static class Problem {
        int number;
        List<Problem> parents = new ArrayList<>();
        List<Problem> children = new ArrayList<>();

        public Problem(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }
    }
}
