import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            long x = Long.parseLong(br.readLine());
            if (x == 1 || x== 0) {
                System.out.println(2);
                continue;
            }
            if (x == 2 || x == 3) {
                System.out.println(x);
                continue;
            }
            if (x % 2 == 0)
                x++;

            while (true) {
                boolean isUnique = true;
                for (long j = 3; j <= Math.sqrt(x); j += 2) {
                    if (x % j == 0) {
                        isUnique = false;
                        break;
                    }
                }

                if (isUnique) {
                    System.out.println(x);
                    break;
                }
                x += 2;
            }
        }
    }
}
