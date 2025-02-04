class Solution {
    public int solution(String myString, String pat) {
        int myStringLength = myString.length();
        int patLength = pat.length();
        int count = 0;
        for(int i = 0; i<myStringLength-patLength+1; i++){
            if(pat.equals(myString.substring(i,i+patLength)))
               count++;
        }
        return count;
    }
}