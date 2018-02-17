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
        for(int i = 0; i < sortedJobListMapByValue.size(); i++){
            sum+=sortedJobListMapByValue.get(i);
            System.out.println("Job " + (i+1) +
                    "\t\tTime Taken: " + sortedJobListMapByValue.get(i) +
                    "\t\tTOTAL Time Taken: " + sum);
        }
    }

}
