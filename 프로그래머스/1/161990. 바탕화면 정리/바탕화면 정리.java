class Solution {
    static int findTop(int max_sero, int max_garo, char[][] charArray){
        for(int i = 0; i < max_sero; i++) {
            for(int j = 0; j < max_garo; j++) {
                if (charArray[i][j] == '#')
                    return i;
            }
        }
        return -1;
    }

    static int findLeft(int max_sero, int max_garo, char[][] charArray){
        for(int i = 0; i < max_garo; i++) {
            for(int j = 0; j < max_sero; j++) {
                if (charArray[j][i] == '#')
                    return i;
            }
        }
        return -1;
    }

    static int findBottom(int max_sero, int max_garo, char[][] charArray){
        for(int i = max_sero - 1; i >= 0; i--) {
            for(int j = 0; j < max_garo; j++) {
                if (charArray[i][j] == '#')
                    return i+1;
            }
        }
        return -1;
    }

    static int findRight(int max_sero, int max_garo, char[][] charArray){
        for(int i = max_garo - 1; i >= 0; i--) {
            for(int j = 0; j < max_sero; j++) {
                if (charArray[j][i] == '#')
                    return i+1; 
            }
        }
        return -1;
    }

    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        // 문자형 2차원 배열로 가공
        char[][] charArray = new char[wallpaper.length][];
        
        for(int i = 0; i < wallpaper.length; i++) {
            charArray[i] = wallpaper[i].toCharArray();
        }
        
        int max_sero = charArray.length;
        int max_garo = charArray[0].length;
        
        answer[0] = findTop(max_sero, max_garo, charArray);
        answer[1] = findLeft(max_sero, max_garo, charArray);
        answer[2] = findBottom(max_sero, max_garo, charArray);
        answer[3] = findRight(max_sero, max_garo, charArray);
        
        return answer;
    }
}
