import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<String> stack = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String[] strArr = br.readLine().split("");
        for (String s : strArr) {
            if (s.matches("[A-Z]"))
                sb.append(s);
            else if (s.equals("("))
                stack.push(s);
            else if (s.equals(")")) {
                String pop;
                while (!(pop = stack.pop()).equals("(")) {
                    sb.append(pop);
                }
            } else {
                //스택은 우선 순위 별로 나열, 다만 괄호 들어오면 초기화라 괄호까지만 검색? 정렬? 아무튼
                //stack.peek().equals("(") 이게 부분을 나누는 조건
                //precedence(stack.peek()) >= precedence(s)) 현재 s에 +,-가 들어오면 무조건 pop until empty(괄호 만나면 스톱), *,/가 들어오면 *,/만 pop
                while (!stack.isEmpty() && !stack.peek().equals("(") && precedence(stack.peek()) >= precedence(s))
                    sb.append(stack.pop());

                stack.push(s);
            }
        }
        while (!stack.isEmpty())
            sb.append(stack.pop());
        System.out.println(sb);
    }

    static int precedence(String op) {
        if (op.equals("*") || op.equals("/")) return 2;
        if (op.equals("+") || op.equals("-")) return 1;
        return 0; // '('
    }
}


