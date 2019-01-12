package bdms1;
import java.util.Date;

class Bus implements Runnable{
    String name;
    Date inTime;
    Depot d;
    
    public Bus(Depot d){
        this.d = d;
    }
    
    public String getName(){
        return name;
    }
    
    public Date getInTime(){
        return inTime;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setInTime(Date inTime){
        this.inTime = inTime;
    }
    
    public void run(){
        goForRepair();
    }
    
    private synchronized void goForRepair(){
        d.add(this);
    }
}
