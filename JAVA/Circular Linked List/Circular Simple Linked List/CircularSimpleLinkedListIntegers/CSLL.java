/**
 * Clase para representar una lista circular enlazada simple
 * */
public class CSLL {

    /**
     * Atributos de clase
     * */
    Node head,tail;
    int size;
    String name;

    /**
     * Constructor que inicializa la lista.
     * Inicializa la variable size en 0 ya que al principio no hay elementos en la lista.
     * */
    public CSLL(String name)
    {
        this.name = name;
        this.size = 0;
    }

    /**
     * MODIFICADOR: public
     * NOMBRE DEL METODO: imprimirLista()
     * TIPO DE METODO: void
     *
     * DESCRIPCION: Metodo para imprimir los elementos de la lista
     *
     * NOTA: Como se imprimen los elementos no es relevante para comprender las listas circulares.
     *       Se a implementado de esta forma como refuerzo visual. Para comprender mejor el resultado por consola.
     *       SI EL METODO imprimirLista() RESULTA LIOSO
     *          1. Comentar en el metodo desde la linea 42 hasta la 81 donde apoarece (*).
     *          2. Despues descomentar la version de imprimir simple desde la linea 83 hasta la 89.
     *       Las dos porciones de codigo realizan los mismo, pero la primera porcion es mas comprensiva visualmente.
     * */
    public void printList(){

        System.out.println(name);

        if(size == 0 && head == null && tail == null){//Checkear lista vacia
            System.out.print("La lista ligada simple circular esta vacia!\n\n");
            return;
        }

        Node temp = head;//(*)

        int cont = 0;
        do{
            if(head == tail){//Caso unico elemento en la lista
                System.out.print("->"+temp.getData()+"->¬");
                cont++;
                break;
            }
            if(temp.next == head){
                System.out.print(temp.getData()+"->¬");
            }
            else if(temp == head){
                System.out.print("-> "+temp.getData()+" -> ");
            }
            else{
                System.out.print(temp.getData()+" -> ");
            }
            temp = temp.next;
            cont++;
        }while(temp != head);

        System.out.println();
        if(cont == 1){
            System.out.print("'-<--'");
            imprimirCaracteristicas();
            System.out.println("\n");
            return;
        }
        for(int ite = 0 ; ite < cont ; ite++){
            if(ite == 0){
                System.out.print("'-<----");
            }
            else if(ite == cont-1){
                System.out.print("<---'");
            }
            else{
                System.out.print("<----");
            }
        }
        imprimirCaracteristicas();
        System.out.println("\n");//(*)

        /*Node temp = head;
        do{
            System.out.print(temp.getData()+" ");
            temp = temp.next;
        }while(temp != head);

        System.out.println("\n");*/
    }

    private void imprimirCaracteristicas(){
        System.out.println();
        System.out.println("SIZE OF THE LIST: "+size);
        System.out.println("HEAD: "+head.getData());
        System.out.println("TAIL: "+tail.getData());
    }

    /**
     * MODIFICADOR: private
     * NOMBRE DEL METODO: isEmpty()
     * TIPO DE METODO: boolean
     * PARAMETROS: NO
     *
     * DESCRIPCION: Comprueba si la lista se encuentra vacia comparando la variable size (el tamaño)
     **/
    private boolean isEmpty(){
        return size == 0 ? true : false;
    }

    /**
     * MODIFICADOR: public
     * NOMBRE DEL METODO: addFirst()
     * TIPO DE METODO: void
     * PARAMETROS: 1 -> int data
     *
     * DESCRIPCION: Inserta un nuevo nodo con su dato al principio de la lista
     **/
    public void addFirst(int data){
        Node node = new Node(data);

        node.next = head;
        head = node;

        if(isEmpty()){
            tail = head;
        }
        tail.next = head;
        size++;
    }

    /**
     * MODIFICADOR: public
     * NOMBRE DEL METODO: addLast()
     * TIPO DE METODO: void
     * PARAMETROS: 1 -> int data
     *
     * DESCRIPCION: Inserta un nuevo nodo con su dato al final de la lista
     **/
    public void addLast(int data){
        if(isEmpty()){
            addFirst(data);
            return;
        }

        Node node = new Node(data);
        tail.next = node;
        tail = node;
        tail.next = head;
        size++;
    }

