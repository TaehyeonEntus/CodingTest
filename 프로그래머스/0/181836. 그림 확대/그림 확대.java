import java.util.*;

class Solution {
    public String[] solution(String[] picture, int k) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for(String str : picture){
            sb.setLength(0);
            for(char c : str.toCharArray()){
                for(int i = 0; i<k; i++)
                    sb.append(c);
            }
            for(int j = 0; j<k; j++)
                list.add(sb.toString());
        }
        
        String[] answer = list.toArray(new String[0]);
        return answer;
    }
}