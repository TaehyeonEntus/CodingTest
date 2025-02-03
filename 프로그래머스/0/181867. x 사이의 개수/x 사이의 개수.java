import java.util.*;

class Solution {
    public int[] solution(String myString) {
        String[] stringArray = myString.split("x");
        ArrayList<Integer> integerList = new ArrayList<>();
        for(String str : stringArray)
            integerList.add(str.length());

        if(myString.charAt(myString.length()-1)=='x')
            integerList.add(Integer.valueOf(0));
        return integerList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}