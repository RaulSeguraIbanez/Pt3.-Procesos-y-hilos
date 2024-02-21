package pt3_procesos_hilos;

public class calculoMatriz3 {
	
	public static void calculo(int[][] matriz1,int[][] matriz2) {
		
	  int matriz3[][] = new int[main.tamañoMatriz1][main.columnasMatriz2];
	  
      for (int i = 0; i < main.tamañoMatriz1; i++) {
          for (int j = 0; j < main.columnasMatriz2; j++) {
              matriz3[i][j] = 0; // Inicializamos la celda de la matriz3 en 0 antes de sumar
              for (int k = 0; k < main.columnasMatriz1; k++) {
                  matriz3[i][j] += matriz1[i][k] * matriz2[k][j];
              }
          }
      }
      
      System.out.println("Matriz 3");
      // Imprimir matriz3 si se desea
      for (int i = 0; i < main.tamañoMatriz1; i++) {
          for (int j = 0; j < main.columnasMatriz2; j++) {
              System.out.print(matriz3[i][j] + " ");
          }
          System.out.println();
      }
  }
	  
}

