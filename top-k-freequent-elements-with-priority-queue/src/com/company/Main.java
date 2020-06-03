package com.company;


import java.util.*;

/**
 * This solution is credited to user ElementNotFoundException on Leetcode.
 * The tasks of the challenges ares:
 *
 * 1) build a counter map that maps a num to its frequency
 * 2) build a heap/priority queue that keeps track of k most significant entries
 * 3) iterate through the final heap and get the keys
 */
public class Main {

    public static int[] topKFrequent(int[] nums, int k) {

        /**
         *  1) Build a counter map that maps a num to its frequency
         */
        Map<Integer, Integer> counterMap = new HashMap<Integer, Integer>();
        for (int num: nums){
            int count = counterMap.getOrDefault(num, 0);
            counterMap.put(num, count+1);
        }

        /**
         *  2) Build a heap/priority queue that keeps track of k most significant entries
         *
         * PriorityQueue in Java
         * Among its few siblings, one constructor in the PriorityQueue class accepts a single Comparator object.
         * offer() -- inserts the specified element into this priority queue.
         * poll() -- pops the least prioritized element
         *
         */

        PriorityQueue <Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue()-b.getValue());
        for (Map.Entry entry : counterMap.entrySet()) {
            pq.offer(entry);
            if ( pq.size()> k) pq.poll();
        }

        /**
         *  3) Iterate through the final heap and get the keys and save to a List
         */
            List <Integer> resList = new LinkedList<Integer>();
        while(!pq.isEmpty()) {
            resList.add(0, pq.poll().getKey());
        }
        /**
         * Extra step to convert a List to an Array (Leetcode Standard)
         */
        int[] resArray = resList.stream().mapToInt(i->i).toArray();



        return resArray;
    }


    public static void main(String[] args) {
	// Write your code here

        //Test 1.
        int [] test1 = {1,1,1,2,2,2,3,3,4,4,4,4,4,4,5,6,6,6,6,6,6,6,6,6,7};
        System.out.println("\nTest 1 :");
        System.out.print("Expected: ");
        Arrays.stream(new int [] {1,4,6})
                .mapToObj(i -> i + ", ")
                .forEach(System.out::print);
        System.out.print("\nActual: ");
        int [] result1 = topKFrequent(test1,3);
        Arrays.stream(result1)
                .mapToObj(i -> i + ", ")
                .forEach(System.out::print);


        System.out.println("\n\n");
        //Test 2.
        int [] test2 = {10,11,11,12,13,14,14,14,14,15,15,16,16,16,17,17,17};
        System.out.println("\nTest 2 :");
        System.out.print("Expected: ");
        Arrays.stream(new int [] {14,16,17})
                .mapToObj(i -> i + ", ")
                .forEach(System.out::print);
        System.out.print("\nActual: ");
        int [] result2 = topKFrequent(test2,3);
        Arrays.stream(result2)
                .mapToObj(i -> i + ", ")
                .forEach(System.out::print);



        System.out.println("\n\n\n\n");
    }



}
