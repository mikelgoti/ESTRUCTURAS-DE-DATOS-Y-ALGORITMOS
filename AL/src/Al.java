public class Al {

    /**CONSTANTES**/
    private static final int DEF_SIZE = 10;

    /**ATRIBUTOS**/
    private int al[];
    private int size = 0;

    /**
     * CONSTRUCTOR-Inicializa el AL = ArrayList con el tamaño por defecto.
     * */
    public Al(){
        al = new int[DEF_SIZE];
    }

    /**
     * CONSTRUCTOR-Inicializa el AL = ArrayList con el tamaño indicado.
     * @param t = tamaño
     * */
    public Al(int t){
        al = new int[check(t)];
    }

    /**METODO PRIVADOS DE LA CLASE AL**/

    /**
     * checkT comprueba que el tamaño pasado es mayor que 0.
     * @param t = tamaño
     * */
    private int check(int t){
        return t > 0 ? t : 0;
    }

    private int getFreeSpace(){
        return getTotalSize()-getElements();
    }

    private void incrementSize(){

        int temp[] = new int[getTotalSize()*2];

        for(int ite = 0 ; ite < getTotalSize() ; ite++){
            temp[ite] = al[ite];
        }
        al = temp;
    }

    /**METODO PUBLICOS DE LA CLASE AL**/
    public int getTotalSize(){
        return al.length;
    }

    public int getElements(){
        return size;
    }

    public void printArrayList(){

        for(int ite = 0 ; ite < size ; ite++){
            System.out.print("["+al[ite]+"] ");
        }

        /*for(int ite : al){
            System.out.print("["+ite+"] ");
        }*/

        System.out.printf("\nEspacio total: %d\n" +
                          "Espacio usado: %d\n" +
                          "Espacio libre: %d\n",getTotalSize(),getElements(),getFreeSpace());
    }

    public void add(int v){
        if(size == getTotalSize()){
            incrementSize();
        }

        int temp[] = new int[getTotalSize()];
        for(int ite = 0 ; ite < getTotalSize() ; ite++){
            if(ite == 0){
                temp[0] = v;
                ite++;
            }
            temp[ite] = al[ite-1];
        }
        al = temp;
        //al[size] = v;
        size++;
    }

    /**
     * add in a custom index
     * @param v = value
     * @param i = index
     * */
    public void add(int v,int i){

        if(size == getTotalSize()){
            incrementSize();
        }

        int temp[] = new int[getTotalSize()];
        boolean aux = false;
        for(int ite = 0 ; ite < getTotalSize() ; ite++){
            if(ite == check(i)){
                temp[ite] = v;
                aux = true;
            }
            else if(aux == true){
                temp[ite] = al[ite-1];
            }
            else{
                temp[ite] = al[ite];
            }

        }
        al = temp;
        size++;
    }

    /**
     * Metodo para borrar de la lista el parametro indicado
     * @param i = index
     * */
    public void remove(int i){

        int temp[] = new int[getTotalSize()];
        boolean aux = false;
        for(int ite = 0 ; ite < getTotalSize() ; ite++){
            if(ite == check(i)){//Al coincidir con el index se guarda el siguiente valor en la lista
                temp[ite] = al[ite+1];
                aux = true;
            }
            else if(aux == true){//Mediante un booleano se imprime la siguiente posicion de la lista hasta el final
                if(ite == getTotalSize()-1){
                    temp[ite] = al[ite];//Al final no se imprime el siguiente para evitar el error por salirse del array
                    continue;
                }
                temp[ite] = al[ite+1];
            }
            else{
                temp[ite] = al[ite];
            }
        }
        al = temp;
        size--;
    }

    /**
     * METOD0 PARA COPIAR EL ARRAY
     * */
    public int[] clone(){

        int a[] = new int[getTotalSize()];
        for(int i = 0 ; i < getTotalSize() ; i++){
            a[i] = al[i];
        }
        return a;
    }

    /*GETTERS AND SETTERS*/

}
