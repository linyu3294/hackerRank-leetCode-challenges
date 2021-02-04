package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

public class Main {
public static int[] twoSum (int[] nums, int target) {
   HashMap<Integer, Integer> m = new HashMap<>();
   for (int i = 0; i < nums.length; i++) {
      m.put( nums[i], i);
   }

   for (int j = 0; j < nums.length; j++) {
      int remainder = target - nums[j];
      if (m.containsKey(remainder) && m.get(remainder) != j) {
         return (new int[]{j, m.get(remainder)});
      }
   }
   int[] a = new int[0];
   return a;
}


public static void main (String[] args) {
   int [] result = twoSum(new int[]{3, 3}, 6);
   for (int i = 0; i< result.length; i++){
      System.out.println(result[i]);
   }
}
}
