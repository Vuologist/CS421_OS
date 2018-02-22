import java.util.*;

public class SJF {
    private final List<SJFObjects> jobList;
    private int turnaroundTime;
    private double averageTurnaroundTime;
    private double averageProcessingTime;
    private double averageWaitingTime;

    public SJF(Map<String,Integer> container){
        jobList = new ArrayList<>();

        for(Map.Entry<String,Integer> entry: container.entrySet()){
            jobList.add(new SJFObjects(entry.getKey(),entry.getValue()));
        }
        //System.out.println("constructor: " + jobList);
        Collections.sort(jobList);
        //System.out.println("sorted" + jobList);
        runSJFAlgorithm();
    }


    private void runSJFAlgorithm(){
        int processTimePrint = 0;
        turnaroundTime = 0;

        for(SJFObjects a : jobList){
            processTimePrint+=a.getTime();
            turnaroundTime+=processTimePrint;

            System.out.printf("%s \tStart Time: %4d \t\tEnd Time: %4d \t\tCompletion Time of %-6s: %4d \n",
                    a.getJob(), (processTimePrint-a.getTime()), processTimePrint, a.getJob(), processTimePrint);
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
        int processTime = 0;

        for(SJFObjects a : jobList){
            processTime+=a.getTime();
        }

        averageProcessingTime = (double)processTime/jobList.size();
    }

    private void SJFAverageWaitingTime(){
        averageWaitingTime = averageTurnaroundTime - averageProcessingTime;
    }

    private void SJFAverageTurnaroundTime(){
        averageTurnaroundTime = (double)turnaroundTime/jobList.size();
    }
}
