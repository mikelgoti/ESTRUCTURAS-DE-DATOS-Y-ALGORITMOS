public class Main {

    public static void main(String[] args) throws InterruptedException {

        CSLL csll1 = new CSLL("Lista Prueba");//Instancia de la clase simple ligada circular

        csll1.printList();//imprimimos la lista

        csll1.addFirst(3);//insertamos el primer elemento usando insertFirst

        csll1.printList();//imprimimos la lista

        csll1.deleteNode(3);//borramos el unico nodo

        csll1.printList();//imprimimos la lista

        csll1.addLast(4);//insertamos el primer elemento usando insertLast

        csll1.printList();//imprimimos la lista

        csll1.addFirst(3);//insertamos al frente

        csll1.printList();//imprimimos la lista

        csll1.addFirst(2);//insertamos al frente

        csll1.printList();//imprimimos la lista

        //AGREGAMOS MAS ELEMENTOS
        csll1.addFirst(1);
        csll1.addFirst(0);
        csll1.addLast(5);
        csll1.addLast(6);
        csll1.addLast(7);

        csll1.printList();//imprimimos la lista

        System.out.println(csll1.contains(0)+"\n");//busca el nodo con el valor 0, esta en la primera posicion devuelve true
        System.out.println(csll1.contains(7)+"\n");//busca el nodo con el valor 7, esta en la ultima posicion de la lista devuelve true
        System.out.println(csll1.contains(8)+"\n");//busca un nodo con el valor 8, no se encuentra en la lista devuelve false

        //csll1.contains(0);

        csll1.printList();//imprimimos la lista

        csll1.deleteNode(0);//Borramos el primer nodo

        csll1.printList();//imprimimos la lista

        csll1.deleteNode(7);//Borramos el ultimo nodo

        csll1.printList();//imprimimos la lista

        csll1.deleteNode(9);//Borramos un nodo que no contenga el valor pasado

        csll1.printList();//imprimimos la lista

        csll1.deleteNode(3);//Borramos un nodo del medio

        csll1.printList();//imprimimos la lista

        csll1.addInOrder(0);//Inserta un nodo en orden segun el tipo de dato que tenga

        csll1.printList();//imprimimos la lista

        csll1.addInOrder(7);//Inserta un nodo en orden segun el tipo de dato que tenga

        csll1.printList();//imprimimos la lista

        csll1.addInOrder(3);//Inserta un nodo en orden segun el tipo de dato que tenga

        csll1.printList();//imprimimos la lista

        csll1.addIn(3,10);//inserta el nodo con el dato pasado en la posicion pasada

        csll1.printList();//imprimimos la lista

        csll1.addIn(9,8);//inserta el nodo con el dato pasado en la posicion pasada

        csll1.printList();//imprimimos la lista

        csll1.addIn(11,9);//inserta el nodo con el dato pasado en la posicion pasada

        csll1.printList();//imprimimos la lista

        csll1.deleteNodeIn(11);//borra el nodo de la posicion especificada

        csll1.printList();//imprimimos la lista




    }
}
