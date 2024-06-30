import java.util.*;

public class Record {
    private List<Integer> win = new ArrayList<>();
    private List<Integer> lose = new ArrayList<>();

    public List<Integer> getWin() {
        return win;
    }

    public List<Integer> getLose() {
        return lose;
    }
}

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        List<Record> rankingList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            rankingList.add(new Record());
        }
        
        //초기화 완료
        
        for(int[] intArray : results){
            int winner = intArray[0];
            int loser = intArray[1];
            
            rankingList.get(winner-1).getWin().add(loser);
            rankingList.get(loser-1).getLose().add(winner);
        }
        
        //기록 추가 완료
        for(int i = 0; i<n; i++){   //i는 현재 플레이어
            for(int winTo : rankingList.get(i).getWin()){  //i가 이긴 사람들
                for(int loseTo : rankingList.get(i).getLose()){  //i를 이긴 사람들
                    if(rankingList.get(winTo-1).getLose().indexOf(loseTo)==-1)
                        rankingList.get(winTo-1).getLose().add(loseTo);
                    if(rankingList.get(loseTo-1).getWin().indexOf(winTo)==-1)
                        rankingList.get(loseTo-1).getWin().add(winTo);
                }
            }
        }
        
        for(int i = 0; i<n; i++){
            int w = rankingList.get(i).getWin().size();
            int l = rankingList.get(i).getLose().size();
            
            if(w+l == n-1)
                answer++;
        }
        return answer;
    }
}