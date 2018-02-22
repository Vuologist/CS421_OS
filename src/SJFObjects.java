
public class SJFObjects implements Comparable{

    private String job;
    private int time;

    public SJFObjects(String job, int time){
        this.job = job;
        this.time = time;
    }

    public String getJob() {
        return job;
    }

    public int getTime(){
        return time;
    }

    @Override
    public int compareTo(Object a) {
        int indicator =((SJFObjects)a).getTime();
        return this.time-indicator;
    }

    public String toString(){
        return "[" + job + "," + time + "]";
    }

}
