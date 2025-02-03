class Solution {
    public int solution(int a, int b, int c) {
        int abc = a+b+c;
        int abcIfTwo = abc * (a*a + b*b + c*c);
        int abcIfThree = abcIfTwo * (a*a*a + b*b*b + c*c*c);
        
        return  a==b?
                    b==c?
                        abcIfThree:
                        abcIfTwo
                :
                    b==c?
                        a==c?
                            abcIfThree:
                            abcIfTwo
                    :
                        a==c?
                            abcIfTwo:
                            abc;
    }
}