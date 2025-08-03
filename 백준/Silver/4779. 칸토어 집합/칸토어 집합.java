import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        while (line != null){
            int n = Integer.parseInt(line);
            System.out.println(process(n));
            line = br.readLine();
        }
    }

    public static String process(int n){
        int len = (int) Math.pow(3,n);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            sb.append("-");
        }
        return recursive(sb.toString());
    }
    public static String recursive(String n){
        int step = n.length()/3;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < step; i++){
            sb.append(" ");
        }
        if(step == 0)
            return "-";
        return recursive(n.substring(0,step)) + sb + recursive(n.substring(2*step, 3*step));
    }
}

