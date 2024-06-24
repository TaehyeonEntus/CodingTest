import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] string = s.split("\\},\\{");
        
        List<Integer> answer = new ArrayList<>();
        List<Integer>[] intList = new List[string.length];
        
        for (int i = 0; i < string.length; i++) {
            intList[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < string.length; i++) {
            for (String s1 : string[i].split(",")) {
                intList[i].add(Integer.parseInt(s1));
            }
        }
        
        Arrays.sort(intList, Comparator.comparingInt(List::size));
        
        for (List<Integer> list : intList) {
            for (Integer num : list) {
                 if(!answer.contains(num)) {
                    answer.add(num);
                }
            }
        }
        
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
