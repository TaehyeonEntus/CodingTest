class Solution {
    public String solution(String my_string, int[] indices) {
        char[] charArr = my_string.toCharArray();
        for(int i : indices)
            charArr[i] = ' ';
        
        String answer = String.valueOf(charArr);
        return answer.replace(" ","");
    }
}