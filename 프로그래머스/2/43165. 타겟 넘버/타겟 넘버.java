import java.util.Arrays;
class Solution {
    static int answer = 0;
    static void checkTarget(int[] numbers, int target){
        if(Arrays.stream(numbers).sum() == target)
            answer++;
    }
    static void findWays(int count, int[] numbers, int target){
        if(count == -1) {
            checkTarget(numbers, target);
            return;
        }
        findWays(count-1, numbers, target); numbers[count] *= -1; // 음수 체크
        findWays(count-1, numbers, target); numbers[count] *= -1; // 양수 체크
    }
    public int solution(int[] numbers, int target) {
        findWays(numbers.length-1, numbers, target);
        return answer;
    }
}
