import java.util.*;
import java.util.stream.Collectors;
class Progress {
    int work;
    int speed;
    
    Progress(int work, int speed){
        this.work = work;
        this.speed = speed;
    }
    
    void working(){
        work += speed;
    }
}
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Progress> progressList = new ArrayList<Progress>();
        List<Integer> answerList = new ArrayList<Integer>();
        for(int i = 0; i<progresses.length; i++)
            progressList.add(new Progress(progresses[i], speeds[i]));
        while(!progressList.isEmpty()){
            for(Progress p : progressList)
                p.working();
            
            int count = checkDone(progressList);
            if(count!=0)
                answerList.add(count);
        }
        int[] answer = new int[answerList.size()];
        for(int i = 0; i<answerList.size(); i++)
            answer[i] = answerList.get(i);
        return answer;
    }
    public static int checkDone(List<Progress> pList){
        int count = 0;
        List<Progress> doneProgress = new ArrayList<Progress>();
        for(Progress p : pList){
            if(p.work>=100){
                doneProgress.add(p);
                count++;
                }
            else
                break;    
        }
        for(Progress p : doneProgress)
            pList.remove(p);
        return count;
    }
}