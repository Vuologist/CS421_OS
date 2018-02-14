import java.util.ArrayList;
import java.util.List;

public class FCFS {

    private final List<Integer> timeList;
    private int sum;

    public FCFS(List<Integer> container){
        timeList = new ArrayList<Integer>(container);
        runFCFSAlgorithm();
    }

    public int getSJFSum(){return sum;}

    private void runFCFSAlgorithm(){
        sum = 0;
        for(int i = 0; i < timeList.size(); i++){
            sum+=timeList.get(i);
            System.out.println("Job " + (i+1) +
                                "\t\tTime Taken: " + timeList.get(i) +
                                "\t\tTOTAL Time Taken: " + sum);
        }
    }


}
