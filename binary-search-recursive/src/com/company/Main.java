package com.company;

import java.awt.*;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

public class Main {



    private static int recursive_bin_search(Integer[] arr, Integer theOne){
        Integer low = 0;
        Integer high = arr.length;
        Integer mid = (low + high) / 2 ;


        if (theOne < mid) {
            Integer[] subarray = Arrays.asList(arr)
                    .subList(low, mid)
                    .toArray(new Integer[0]);

        recursive_bin_search(subarray, theOne);
        }
        else if (mid > theOne ){
            Integer[] subarray = Arrays.asList(arr)
                    .subList(mid, high)
                    .toArray(new Integer[0]);
            recursive_bin_search(subarray, theOne);
        }
        else {
            return mid;
        }


        return-1;
    }


    public static void main(String[] args) {
        Integer [] arr = {1,2,3,4,5,6,7,8,9};
//        for (int i :arr) {
//            System.out.println(arr[2]);
//        }
        System.out.println(recursive_bin_search(arr,9);
	// write your code here
    }
}
