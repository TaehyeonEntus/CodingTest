import java.util.Arrays;

class Solution {
    static int isInDic(String spell, String[] dic) {  //찾는 함수
        for (String s : dic)
            if (s.equals(spell))
                return 1;
        return 2;
    }

    public int solution(String[] spell, String[] dic) {
        // spell 배열 정렬                      // String[]
        Arrays.sort(spell);

        // spell 배열을 하나의 문자열로 합침       // String
        StringBuilder sortedSpell = new StringBuilder();
        for (String s : spell) {
            sortedSpell.append(s);
        }

        // 각 dic 문자열을 정렬                  //String 대신 charArray를 사용해서 sort
        String[] sortedDic = new String[dic.length];  
        for (int i = 0; i < dic.length; i++) {
            char[] chars = dic[i].toCharArray();
            Arrays.sort(chars);
            sortedDic[i] = new String(chars);
        }

        // 사전 배열에서 sortedSpell을 찾음
        return isInDic(sortedSpell.toString(), sortedDic);
    }
}