import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    //tree 맵은 key 기준 정렬, 중복 값도 처리 가능하니까 아주 굿 ^~^ (PQ로 해결하려다가 도망친거임 ㅅ사실)
    static TreeMap<Integer, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            map.clear();
            int k = Integer.parseInt(br.readLine());
            for (int j = 0; j < k; j++) {
                String[] s = br.readLine().split(" ");
                int value = Integer.parseInt(s[1]);
                //삽입
                if (s[0].equals("I")) {
                    map.put(value, map.getOrDefault(value, 0) + 1);
                }
                //삭제
                else if (!map.isEmpty()) {
                    Integer mapValue = 0;
                    //최대값 삭제
                    if (value == 1)
                        mapValue = map.lastKey();

                        //최소값 삭제
                    else
                        mapValue = map.firstKey();

                    if (map.containsKey(mapValue))
                        map.put(mapValue, map.get(mapValue) - 1);
                    if (map.get(mapValue) == 0)
                        map.remove(mapValue);
                }
            }
            if (map.isEmpty()){
                sb.append("EMPTY").append("\n");
            }
            else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }
        System.out.println(sb);
    }
}