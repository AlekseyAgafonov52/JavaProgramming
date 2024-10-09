package hse.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void add() {
        Matrix matrix = new Matrix(2, 2);
        matrix.setValue(0, 0, new ComplexNumber(1, 1));
        matrix.setValue(0, 1, new ComplexNumber(2, 2));
        matrix.setValue(1, 0, new ComplexNumber(3, 3));
        matrix.setValue(1, 1, new ComplexNumber(4, 4));
        Matrix matrix1 = new Matrix(2, 2);
        matrix1.setValue(0, 0, new ComplexNumber(1, 1));
        matrix1.setValue(0, 1, new ComplexNumber(2, 2));
        matrix1.setValue(1, 0, new ComplexNumber(3, 3));
        matrix1.setValue(1, 1, new ComplexNumber(4, 4));
        Matrix matrixResult = new Matrix(2, 2);
        matrixResult.setValue(0, 0, new ComplexNumber(2, 2));
        matrixResult.setValue(0, 1, new ComplexNumber(4, 4));
        matrixResult.setValue(1, 0, new ComplexNumber(6, 6));
        matrixResult.setValue(1, 1, new ComplexNumber(8, 8));
        assertEquals(matrix.add(matrix1), matrixResult);
    }

    @Test
    void subtract() {
        Matrix matrix = new Matrix(2, 2);
        matrix.setValue(0, 0, new ComplexNumber(1, 1));
        matrix.setValue(0, 1, new ComplexNumber(2, 2));
        matrix.setValue(1, 0, new ComplexNumber(3, 3));
        matrix.setValue(1, 1, new ComplexNumber(4, 4));
        Matrix matrix1 = new Matrix(2, 2);
        matrix1.setValue(0, 0, new ComplexNumber(1, 1));
        matrix1.setValue(0, 1, new ComplexNumber(2, 2));
        matrix1.setValue(1, 0, new ComplexNumber(3, 3));
        matrix1.setValue(1, 1, new ComplexNumber(4, 4));
        Matrix matrixResult = new Matrix(2, 2);
        matrixResult.setValue(0, 0, new ComplexNumber(0, 0));
        matrixResult.setValue(0, 1, new ComplexNumber(0, 0));
        matrixResult.setValue(1, 0, new ComplexNumber(0, 0));
        matrixResult.setValue(1, 1, new ComplexNumber(0, 0));
        assertEquals(matrix.subtract(matrix1), matrixResult);
    }

    @Test
    void multiplication() {
        Matrix matrix = new Matrix(2, 2);
        matrix.setValue(0, 0, new ComplexNumber(1, 1));
        matrix.setValue(0, 1, new ComplexNumber(2, 2));
        matrix.setValue(1, 0, new ComplexNumber(3, 3));
        matrix.setValue(1, 1, new ComplexNumber(4, 4));
        Matrix matrix1 = new Matrix(2, 2);
        matrix1.setValue(0, 0, new ComplexNumber(1, 1));
        matrix1.setValue(0, 1, new ComplexNumber(2, 2));
        matrix1.setValue(1, 0, new ComplexNumber(3, 3));
        matrix1.setValue(1, 1, new ComplexNumber(4, 4));
        Matrix matrixResult = new Matrix(2, 2);
        matrixResult.setValue(0, 0, new ComplexNumber(0, 14));
        matrixResult.setValue(0, 1, new ComplexNumber(0, 20));
        matrixResult.setValue(1, 0, new ComplexNumber(0, 30));
        matrixResult.setValue(1, 1, new ComplexNumber(0, 44));
        assertEquals(matrix.multiplication(matrix1), matrixResult);
    }

    @Test
    void transpose() {
        Matrix matrix = new Matrix(2, 2);
        matrix.setValue(0, 0, new ComplexNumber(1, 1));
        matrix.setValue(0, 1, new ComplexNumber(2, 2));
        matrix.setValue(1, 0, new ComplexNumber(3, 3));
        matrix.setValue(1, 1, new ComplexNumber(4, 4));
        Matrix matrixResult = new Matrix(2, 2);
        matrixResult.setValue(0, 0, new ComplexNumber(1, 1));
        matrixResult.setValue(0, 1, new ComplexNumber(3, 3));
        matrixResult.setValue(1, 0, new ComplexNumber(2, 2));
        matrixResult.setValue(1, 1, new ComplexNumber(4, 4));
        assertEquals(matrix.transpose(), matrixResult);
    }
}