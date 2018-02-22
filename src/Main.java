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

    private static void test1(){
        readFile("testdata1.txt");
        System.out.println("\n**********TestData1**********\n");
        System.out.println("---First Come First Server---\n");
        FCFS fcfs = new FCFS(container);
        fcfs.printFCFSAverages();

        System.out.println("\n---Shortest Job First---\n");
        SJF sjf = new SJF(container);
        sjf.printSJFAverages();

        System.out.println("\nRound Robin - 2\n");
        RR rr2 = new RR(container, 2);
        rr2.printRRAverages();

        System.out.println("\nRound Robin - 5\n");
        RR rr5 = new RR(container, 5);
        rr5.printRRAverages();

    }

    private static void test2(){
        readFile("testdata2.txt");
        System.out.println("\n**********TestData2**********\n");
        System.out.println("---First Come First Server---\n");
        FCFS fcfs = new FCFS(container);
        fcfs.printFCFSAverages();

        System.out.println("\n---Shortest Job First---\n");
        SJF sjf = new SJF(container);
        sjf.printSJFAverages();

        System.out.println("\nRound Robin - 2\n");
        RR rr2 = new RR(container, 2);
        rr2.printRRAverages();

        System.out.println("\nRound Robin - 5\n");
        RR rr5 = new RR(container, 5);
        rr5.printRRAverages();

    }
    private static void test3(){
        readFile("testdata3.txt");
        System.out.println("**********TestData3**********\n");
        System.out.println("---First Come First Server---\n");
        FCFS fcfs = new FCFS(container);
        fcfs.printFCFSAverages();

        System.out.println("\n---Shortest Job First---\n");
        SJF sjf = new SJF(container);
        sjf.printSJFAverages();

        System.out.println("\nRound Robin - 2\n");
        RR rr2 = new RR(container, 2);
        rr2.printRRAverages();

        System.out.println("\nRound Robin - 5\n");
        RR rr5 = new RR(container, 5);
        rr5.printRRAverages();
    }

    public static void main (String args[]){
        test1();
        test2();
        test3();
    }
}
