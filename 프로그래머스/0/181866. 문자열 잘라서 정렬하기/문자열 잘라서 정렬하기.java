import java.util.*;

class Solution {
    public String[] solution(String myString) {
        ArrayList<String> list = new ArrayList<>();
        String[] stringArray = myString.split("x");
        for(String str : stringArray){
            if(!str.equals(""))
                list.add(str);
        }
        
        String[] answerArray = list.toArray(new String[0]);
        Arrays.sort(answerArray,Comparator.naturalOrder());
        return answerArray;
    }
}