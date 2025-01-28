import java.util.*;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        while(true){
            arrayList.add(n);
            if(n%2==0)
                n/=2;
            else
                n = 3*n+1;
            if(n==1){
                arrayList.add(n);
                break;
            }
        }
        return arrayList.stream().mapToInt(Integer::intValue).toArray();
    }
}