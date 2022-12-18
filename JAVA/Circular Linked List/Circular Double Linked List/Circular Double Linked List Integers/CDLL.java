import java.sql.SQLOutput;

/**
 * Clase para representar una lista doblemente enlazada circular
 * CDLL = Circular Double Linked List
 * */
public class CDLL {

    //Atributos de clase
    Node head,tail;
    int size;
    String nombreLista;

    /**
     * Constructor parametrizado
     * @param=String nombreLista
     *
     * */
    public CDLL(String nombreLista)
    {
        this.size = 0;
        this.nombreLista = nombreLista;
    }

    /**
     * MODIFICADOR: privado
     * NOMBRE: isEmpty()
     * TIPO: boolean
     * PARAMETROS: 0
     *
     * DESCRIPCION: Comprueba si la lista esta vacia o no.
     **/
    private boolean isEmpty(){
        return size == 0 ? true : false;
    }

    /**
     * MODIFICADOR: privado
     * NOMBRE: isEmpty()
     * TIPO: boolean
     * PARAMETROS: 0
     *
     * DESCRIPCION: Comprueba si la lista esta vacia o no.
     **/
    public void printList(){
        System.out.println(this.nombreLista);
        int cont = 0;

        Node temp = head;
        do{
            if(temp.next == head){
                System.out.println(temp.getData()+"<-");
                break;
            }
            else if(temp == head){
                System.out.print("->"+temp.getData()+" <-> ");
                temp = temp.next;
            }
            else{
                System.out.print(temp.getData()+" <-> ");
                temp = temp.next;
            }
            cont++;
        }while(temp != head);

        for(int ite = 0 ; ite <= cont ; ite++){
            if(ite == 0){
                System.out.print("'-------");
            }
            else if(ite == size-1){
                System.out.println("--'");
            }
            else{
                System.out.print("------");
            }
        }

        System.out.println("SIZE: "+size);
        System.out.println("HEAD: "+head.getData());
        System.out.println("TAIL: "+tail.getData());
        getFirstFromLast();
        getlastFromFirst();
    }

    /**
     * PRIVATE
     * Metodo para probar que se trata de una lista doblemente enlazada circular.
     * Desde el primer nodo con su referencia al previo se obtiene el ultimo.
     * */
    private void getlastFromFirst(){
        System.out.println("NODO PREVIO AL PRIMERO: "+head.prev.getData());
    }

    /**
     * PRIVATE
     * Metodo para probar que se trata de una lista doblemente enlazada circular.
     * Desde el ultimo nodo se puede acceder al primero mediante la referencia next.
     * */
    private void getFirstFromLast(){
        System.out.println("NODO SIGUIENTE AL ULTIMO: "+tail.next.getData());
    }

    /**
     * MODIFICADOR: public
     * NOMBRE: addFirst
     * TIPO: void
     * PARAMETROS: 1 -> int data
     *
     * DESCRIPCION: Inserta un nodo con el dato especificado al comienzo de la lista. Cambiando las referencias.
     **/
    public void addFirst(int data){

        Node node = new Node(data);

        if(isEmpty()){
            head = node;
            tail = node;
            node.next = head;
            node.prev = tail;
            size++;
            return;
        }

        node.next = head;
        head.prev = node;

        head = node;
        head.prev = tail;
        tail.next = head;

        size++;
    }

    /**
     * MODIFICADOR: public
     * NOMBRE: addLast
     * TIPO: void
     * PARAMETROS: 1 -> int data
     *
     * DESCRIPCION: Inserta un nuevo nodo con el dato especificado al final de la lista.
     **/
    public void addLast(int data){
        if(isEmpty()){
            addFirst(data);
            return;
        }

        Node node = new Node(data);

        tail.next = node;
        node.prev = tail;

        tail = node;

        tail.next = head;
        head.prev = tail;

        size++;
    }

    /**
     * Clase interna privada para representar los nodos que comprondan la lista
     * */
    private class Node{

        //Atributos de clase
        Node next,prev;//Referencias de tipo Node al siguiente nodo y al previo
        int data;//Lo que contiene el nodo que en este caso es un entero

        /**
         * Constructor parametrizado
         * @param=int data
         * */
        public Node(int data)
        {
            this.data = data;
        }

        /**
         * Constructor parametrizado
         * @param=int data
         * @param=Node next
         * @param=Node prev
         * */
        public Node(Node next, Node prev, int data)
        {
            this.next = next;
            this.prev = prev;
            this.data = data;
        }

        /**
         * GETTERS Y SETTERS PARA LOS ATRIBUTOS
         * */
        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }
}
