/*
 *ALGORITMO INSERTION SORT
 *El algoritmo insercion compara las primeras dos posiciones
 **/

public class Nucleo {

	//LISTA DE EJEMPLO
		private static final int listaNumeros[] = {2,4,7,6,5,1,10,9,11};
		private static final int t = listaNumeros.length-1;
		
		public static void main(String[] args) {
			insertionSort();
			
			for(int ln : listaNumeros) {
				System.out.println(ln);
			}
		}
		
		public void insertionSort() {
			
			for(int ite = 2 ; ite < t ; ite++) {
				while(ite > 0) {
					if(listaNumeros[ite-2] > listaNumeros[ite-1]) {
						cambiar(ite,ite+1);
					}
					ite = ite - ite;
				}
			}
		}
		
		public void cambiar(int n1 , int n2) {
			int aux = listaNumeros[n1];
			listaNumeros[n1] = listaNumeros[n2];
			listaNumeros[n2] = aux;
		}

}
