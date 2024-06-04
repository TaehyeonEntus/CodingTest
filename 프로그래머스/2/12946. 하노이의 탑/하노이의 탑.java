import java.util.*;

class Solution {
    // n개의 타워는 n-1, 1 크기의 2개의 원판이라고 생각하고 재귀함수 구조 생성
    static List<int[]> arr = new ArrayList<>();
    
    static void move(int cnt, int start, int mid, int end) {   //재귀함수
        if (cnt == 0) {
            return;
        }
        move(cnt - 1, start, end, mid); //1 -> 2
        arr.add(new int[]{start, end}); //1 -> 3
        move(cnt - 1, mid, start, end); //2 -> 3
    }
    
    public int[][] solution(int n) {
        move(n, 1, 2, 3);   //1 = 출발지 // 2 = 경유지 // 3 = 도착지
        int[][] answer = arr.stream()
                .toArray(int[][]::new);
        return answer;
    }
}