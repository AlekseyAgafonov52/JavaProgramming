package hse.homework;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ComplexNumberTest {

    @Test
    void add() {
        ComplexNumber complexNumber1 = new ComplexNumber(1, 1);
        ComplexNumber complexNumber2 = new ComplexNumber(2, 2);
        ComplexNumber complexNumberResult = new ComplexNumber(3, 3);
        assertEquals(complexNumber1.add(complexNumber2), complexNumberResult);
    }

    @Test
    void subtract() {
        ComplexNumber complexNumber1 = new ComplexNumber(5, 5);
        ComplexNumber complexNumber2 = new ComplexNumber(3, 3);
        ComplexNumber complexNumberResult = new ComplexNumber(2, 2);
        assertEquals(complexNumber1.subtract(complexNumber2), complexNumberResult);
        }

    @Test
    void multiplication() {
        ComplexNumber complexNumber1 = new ComplexNumber(1, 1);
        ComplexNumber complexNumber2 = new ComplexNumber(2, 2);
        ComplexNumber complexNumberResult = new ComplexNumber(0, 4);
        assertEquals(complexNumber1.multiplication(complexNumber2), complexNumberResult);
    }
}