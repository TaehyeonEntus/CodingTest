class Solution {
    public int solution(int a, int b) {
        String result = Integer.valueOf(a).toString() + Integer.valueOf(b).toString();
        int resultA = Integer.parseInt(result);
        int resultB = 2*a*b;
        
        return resultA>=resultB ? resultA : resultB;
    }
}