class Solution {
    public int solution(String myString, String pat) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = myString.toCharArray();
        for(char c : charArray){
            if(c=='A')
                sb.append('B');
            else
                sb.append('A');
        }
        return sb.toString().contains(pat)?1:0;
    }
}