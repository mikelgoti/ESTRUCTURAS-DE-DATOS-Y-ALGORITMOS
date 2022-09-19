
/**
 *CLASE PARA IMPLEMENTAR EL ALGORITMO SELECTION SORT
 * 
 *El algoritmo de seleccion escanea toda la lista para encontrar el valor menor.
 *Despues intercambia la primera posicion de la lista con ese valor. 
 *Y repite el proceso pero empezando desde la segunda posicion. Ya que la primera ya esta posicionada.
 * 
 **/
public class Main {
	
	/*
	 *NOTAS: 
	 *-Solamente esta implementado con numeros enteros. Para hacerlo con cadenas hay que utilizar compareTo().
	 *-Se puede mejorar el algoritmo para que calcule el minimo de la lista y despues lo intercambie en la misma iteracion,
	 *de esta forma no intercambiara el primer valor menor que vea y asi poder ahorrar ciclos. 
	 **/
	//LISTA DE EJEMPLO
	private static final int listaNumeros[] = {2,4,7,6,5,1,10,9,11};
	private static final int t = listaNumeros.length;
	
	public static void main(String[] args) {
		System.out.println("Sin ordenar la lista");
		
		for(int ln : listaNumeros) {
			System.out.println("\t"+ln);
		}
		
		System.out.println("\nCon la lista ordenada");
		selectionSort();
		
		for(int ln : listaNumeros) {
			System.out.print("\t"+ln);
		}
	}
	
	public static void selectionSort() {
		
		for(int index = 0 ; index < t ; index++) {
			
			int min = listaNumeros[index];
			
			for(int ite = index + 1 ; ite < t ; ite++) {
				
				if(min > listaNumeros[ite]) {
					min = listaNumeros[ite];
					int aux = listaNumeros[index];
					listaNumeros[index] = listaNumeros[ite];
					listaNumeros[ite] = aux;
				}
			}
		}
	}

}	

