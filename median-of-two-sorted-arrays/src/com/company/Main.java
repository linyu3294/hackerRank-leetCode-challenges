package com.company;

import javax.sound.midi.SysexMessage;

public class Main {
public static double findMedianSortedArrays (int[] nums1, int[] nums2) {

   if (nums1.length > nums2.length) {
      return findMedianSortedArrays(nums2, nums1);
   }

   int l = 0;
   int r = nums1.length;
   int combinedLen = nums1.length + nums2.length;
   String evenOrOdd = combinedLen % 2 == 0 ? "even" : "odd";
   int k = (combinedLen + 1) / 2;
   double median = -1;
   while (l < r) {
      final int m1 = l + (r-l) / 2;
      final int m2 = k - m1;

      System.out.println(m1);
      System.out.println(m2);
      if (nums1[m1] < nums2[m2-1]) {
         l = m1 +1;
      } else {
         r = m1;
      }
   }

   final int m1 = l;
   final int m2 = k - m1;
   System.out.println(m1);
   System.out.println(m2);

   final double c1 = Math.max (
      m1<=0? Double.NEGATIVE_INFINITY: nums1[m1-1],
      m2<=0? Double.NEGATIVE_INFINITY: nums2[m2-1]
   );
   if (combinedLen % 2 == 1) return c1;

   final double c2 = Math.min (
      m1>=nums1.length ?  Double.POSITIVE_INFINITY : nums1[m1],
      m2>=nums2.length ?  Double.POSITIVE_INFINITY : nums2[m2]
   );
   System.out.println(c1 +  "   " + c2);
   return (double) (c1 + c2) * 0.5;
}



public static void main (String[] args) {
   // write y our code here
   int[] nums1 = new int[]{1, 4, 5, 6, 10, 12, 13};
   int[] nums2 = new int[]{3, 7, 8, 11, 14, 15, 16, 17};

   int[] nums3 = new int[]{1, 2};
   int[] nums4 = new int[]{3, 4};
   double median = findMedianSortedArrays(nums3, nums4);
   System.out.println(median);

   // k = (len(num1) + len(num2) +1 ) / 2
   // combined list = {1,3,4,5,6,7,8,10,11,12,13,14,15,16,17}
   //                  0 1 2 3 4 5 6  7  8  9 10 11 12 13 14
   //                                 *
   //                                ***
   // median of two sorted arrays = 10, the 7th element of the combined list


}
}
