import java.util.*;

public class SJF {

    private final List<Integer> jobList;
    private Map<String, Integer> jobListMap;
    private Map<String, Integer> sortedJobListMapByValue;
    private int sum;

    public SJF(List<Integer> container){
        jobList = new ArrayList<>(container);
        jobListMap = new TreeMap<>();
        generateJobListMap();
        //runSJFAlgorithm();
    }

    public int getSJFSum(){return sum;}

    private void generateJobListMap(){
        for(int i=0; i < jobList.size();i++){
            //System.out.println(jobList.get(i));
            jobListMap.put(Integer.toString(i+1), jobList.get(i));
        }
        sortJobListMapByKey();
        System.out.println(sortedJobListMapByValue);
    }

    private void sortJobListMapByKey(){
        sortedJobListMapByValue = new TreeMap<String,Integer>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return jobListMap.get(o1).compareTo(jobListMap.get(o2));
            }
        });
        sortedJobListMapByValue.putAll(jobListMap);
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
