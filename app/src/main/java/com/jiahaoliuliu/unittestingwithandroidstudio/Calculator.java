package com.jiahaoliuliu.unittestingwithandroidstudio;

/**
 * Created by jiahaoliuliu on 3/8/15.
 * This is a simple class to demonstrate how the unit test on Android works.
 * What it do is just set the first number and the second number, then calculate
 * the sum of both number
 */
public class Calculator {

    private int firstNumber;
    private int secondNumber;

    // Empty constructor
    public Calculator() {}

    public Calculator(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    /**
     * Sum the first number with the second number and return the result
     * @return The sum of the first number and the second number
     */
    public int sum() {
        return firstNumber + secondNumber;
    }

    /**
     * Remove the value from the numbers
     */
    public void clean() {
        firstNumber = 0;
        secondNumber = 0;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Calculator that = (Calculator) o;

        if (firstNumber != that.firstNumber) return false;
        if (secondNumber != that.secondNumber) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstNumber;
        result = 31 * result + secondNumber;
        return result;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "firstNumber=" + firstNumber +
                ", secondNumber=" + secondNumber +
                '}';
    }
}
