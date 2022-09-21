/*ALGORITMO RAPIDO O QUICKSORT*/


public class Main {
	
	static int lNumeros[] = {6,2,3,1,9,8,7,10};
	
	public static void main(String[] args) {
		System.out.println("Sin ordenar");
		for(int ite : lNumeros) {
			System.out.print("\t"+ite);
		}
		
		System.out.println();
		quickSort(lNumeros,0,lNumeros.length-1);
		System.out.println("Ordenado");
		for(int ite : lNumeros) {
			System.out.print("\t"+ite);
		}
	}
	
	public static void quickSort(int ln[], int min,int max) {
		
		if(min >= max) {
			return;
		}
		
		int p = ln[max];
		int leftIndex = min;
		int rigthIndex = max;
		
		while(leftIndex < rigthIndex) {
			
			while(ln[leftIndex] <= p && leftIndex < rigthIndex) {
				leftIndex++;
			}
			
			while(ln[rigthIndex] >= p && leftIndex < rigthIndex) {
				rigthIndex--;
			}
			
			changePosition(ln,leftIndex,rigthIndex);
		}
		
		changePosition(ln,leftIndex,max);
		
		quickSort(ln,min,leftIndex-1);
		quickSort(ln,leftIndex+1,max);
	}
	
	private static void changePosition(int ln[],int n1,int n2) {
		int aux = ln[n1];
		ln[n1] = ln[n2];
		ln[n2] = aux;
	}
}
