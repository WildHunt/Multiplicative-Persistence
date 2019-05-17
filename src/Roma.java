import java.util.ArrayList;
import java.util.Random;
import java.util.*;

public class Roma {
    public ArrayList<Integer> massive;
    public ArrayList<Integer> cats = new ArrayList<Integer>();
    //public ArrayList dogs = new ArrayList();
    int[] numbers = {2, 3, 7, 8, 9, 4, 6};
    public int totalSteps=1;


    public Roma() {
        Random a = new Random();
        for (int i=0;i <5;i++){
            int num = a.nextInt(7);
            cats.add(numbers[num]);
            System.out.print(cats.get(i));
        }
        System.out.println();
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
            System.out.println(cats.get(0));
        }


    }

    public void numberToList() {
        int temp = cats.get(0);
        System.out.println(temp);
        cats.remove(0);
        while (temp != 0) {
            cats.add(temp % 10);
            temp /= 10;

        }
    }


    public void printIt(){
        //System.out.println(cats);
        System.out.println("Total: "+totalSteps);

    }
}
