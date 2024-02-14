package pt3_procesos_hilos;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		Scanner sI = new Scanner(System.in);
		int tamañoMatriz1 = 0;
		int columnasMatriz1 = 0;
		int tamañoMatriz2 = 0;
		int columnasMatriz2 = 0;
		
		System.out.println("Se requiere que se introduzcan los datos para definir el tamaño de las matrices. No se aceptarán valores inferiores a 1 o superiores a 20");
		
		System.out.println("Introduce el numero de filas que quieres que tenga la primera matriz");
		tamañoMatriz1 = sI.nextInt();
		
		System.out.println("Introduce el numero de columnas que quieres que tenga la primera matriz");
		columnasMatriz1 = sI.nextInt();
		
		System.out.println("Introduce el numero de filas que quieres que tenga la segunda matriz. Ha de ser el mismo que de columnas de la primera matriz");
		tamañoMatriz2 = sI.nextInt();
		
		System.out.println("Introducoce el numero de columnas que quieres que tenga la segunda matriz. Ha de ser el mismo que de filas de la primera matriz");
		columnasMatriz2 = sI.nextInt();
		
		if(tamañoMatriz1 != columnasMatriz2 || tamañoMatriz2 != columnasMatriz1 || tamañoMatriz1 < 1 || tamañoMatriz1 > 20 || tamañoMatriz2 < 1 || tamañoMatriz2 > 20 || columnasMatriz1 < 1 || columnasMatriz1 > 20 || columnasMatriz2 < 1 || columnasMatriz2 > 20) {
			System.out.println("Error de formato. No has seguido las condiciones pautadas, Cerrando aplicacion");
			System.exit(1);
		}
		
		System.out.println("Las matrices serán de " + columnasMatriz1 + "/" + tamañoMatriz1 + " y " + columnasMatriz2 + "/" + tamañoMatriz2 + ", respectivamente");
		
		System.out.println("Indica como quieres introducir los valores");
		System.out.println("1. Por consola. 2.Fichero txt");
		
		int seleccion = sI.nextInt();
		
		if(seleccion == 1) {
			introducirManual();
		} else if(seleccion == 2) {
			introducirFichero();
		} else {
			System.exit(1);
		}
	}
	
	public static void introducirManual() {
		System.out.println("Introduce todos valores para la matriz 1 en una sola linea, separados por un espacio");
		System.out.println("Si los numeros introducidos son '1 2 3 4', en una matriz 2/2, sería:");
		System.out.println("1 2");
		System.out.println("3 4");
		
		Scanner sS1 = new Scanner(System.in);
		
		
		
	}
	public static void introducirFichero() {
		System.out.println("El contenido del fichero debe tener todos valores para la matriz 1 en una sola linea, separados por un espacio; y en la siguiente linea, los valores de la segunda matriz, con el mismo formato");
		System.out.println("Si los numeros introducidos son '1 2 3 4', en una matriz 2/2, sería:");
		System.out.println("1 2");
		System.out.println("3 4");
		
		Scanner sS2 = new Scanner(System.in);
	}
}