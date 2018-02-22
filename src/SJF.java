import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SJF {
    private final Map<String, Integer> jobList;
    private Map<String, Integer> sortedJobListMapByValue;
    private int turnaroundTime;
    private double averageTurnaroundTime;
    private double averageProcessingTime;
    private double averageWaitingTime;

    public SJF(Map<String,Integer> container){
        jobList = new LinkedHashMap<>(container);
        //System.out.println("constructor: " + jobList);
        sortJobListMapByValue();
        runSJFAlgorithm();
    }

    private void sortJobListMapByValue(){
        sortedJobListMapByValue = new TreeMap<>(new SJFValueComparator(jobList));
        sortedJobListMapByValue.putAll(jobList);
        //System.out.println("sorted: " + sortedJobListMapByValue);
    }

    private void runSJFAlgorithm(){
        //set throw out duplicates, and 5 is a duplicate
        //might just want to sort, run fcfs, and then access a hash table for job names
        Set<String> key = sortedJobListMapByValue.keySet();
        int processTimePrint = 0;
        turnaroundTime = 0;

        for(String k : key){
            processTimePrint+=sortedJobListMapByValue.get(k);
            turnaroundTime+=processTimePrint;

            System.out.printf("%s \tStart Time: %4d \t\tEnd Time: %4d \t\tCompletion Time of %-6s: %4d \n",
                    k, (processTimePrint-sortedJobListMapByValue.get(k)), processTimePrint, k, processTimePrint);
        }
        calculateSJFAverages();
        System.out.println();
    }

    private void calculateSJFAverages(){
        SJFAverageProcessingTime();
        SJFAverageTurnaroundTime();
        SJFAverageWaitingTime();
    }

    public void printSJFAverages(){
        System.out.println("SJF Average Processing Time (APT): " + averageProcessingTime);
        System.out.println("SJF Average Waiting Time (AWT): " + averageWaitingTime);
        System.out.println("SJF Average Turnaround Time(ATT): " + averageTurnaroundTime);
    }

    private void SJFAverageProcessingTime(){
        Set<String> keys = sortedJobListMapByValue.keySet();
        int processTime = 0;
        for(String k : keys){
            processTime+=sortedJobListMapByValue.get(k);
        }
        averageProcessingTime = (double)processTime/sortedJobListMapByValue.size();
    }

    private void SJFAverageWaitingTime(){
        averageWaitingTime = averageTurnaroundTime - averageProcessingTime;
    }

    private void SJFAverageTurnaroundTime(){
        averageTurnaroundTime = (double)turnaroundTime/sortedJobListMapByValue.size();
    }

}
