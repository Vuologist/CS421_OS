import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import static java.lang.Math.abs;

public class RR {

    private final Map<String, Integer> jobList;
    private final int timeSlice;
    private int turnaroundTime;
    private double averageTurnaroundTime;
    private double averageProcessingTime;
    private double averageWaitingTime;

    public RR(Map<String,Integer> container, int timeSlice){
        jobList = new LinkedHashMap<>(container);
        this.timeSlice = timeSlice;
        RRAverageProcessingTime();
        runRRAlgorithm();
    }

    private void runRRAlgorithm(){
        int processTime = 0;
        turnaroundTime = 0;
        boolean stop;
        Set<String> key = jobList.keySet();

        System.out.println("Time slice is: " + timeSlice);

        do{
            for(String k : key){
                if(jobList.get(k) > 0){
                    jobList.put(k, jobList.get(k) - timeSlice);
                    processTime+=(timeSlice - ((jobList.get(k)>= 0) ? 0 : (timeSlice-abs(jobList.get(k)))));
                    // (jobList.get(k) > 0 ? jobList.get(k) : 0) to zero out negatives
                    System.out.printf("%s \tStart Time: %4d \t\tEnd Time: %4d \t\t%s Time Remaining: %4d",
                            k, (processTime - ((jobList.get(k)>= 0) ? 2 : (timeSlice-abs(jobList.get(k))))), processTime, k, jobList.get(k));
                    if(jobList.get(k)<=0) {
                        turnaroundTime+=processTime;
                        System.out.printf("\t\tCompletion Time of %-6s: %4d\n", k, turnaroundTime);
                    } else {
                        System.out.println();
                    }
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

        calculateRRAverages();
        System.out.println();
    }

    public void printRRAverages(){
        System.out.println("RR-" + timeSlice + " Average Processing Time (APT): " + averageProcessingTime);
        System.out.println("RR-" + timeSlice + " Average Waiting Time (AWT): " + averageWaitingTime);
        System.out.println("RR-" + timeSlice + " Average Turnaround Time(ATT): " + averageTurnaroundTime);
    }

    private void calculateRRAverages(){
        //RRAverageProcessingTime();
        RRAverageTurnaroundTime();
        RRAverageWaitingTime();
    }

    private void RRAverageProcessingTime(){
        Set<String> keys = jobList.keySet();
        int processTime = 0;
        for(String k : keys){
            processTime+=jobList.get(k);
        }
        averageProcessingTime = (double)processTime/jobList.size();
    }

    private void RRAverageWaitingTime(){
        averageWaitingTime = averageTurnaroundTime - averageProcessingTime;
    }

    private void RRAverageTurnaroundTime(){
        averageTurnaroundTime = (double)turnaroundTime/jobList.size();
    }

}
