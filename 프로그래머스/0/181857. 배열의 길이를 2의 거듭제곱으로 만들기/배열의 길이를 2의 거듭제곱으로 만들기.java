import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int arrLength = arr.length;

        int maxLength = (int)Math.pow(2,Math.ceil(Math.log(arrLength)/Math.log(2)));
        int[] answerArray = Arrays.copyOf(arr, maxLength);
        return answerArray;
    }
}