class Solution {
    public String solution(String myString, String pat) {
        int myStringLength = myString.length();
        int patLength = pat.length();
        
        for(int i = myStringLength-patLength; i>=0; i--){
            if(pat.equals(myString.substring(i,i+patLength)))
                return myString.substring(0,i+patLength);
        }
        String answer = "";
        return answer;
    }
}