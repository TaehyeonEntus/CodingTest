class Solution {
    public int solution(int n) {
        Integer answer = 0;
        String str = String.valueOf(n);
        for(char c : str.toCharArray()){
            answer += Integer.valueOf(String.valueOf(c));
        }
        return answer.intValue();
    }
}