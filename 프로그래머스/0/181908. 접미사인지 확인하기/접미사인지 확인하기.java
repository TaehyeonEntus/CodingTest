class Solution {
    public int solution(String my_string, String is_suffix) {
        int myStrLen = my_string.length();
        int isSufLen = is_suffix.length();
        
        if(isSufLen>myStrLen)
            return 0;
        
        return my_string
            .substring(myStrLen-isSufLen,myStrLen)
            .equals(is_suffix)
            ? 1 : 0;
    }
}