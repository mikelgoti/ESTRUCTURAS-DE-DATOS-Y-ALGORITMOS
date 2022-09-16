
public class Main {
	
	//Lista de numeros para buscars
	private static Integer listaNumeros [];
	
	public static void main(String[] args) throws InterruptedException {
		/**
		 * 
		 *La busqueda lineal recorre todos los elementos de la lista "listaNumeros"
		 *hasta encontrar el numero deseado. Este es un ejemplo con numero de enteros,
		 *pero se podria utilizar el mismo porcedimiento para cualquier tipo de dato.
		 * 
		 **/
		
		listaNumeros = new Integer [100000000];
		
		for(int ite = 0 ; ite < listaNumeros.length ; ite++) {
			listaNumeros[ite] = ite;
		}
		System.out.println("Lista generada");
		
		long start = System.nanoTime();//NANOSEGUNDOS
		long start1 = System.currentTimeMillis();//MILISEGUNDOS
		
		System.out.println(linealSearch(listaNumeros,0,listaNumeros.length,99999999));
		
		long end1 = System.currentTimeMillis();
		long end = System.nanoTime();
		System.out.println("\t\t\tT(s)\t\tT(ns)");
		System.out.printf("%s\t%.5f\t\t%.5f\n","Tiempo trasncurrido: ",
				(double) (end1 - start1) / 1000,(double) (end - start) / 1000000000);
	
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
	
	//VERSION GENERICA
	public static <T> boolean linealSearch(T[] lista,int min, int max, T i) {
		
		int index = min;
		boolean found = false;
		
		while(!found && index <= max) {
			found = lista[index].equals(i);
			index++;
		}
		return found;
	}
}
