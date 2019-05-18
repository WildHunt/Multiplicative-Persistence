import  java.lang.Thread;

public class MyThread extends Thread {


    @Override
    public void run() {
        System.out.println("Выполнен поток " + getName());
    }
}
