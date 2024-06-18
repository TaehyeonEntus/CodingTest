class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int tLength = t.length();
        int pLength = p.length();
        long tLong = 0;
        long pLong = Long.parseLong(p);
        
        for(int i = 0; i <= tLength - pLength; i++){
            tLong = Long.parseLong(t.substring(i,i+pLength));
            answer += (tLong <= pLong) ? 1 : 0;
        }

        return answer;
    }
}