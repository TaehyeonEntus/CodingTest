import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Pair {
    int A;
    int B;

    Pair(int A, int B) {
        this.A = A;
        this.B = B;
    }

    int Sum() {
        return A + B;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String string;

        while((string = bf.readLine()) != null){
            String[] strings = string.split(" ");

            int A = Integer.parseInt(strings[0]);
            int B = Integer.parseInt(strings[1]);
            
            Pair pair = new Pair(A, B);
            if(pair.Sum() == 0)
                break;
            bw.write(pair.Sum() + "\n");
        }
        bw.flush();
        bw.close();
        bf.close(); 
    }
}
