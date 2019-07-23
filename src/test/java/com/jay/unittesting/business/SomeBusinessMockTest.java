package com.jay.unittesting.business;

import com.jay.unittesting.data.SomeDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {
    @InjectMocks
    SomeBusinessImpl business = new SomeBusinessImpl();

    @Mock
    SomeDataService dataServiceMock;


    @Test
    public void calculateSomeUsingDataService_basic(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{1,2,3});
        int actualResult = business.calculateSumUsingDataService();
        assertEquals(6, actualResult);
    }


    @Test
    public void calculateSomeUsingDataService_empty(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        int actualResult = business.calculateSumUsingDataService();
        assertEquals(0, actualResult);
    }

    @Test
    public void calculateSomeUsingDataService_oneValue(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{5});
        int actualResult = business.calculateSumUsingDataService();
        assertEquals(5, actualResult);
    }


}
