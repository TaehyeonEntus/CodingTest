import java.util.*;

public class Main {

    public static String DiceGame(ArrayList<Integer> list){
        String string = new String();
        
        if(list.get(0) == list.get(1)){
            if(list.get(1) == list.get(2)){ 
                //1,2,3 같을 때
                string = Integer.toString(10000 + list.get(0) * 1000);
                return string;
            }
            //1,2 같을 때
            string = Integer.toString(1000 + list.get(0) * 100);
            return string;
        } else {
            //2,3 같을 때
            if(list.get(1) == list.get(2)){
                string = Integer.toString(1000 + list.get(1) * 100);
                return string;
            }
            //모두 다를 때
            string = Integer.toString(list.get(2) * 100);
            return string;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] strings = string.split(" ");
        
        ArrayList<Integer> list = new ArrayList<>();
        for(String str : strings)
            list.add(Integer.parseInt(str));
        
        Collections.sort(list);
        
        System.out.println(DiceGame(list));
    }
}
