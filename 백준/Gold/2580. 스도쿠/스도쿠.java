import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static List<List<Integer>> lists = new ArrayList<>();
    static Set<Integer> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    static int count = 0;
    static int n = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++)
            lists.add(new ArrayList<>(Arrays.stream(br.readLine().split(" "))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList())));

        dfs(0);

        
    }

    public static void dfs(int row) {
        if (row == 9) {
            for (List<Integer> list : lists) {
                for (Integer i : list) {
                    sb.append(i).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }
        List<Integer> list = lists.get(row);
        if (list.contains(0)) {
            //행 채우기
            for (int i = 1; i <= 9; i++) {
                if (!list.contains(i)) {
                    int index = list.indexOf(0);
                    if (sectionCheck(index, row, i) && columnCheck(index, i)) {
                        list.set(index, i);
                        if(list.contains(0))
                            dfs(row);
                        else
                            dfs(row + 1);
                        list.set(index, 0);
                    }
                }
            }
        }
    }

    public static boolean sectionCheck(int x, int y, int target) {
        set.clear();
        set.add(target);

        int sectionX = x / 3 * 3;
        int sectionY = y / 3 * 3;

        List<Integer> row1 = lists.get(sectionY).subList(sectionX, sectionX + 3);
        List<Integer> row2 = lists.get(sectionY + 1).subList(sectionX, sectionX + 3);
        List<Integer> row3 = lists.get(sectionY + 2).subList(sectionX, sectionX + 3);

        for (int num : row1) {
            if (num != 0 && !set.add(num)) return false;
        }
        for (int num : row2) {
            if (num != 0 && !set.add(num)) return false;
        }
        for (int num : row3) {
            if (num != 0 && !set.add(num)) return false;
        }

        return true;
    }

    public static boolean columnCheck(int index, int target) {
        for (List<Integer> list : lists) {
            if (list.get(index)==target)
                return false;
        }
        return true;
    }
}

