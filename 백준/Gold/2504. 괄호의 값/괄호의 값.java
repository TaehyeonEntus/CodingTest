import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Deque<String> stack = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        String[] line = br.readLine().split("");
        for (String str : line) {
            if (str.equals("(") || str.equals("["))
                stack.push(str);
            else if (str.equals(")")) {
                int sum = 0;

                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    String pop = stack.pop();
                    if(pop.equals("[")) {
                        System.out.println(0);
                        return;
                    }
                    sum += Integer.parseInt(pop);
                }
                if (stack.isEmpty()) {
                    System.out.println(0);
                    return;
                }
                stack.pop();
                if (sum == 0)
                    stack.push("2");
                else
                    stack.push(String.valueOf(sum * 2));
            } else if (str.equals("]")) {
                int sum = 0;

                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    String pop = stack.pop();
                    if(pop.equals("(")) {
                        System.out.println(0);
                        return;
                    }
                    sum += Integer.parseInt(pop);
                }
                if (stack.isEmpty()) {
                    System.out.println(0);
                    return;
                }
                stack.pop();
                if (sum == 0)
                    stack.push("3");
                else
                    stack.push(String.valueOf(3 * sum));
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            if(pop.equals("(")||pop.equals("[")) {
                System.out.println(0);
                return;
            }
            sum += Integer.parseInt(pop);
        }
        System.out.println(sum);
    }
}