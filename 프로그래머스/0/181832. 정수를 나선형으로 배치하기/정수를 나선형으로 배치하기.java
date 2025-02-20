class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int x = 0;
        int y = 0;
        String direction = "right";
        for(int i = 0; i<n*n; i++){
            if(answer[y][x]==0){
                answer[y][x] = i+1;
                if(direction.equals("right")){
                if((x+1)<n){
                        if(answer[y][x+1]==0){
                            x++;
                            continue;
                        }
                        else{
                            y++;
                            direction = "up";
                            continue;
                        }
                    }
                else{
                    y++;
                    direction = "up";
                    continue;
                }
                }
                if(direction.equals("up")){
                if((y+1)<n){
                        if(answer[y+1][x]==0){
                            y++;
                            continue;
                        }
                        else{
                            x--;
                            direction = "left";
                            continue;
                        }
                    }                   
                else{
                    x--;
                    direction = "left";
                    continue;
                }
                }
                
                if(direction.equals("left")){
                if(x>0){
                        if(answer[y][x-1]==0){
                            x--;
                            continue;
                        }
                        else{
                            y--;
                            direction = "down";
                            continue;
                        }
                    }
                else{
                    y--;
                    direction = "down";
                    continue;
                }
                }
                
                if(direction.equals("down")){
                if(y>0){
                        if(answer[y-1][x]==0){
                            y--;
                            continue;
                        }
                        else{
                            x++;
                            direction = "right";
                            continue;
                        }
                    }
                else{
                    x++;
                    direction = "right";
                    continue;
                }
                }
            }
        }
        return answer;
    }
}