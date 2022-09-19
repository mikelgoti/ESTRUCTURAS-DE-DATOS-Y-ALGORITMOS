
/*
 *ALGORITMO DE LA BURBUJA O BUBBLE SORT
 *El algoritmo compara de dos en dos las posciones y is no estan en orden las intercambia.
 **/
public class Main {
	//LISTA DE EJEMPLO
		private static final Integer listaNumeros[] = {2,4,7,6,5,1,10,9,11};
		private static final int t = listaNumeros.length - 1;
		
		public static void main(String[] args) {
			System.out.println("Sin ordenar la lista");
			
			for(int ln : listaNumeros) {
				System.out.print("\t"+ln);
			}
			
			System.out.println("\nCon la lista ordenada");
			bubbleSort();
			
			for(int ln : listaNumeros) {
				System.out.print("\t"+ln);
			}
		}
		
		public static void bubbleSort() {
			int out,in;
			
			for(out = t ; out > 0 ; out--) {
				for(in = 0 ; in < out ; in++) {
					if(listaNumeros[in].compareTo(listaNumeros[in+1]) > 0) {
						swap(in,in+1);
						for(Integer i : listaNumeros) {
							System.out.printf("\t"+i);
						}
						System.out.println("\n");
						try{Thread.sleep(4000);}catch(Exception e) {};
					}
				}
			}
		}
		
		public static void swap(int one, int two) {
			Integer temp = listaNumeros[one];
			listaNumeros[one] = listaNumeros[two];
			listaNumeros[two] = temp;
		}
}
