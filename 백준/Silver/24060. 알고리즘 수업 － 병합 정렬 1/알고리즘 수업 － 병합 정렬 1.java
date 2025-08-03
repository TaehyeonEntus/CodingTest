import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    static int k;
    static int target = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        k = Integer.parseInt(strArr[1]);

        strArr = br.readLine().split(" ");
        int[] intArr = new int[n];
        for (int i = 0; i < n; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        mergeSort(intArr);
        System.out.println(target);
    }

    public static int[] mergeSort(int[] arr) {
        int start = 0;
        int end = arr.length;
        if (end == 1)
            return arr;

        int pivot = (end+1)/2;
        return merge(mergeSort(Arrays.copyOfRange(arr, start, pivot)), mergeSort(Arrays.copyOfRange(arr, pivot, end)));
    }

    public static int[] merge(int[] arrA, int[] arrB) {
        int len = arrA.length + arrB.length;
        int aLen = arrA.length;
        int bLen = arrB.length;
        int cur = 0;
        int a = 0;
        int b = 0;

        int[] temp = new int[len];
        while (a < aLen || b < bLen) {
            count++;
            if (a == aLen) {
                temp[cur++] = arrB[b++];
            }
            else if (b == bLen) {
                temp[cur++] = arrA[a++];
            }
            else {
                if (arrA[a] < arrB[b]) {
                    temp[cur++] = arrA[a++];
                }
                else {
                    temp[cur++] = arrB[b++];
                }
            }
            if(count == k) {
                target = temp[cur - 1];
            }
        }

        return temp;
    }
}

