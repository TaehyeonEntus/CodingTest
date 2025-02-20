class Solution {
    public String solution(String code) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        int mode = 0;
        for(int i=0; i<code.length(); i++){
            char c = code.charAt(i);
            if(mode==1){
                if(c == '1')
                    mode = 0;
                else{
                    if(i%2!=0)
                        sb.append(c);
                }
            }
            else{
                if(c == '1')
                    mode = 1;
                else{
                    if(i%2==0)
                        sb.append(c);
                }
            }
        }
        if(sb.toString().isEmpty()){
            sb.append("EMPTY");
        }
        return sb.toString();
    }
}