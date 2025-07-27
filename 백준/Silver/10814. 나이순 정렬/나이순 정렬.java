import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(br.readLine());

        List<User> list = new ArrayList<>();
        for(int j = 0; j < i; j++) {
            String[] line = br.readLine().split(" ");
            list.add(new User(Integer.parseInt(line[0]), line[1]));
        }

        list.sort(Comparator.comparing(User::getAge).thenComparing(User::getNumber));

        for(User user: list) {
            System.out.println(user.getAge() + " " + user.getName());
        }
    }
    public static class User{
        static int count = 0;
        int age;
        int number;
        String name;

        public int getNumber() {
            return number;
        }

        public User(int age, String name) {
            this.age = age;
            this.name = name;
            this.number = ++count;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }
    }
}
