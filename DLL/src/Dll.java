/**
 *
 * CLASE QUE REPRESENTA UNA Dll = Double Linked List
 *
 * */
public class Dll {

    /**ATRIBUTOS DE LA LISTA
     * @param s = size
     * @param h = head
     * @param t = tail
     * @param nombre
     * */
    private int s;
    private N h;
    private N t;
    private String nombre = "";

    /*CONSTANTES*/
    private String MSJ = "La lista "+nombre+" esta vacia";

    /**
     * CONSTRUCTOR PARA LA LISTA DLL
     * */
    public Dll(String nombre){
        s = 0;
        setNombre(nombre);
    }

    private void setNombre(String nombre){
            this.nombre += nombre;
    }

    /**METODOS DE LA CLASE Dll**/

    /**METODOS PRIVADOS**/
    private boolean isEmpty(){
        if(s == 0){
            return true;
        }
        return false;
    }

    /**METODOS PUBLICOS**/
    public void printDll(){

        if(isEmpty()){
            System.out.println(MSJ);
            return;
        }

        N temp = h;
        boolean aux = true;
        int cont = 0;
        while(aux){
            cont++;
            if(temp == t){
                System.out.print("["+temp.getV()+"]");
                aux = false;
                break;
            }
            System.out.print("["+temp.getV()+"] <-> ");
            temp = temp.next;
        }

        System.out.printf("\nInformacion general de la lista\nLongitud: %d\n"+
                          "Cabeza: %d\n"+
                          "Cola: %d\n",s,h.getV(),t.getV());
        int cont1 = 1;
        N temp1 = h;
        while(cont != 0){

            System.out.printf("%d. Nodo\n" +
                    "Data: %d\n" +
                    "Next: %s\n"+
                    "Prev: %s\n\n",cont1,temp1.getV(),temp1.getN(),temp1.getP());
            temp1 = temp1.next;
            cont1++;
            cont--;
        }

    }

    public void insertFirst(int v){
        N node = new N(v);

        if(isEmpty()){
            node.next = h;
            h = node;
            t = h; // Si esta vacia la cola sera la cabeza.
            s++;
            return;
        }

        node.next = h;
        h.prev = node;
        h = node;
        s++;
    }

    public void insertLast(int v){

        if(isEmpty()){
            insertFirst(v);
            return;
        }

        N node = new N(v);

        t.next = node;
        node.prev = t;
        t = node;
        s++;
    }

    /**
     * Insertar en el determinado index que se pase
     * @param v = value
     * @param i = index
     * */
    public void insert(int v, int i){

        if(isEmpty() || i == 0){
            insertFirst(v);
            return;
        }

        if(i == s){
            insertLast(v);
            return;
        }

        N temp = h;
        for(int ite = 1 ; ite < i-1 ; ite++){
            temp = temp.next;
        }

        N node = new N(v);
        N temp1 = temp.next;

        temp.next = node;
        node.prev = temp;

        node.next = temp1;
        temp1.prev = node;

        s++;
    }
    /**
     * BORRAR EL PRIMER NODO DE LA LISTA
     * */
    public void removeFirst(){
        if(isEmpty()){
            System.out.println(MSJ);
            return;
        }

        h = h.next;
        s--;
    }

    public void removeLast(){
        if(isEmpty()){
            System.out.println(MSJ);
            return;
        }

        if(s == 1){
            removeFirst();
        }
        t.prev.next = null;
        t = t.prev;
        s--;
    }

    /**
     * REMOVE THE ELEMENT AT GIVEN INDEX
     * @param i = index
     * */
    public void remove(int i){

        if(s == 1 || i == 0){
            removeFirst();
            return;
        }

        if(i == s){
            removeLast();
            return;
        }

        N t = h;
        for(int ite = 1 ; ite < i ; ite++){
            t = t.next;
        }

        N t1 = t.prev;
        N t2 = t.next;
        t1.next = t.next;
        t2.prev = t.prev;
        t.next = null;
        t.prev = null;
        s--;
    }
    /**
     *
     * CLASE INTERNA PRIVADA PARA REPRESENTAR UN NODO
     *
     */
    private class N{

        /**ATRIBUTOS DEL NODO
         * @param v = value
         * @param n = next
         * @param p = prev
         */
        private int v;
        private N next;
        private N prev;

        /**
         * CONSTRUCTOR PARAMETRIZADO
         * @param v
         * */
        private N(int v){
            this.v = v;
        }

        /**
         * CONSTRUCTOR PARAMETRIZADO
         * @param v
         * @param next
         * @param prev
         * */
        private N(int v,N next, N prev){
            this.v = v;
            this.next = next;
            this.prev = prev;
        }

        //GETTERS AND SETTERS
        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }

        public N getN() {
            return next;
        }

        public void setN(N next) {
            this.next = next;
        }

        public N getP() {
            return prev;
        }

        public void setP(N prev) {
            this.prev = prev;
        }
    }


}
