class Solution {
    public int solution(String num_str) {
        int answer = 0;
        char[] charArr = num_str.toCharArray();
        for(char c : charArr){
            answer += Integer.parseInt(String.valueOf(c));
        }
        return answer;
    }
}