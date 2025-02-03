class Solution {
    public int solution(String number) {
        char[] charArray = number.toCharArray();
        int answer = 0;
        for(char c : charArray)
            answer+=Integer.parseInt(String.valueOf(c));
        
        return answer%9;
    }
}