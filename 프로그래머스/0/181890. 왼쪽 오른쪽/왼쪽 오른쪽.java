import java.util.*;

class Solution {
    public String[] solution(String[] str_list) {
        List<String> list = new ArrayList<>();
        int targetIndex=0;
        for(String str : str_list){
            if(str.equals("r")){
                for(int i = targetIndex+1; i<str_list.length; i++)
                    list.add(str_list[i]);
                break;
            }
            else if(str.equals("l")){
                for(int i = 0; i<targetIndex; i++)
                    list.add(str_list[i]);
                break;
            }
            targetIndex++;
        }
        return list.toArray(new String[0]);
    }
}