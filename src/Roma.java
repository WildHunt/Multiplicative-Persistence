import java.util.ArrayList;
import java.util.Random;
import java.util.*;
import  java.lang.Thread;

public class Roma  extends Thread{
    public ArrayList<Integer> massive;
    public ArrayList<Integer> cats = new ArrayList<Integer>();
    //public ArrayList dogs = new ArrayList();
    int[] numbers = {2, 3, 7, 8, 9, 4, 6};
    public int totalSteps=1;


    public Roma() {
        Random a = new Random();
        for (int i=0;i <40;i++){
            int num = a.nextInt(7);
            cats.add(numbers[num]);
           // System.out.print(cats.get(i));
        }
        //System.out.println();
    }


    @Override
    public void run() {
        System.out.println("Стартовал поток " + getName() + " Цифра: " + cats);
        multiply();

    }

    public void multiply(){
        if (cats.size()!=1){
            int temp;
            temp = cats.get(0) * cats.get(1);
            cats.set(0, temp);
            cats.remove(1);
            //System.out.println(cats);
            multiply();
        }
        else if (cats.get(0) >=10){
            totalSteps++;
            //System.out.println("======STEP NEW======");
            numberToList();
           // System.out.println(cats);
            multiply();
        }
        else {
           // System.out.println(cats.get(0));
            printIt();
        }


    }

    public void numberToList() {
        int temp = cats.get(0);
       // System.out.println(temp);
        cats.remove(0);
        while (temp != 0) {
            cats.add(temp % 10);
            temp /= 10;

        }
    }

    public boolean check(){
        if (cats.contains(0)){
            return false;
        }
        return true;
    }


    public void printIt(){
        //System.out.println(cats);
        System.out.println("Total: "+totalSteps + " Для потока " + getName());
        //System.out.println("Выполнен поток " + getName());

    }
}
