class Solution {
    public int solution(int i, int j, int k) {
        int count = 0;
        for(int x = i; x <= j; x++){
            String str = String.valueOf(x);
            char target = Integer.toString(k).charAt(0);
            for(char c : str.toCharArray())
                if(c==target)
                    count++;
        }
        return count;
    }
}