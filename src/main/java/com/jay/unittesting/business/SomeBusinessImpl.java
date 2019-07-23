package com.jay.unittesting.business;

import com.jay.unittesting.data.SomeDataService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class SomeBusinessImpl {
    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    private SomeDataService someDataService;

    public int calculateSum(int[] data){

        //1,2,3,4,5 => 1 + 2 + 3 + 4 + 5
        OptionalInt number = Arrays.stream(data).reduce(Integer::sum);
        return number.orElse(0);

        /*
        int sum = 0;
        for(int value: data){
            sum += value;
        }
        return sum;
         */
    }

    public int calculateSumUsingDataService(){
        int sum = 0;
        int[] data = someDataService.retrieveAllData();
        for(int value: data){
            sum += value;
        }
        return sum;
    }
}
