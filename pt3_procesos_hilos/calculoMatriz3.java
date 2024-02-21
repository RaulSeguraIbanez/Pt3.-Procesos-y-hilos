package pt3_procesos_hilos;

class CalculoMatriz3Runnable implements Runnable {
    private static int[][] resultado;
    private final int[][] matriz1;
    private final int[][] matriz2;
    private final int fila;
    private final int columna;

    public CalculoMatriz3Runnable(int[][] matriz1, int[][] matriz2, int fila, int columna) {
        this.matriz1 = matriz1;
        this.matriz2 = matriz2;
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public void run() {
        calcularElementoMatriz3();
    }

    private void calcularElementoMatriz3() {
        int valor = 0;
        for (int i = 0; i < matriz1[0].length; i++) {
            valor += matriz1[fila][i] * matriz2[i][columna];
        }
        synchronized (CalculoMatriz3Runnable.class) {
            if (resultado == null) {
                resultado = new int[matriz1.length][matriz2[0].length];
            }
            resultado[fila][columna] = valor;
        }
    }

    public static int[][] getResultado() {
        return resultado;
    }
}
