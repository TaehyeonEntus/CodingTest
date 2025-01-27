import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = {};
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i:num_list)
            arrayList.add(Integer.valueOf(i));
        arrayList.sort(Comparator.naturalOrder());
        
        ArrayList<Integer> answerList = new ArrayList<>();
        for(int i =0;i<5;i++)
            answerList.add(arrayList.get(i));
        answer = answerList.stream().mapToInt(i->i).toArray();
        return answer;
    }
}