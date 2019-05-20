import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import  java.lang.Thread;
//8, 9, 3, 6, 8, 4, 2, 3, 9, 2] total 9

public class Roma  extends Thread{
    private ArrayList<Long> cats = new ArrayList<>();
    private final long[] numbers = {2, 3, 7, 8, 9, 4, 6};
    private int totalSteps=1;
    private final int maxSteps=8;


    public Roma() {
//        Random a = new Random();
//        for (int i=0;i <10;i++){
//            //long number = (long)(a.nextDouble()*7);
//            int num = a.nextInt(7);
//            cats.add(numbers[num]);
//            //System.out.print(cats.get(i));
//        }
        setCats(this.cats);

    }


    @Override
    public void run() {
        System.out.println("Стартовал поток " + getName() + " Цифра: " + cats);
        multiply();

    }

    public void setCats(ArrayList<Long> cats) {
        //cats.removeAll(Collections<>);
        Random a = new Random();
        for (int i=0;i <10;i++){
            //long number = (long)(a.nextDouble()*7);
            int num = a.nextInt(7);
            cats.add(numbers[num]);
            //System.out.print(cats.get(i));
        }
        this.cats = cats;
    }

    private void multiply(){
       // System.out.println("Стартовал поток " + getName() + " Цифра: " + cats);
        if (cats.size()!=1){
            long temp;
            temp = cats.get(0) * cats.get(1);
            cats.set(0, temp);
            cats.remove(1);
           // System.out.println(cats);
            multiply();
        }
        else if (cats.get(0) >=10){
            totalSteps++;
            numberToList();
           // System.out.println(cats);
            multiply();
        }
        else {
           // System.out.println(cats.get(0));
            printIt();
            loop();
        }


    }

    private void numberToList() {
        long temp = cats.get(0);
        //System.out.println(temp);
        cats.remove(0);
        while (temp != 0) {
            cats.add(temp % 10);
            temp /= 10;

        }
    }

    public boolean check(){
        return !cats.contains(0L);
    }

    private void loop(){
        if (totalSteps<maxSteps){
           // new Roma().multiply();
            deleteCats();
            setCats(cats);
            multiply();

        }


    }

    private void deleteCats(){
        cats.remove(0);
    }

    private void printIt(){
        if (totalSteps>=maxSteps)
        System.out.println("Total: "+totalSteps + " Для потока " + getName());

    }
}
