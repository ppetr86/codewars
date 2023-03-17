package com.example.codewars3;

import com.example.vogella.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Simple multiplication should work")
    void testMultiply() {
        Assertions.assertEquals(20, calculator.multiply(4, 5),
                "Regular multiplication should work");
    }

    @RepeatedTest(5)
    @DisplayName("Ensure correct handling of zero")
    void testMultiplyWithZero() {
        Assertions.assertEquals(0, calculator.multiply(0, 5), "Multiple with zero should be zero");
        Assertions.assertEquals(0, calculator.multiply(5, 0), "Multiple with zero should be zero");
    }

    @Test
    @DisplayName("invalid arg should throw Exception")
    void invalidArgumentTestDivide() {
        Throwable exception = assertThrows(InvalidParameterException.class, () -> calculator.divide(10, 0));
        assertEquals("divisor must be greater 0", exception.getMessage());
    }

}