import java.util.ArrayList;

public class Main {

    static ArrayList <Integer> enteros = new ArrayList<>();

    public static void main(String[] args){
        Al l = new Al();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        l.add(7);
        l.add(8);
        l.add(9);
        l.add(10);
        l.add(11);

        System.out.println("ORIGINAL");
        l.printArrayList();


        System.out.println("COPIA");
        int copia[] = l.clone();

        for(int ite : copia){
            System.out.print("["+ite+"] ");
        }

        int array[] = {1,2,3,4};

    }
}
