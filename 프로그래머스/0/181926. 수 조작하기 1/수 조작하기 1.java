class Solution {
    public int solution(int n, String control) {
        int length = control.length();
        for(int i = 0; i<length;i++){
            if(control.charAt(i) == 'w')
                n+=1;
            else if(control.charAt(i) == 's')
                n-=1;
            else if(control.charAt(i) == 'd')
                n+=10;
            else if(control.charAt(i) == 'a')
                n-=10;
        }
        return n;
    }
}