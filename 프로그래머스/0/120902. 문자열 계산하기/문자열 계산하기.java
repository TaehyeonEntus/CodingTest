class Solution {
    public int solution(String my_string) {
        String[] q = my_string.split(" ");
        int answer = Integer.valueOf(q[0]);
        for(int i = 1; i<q.length; i++){
            if(q[i].equals("+"))
                answer += Integer.valueOf(q[i+1]);
            else if(q[i].equals("-"))
                answer -= Integer.valueOf(q[i+1]);
        }
        return answer;
    }
}