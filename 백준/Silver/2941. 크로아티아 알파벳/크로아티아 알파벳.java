import java.io.*;
import java.security.Key;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = br.readLine().toCharArray();
        int count = 0;
        for(int i = 0; i < charArray.length; i++){
            if(i==charArray.length-1){
                count++;
                break;
            }
            if(charArray[i] == 'c'){
                if(charArray[i+1] == '='){
                    i+=1;
                    count++;
                    continue;
                }
                else if(charArray[i+1] == '-'){
                    i+=1;
                    count++;
                    continue;
                }
            }
            else if(charArray[i] == 'd'){
                if(charArray[i+1] == 'z'){
                    if(i==charArray.length-2){
                        count+=2;
                        break;
                    }
                    if(charArray[i+2] == '='){
                        i+=2;
                        count++;
                        continue;
                    }
                }
                else if(charArray[i+1] == '-'){
                    i+=1;
                    count++;
                    continue;
                }
            }
            else if(charArray[i] == 'l'){
                if(charArray[i+1] == 'j'){
                    i+=1;
                    count++;
                    continue;
                }
            }
            else if(charArray[i] == 'n'){
                if(charArray[i+1] == 'j'){
                    i+=1;
                    count++;
                    continue;
                }
            }
            else if(charArray[i] == 's'){
                if(charArray[i+1] == '='){
                    i+=1;
                    count++;
                    continue;
                }
            }
            else if(charArray[i] == 'z'){
                if(charArray[i+1] == '='){
                    i+=1;
                    count++;
                    continue;
                }
            }
            count++;
        }
        System.out.println(count);
    }
}
