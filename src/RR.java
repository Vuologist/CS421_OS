import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

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

                    processTime+=((jobList.get(k) >= timeSlice) ? timeSlice :jobList.get(k));
                    // (jobList.get(k)-timeSlice > 0 ? jobList.get(k)-timeSlice : 0) to zero out negatives
                    System.out.printf("%s \tStart Time: %4d \tEnd Time: %4d \tTime Remaining: %4d",
                            k, (processTime - ((jobList.get(k) >= timeSlice) ? timeSlice :jobList.get(k))), processTime, (jobList.get(k)-timeSlice > 0 ? jobList.get(k)-timeSlice : 0));

                    if(jobList.get(k)-timeSlice<=0) {
                        //System.out.print("\t\t" + turnaroundTime + " + " + processTime);
                        turnaroundTime+=processTime;
                        System.out.printf("\t\tCompletion Time of %-6s: %4d\n", k, processTime);
                    } else {
                        System.out.println();
                    }
                    jobList.put(k, jobList.get(k) - timeSlice);
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
        //RRAverageProcessingTime(); - has to be calculated first or else original value overwritten
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
