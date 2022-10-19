public class Main {

    public static void main(String[] args){
        Sll newSll1 = new Sll("newSll1");


        newSll1.insertFirst(4);
        newSll1.insertFirst(3);
        newSll1.insertFirst(1);
        newSll1.insertFirst(0);
        newSll1.deleteIndex(0);

        //newSll1.insertBeforeIndex(16,3);
        //System.out.println(newSll1.get(1));
        newSll1.printSll();
    }
}
