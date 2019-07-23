package com.jay.unittesting.business;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {
    List<String> mock = mock(List.class);
    @Test
    public void test1(){
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }
    @Test
    public void test2(){
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
    }
    @Test
    public void testReturnWithParameters(){
        when(mock.get(0)).thenReturn("hello worlds");
        assertEquals("hello worlds", mock.get(0));
    }

    @Test
    public void testReturnWithGenericParameters(){
        when(mock.get(anyInt())).thenReturn("hello worlds");
        assertEquals("hello worlds", mock.get(11));
    }

    @Test
    public void verificationbasics(){
        //SUT
        String value1 = mock.get(0);
        String value2 = mock.get(1);

        //verify
        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atLeastOnce()).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);

    }

    @Test
    public void argumentCapturing(){
        //SUT
        mock.add("Some String");

        //verify
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());
        assertEquals("Some String", captor.getValue());
    }

    @Test
    public void argumentCapturingMultiple(){
        //SUT
        mock.add("Some String1");
        mock.add("Some String2");

        //verify
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());
        List<String> allValues = captor.getAllValues();
        assertEquals("Some String1", allValues.get(0));
        assertEquals("Some String2", allValues.get(1));
    }

    @Test
    public void spying(){
        //SUT
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Test1");
        //verify
        System.out.println(arrayListSpy.get(0)); //null
        System.out.println( arrayListSpy.size()); //0
        arrayListSpy.add("Test");
        arrayListSpy.add("Test2");
        System.out.println(arrayListSpy.size());//0
        when(arrayListSpy.size()).thenReturn(5);
        arrayListSpy.add("Test3");
        System.out.println(arrayListSpy.size());//0

    }
}
