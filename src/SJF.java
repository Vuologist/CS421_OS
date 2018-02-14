import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SJF {

    private List<Integer> jobList;
    private Map<String, Integer> jobListMap;
    private int sum;

    public SJF(List<Integer> container){
        jobList = new ArrayList<Integer>(container);
        generateJobListMap();
        runSJFAlgorithm();
    }

    public int getSJFSum(){return sum;}

    private void generateJobListMap(){
        for(int i=0; i < jobList.size();i ++){
            jobListMap.put(Integer.toString(i+1), jobList.get(i));
        }
    }

    private void runSJFAlgorithm(){
        sum = 0;
        for(int i = 0; i < jobListMap.size(); i++){
            sum+=jobListMap.get(i);
            System.out.println("Job " + (i+1) +
                    "\t\tTime Taken: " + jobListMap.get(i) +
                    "\t\tTOTAL Time Taken: " + sum);
        }
    }

}
