import java.util.ArrayList;
import  java.lang.Thread;

public class Main {

    public static void main(String[] args) {

        //System.out.println("Hello World!");
//        Roma g= new Roma();
//        g.multiply();
//        g.printIt();

        for (int i = 0; i < 10; i++) {
            Roma a= new Roma();
            //MyThread thread = new MyThread();
           // thread.start();
            a.start();
        }

    }

}
