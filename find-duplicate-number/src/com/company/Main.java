package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {


    public static int findDuplicate(int[] nums) {
        int dup = 0;
        Map<Integer, Integer> counterMap = new HashMap<Integer, Integer>();

        for (Integer num : nums){
            int count = counterMap.getOrDefault(num, 0);
            if (count ==1 ){
                dup = num;
                break;
            } else {
                count = count + 1;
                counterMap.put(num,
                        count);
            }

        }
        return dup;
    }

    public static void main(String[] args) {
	// write your code here

        System.out.println("\nTest 1");
        System.out.println("\nExpected Output: ");
        System.out.println(2);
        System.out.println("\nActual Output: ");
        System.out.println(findDuplicate(new int[] {1,3,4,2,2}));


        System.out.println("\nTest 2");
        System.out.println("\nExpected Output: ");
        System.out.println(3);
        System.out.println("\nActual Output: ");
        System.out.println(findDuplicate(new int[] {3,1,3,4,2}));

    }
}
