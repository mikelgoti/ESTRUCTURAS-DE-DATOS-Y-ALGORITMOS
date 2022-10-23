public class Main {
    public static void main(String[] args){
        Dll dllList = new Dll("pruebaLista");
        dllList.insertFirst(4);
        dllList.insertFirst(3);
        dllList.insertFirst(2);
        dllList.insertFirst(1);
        dllList.insertLast(5);
        dllList.insertLast(6);
        dllList.insertLast(8);
        dllList.insertLast(9);
        dllList.insert(7,7);
        dllList.removeLast();
        dllList.remove(3);
        dllList.remove(7);
        dllList.remove(5);
        dllList.insertFirst(0);
        dllList.insertLast(100);
        dllList.printDll();
    }
}
