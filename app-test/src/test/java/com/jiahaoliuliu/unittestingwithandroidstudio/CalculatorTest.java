package com.jiahaoliuliu.unittestingwithandroidstudio;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by jiahao on 3/10/15.
 */
@RunWith(RobolectricGradleTestRunner.class)
public class CalculatorTest {

    /**
     * Test when the empty constructor has been created, the values assigned
     * to the first number and the second number are zero
     */
    @Test
    public void emptyConstructorTest() {
        Calculator calculator = new Calculator();

        assertThat(calculator.getFirstNumber()).isEqualTo(0);
        assertThat(calculator.getSecondNumber()).isEqualTo(0);
    }

    /**
     * Test when the full constructor has been created, the values are correctly
     * assigned.
     */
    @Test
    public void fullConstructorTest() {
        int firstNumber = 1;
        int secondNumber = 2;

        Calculator calculator = new Calculator(firstNumber, secondNumber);
        assertThat(calculator.getFirstNumber()).isEqualTo(firstNumber);
        assertThat(calculator.getSecondNumber()).isEqualTo(secondNumber);
    }

    /**
     * Test the constructor assignation for the extreme numbers
     */
    @Test
    public void extremeAssignationsTest() {
        // Checking the max value
        Calculator calculator1 = new Calculator(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertThat(calculator1.getFirstNumber()).isEqualTo(Integer.MAX_VALUE);
        assertThat(calculator1.getSecondNumber()).isEqualTo(Integer.MAX_VALUE);

        // Checking the min value
        Calculator calculator2 = new Calculator(Integer.MIN_VALUE, Integer.MIN_VALUE);
        assertThat(calculator2.getFirstNumber()).isEqualTo(Integer.MIN_VALUE);
        assertThat(calculator2.getSecondNumber()).isEqualTo(Integer.MIN_VALUE);
    }

    /**
     * Testing all the possible values for the sum inside of the integer.
     * The follow test takes 1m14.27s in an MacBook with i7 2.2Ghz
     */
    @Test
    public void sumTest() {
        for (int firstNumber = Integer.MIN_VALUE; firstNumber < Integer.MAX_VALUE; firstNumber++) {
            int secondNumber = Integer.MAX_VALUE - firstNumber;
            Calculator calculator = new Calculator(firstNumber, secondNumber);
            assertThat(calculator.sum()).isEqualTo(Integer.MAX_VALUE);
        }
    }

    /**
     * Test the method clean() cleans correctly the values assigned
     */
    @Test
    public void cleanTest() {
        int firstNumber = 1;
        int secondNumber = 2;

        Calculator calculator = new Calculator(firstNumber, secondNumber);

        // check the values has been correctly assigned
        assertThat(calculator.getFirstNumber()).isEqualTo(firstNumber);
        assertThat(calculator.getSecondNumber()).isEqualTo(secondNumber);

        // Clean the values
        calculator.clean();
        assertThat(calculator.getFirstNumber()).isEqualTo(0);
        assertThat(calculator.getSecondNumber()).isEqualTo(0);
    }
}
