/*
 *ALGORITMO INSERTION SORT
 *El algoritmo insercion compara las primeras dos posiciones,
 *si el segundo termino es menor que el primero los intercambia.
 *Luego compara el tercer elemento con el segundo y el primero y asi etc...
 **/

public class Nucleo {
	
	/**
	 *ALGORITMO MEJORADO
	 **/
	//LISTA DE EJEMPLO
		private static final int listaNumeros[] = {2,4,7,6,5,1,10,9,11};
		private static final int t = listaNumeros.length;
		
		public static void main(String[] args) {
			insertionSort();
			
			for(int ln : listaNumeros) {
				System.out.print("\t"+ln);
			}
		}
		
		public static void insertionSort() {
			
			for(int index = 1 ; index < t ; index++) {
				
				while(index > 0 && listaNumeros[index-1] > listaNumeros[index]) {
					cambiar(index-1,index);
					index--;
				}
			}
		}
		
		public static void cambiar(int n1 , int n2) {
			int aux = listaNumeros[n1];
			listaNumeros[n1] = listaNumeros[n2];
			listaNumeros[n2] = aux;
		}

}
