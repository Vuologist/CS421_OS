import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FCFS {

    private final Map<String,Integer> timeList;
    private int turnaroundTime;
    private double averageTurnaroundTime;
    private double averageProcessingTime;
    private double averageWaitingTime;

    public FCFS(Map<String,Integer> container){
        timeList = new LinkedHashMap<String,Integer>(container);
        runFCFSAlgorithm();
    }

    private void runFCFSAlgorithm(){
        Set<String> keys = timeList.keySet();
        int processTimePrint = 0;
        for(String k : keys){
            processTimePrint+=timeList.get(k);
            turnaroundTime+=processTimePrint;

            System.out.printf("%s \t\tStart Time: %3d \t\tEnd Time: %3d \t\tCompletion Time of %-6s: %3d \n",
                                k, (processTimePrint-timeList.get(k)), processTimePrint, k, processTimePrint);
        }
        calculateFCFSAverages();
        System.out.println();
    }

    public void printFCFSAverages(){
        System.out.println("FCFS Average Processing Time (APT): " + averageProcessingTime);
        System.out.println("FCFS Average Waiting Time (AWT): " + averageWaitingTime);
        System.out.println("FCFS Average Turnaround Time(ATT): " + averageTurnaroundTime);
    }

    private void calculateFCFSAverages(){
        FCFSAverageProcessingTime();
        FCFSTurnaroundTime();
        FCFSAverageWaitingTime();
    }

    public void FCFSAverageProcessingTime(){
        Set<String> keys = timeList.keySet();
        int processTime = 0;
        for(String k : keys){
            processTime+=timeList.get(k);
        }
        averageProcessingTime = (double)processTime/timeList.size();

    }

    public void FCFSAverageWaitingTime(){
        averageWaitingTime = averageTurnaroundTime - averageProcessingTime;
    }

    public void FCFSTurnaroundTime(){
        averageTurnaroundTime = (double)turnaroundTime/timeList.size();

    }

}
