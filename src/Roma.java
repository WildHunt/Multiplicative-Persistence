import java.util.ArrayList;
import java.util.Random;
import  java.lang.Thread;

//[3, 3, 3, 4, 2, 8, 3, 8, 9, 6] total 8
//[4, 9, 6, 6, 2, 2, 7, 3, 4, 2, 7, 3, 3, 4, 2] total 10
//[7, 2, 4, 2, 8, 2, 6, 7, 7, 2, 3, 3, 7, 4, 3, 7, 7, 4, 4, 8] total 11

public class Roma  extends Thread{
    private ArrayList<Long> cats = new ArrayList<>();
    private final ArrayList<Long> dogs = new ArrayList<>();
    private final long[] numbers = {2, 3, 7, 8, 9, 4, 6};
    private int totalSteps=1;
    private final int maxSteps=7;


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

    private void setCats(ArrayList<Long> cats) {

        Random a = new Random();
        for (int i=0;i <20;i++){
            //long number = (long)(a.nextDouble()*7);
            int num = a.nextInt(7);
            cats.add(numbers[num]);
            dogs.add(numbers[num]);
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
        else if (totalSteps > maxSteps){
            printIt();
            System.out.println(dogs);
          //  loop();

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
        else {
            for (int i=dogs.size(); i< dogs.size()-10;i--){
                System.out.println("max"+ dogs.get(i)+ getName());
            }

        }


    }

    private void deleteCats(){
        cats.remove(0);
    }

    private void clearCats()
    {
        totalSteps=1;
        //System.out.print(cats.get(i));
        if (11 > 11) {
            cats.subList(11, 11).clear();
        }
    }

    private void printIt(){
        if (totalSteps>=maxSteps)
        System.out.println("Total: "+totalSteps + "Number"+ cats+" Для потока " + getName());

    }
}
