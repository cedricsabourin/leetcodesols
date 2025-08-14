class Solution {
    // TWO PASS SOLUTION
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numbers = new HashMap<>();

        // first pass add all the numbers to the hashmap with their corresponding index
        for (int i = 0; i < nums.length; i++) {
            numbers.put(nums[i], i);
        }
      
        int difference;

        // for each number in the array, check if there is something in the hashmap that will add up to the target value. (that is not in the same index)
        for (int i = 0; i < nums.length; i++) {
            difference = target - nums[i];
            if (numbers.containsKey(difference) && numbers.get(difference) != i) {
                return new int[] {i, numbers.get(difference)};
            }
        }
        return new int[0];
    }
}
