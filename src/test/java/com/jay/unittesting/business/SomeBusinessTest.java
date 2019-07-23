package com.jay.unittesting.business;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SomeBusinessTest {
    @Test
    public void calculateSom_basic(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[]{1,2,3});
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }
}
