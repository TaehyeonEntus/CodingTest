class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int curHealth = health;
        int end = attacks[attacks.length-1][0];
        int time = 0;
        int attackCount = 0;
        int healTime = 0;
        
        while(time <= end){
            //공격
            if(time == attacks[attackCount][0]){
                healTime = 0;
                curHealth-=attacks[attackCount++][1];
            } 
            //힐
            else {
                healTime++;
                curHealth += bandage[1];
                if(healTime == bandage[0]){
                    healTime = 0;
                    curHealth+=bandage[2];
                }
            }
            
            if(curHealth>=maxHealth)
                curHealth = maxHealth;
            
            if(curHealth<=0)
                return -1;
            
            time++;
        }
        return curHealth>=1?curHealth:-1;
    }
}