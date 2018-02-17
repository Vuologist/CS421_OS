import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class RR {

    private final Map<String, Integer> jobList;
    private final int timeSlice;
    private int sum = 0;

    public RR(Map<String,Integer> container, int timeSlice){
        jobList = new LinkedHashMap<>(container);
        this.timeSlice = timeSlice;
        runRR();
    }

    public int getSum(){return sum;}

    private void runRRAlgorithm(){
        sum = 0;
        Set<String> key = sortedJobListMapByValue.keySet();

        for(String k : key){
            sum+=sortedJobListMapByValue.get(k);
            System.out.println(k + "\t\tTime Taken: " + sortedJobListMapByValue.get(k) +
                    "\t\tTOTAL Time Taken: " + sum);
        }
    }
    }

}
