import java.util.Stack;

public class Tree {
    Node seed;
    int totalNodes;
    int totalLevels;

    public Tree()
    {
        this.totalNodes = 0;
        this.totalLevels = 0;
        this.seed = new Node(25);
        totalNodes++;
        totalLevels++;

        seed.left = new Node(15);
        seed.right = new Node(50);
        totalNodes += 2;
        totalLevels++;

        seed.left.left = new Node(10);
        seed.left.right = new Node(22);
        totalNodes += 2;

        seed.left.left.left = new Node(4);
        seed.left.left.right = new Node(12);
        totalNodes += 2;

        seed.left.right.left = new Node(18);
        seed.left.right.right = new Node(24);
        totalNodes += 2;

        seed.right.right = new Node(70);
        seed.right.left = new Node(35);
        totalNodes += 2;
        totalLevels++;

        seed.right.left.left = new Node(31);
        seed.right.left.right = new Node(44);
        totalNodes += 2;

        seed.right.right.left = new Node(60);
        seed.right.right.right = new Node(90);
        totalNodes +=2;
        totalLevels++;

    }

    /**
     * INORDER
     * Va hasta la izquierda del todo e imprime izquierda medio derecha.
     * */
    public void printInOrder(Node n){
        if(n == null){
            return;
        }
        printInOrder(n.left);
        System.out.println(n.getData());
        printInOrder(n.right);
    }

    /**
     * PREORDER
     * Va imprimiendo los medios despues izquierda y por ultimo derecha
     * */
    public void printPreOrder(Node n){
        if(n == null){
            return;
        }
        System.out.println(n.getData());
        printPreOrder(n.left);
        printPreOrder(n.right);
    }

    /**
     * POSTORDER
     * Va hasta la izquierda del todo e imprime despues derecha y oor ultimo el medio
     * */
    public void printPostOrder(Node n){
        if(n == null){
            return;
        }
        printPostOrder(n.left);
        printPostOrder(n.right);
        System.out.println(n.getData());
    }
    public void inOrderWithOutRecursion(){
        Stack<Node> nodes = new Stack<>();
        Node temp = seed;

        while(!nodes.isEmpty() || temp != null){
            if(temp != null){
                nodes.push(temp);
                temp = temp.left;
            }
            else{
                Node aux = nodes.pop();
                System.out.println(aux.getData());
                temp = aux.right;
            }
        }
    }

    public Node findMinNode(){
        Node temp = seed;
        while(temp.left != null){
            temp = temp.left;
        }
        return temp;
    }

    public Node findMaxNode(){
        Node temp = seed;
        while(temp.right != null){
            temp = temp.right;
        }
        return temp;
    }

    public boolean containsNode(int data){
        Node temp = seed;

        while(temp != null){
            if(temp.getData() == data){
                return true;
            }
            if(data < temp.getData()){
                temp = temp.left;
            }
            else{
                temp = temp.right;
            }
        }
        return false;
    }
}
