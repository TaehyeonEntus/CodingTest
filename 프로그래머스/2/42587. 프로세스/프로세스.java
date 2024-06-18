import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int maxPriority = 0;
        Queue<queObject> q = new LinkedList<>();
        for(int i = 0; i< priorities.length; i++){
            q.add(new queObject(priorities[i],i));
        }
        
        while(true){
            for(queObject queObj : q)
                maxPriority = maxPriority<queObj.p?queObj.p:maxPriority;
            
            while(true){
                queObject obj = q.poll();
                if(obj.p == maxPriority){
                    answer++;
                    if(obj.l == location){   //추출된 것이 타겟이였다면 return
                        return answer;
                    }
                    maxPriority = 0;
                    break;
                }
                q.add(obj);
                break;
                }
            }
        }
    
    static class queObject {
        int p;
        int l;
        
        queObject(int p, int l) {
            this.p = p;
            this.l = l;
        }
    }
}