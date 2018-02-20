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

    public static void main (String args[]){
        readFile("test.txt");

        System.out.println("FCFS\n");
        FCFS fcfs = new FCFS(container);
        fcfs.printFCFSAverages();

        //SJF sjf = new SJF(container);


        //RR rr2 = new RR(container, 2);


        //RR rr5 = new RR(container, 5);



    }
}
