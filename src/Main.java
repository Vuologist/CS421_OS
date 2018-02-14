import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Integer> container;

    private static void readFile(String fileName) {
        try{
            URL path = Main.class.getResource(fileName);
            if(path==null){
                System.out.println("file not found");
            }

            container = new ArrayList<Integer>();
            int counter = 1;
            File file = new File(path.getFile());
            Scanner sc = new Scanner(file);

            while (sc.hasNext()){
                sc.useDelimiter("\n|\r");
                //System.out.println(sc.nextLine());

                if(counter%2 == 0) {
                    String temp = sc.nextLine();
                    //System.out.println(counter + " value: " + sc.nextLine());
                    int num = Integer.parseInt(temp);
                    //System.out.println(num);
                    container.add(num);

                }else {
                    //System.out.println(counter + " " + sc.nextLine());
                    sc.nextLine();
                }
                counter++;
            }
        } catch (FileNotFoundException e){
            System.out.println("file not found");
        }
        //System.out.println("size: " + container.size());
        System.out.println(container +  " ");
    }


    private static double averageTime(int sum){
        return (double)sum/container.size();
    }

    public static void main (String args[]){
        readFile("test.txt");

        //FCFS fcfs = new FCFS(container);
        //System.out.println("\n" + "average Time for SJF: " + averageTime(fcfs.getSJFSum()));

        SJF sjf = new SJF(container);

    }
}
