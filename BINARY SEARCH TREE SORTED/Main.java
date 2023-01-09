public class Main {
    public static void main(String[] args) {
        Tree t = new Tree();

        System.out.println("In order");
        t.printInOrder(t.seed);
        System.out.println("\nPost order");
        t.printPreOrder(t.seed);
        System.out.println("\nPre order");
        t.printPostOrder(t.seed);

        System.out.println("In order with out recursion");
        t.inOrderWithOutRecursion();
        System.out.println("\n");
        System.out.println("min node: "+t.findMinNode().getData());
        System.out.println("max node: "+t.findMaxNode().getData());

        System.out.println(t.containsNode(89));
    }
}