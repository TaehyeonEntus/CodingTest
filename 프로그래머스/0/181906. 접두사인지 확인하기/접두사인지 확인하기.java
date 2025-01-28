class Solution {
    public int solution(String my_string, String is_prefix) {
        int prefixLength = is_prefix.length();
        if(prefixLength>my_string.length())
            return 0;
        String prefix = my_string.substring(0,prefixLength);
        
        return prefix.contains(is_prefix)?1:0;
    }
}