import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static List<Building> buildings = new ArrayList<>();
    static Deque<Building> queue = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++)
            buildings.add(new Building(i));

        for (int i = 1; i <= n; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Building child = buildings.get(i);
            child.cost = arr[0];

            for (int j = 1; j < arr.length-1; j++) {
                Building parent = buildings.get(arr[j]);
                parent.children.add(child);
                child.parents.add(parent);
            }
        }

        for (int i = 1; i <= n; i++) {
            Building building = buildings.get(i);
            if (building.parents.isEmpty()) {
                queue.add(building);
            }
        }

        int[] answer = new int[n + 1];

        while (!queue.isEmpty()) {
            Building building = queue.poll();
            answer[building.number] = building.cost + building.readyTime;
            for (Building child : building.children) {
                child.readyTime = Math.max(child.readyTime, answer[building.number]);
                child.parents.remove(building);
                if (child.parents.isEmpty())
                    queue.add(child);
            }
        }
        for (int i = 1; i <= n; i++)
            System.out.println(answer[i]);
    }

    public static class Building {
        int readyTime = 0;
        int number;
        int cost;

        List<Building> parents = new ArrayList<>();
        List<Building> children = new ArrayList<>();

        public Building(int number) {
            this.number = number;
        }
    }
}