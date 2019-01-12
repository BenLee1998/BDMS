package bdms1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

class Generator implements Runnable{
    Depot d;
    public boolean closingTime = false;

    public Generator(Depot d){
        this.d = d;
    }
    
    public void run(){
        while(!closingTime){
            Bus b = new Bus(d);
            b.setInTime(new Date());
            Thread thb = new Thread(b);
            b.setName("Bus " + thb.getId());
            thb.start();
            
            try{
                TimeUnit.SECONDS.sleep((long)(Math.random()*10));
            }catch(InterruptedException iex){
                iex.printStackTrace();
            }
        }
        if(closingTime){
            try{
                Thread.sleep(5000);
            }catch(InterruptedException iex){
                iex.printStackTrace();
            }return;
        }
    }
    
    public synchronized void setClosingTime(){
        closingTime = true;
        System.out.println("Closing? Ok.");
    }
}