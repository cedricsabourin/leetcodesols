package EASY;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        MergeSortedArray.merge(nums1, 3, nums2, 3);
        System.out.println("Test 1: " + Arrays.toString(nums1)); // Expected: [1, 2, 2, 3, 5, 6]

        // Test Case 2: nums1 has only one element, nums2 is empty
        int[] nums3 = {1};
        int[] nums4 = {};
        MergeSortedArray.merge(nums3, 1, nums4, 0);
        System.out.println("Test 2: " + Arrays.toString(nums3)); // Expected: [1]

        // Test Case 3: nums1 initially empty except for zeroes, nums2 has elements
        int[] nums5 = {0};
        int[] nums6 = {1};
        MergeSortedArray.merge(nums5, 0, nums6, 1);
        System.out.println("Test 3: " + Arrays.toString(nums5)); // Expected: [1]

        // Test Case 4: Both arrays empty
        int[] nums7 = {};
        int[] nums8 = {};
        MergeSortedArray.merge(nums7, 0, nums8, 0);
        System.out.println("Test 4: " + Arrays.toString(nums7)); // Expected: []

        // Test Case 5: nums1 has elements, nums2 has elements, but nums1 is all smaller
        int[] nums9 = {1, 2, 3, 0, 0, 0};
        int[] nums10 = {4, 5, 6};
        MergeSortedArray.merge(nums9, 3, nums10, 3);
        System.out.println("Test 5: " + Arrays.toString(nums9)); // Expected: [1, 2, 3, 4, 5, 6]
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        // pointing at the end of array 1 and array 2. m and n respectively
        int p1 = m-1;
        int p2 = n-1;

        // pointing at the end of the final array
        int i = n+m-1;

        // loop backwards through each array
        while (p1 >= 0 && p2 >= 0) {
            
            // whichever is highest gets put at the end of final array
            if (nums1[p1] >= nums2[p2]) {
                nums1[i] = nums1[p1];
                p1--;
            } else {
                nums1[i] = nums2[p2];
                p2--;
            }
            i--;
        }

        // if we have remaining elements in array 2, we simply loop through and add it to the final array
        while (p2 >= 0) {
            nums1[i] = nums2[p2];
            p2--;
            i--;
        }

        /** Example walkthrough
        [1, 2, 3, 0, 0, 0] and [2, 5, 6]
        > [1, 2, 3, 0, 0, 6]
        > [1, 2, 3, 0, 5, 6]
        > [1, 2, 3, 3, 5, 6]
        > [1, 2, 2, 3, 5, 6] => final merged array
         */


    }
}
