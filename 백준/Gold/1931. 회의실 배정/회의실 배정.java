import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Meeting> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            list.add(new Meeting(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
        }

        list.sort(Comparator
                .comparing(Meeting::getEnd)
                .thenComparing(Meeting::getStart));

        int current = 0;
        int count = 0;
        for (Meeting meeting : list) {
            int start = meeting.getStart();
            int end = meeting.getEnd();
            if (start >= current) {
                current = end;
                count++;
            }
        }
        System.out.println(count);
    }

    public static class Meeting {
        int start;
        int end;

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
