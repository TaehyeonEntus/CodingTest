import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] wires = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int a : wires) {
            //Collections.binarySearch
            //1. key 찾으면 해당 인덱스 반환(근데 여기는 의미 없음, 중복값이 없어서)
            //2. key 없으면 -(삽입 위치 + 1) 반환
            //예를 들어서 비어있는 리스트를 검사하면 -(0(인덱스)+1) 이므로 -1 반환
            //반환값이 리스트 사이즈 보다 크면 Append해야함

            int index = Collections.binarySearch(list, a) * -1;

            if (index > list.size())
                list.add(a);
            else
                list.set(index-1, a);
        }

        System.out.println(n-list.size());
    }
}

