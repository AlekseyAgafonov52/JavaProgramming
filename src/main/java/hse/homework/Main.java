package hse.homework;

public class Main {
    public static void main(String[] args) {
        //Example of matrix
        Matrix matrix = new Matrix(2, 2);
        matrix.setValue(0, 0, new ComplexNumber(1, 1));
        matrix.setValue(0, 1, new ComplexNumber(2, 2));
        matrix.setValue(1, 0, new ComplexNumber(3, 3));
        matrix.setValue(1, 1, new ComplexNumber(4, 4));
    }
}
