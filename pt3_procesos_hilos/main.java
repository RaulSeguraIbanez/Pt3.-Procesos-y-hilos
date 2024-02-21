package pt3_procesos_hilos;
import java.util.Scanner;

public class main {
	public static int tamañoMatriz1 = 0;
	public static int columnasMatriz1 = 0;
	public static int tamañoMatriz2 = 0;
	public static int columnasMatriz2 = 0;
	
	public static void main(String[] args) {
		
		Scanner sI = new Scanner(System.in);
		
		System.out.println("Se requiere que se introduzcan los datos para definir el tamaño de las matrices. No se aceptarán valores inferiores a 1 o superiores a 20");
		
		System.out.println("Introduce el numero de filas que quieres que tenga la primera matriz");
		main.tamañoMatriz1 = sI.nextInt();
		
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
	
	inicioCalculos();
	}
	public static void inicioCalculos() {
		Scanner sI2 = new Scanner(System.in);

		System.out.println("Indica como quieres introducir los valores");
		System.out.println("1. Por consola. 2.Fichero txt");
		
		int seleccion = sI2.nextInt();
		
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
		
		String numMatriz1 = sS1.nextLine();
		
		System.out.println("Introduce todos valores para la matriz 2 en una sola linea, separados por un espacio");
		System.out.println("Si los numeros introducidos son '1 2 3 4', en una matriz 2/2, sería:");
		System.out.println("1 2");
		System.out.println("3 4");
		
		String numMatriz2 = sS1.nextLine();
		
		crearMatricesBase(numMatriz1,numMatriz2);

		
	}
	public static void introducirFichero() {
		System.out.println("El contenido del fichero debe tener todos valores para la matriz 1 en una sola linea, separados por un espacio; y en la siguiente linea, los valores de la segunda matriz, con el mismo formato");
		System.out.println("Si los numeros introducidos son '1 2 3 4', en una matriz 2/2, sería:");
		System.out.println("1 2");
		System.out.println("3 4");
		
		Scanner sS2 = new Scanner(System.in);
		
		System.out.println("Introduce la ruta de directorio del fichero .txt con el contenido indicado");
		
		String ficheroTxt = sS2.nextLine();
		
		leerFichero.leerFichero(ficheroTxt);
	}
	
	public static void crearMatricesBase(String sMatriz1, String sMatriz2) {
		
        String[] numMatriz1 = sMatriz1.split(" ");
        String[] numMatriz2 = sMatriz2.split(" ");
		
		int matriz1[][] = new int[tamañoMatriz1][columnasMatriz1];
		int matriz2[][] = new int[tamañoMatriz2][columnasMatriz2];
		
        // Llenar la primera matriz
        llenarMatriz(matriz1, numMatriz1);

        // Llenar la segunda matriz
        llenarMatriz(matriz2, numMatriz2);

        // Mostrar las matrices
        System.out.println("Matriz 1:");
        mostrarMatriz(matriz1);
        System.out.println("Matriz 2:");
        mostrarMatriz(matriz2);
        
        Thread[][] threads = new Thread[tamañoMatriz1][columnasMatriz2];

        for (int i = 0; i < tamañoMatriz1; i++) {
            for (int j = 0; j < columnasMatriz2; j++) {
                threads[i][j] = new Thread(new CalculoMatriz3Runnable(matriz1, matriz2, i, j));
                threads[i][j].start();
            }
        }

        // Esperar a que todos los hilos terminen
        try {
            for (int i = 0; i < tamañoMatriz1; i++) {
                for (int j = 0; j < columnasMatriz2; j++) {
                    threads[i][j].join();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Matriz 3:");
        mostrarMatriz(CalculoMatriz3Runnable.getResultado());
        
        String opcion = "";
        System.out.println("¿Quieres multiplicar otras 2 matrices? No podrás modificar el tamaño de las mismas");
        System.out.println("1.Si/ 2.No");
        Scanner sR = new Scanner(System.in);
        
        opcion = sR.nextLine();
        if(opcion.equals("1")) {
        	inicioCalculos();
        } else if(opcion.equals("2")) {
        	System.exit(1);
        }
	}

    // Método para llenar una matriz con los números de una cadena
    public static void llenarMatriz(int[][] matriz, String[] numeros) {
        int fila = 0;
        int columna = 0;
        for (String numero : numeros) {
            matriz[fila][columna] = Integer.parseInt(numero);
            columna++;
            if (columna == matriz[0].length) {
                columna = 0;
                fila++;
                if (fila == matriz.length) {
                    break; // Matriz completamente llena
                }
            }
        }
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    }