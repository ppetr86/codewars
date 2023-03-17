package com.example.vogella;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.security.InvalidParameterException;
import java.util.Arrays;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Calculator {


    private int i1, i2, i3;
    private int[] ints;

    public Calculator(int i1, int i2, int i3) {
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
        this.ints = null;
    }


    public int divide(int i1, int i2) {

        if (i2 <= 0) throw new InvalidParameterException("divisor must be greater 0");
        return i1 / i2;
    }

    public int multiply(int i1, int i2) {
        return i1 * i2;
    }

    public int subtract(int i1, int i2, int i3, int... ints) {
        int result = i1 - i2 - i3;
        int arrSum = 0;
        if (ints != null)
            arrSum = Arrays.stream(ints).reduce(Integer::sum).getAsInt();
        return result - arrSum;
    }

    private int add(int i1, int i2, int i3, int... ints) {
        int result = i1 + i2 + i3;
        int arrSum = 0;
        if (ints != null)
            arrSum = Arrays.stream(ints).reduce(Integer::sum).getAsInt();
        return result + arrSum;
    }
}
