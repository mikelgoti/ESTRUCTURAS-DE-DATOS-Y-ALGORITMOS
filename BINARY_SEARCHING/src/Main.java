import java.util.Arrays;

public class Main {
	
	/**
	 *Implementacion no recursiva generica de una busqueda binaria.
	 **/
	
	//DOS LISTAS UNA DE ENTEROS Y OTRA DE NOMBRES(STRINGS)
	//LA BUSQUEDA FUNIONA PARA AMBAS 
	static String listaNombres [] = {"Mikel","Ane","Maialen","Joseba","Ellaku","Romero","Jon","Aimar","Goros","Urquiza","Karmele","Hugo"};
	static Integer listaNumeros [] = {1,2,3,4,5,6,7,8,9,10,11};
	
	public static void main(String[] args) {
		
		//llamada al metodo
		System.out.println(binarySearch(listaNumeros,0,listaNumeros.length-1,11));//mediante la recursividad
	}
	
	/**
	 *Parametros de la funcion binarySearch()
	 *@return boolean Devuelve true si el elemento a buscar se encuentra dentro de la lista. De lo contrario devuelve false.
	 *@param data La lista de datos
	 *@param min La posicion minima de la lista
	 *@param max La posicion maxima de la lista
	 *@param target el elemento a buscar dentro de la lista  
	 **/
	public static <T extends Comparable <T>> boolean binarySearch(T[] data, int min, int max, T target) {//EXTIENDE LA CLASE COMPARABLE PARA ACEPTAR OBJETOS COMPRABLES
		
		//ORDENA LA LISTA DE DATOS DE MAYOR A MENOR
		Arrays.sort(data);
		
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
