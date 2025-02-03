import java.util.*;

class Solution {
    public int solution(int a, int b) {
        return  a%2==0 ? 
                    b%2==0 ?  
                        Math.abs(a-b) : 2 * (a+b)
                :
                    b%2==0 ?
                        2 * (a+b) : (a*a + b*b)
        ;
    }
}