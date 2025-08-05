class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        StringBuilder sb = new StringBuilder();
        int totalVideo = toSecond(video_len);
        int currentVideo = toSecond(pos);
        int opStart = toSecond(op_start);
        int opEnd = toSecond(op_end);
        if(opEnd>=currentVideo && opStart<=currentVideo)
            currentVideo = opEnd;
        for(String command : commands){
            if(command.equals("next")){
                if(totalVideo-currentVideo<=10)
                    currentVideo = totalVideo;
                else
                    currentVideo+=10;
            }
            else{
                if(currentVideo-10<=0)
                    currentVideo = 0;
                else
                    currentVideo-=10;
            }
            if(opEnd>=currentVideo && opStart<=currentVideo)
            currentVideo = opEnd;
        }
        String curMinute = String.valueOf(currentVideo/60);
        String curSecond = String.valueOf(currentVideo%60);
        if(curMinute.length() == 1)
            sb.append("0");
        sb.append(curMinute).append(":");
        if(curSecond.length() == 1)
            sb.append("0");
        sb.append(curSecond);
        return sb.toString();
    }
    public static int toSecond(String str){
        int minutes = Integer.parseInt(str.substring(0,2));
        int seconds = Integer.parseInt(str.substring(3,str.length()));
        seconds += minutes*60;
        return seconds;
    }
}