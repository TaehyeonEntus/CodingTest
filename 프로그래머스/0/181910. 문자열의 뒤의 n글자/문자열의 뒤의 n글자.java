class Solution {
    public String solution(String my_string, int n) {
        int startIndex = my_string.length()-n;
        int endIndex = my_string.length();
        return my_string.substring(startIndex,endIndex);
    }
}