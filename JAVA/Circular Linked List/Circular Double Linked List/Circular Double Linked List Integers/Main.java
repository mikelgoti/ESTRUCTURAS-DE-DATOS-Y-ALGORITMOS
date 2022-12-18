public class Main {
    public static void main(String[] args) {
        CDLL cdll1 = new CDLL("mi lista");

        cdll1.addFirst(3);
        cdll1.addFirst(2);
        cdll1.addFirst(1);
        cdll1.addFirst(0);
        cdll1.addLast(4);

        cdll1.printList();
    }
}
