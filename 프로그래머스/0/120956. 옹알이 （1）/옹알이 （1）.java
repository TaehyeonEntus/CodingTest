class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for(String babble : babbling){
            sb.setLength(0);
            for(int i = 0; i<babble.length();i++){
                if(babble.charAt(i) == 'a'){
                    sb.append("aya");
                    i+=2;
                }
                else if(babble.charAt(i) == 'y'){
                    sb.append("ye");
                    i+=1;
                }
                else if(babble.charAt(i) == 'w'){
                    sb.append("woo");
                    i+=2;
                }
                else if(babble.charAt(i) == 'm'){
                    sb.append("ma");
                    i+=1;
                }
            }
            if(sb.toString().equals(babble))
                answer++;
        }
        return answer;
    }
}