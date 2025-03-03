class Solution {
    public int solution(int num, int k) {
        String str = String.valueOf(num);
        int index = str.indexOf(String.valueOf(k));
        if(index == -1)
            return index;
        return index + 1;
    }
}