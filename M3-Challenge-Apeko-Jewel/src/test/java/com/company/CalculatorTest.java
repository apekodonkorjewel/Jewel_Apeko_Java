package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    Calculator calc;

    @Before
    public void setUp() {
        calc = new Calculator();
    }

    @Test
    public void shouldDividePositives() {

        assertEquals(3, calc.divide(6,2));
        assertEquals(2, calc.divide(80, 39));
        assertEquals(1, calc.divide(105, 100));
    }

    @Test
    public void shouldDivideNegatives() {

        assertEquals(3, calc.divide(-6,-2));
        assertEquals(2, calc.divide(-80, -39));
        assertEquals(1, calc.divide(-105, -100));
    }

    @Test
    public void shouldDivideBothPosAndNeg() {
        assertEquals(-3, calc.divide(6,-2));
        assertEquals(-2, calc.divide(-80, 39));
        assertEquals(-1, calc.divide(105, -100));
    }

    @Test
    public void shouldReturnZero() {
        assertEquals(0, calc.divide(0,0));
        assertEquals(0, calc.divide(0, 1));
        assertEquals(0, calc.divide(105, 0));
    }

    //Test Cases for add() method
    @Test
    public void shouldAddPositives(){
        assertEquals(6, calc.add(4, 2));
        assertEquals(23, calc.add(22, 1));
        assertEquals(12229, calc.add(2357, 9872));

    }

    @Test
    public void shouldAddNegatives(){
        assertEquals(-7, calc.add(-5, -2));
        assertEquals(-109, calc.add(-100, -9));
        assertEquals(-1598, calc.add(-6, -1592));
    }

    @Test
    public void shouldAddBothPosAndNeg(){
        assertEquals(-4, calc.add(-6, 2));
        assertEquals(3, calc.add(5, -2));
        assertEquals(-104, calc.add(-115, 11));
    }

    @Test
    public void shouldAddPosAndZero(){
        assertEquals(82, calc.add(0, 82));
        assertEquals(44, calc.add(44, 0));
        assertEquals(29, calc.add(0, 29));
    }

    @Test
    public void shouldAddNegAndZero(){
        assertEquals(-3, calc.add(0, -3));
        assertEquals(-179, calc.add(-179, 0));
        assertEquals(-193, calc.add(0, -193));
    }

    //Test cases for subtract() method
    @Test
    public void shouldSubPositives(){
        assertEquals(1, calc.subtract(20, 19));
        assertEquals(-46, calc.subtract(9, 55));
        assertEquals(998, calc.subtract(1002, 4));
    }

    @Test
    public void shouldSubNegatives(){
        assertEquals(1, calc.subtract(-19, -20));
        assertEquals(-14, calc.subtract(-15, -1));
        assertEquals(-90, calc.subtract(-189, -99));
    }

    @Test
    public void shouldSubBothPosAndNeg(){
        assertEquals(1008, calc.subtract(1004, -4));
        assertEquals(-69, calc.subtract(-25, 44));
        assertEquals(-16, calc.subtract(-2, 14));
    }

    @Test
    public void shouldSubPosAndZero(){
        assertEquals(1004, calc.subtract(1004, 0));
        assertEquals(-44, calc.subtract(0, 44));
        assertEquals(-14, calc.subtract(0, 14));
    }

    @Test
    public void shouldSubNegAndZero(){
        assertEquals(4, calc.subtract(0, -4));
        assertEquals(-25, calc.subtract(-25, 0));
        assertEquals(-2, calc.subtract(-2, 0));
    }

    //Test Cases for multiply() methods
    @Test
    public void shouldMulPositives(){
        assertEquals(8, calc.multiply(2, 4));
        assertEquals(90, calc.multiply(15, 6));
        assertEquals(297, calc.multiply(3, 99));
    }

    @Test
    public void shouldMulNegatives(){
        assertEquals(18, calc.multiply(-2, -9));
        assertEquals(260, calc.multiply(-4, -65));
        assertEquals(710, calc.multiply(-71, -10));
    }

    @Test
    public void shouldMulBothPosAndNeg(){
        assertEquals(-60, calc.multiply(-6, 10));
        assertEquals(-440, calc.multiply(88, -5));
        assertEquals(-99, calc.multiply(-9, 11));
    }

    @Test
    public void shouldMulPosAndZero(){
        assertEquals(0, calc.multiply(0, 10));
        assertEquals(0, calc.multiply(88, 0));
        assertEquals(0, calc.multiply(0, 11));
    }

    @Test
    public void shouldMulNegAndZero(){
        assertEquals(0, calc.multiply(-6, 0));
        assertEquals(0, calc.multiply(0, -5));
        assertEquals(0, calc.multiply(-9, 0));
    }
}