
public class Main {
	
	//Lista de numeros para buscar
	private static final int listaNumeros [] = {0,1,2,3,4,5,6,7,8,9};
	
	public static void main(String[] args) {
		/**
		 * 
		 *La busqueda lineal recorre todos los elementos de la lista "listaNumeros"
		 *hasta encontrar el numero deseado. Este es un ejemplo con numero de enteros,
		 *pero se podria utilizar el mismo porcedimiento para cualquier tipo de dato.
		 * 
		 **/
		
		//Imaginemos que queremos econtrar el valor 6
		int n = 10;
		int ite = 0;//Variable que llevara la cuenta de las posiciones que se compararan. Los vectores comienzas por 0.
		int max = listaNumeros[listaNumeros.length-1];
		
		//ALGORITMO DE BUSQUEDA LINEAL
		try {
			while(listaNumeros[ite] != n) {
				try {Thread.sleep(2000);}catch(Exception e){};
				System.err.println("El numero "+n+" no esta en la posicion "+ite+".");
				ite++;
			}
			try {Thread.sleep(2000);}catch(Exception e){};
		}catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("Todas los numeros de la lista comparados.\nEl numero "+n+" no se encuentra en la lista.");
		};
		if(ite <= max) {
		System.out.println("El numero "+n+" esta en la posicion "+ite+" de la listaNumeros.");
		}
	}
	
	/**
	 *Este tipo de algoritmo es muy facil de implementar pero es poco efectivo para conjuntos de datos grandes. 
	 *Ya que su complejidad computacional sera de O(n).
	 *Esto quiero decir que si en vez de tener una lista minima como la del ejemplo, 
	 *de tan solo 10 elementos con 1 segundo de parada por iteracion en el bucle. 
	 *Si tuvieramos 1000 numeros en la lista y quisieramos buscar el numero 600 tardaria 600 segundos en encontrarlo.
	 *La eficacia del algoritmo de busqueda lineal esta directamente ligado con el numero de datos en los que puede residir el elemento a buscar.
	 *-------------------------------------------------------------------------------------------------------------------------------------------
	 **/
}
