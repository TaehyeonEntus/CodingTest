class Solution {
    public int solution(int[] num_list) {
        int listLength = num_list.length;
        int answer = listLength>10?0:1;
        for(int i : num_list){
            if(listLength>10)
                answer+=i;
            else
                answer*=i;
        }
        return answer;
    }
}