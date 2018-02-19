import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<String,Integer> container;

    private static void readFile(String fileName) {
        try{
            URL path = Main.class.getResource(fileName);
            if(path==null){
                System.out.println("file not found");
            }

            container = new LinkedHashMap<String, Integer>();
            //int counter = 1;
            File file = new File(path.getFile());
            Scanner sc = new Scanner(file);

            while (sc.hasNext()){
                sc.useDelimiter("\n|\r");
                //System.out.println(sc.nextLine());
                String jobTitle = sc.nextLine();
                int jobTime = Integer.parseInt(sc.nextLine());

                container.put(jobTitle,jobTime);
            }
        } catch (FileNotFoundException e){
            System.out.println("file not found");
        }
        //System.out.println("size: " + container.size());
        //System.out.println(container +  " ");
    }


    private static double averageTime(int sum){
        return (double)sum/container.size();
    }

    public static void main (String args[]){
        readFile("test.txt");

        //FCFS fcfs = new FCFS(container);
        //System.out.println("\n" + "average Time for SJF: " + averageTime(fcfs.getSJFSum()));

        //SJF sjf = new SJF(container);
        //System.out.println("\n" + "average Time for SJF: " + averageTime(sjf.getSJFSum()));

        RR rr2 = new RR(container, 2);
        System.out.println("\n" + "average Time for RR2: " + averageTime(rr2.getRRSum()));

        //RR rr3 = new RR(container, 3);
        //System.out.println("\n" + "average Time for RR2: " + averageTime(rr3.getRRSum()));


    }
}
