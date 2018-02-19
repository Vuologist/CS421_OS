import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static java.lang.Math.abs;

public class RR {

    private final Map<String, Integer> jobList;
    private final int timeSlice;
    private int sum = 0;

    public RR(Map<String,Integer> container, int timeSlice){
        jobList = new LinkedHashMap<>(container);
        this.timeSlice = timeSlice;
        runRRAlgorithm();
    }

    public int getRRSum(){return sum;}

    private void runRRAlgorithm(){
        sum = 0;
        boolean stop;
        Set<String> key = jobList.keySet();

        System.out.println("Time slice is: " + timeSlice);

        do{
            for(String k : key){
                if(jobList.get(k) > 0){
                    jobList.put(k, jobList.get(k) - timeSlice);
                    sum+=(timeSlice - ((jobList.get(k)>= 0) ? 0 : (timeSlice-abs(jobList.get(k)))));
                    // (jobList.get(k) > 0 ? jobList.get(k) : 0) to zero out negatives
                    System.out.println(k + "\t\tTime Remaining: " + (jobList.get(k))+
                            "\t\tTOTAL Time Taken: " + sum);
                }
            }

            stop = true;

            for(String j : key){
                if(jobList.get(j) > 0){
                    stop = false;
                    break;
                }
            }
        } while (stop == false);
    }


}
