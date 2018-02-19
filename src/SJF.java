import java.util.*;

public class SJF {
    private final Map<String, Integer> jobList;
    private Map<String, Integer> sortedJobListMapByValue;
    private int sum;

    public SJF(Map<String,Integer> container){
        jobList = new LinkedHashMap<>(container);
        System.out.println("constructor: " + jobList);
        sortJobListMapByValue();
        runSJFAlgorithm();
    }

    public int getSJFSum(){return sum;}

    private void sortJobListMapByValue(){
        sortedJobListMapByValue = new TreeMap<>(new SJFValueComparator(jobList));
        sortedJobListMapByValue.putAll(jobList);
        System.out.println("sorted: " + sortedJobListMapByValue);
    }

    private void runSJFAlgorithm(){
        sum = 0;
        Set<String> key = sortedJobListMapByValue.keySet();

        for(String k : key){
            sum+=sortedJobListMapByValue.get(k);

            System.out.printf("%s \tStart Time: %4d \t\tEnd Time: %4d \t\tTime Taken: %4d \t\tTOTAL Time Taken: %4d \n",
                    k, (sum-sortedJobListMapByValue.get(k)), sum, sortedJobListMapByValue.get(k), sum);


//            System.out.println(k + "\t\tTime Taken: " + sortedJobListMapByValue.get(k) +
//                    "\t\tTOTAL Time Taken: " + sum);
        }
    }
}
