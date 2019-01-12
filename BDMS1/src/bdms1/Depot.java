package bdms1;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

class Depot {
    int waitarea = 5;
    
    //public boolean checkmech = true;
    
    List<Bus> listBus;
    
    public Depot(){
        listBus = new LinkedList<Bus>();
    }
    
    public void getRepair(){
        Bus bus = null;
        Mechanic[] mechArray = new Mechanic[5];
        String temp;
        Depot depot;
        
        synchronized(listBus){
            //while(!checkmech){
            for(int counter = 0; counter < mechArray.length; counter++){
                while(listBus.size() == 0){
                    System.out.println("Mechanic" + counter +" is waiting for bus.");
                    try{
                        listBus.wait();
                    }catch(InterruptedException iex){
                        iex.printStackTrace();
                    }
                }
                System.out.println("Mechanic" + counter + "found a bus in the queue.");
                bus = (Bus)((LinkedList<?>) listBus).poll();
                
                temp = Integer.toString(counter);
                mechArray[counter] = new Mechanic();
                mechArray[counter].setCounter(temp);
            }
  
                long duration = 0;
                try{
                    System.out.println("Mechanic" + counter + " repairing Bus " + bus.getName());
                    duration = (long) 7.5; //7500ms to repair bus
                    TimeUnit.SECONDS.sleep(duration);
                }catch(InterruptedException iex){
                    iex.printStackTrace();
                }
                System.out.println("Completed repairing Bus " + bus.getName() + "in " + duration + " seconds.");
                System.out.println("Bus " + bus.getName() + " exits");
            
            
            
        }
    }
            
//            while(listBus.size()==0){
//                
//                
//                for(int counter = 0; counter < 5; counter ++){
//                    System.out.println("Mechanic" + counter +"is waiting for customer.");
//                    try{
//                        listBus.wait();
//                    }catch(InterruptedException iex){
//                        iex.printStackTrace();
//                    }
//                }
//                System.out.println("Mechanic" + counter + "found a bus in the queue.");
//                bus = (Bus)((LinkedList<?>) listBus).poll();
//            }
        
//                System.out.println("Mechanic is waiting for customer.");
//                try{
//                    listBus.wait();
//                }catch(InterruptedException iex){
//                    iex.printStackTrace();
//                }
//            }
//            System.out.println("Mechanic found a bus in the queue.");
//            bus = (Bus)((LinkedList<?>) listBus).poll();
//        }
//        long duration = 0;
//        try{
//            System.out.println("Repairing Bus " + bus.getName());
//            duration = (long) (Math.random() * 10);
//            TimeUnit.SECONDS.sleep(duration);
//        }catch(InterruptedException iex){
//            iex.printStackTrace();
//        }
//        System.out.println("Completed repairing Bus " + bus.getName() + "in " + duration + " seconds.");
//        System.out.println("Bus " + bus.getName() + " exits");
    
        
    public void add(Bus bus){
        System.out.println("Bus " + bus.getName() + "entering the depot at " + bus.getInTime());

        synchronized(listBus){
            if(listBus.size() == waitarea){
                System.out.println("No waiting area available for bus " + bus.getName());
                System.out.println("Bus " + bus.getName() + "Exits");
                return;
            }
            ((LinkedList<Bus>) listBus).offer(bus);
            System.out.println("Bus " + bus.getName() + "got to the waiting area.");

            if(listBus.size() == 1){
                listBus.notifyAll();
            } 
        }
    }
}
