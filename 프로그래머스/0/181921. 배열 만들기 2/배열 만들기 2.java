import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        int check = 0;
        for(int i = l; i<=r; i++){
            check = 0;
            sb.setLength(0);
            String intStr = String.valueOf(i);
            for(char c : intStr.toCharArray()){
                if(!((c == '0') || (c== '5'))){
                    check = 1;
                    break;
                }
            }
            if(check!=1)
                list.add(Integer.valueOf(i));
        }
        
        if(list.isEmpty())
            list.add(Integer.valueOf(-1));
        return list
            .stream()
            .mapToInt(i->i)
            .toArray();
    }
    
    
}