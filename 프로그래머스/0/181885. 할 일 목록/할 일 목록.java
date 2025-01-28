import java.util.*;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        List<String> arrayList = new ArrayList<>();
        for(int i = 0; i<finished.length;i++){
            if(!finished[i])
                arrayList.add(todo_list[i]);
        }
        return arrayList.toArray(String[]::new);
    }
}