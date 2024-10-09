package hse.homework;

import java.util.Objects;

public class ComplexNumber {
    private double real, image;

    public ComplexNumber() {
        this(0, 0);
    }

    public ComplexNumber(double real) {
        this(real, 0);
    }

    public ComplexNumber(double real, double image) {
        this.real = real;
        this.image = image;
    }

    public ComplexNumber add(ComplexNumber num) {
        return new ComplexNumber(this.real + num.real, this.image + num.image);
    }

    public ComplexNumber subtract(ComplexNumber num) {
        return new ComplexNumber(this.real - num.real, this.image - num.image);
    }

    public ComplexNumber multiplication(ComplexNumber num) {
        return new ComplexNumber(this.real*num.real - this.image*num.image, this.real*num.image + this.image*num.real);
    }

    public void printCNum() {
        System.out.printf("%.2f + %.2f*i", real, image);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        return Double.compare(real, that.real) == 0 && Double.compare(image, that.image) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, image);
    }
}
