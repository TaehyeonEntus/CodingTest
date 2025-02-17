import java.util.*;

class Solution {
    public String solution(String a, String b) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        StringBuilder sb = new StringBuilder();
        
        int aLength = a.length();
        int bLength = b.length();
        
        int maxLength = Math.max(aLength,bLength);
        
        sb1.append(a);
        sb1.reverse();
        
        sb2.append(b);
        sb2.reverse();
        
        String reversedA = sb1.toString();
        String reversedB = sb2.toString();
        
        int A = 0;
        int B = 0;
        int sum = 0;
        int carry = 0;
        
        for(int i = 0; i<maxLength; i++){
            if(i<aLength)
                A = reversedA.charAt(i)-48;
            else
                A = 0;
            
            if(i<bLength)
                B = reversedB.charAt(i)-48;
            else
                B = 0;
            
            sum = A+B;
            sum += carry;
            
            if(sum>=10){
                sum-=10;
                carry = 1;
            }
            else
                carry = 0;
            
            sb.append(sum);
        }
        if(carry == 1)
            sb.append(1);

        return sb.reverse().toString();
    }
}