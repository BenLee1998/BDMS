package bdms1;

public class BDMS1 {

    public static void main(String[] args) {
        Depot d = new Depot();
        
        Mechanic m = new Mechanic(d);
        Generator gen = new Generator(d);
        
        Thread thm = new Thread(m);
        Thread thgen = new Thread(gen);
        thgen.start();
        thm.start();
        
        Clock c = new Clock(gen, m);
        c.start();
    }
}
