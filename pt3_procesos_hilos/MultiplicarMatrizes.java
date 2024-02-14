package pt3_procesos_hilos;

class MultiplicarMatrizes extends Thread {
    private int[][] matrix1;
    private int[][] matrix2;
    private int[][] result;
    private int startRow;
    private int endRow;

    public MultiplicarMatrizes(int[][] matrix1, int[][] matrix2, int[][] result, int startRow, int endRow) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = result;
        this.startRow = startRow;
        this.endRow = endRow;
    }

    @Override
    public void run() {
        for (int i = startRow; i < endRow; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix2.length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
    }
}

class Matrix {
    int[][] matrix;

    public Matrix(int rows, int cols) {
        matrix = new int[rows][cols];
    }

    public void setElement(int i, int j, int value) {
        matrix[i][j] = value;
    }

    public int getElement(int i, int j) {
        return matrix[i][j];
    }

    public int getRows() {
        return matrix.length;
    }

    public int getCols() {
        return matrix[0].length;
    }

    public void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
