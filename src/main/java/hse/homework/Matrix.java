package hse.homework;

class Matrix {
    private int rows, columns;
    private ComplexNumber[][] matrix;

    public Matrix() {
        this(0, 0);
    }

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new ComplexNumber[rows][columns];
    }

    public void setValue(int row, int column, ComplexNumber value) {
        if (row >= 0 && row < rows && column >= 0 && column < columns) {
            matrix[row][column] = value;
        }
        else {
            System.out.println("Invalid");
        }
    }

    public ComplexNumber getValue(int row, int column) {
        if (row >= 0 && row < rows && column >= 0 && column < columns) {
            return matrix[row][column];
        }
        else {
            return null;
        }
    }

    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.getValue(i, j).printCNum();
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public Matrix add(Matrix matrix) {
        if (this.rows != matrix.rows || this.columns != matrix.columns) {
            System.out.println("Invalid");
            return null;
        }
        else{
            Matrix resultMatrix = new Matrix(this.rows, this.columns);
            for (int i = 0; i < matrix.rows; i++) {
                for (int j = 0; j < matrix.columns; j++) {
                    ComplexNumber sumValue = this.getValue(i, j).add(matrix.getValue(i, j));
                    resultMatrix.setValue(i, j, sumValue);
                }
            }
            return resultMatrix;
        }
    }

    public Matrix diff(Matrix matrix) {
        if (this.rows != matrix.rows || this.columns != matrix.columns) {
            System.out.println("Invalid");
            return null;
        }
        else{
            Matrix resultMatrix = new Matrix(this.rows, this.columns);
            for (int i = 0; i < matrix.rows; i++) {
                for (int j = 0; j < matrix.columns; j++) {
                    ComplexNumber diffValue = this.getValue(i, j).subtract(matrix.getValue(i, j));
                    resultMatrix.setValue(i, j, diffValue);
                }
            }
            return resultMatrix;
        }
    }

    public Matrix multiplication(Matrix matrix) {
        if (this.columns != matrix.rows) {
            System.out.println("Invalid");
            return null;
        }
        else {
            Matrix resMatrix = new Matrix(this.rows, this.columns);
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < matrix.columns; j++) {
                    ComplexNumber multiSum = new ComplexNumber(0, 0);
                    for (int k = 0; k < this.columns; k++) {
                        multiSum = multiSum.add(this.getValue(i, k).multiplication(matrix.getValue(k, j)));
                    }
                    resMatrix.setValue(i, j, multiSum);
                }
            }
            return resMatrix;
        }
    }

    public Matrix transpose() {
        Matrix matrix = new Matrix(this.rows, this.columns);
        for (int i = 0; i < matrix.rows; i++) {
            for (int j = 0; j < matrix.columns; j++) {
                matrix.setValue(j, i, this.matrix[i][j]);
            }
        }
        return matrix;
    }
}
