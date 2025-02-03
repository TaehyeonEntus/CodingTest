class Solution {
    public int solution(String binomial) {
        String[] StringList = binomial.split(" ");
        Integer a = Integer.parseInt(StringList[0]);
        Integer b = Integer.parseInt(StringList[2]);
        String op = StringList[1];
        
        return op.equals("+") ? a+b : op.equals("-")? a-b : a*b;
    }
}