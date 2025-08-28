import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Set<Integer> set = new HashSet<>();
    static Integer[] init = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "add":
                    set.add(Integer.parseInt(command[1]));
                    break;
                case "remove":
                    set.remove(Integer.parseInt(command[1]));
                    break;
                case "check":
                    if (set.contains(Integer.parseInt(command[1])))
                        sb.append("1").append("\n");
                    else
                        sb.append("0").append("\n");
                    break;
                case "toggle":
                    if (set.contains(Integer.parseInt(command[1])))
                        set.remove(Integer.parseInt(command[1]));
                    else
                        set.add(Integer.parseInt(command[1]));
                    break;
                case "all":
                    set.clear();
                    set.addAll(List.of(init));
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
        System.out.println(sb);
    }
}

