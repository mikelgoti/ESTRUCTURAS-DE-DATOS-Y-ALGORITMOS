import java.util.Arrays;

public class Main {
	
	static String listaNombres [] = {"Mikel","Ane","Maialen","Joseba","Ellaku","Romero","Jon","Aimar","Goros","Urquiza","Karmele","Hugo"};
	static Integer listaNumeros [] = {1,2,3,4,5,6,7,8,9,10,11};
	
	public static void main(String[] args) {
		
		System.out.println(binarySearch(listaNumeros,0,listaNumeros.length-1,11));//mediante la recursividad
	}
	
	public static <T extends Comparable <T>> boolean binarySearch(T[] data, int min, int max, T target) {//EXTIENDE LA CLASE COMPARABLE PARA ACEPTAR OBJETOS COMPRABLES
		
		Arrays.sort(data);
		for(T ite : data) {
			System.out.print("["+ite+"],");
		}
		
		while(data[min] != data[max]) {
			int med = (min + max) / 2;
			
			if(data[med] == target || data[min] == target || data[max] == target) {
				return true;
			}
			else if(data[med].compareTo(target) > 0) {
				max = med - 1;
			}
			else if(data[med].compareTo(target) < 0){
				min= med + 1;
			}
		}
		return false;
	}
}
