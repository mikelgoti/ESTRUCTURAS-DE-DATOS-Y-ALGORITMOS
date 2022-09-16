import java.util.Arrays;

public class Main {
	
	/**
	 *Implementacion no recursiva generica de una busqueda binaria.
	 **/
	
	//DOS LISTAS UNA DE ENTEROS Y OTRA DE NOMBRES(STRINGS)
	//LA BUSQUEDA FUNIONA PARA AMBAS 
	static String listaNombres [] = {"Mikel","Ane","Maialen","Joseba","Ellaku","Romero","Jon","Aimar","Goros","Urquiza","Karmele","Hugo"};
	static Integer listaNumeros [] = {1,2,3,4,5,6,7,8,9,10,11};
	static Integer listaNums [];
	
	public static void main(String[] args) {
		
		listaNums = new Integer [10000];
		
		for(int ite = 0 ; ite < listaNums.length ; ite++) {
			listaNums[ite] = ite;
		}
		System.out.println("Lista generada");
		
		long start = System.nanoTime();//NANOSEGUNDOS
		long start1 = System.currentTimeMillis();//MILISEGUNDOS
		//llamada al metodo
		System.out.println(binarySearch(listaNums,0,listaNums.length-1,9999));//mediante la recursividad
		
		long end1 = System.currentTimeMillis();
		long end = System.nanoTime();
		System.out.println("\t\t\tT(s)\t\tT(ns)");
		System.out.printf("%s\t%.5f\t\t%.5f\n","Tiempo trasncurrido: ",
				(double) (end1 - start1) / 1000,(double) (end - start) / 1000000000);
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
		
		/*
		 *SE PODRIA MEJORAR EL METODO
		 *-NO HACE FALTA PASARLE EL MINIMO NI EL MAXIMO SE PUEDEN SACAR DE LA PROPIA LISTA
		 *-NO HACE FALTA EL ULTIMO ELSE IF, CON UN SIMPLE ELSE BASTA
		 **/
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
