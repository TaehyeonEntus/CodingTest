import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
        List<String> list = new ArrayList<>();
        for(String str : quiz){
        String[] q = str.split(" ");
        //0번 = A
        //1번 = + or -
        //2번 = B
        //3번 = 등호
        //4번 = 결과
            Integer A = Integer.valueOf(q[0]);
            Integer B = Integer.valueOf(q[2]);
            
            Integer AB = Integer.valueOf(q[4]);
            if(q[1].equals("+")){
                if(AB == A+B)
                    list.add("O");
                else
                    list.add("X");
            }
            else{
                if(AB == A-B)
                    list.add("O");
                else
                    list.add("X");
            }
        }
        return list.stream().toArray(String[]::new);
    }
}