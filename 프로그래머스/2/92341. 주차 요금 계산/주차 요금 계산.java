import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Pair 클래스 정의
class Pair<String, Integer> {
    public String key;
    public int value;

    public Pair(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getLeft() {
        return key;
    }

    public int getRight() {
        return value;
    }
    
    public void addTime(int time){
        value += time;
    }
}

//Record 클래스 정의
class Record{
    String number;
    int inTime;
    
    Record(String number, int inTime){
        this.number = number;
        this.inTime = inTime;
    }
}

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int BASE_TIME = fees[0];
        int BASE_FEE = fees[1];
        int UNIT_TIME = fees[2];
        int UNIT_FEE = fees[3];
        
        List<Record> recordList = new ArrayList<>();
        List<Pair<String, Integer>> feeList = new ArrayList<>();
        for(String s : records){
            String[] info = s.split(" ");
            int time = convertToMinutes(info[0]);
            String number = info[1];
            
            if(info[2].equals("IN")){
                recordList.add(new Record(number,time));
                continue;
            }
            
            if(info[2].equals("OUT")){
                Record r = getRecordWithNumber(recordList, number);
                boolean exist = false;
                int totalTime = time - r.inTime;
                for(Pair<String,Integer> p : feeList)
                    if(p.key.equals(r.number)){
                        p.addTime(totalTime);
                        exist = true;
                        break;
                    }
                if(!exist)
                    feeList.add(new Pair<>(number, totalTime));
                recordList.remove(r);
            }
        }
        
        int endTime = 23 * 60 + 59;
        for (Record r : recordList) {
            int totalTime = endTime - r.inTime;
            boolean exist = false;
            for (Pair p : feeList) {
                if (p.key.equals(r.number)) {
                    p.addTime(totalTime);
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                feeList.add(new Pair(r.number, totalTime));
            }
        }

        feeList.sort(Comparator.comparing(Pair::getLeft));

        // 정렬된 feeList에서 fee 값만 추출하여 answer 배열에 저장
        int[] answer = new int[feeList.size()];
        for (int i = 0; i < feeList.size(); i++) {
            answer[i] = calcFee(feeList.get(i).value, BASE_TIME, BASE_FEE,UNIT_TIME, UNIT_FEE);
        }
        return answer;
    }
    
    public int convertToMinutes(String timeString) {
        String[] parts = timeString.split(":");
        
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        
        int totalMinutes = (hours * 60) + minutes;
        
        return totalMinutes;
    }
    
    public Record getRecordWithNumber(List<Record> recordList, String number){
        for (Record record : recordList)
            if (record.number.equals(number))
                return record;
        return null;
    }
    
    public int calcFee(int totalTime,int BASE_TIME,int BASE_FEE,int UNIT_TIME,int UNIT_FEE){
        int totalFee = BASE_FEE;
        totalTime -= BASE_TIME;
        if (totalTime <= 0)
            return totalFee;
    
        
        totalFee += (totalTime/UNIT_TIME)*UNIT_FEE;
        if(totalTime%UNIT_TIME>0)
            totalFee += UNIT_FEE;
        
        return totalFee;
    }
}
