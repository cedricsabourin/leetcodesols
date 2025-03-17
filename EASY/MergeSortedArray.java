public class MergeSortedArray {
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
