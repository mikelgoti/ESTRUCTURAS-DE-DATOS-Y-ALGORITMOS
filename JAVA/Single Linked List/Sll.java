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

    public void deleteLast(){
        if(isEmpty()){
            System.out.println(nombre+MSJ_EMPTY);
            return;
        }

        if(size == 1){
            deleteFirst();
            return;
        }

        Node temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
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
     * DELETE with index
     * @param i = index
     * ALGORITMO
     * ---------
     * 1. Tratar error de la lista vacia.
     * 2. Si la lista solo contiene un elemento borrarlo o si el index es 0 borrar el primero.
     * 3.a. Si no es ni el paso 1 ni el 2. Definir un nodo temporal -> temp con la referencia del principio.
     *    Recorrer hasta el index-1 para encontrar la referencia que se tiene que cambiar.
     *    Definr otro nodo temporal -> temp1 con la referencia del nodo que vamos a borrar el que coincide con el index.
     * 4. Tratar caso exceptional de la instruccion 3. Cuando el index es la ultima posicion, es decir, cuando no hay
     *    siguiente al que apuntar.Se asigna null a la referencia del nodo temporal -> temp porque es el ultimo.
     *    Y se asigna como tail.Decrementar longitud y salir.
     * 3.b Si no es la ultima posicion la que intentamos borrar. Al borrar el nodo se rompe la lista para evitar eso
     *     el puntero del nodo borrado es el que apunta al siguiente, esa referencia se asigna al la referencia del nodo
     *     anterior que apunta al borrado. Despues decrementamos.
     * */
    public void deleteIndex(int i){

        if(isEmpty()){
            System.out.println(nombre+MSJ_EMPTY);
        }

        if(size == 1 || i == 0){
            deleteFirst();
            return;
        }

        Node temp = head;
        for(int ite = 0 ; ite < i-1 ; ite++){
            temp = temp.next;
        }

        Node temp1 = temp.next;
        if(temp1.next == null){
            temp.next = null;
            tail = temp;
            size--;
            return;
        }
        temp.next = temp1.next;
        size--;
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
