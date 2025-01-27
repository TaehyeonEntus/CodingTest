class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        StringBuilder AB =  new StringBuilder();
        AB.append(a);
        AB.append(b);

        int ab = Integer.parseInt(AB.toString());
        
        StringBuilder BA = new StringBuilder();
        BA.append(b);
        BA.append(a);

        int ba = Integer.parseInt(BA.toString());
        
        if(ab>=ba)
            answer = ab;
        else
            answer = ba;
        return answer;
    }
}