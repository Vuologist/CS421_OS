import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<String> container;

    private static void readFile(String fileName) {
        try{
            URL path = Main.class.getResource(fileName);
            if(path==null){
                System.out.println("file not found");
            }

            container = new ArrayList<String>();
            int counter = 1;

            File file = new File (path.getFile());
            Scanner sc = new Scanner(file);

            while (sc.hasNext()){
                sc.useDelimiter("\n");
                if(counter%2 == 0) {
                    container.add(sc.next());
                    System.out.println("hit");
                }else {
                    sc.next();
                }
                counter++;
            }
        } catch (FileNotFoundException e){
            System.out.println("file not found");
        }
    }

    public static void main (String args[]){
        readFile("test.txt");
        //System.out.println(container.get(2));
        FCFS fcfs = new FCFS(container);

    }
}
