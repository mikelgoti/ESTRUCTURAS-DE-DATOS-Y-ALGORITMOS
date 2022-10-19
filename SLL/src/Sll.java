/**
 * CLASE Sll =  SingleLinkedList
 * */
public class Sll {

    private Node head;
    private Node tail;
    private int size;
    private String nombre = "";
    private static final String MSJ_EMPTY = " is empty!";

    /**
     *CONSTRUCTOR Node
     * */
    public Sll(String nombre){
        this.size = 0;
        this.nombre = nombre;
    }

    /**
     * METODOS PRIVADOS
     * */
    private boolean isEmpty(){
        return size == 0;
    }

    private Node gN(int v){//gN = generateNode
        return new Node(v);
    }

    /**
     * METODOS PUBLICOS PARA INTERACTUAR CON LA LISTA
     * */
    public void printSll(){
        if(isEmpty()){
            System.out.println(nombre+MSJ_EMPTY);
            return;
        }

        Node temp = head;
        boolean aux = true;

        System.out.println("Lista enlazada "+nombre);
        while(aux == true){
            if(temp == tail){
                System.out.println("["+temp.getValue()+"]");
                aux = false;
            }
            else {
                System.out.print("[" + temp.getValue() + "] -> ");
                temp = temp.next;//Pasamos de nodo en nodo
            }
        }

        System.out.println("\nSize of the list: "+size);
        System.out.println("HEAD: "+head.value);
        System.out.println("TAIL: "+tail.value);
    }

    public void insertFirst(int v){
        Node n = gN(v);//Creamos el nodo
        n.next = head;//El valor del puntero next del nodo n será el anterior nodo que estaba el primero, es decir, head.
        head = n;//Asingamos la cabeza de la lista como el nuevo nodo creado.

        if(isEmpty()){
            tail = head;
        }
        size ++;//Agregamos un nodo a la lista por lo que su tam incrementa en 1.
    }

    public void deleteFirst(){

        if(isEmpty()){
            System.out.println(nombre+MSJ_EMPTY);
            return;
        }

        head = head.next;

        size--;
    }

    public void insertLast(int v){
        if(isEmpty()){
            insertFirst(v);//Si la lista esta vacia insertasPrimero de normal.
            return;
        }
        //Si no insertas al final asignando la referencia de la cola al nuevo nodo creado n.
            Node n = gN(v);
            tail.next = n;
            tail = n;
            size++;
    }

    /**
     * Devuelve el elemento del index especificado.
     * @param i = index
     * */
    public int get(int i){
        Node temp = head;
        for(int ite = 0 ; ite < i-1 ; ite++){
            temp = temp.next;
        }

        return temp.getValue();
    }

    /**
     * Inserta el elemento delante del index.
     * @param v = value
     * @param i = index
     * */
    public void insertBeforeIndex(int v, int i){

        if(i == 0 || i == 1){
            insertFirst(v);
            return;
        }

        if(i == size){
            insertLast(v);
            return;
        }

        Node temp = head;
        for(int ite = 1 ; ite < i-1 ; ite++){
            temp = temp.next;
        }

        Node n = new Node(v,temp.next);
        temp.next = n;

        size++;
    }
    /**
     * Inserta el elemento detras del index.
     * @param v = value
     * @param i = index
     * */
    public void insertAfterIndex(int v, int i){
        if(i == 0){
            insertFirst(v);
            return;
        }

        if(i == size){
            insertLast(v);
            return;
        }

        Node temp = head;
        for(int ite = 1 ; ite < i ; ite++){
            temp = temp.next;
        }

        Node n = new Node(v,temp.next);
        temp.next = n;

        size++;
    }

    /**
     * CLASE Node
     * */
    private class Node{

        private int value;
        private Node next;

        /**
         * CONSTRUCTOR Node
         * @param value
         * */
        private Node(int value)
        {
            this.value = value;
        }
        /**
         * CONSTRUCTOR Node
         * @param value
         * @param next
         * */
        private Node(int value,Node next)
        {
            this.value = value;
            this.next = next;
        }

        //GETTERS AND SETTTERS FOR NODE
        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }//Fin de la clase privada Node
}
