package bdms1;

public class Clock extends Thread {
    private Generator gen;
    private Mechanic m;
    
    public Clock(Generator gen, Mechanic m){
        this.gen = gen;
        this.m = m;
    }
    
    public void run(){
        try{
            Thread.sleep(120000);//2 minutes to simulate 8 hours
            NotifyClosed();
        }catch(InterruptedException iex){
            iex.printStackTrace();
        }
    }
    
    public synchronized void NotifyClosed(){
        System.out.println("Clock: It's closing time folks");
        gen.setClosingTime();
        m.setClosingTIme();
    }
}
