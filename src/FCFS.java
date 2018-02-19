import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FCFS {

    private final Map<String,Integer> timeList;
    private int sum;

    public FCFS(Map<String,Integer> container){
        timeList = new LinkedHashMap<String,Integer>(container);
        runFCFSAlgorithm();
    }

    public int getSJFSum(){return sum;}

    private void runFCFSAlgorithm(){
        Set<String> keys = timeList.keySet();
        for(String k : keys){
            sum+=timeList.get(k);

            System.out.printf("%s \tStart Time: %4d \t\tEnd Time: %4d \t\tTime Taken: %4d \t\tTOTAL Time Taken: %4d \n",
                                k, (sum-timeList.get(k)), sum, timeList.get(k), sum);
//            System.out.println(k + "\t\tStart Time: " + (sum-timeList.get(k)) +
//                            "\t\tEnd Time: " + sum +
//                            "\t\tTime Taken: " + timeList.get(k) +
//                            "\t\tTOTAL Time Taken: " + sum);
        }
    }


}
