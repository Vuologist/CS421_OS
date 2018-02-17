import java.util.Comparator;
import java.util.Map;

public class SJFValueComparator implements Comparator<String> {
    private Map<String, Integer> map;

    public SJFValueComparator(Map<String, Integer> map){
        this.map = map;
    }

    public int compare(String a, String b) {
        //try catch
        try{
            Integer jobA = map.get(a);
            Integer jobB = map.get(b);
            if (jobA == 0) {
                return -1;
            }
            if (jobB == 0) {
                return 1;
            }
            if (jobA == jobB) {
                return 0;
            }
            //return a.compareTo(b);
            return map.get(a).compareTo(map.get(b));
        }catch (ClassCastException e){
            System.out.println("Error in compare -- String a: " + a + "    String b: " + b);
            return 0;
        }
    }

}