    /**
     * MODIFICADOR: public
     * NOMBRE DEL METODO: contains()
     * TIPO DE METODO: boolean
     * PARAMETROS: 1 -> int index
     *
     * DESCRIPCION: Metodo que devuelve verdadero si el parametro pasado
     *              coincide con el valor de algun nodo de la lista
     *
     * NOTA: PARA PROBAR QUE DEVERDAD SE TRATA DE UNA LISTA CIRCULAR.
     * 1. Comentar donde dice COMENTAR en el metodo.
     * 2. Descomentar todos los comentarios con el asterisco(*) en el metodo.
     * 3. Llamar a la funcion con el parametro 0. Para ello descomentar en la clase Main.java la linea 42 donde dice ==> csll1.contains(0);.
     **/
    public boolean contains(int index){

        if(isEmpty()){//checkear lista vacia
            return false;
        }
        Node temp = head;//COMENTAR
        //Node temp = head.next;//(*)
        //int c = 0;//(*)
        do{
            //System.out.println("Pos: "+c+"\tData: "+temp.getData());//(*)
            if(temp.getData() == index){
                return true;
            }
            temp = temp.next;
            //c++;//(*)
        }
        while(temp != head);
        return false;
    }

    /**
     * MODIFICADOR: public
     * NOMBRE DEL METODO: deleteNode()
     * TIPO DE METODO: void
     * PARAMETROS: 1 -> int index
     *
     * DESCRIPCION: Metodo que elimia el nodo que contenga el dato pasado como parametro
     **/
    public void deleteNode(int index){
        if(isEmpty()){
            return;
        }

        Node temp = head;

        do{
            if(temp.next.getData() == index){
                if(head == tail){
                    head = null;
                    tail = null;
                    size--;
                    break;
                }
                if(temp.next == head){
                    head = temp.next.next;
                }
                if(temp.next == tail){
                    tail = temp;
                }
                temp.next = temp.next.next;
                size--;
            }
            temp = temp.next;
        }while(temp != head);
    }

    /**
     * MODIFICADOR: public
     * NOMBRE DEL METODO: deleteNodeIn()
     * TIPO DE METODO: void
     * PARAMETROS: 1 -> int pos
     *
     * DESCRIPCION: Metodo que elimia el nodo en la posicion especificada en el parametro.
     * NOTE: LAS POSICIONES EN LA LISTA EMPIEZAN A CONTAR POR 1. EN VEZ DE SER 0 EL PRIMER NODO ES 1.
     **/
    public void deleteNodeIn(int pos){

        if(isEmpty()){
            return;
        }

        if(pos == 1){
            head = head.next;
            tail.next = head;
            size--;
            return;
        }

        Node temp = head;

        for(int ite = 1 ; ite < pos - 1 ; ite++){
            temp = temp.next;
        }
        if(temp.next == tail){
            temp.next = temp.next.next;
            tail = temp;
            size--;
            return;
        }
        temp.next = temp.next.next;
        size--;
    }

    /**
     * MODIFICADOR: public
     * NOMBRE DEL METODO: addIn()
     * TIPO DE METODO: void
     * PARAMETROS: 2 -> int pos, int data
     *
     * DESCRIPCION: inserts the node in the correct place according to the position passed as the parameter.
     * NOTE: POSITIONS IN THE LIST STARTS COUNTING BY 1. INSTEAD OF BEING 0 THE FIRST NODE IS 1.
     **/
    public void addIn(int pos, int data){

        if(pos == 1 || isEmpty()){
            addFirst(data);
            return;
        }

        if(pos >= size){
            addLast(data);
            return;
        }

        Node temp = head;

        for(int ite = 2 ; ite < pos ; ite++){
            temp = temp.next;
        }
        Node node = new Node(data);
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    /**
     * MODIFICADOR: public
     * NOMBRE DEL METODO: insertInOrder()
     * TIPO DE METODO: void
     * PARAMETROS: 1 -> int data
     *
     * DESCRIPCION: inserts the node in the correct place of the list according to his data value.
     **/
    public void addInOrder(int data) {

        if(isEmpty()){
           addFirst(data);
           return;
        }

        Node temp =tail;

        do{
            if(temp.next == tail){
                addLast(data);
                return;
            }
            if(temp.next.getData() > data){
                Node node = new Node(data);
                size++;
                if(temp.next == head){
                    node.next = temp.next;
                    temp.next = node;
                    head = node;
                    break;
                }
                else{
                    node.next = temp.next;
                    temp.next = node;
                    break;
                }
            }
            temp = temp.next;
        }while(temp != tail);
    }

    /**
     * Clase interna para representar un nodo
     * */
    private class Node{

        int data;
        Node next;

        public Node(int data)
        {
            this.data = data;
        }

        public Node(int data, Node next)
        {
            this.data = data;
            this.next = next;
        }

        //GETTERS Y SETTERS
        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
