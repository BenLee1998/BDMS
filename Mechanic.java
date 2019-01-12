package bdms1;

public class Mechanic implements Runnable{
    
    Depot d;
    public boolean closingTime = false;
        
    private String counter;
    
    public Mechanic(Depot d){
        this.d = d;
    }
    
    public void run(){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException iex){
            iex.printStackTrace();
        }
        System.out.println("Mechanic started...");
        while(!closingTime){
            d.getRepair();
        }
        
        if(closingTime){
            try{
                Thread.sleep(5000);
            }catch(InterruptedException iex){
                iex.printStackTrace();
            }
        }
    }
    
    public synchronized void setClosingTIme(){
        closingTime = true;
        System.out.println("Mechanic: We're closing now!");
    }
    
    public String getCounter(){
        return counter;
    }
    
    public void setCounter (String c){
        counter = c;
    }
}
