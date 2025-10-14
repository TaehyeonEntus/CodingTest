import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] tree;

    //    public static void main(String[] args) throws IOException {
//        int n = Integer.parseInt(br.readLine());
//        int[] numbers = new int[n + 1];
//        numbers[0] = 0;
//
//        for (int i = 1; i <= n; i++)
//            numbers[i] = Integer.parseInt(br.readLine());
//        list.add(n);
//
//        for (int i = n - 1; i >= 1; i--)
//            list.add(numbers[i], i);
//
//        for (int i : list)
//            sb.append(i).append("\n");
//        System.out.println(sb);
//    }
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n + 1];
        numbers[0] = 0;
        for (int i = 1; i <= n; i++)
            numbers[i] = Integer.parseInt(br.readLine());

        tree = new int[4 * n];
        build(1, 1, n);

        int[] answer = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            //앞에 빈칸의 갯수 -> numbers[i] + 1 (넣을 자리도 빈칸이여야 함)
            int index = find(1, 1, n, numbers[i] + 1);
            update(1, 1, n, index);
            answer[index] = i;
        }
        for(int i = 1; i <= n; i++)
            sb.append(answer[i]).append("\n");
        System.out.println(sb);
    }

    public static void build(int node, int start, int end) {
        //빈칸이면 1 저장 (빈칸의 갯수를 세기 위함)
        if (start == end) {
            tree[node] = 1;
            return;
        }

        int mid = (start + end) / 2;
        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public static int find(int node, int start, int end, int k) {
        if (start == end)
            return start;

        int mid = (start + end) / 2;

        //왼쪽
        if (tree[node * 2] >= k) return find(node * 2, start, mid, k);
            //오른쪽
        else return find(node * 2 + 1, mid + 1, end, k - tree[node * 2]);
    }

    public static void update(int node, int start, int end, int idx) {
        if (idx < start || idx > end) return;
        if (start == end) {
            tree[node] = 0; // 채워짐
            return;
        }
        int mid = (start + end) / 2;

        //왼쪽
        if (idx <= mid) update(node * 2, start, mid, idx);
            //오른쪽
        else update(node * 2 + 1, mid + 1, end, idx);

        //돌아오면서 경유지 최신화
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
}