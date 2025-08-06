class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int level = 101;
        while(true){
            if(calcTime(diffs, times, limit, level)<=limit){
                for(int i = level-100; i<=level; i++){
                    if(calcTime(diffs, times, limit, i)<=limit)
                        return i;
                }
            }
            level+=100;
        }
    }
    public static long calcTime(int[] diffs, int[] times, long limit, int level){
        long total = 0;
        int diff;
        long cur_time;
        int k;
        for(int i = 0; i<diffs.length; i++){
            if(total>limit)
                return total;
            diff = diffs[i];
            k = diff-level;
            cur_time = (long)times[i];
            
            total+=cur_time;
            if(k>0){
                total+=cur_time*k;
                if(i>0)
                    total+=(long)times[i-1]*k;
            }
        }
        return total;
    }
}