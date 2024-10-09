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
}