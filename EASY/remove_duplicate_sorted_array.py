class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        k = 1 # first element will always be unique so there's always at least one 
              # k tracks the position where the next unique element should be written.
              #     k
              # [1, 1, 2, 3, 4]
              # [1, 1, 2, 3, 4]
              #        k
              # [1, 2, 2, 3, 4]
              #           k
              # [1, 2, 3, 3, 4]
              #              k
              # [1, 2, 3, 4, 4]
        
        # We're gonna iterate through the list, if the current element is equal 
        for i in range(1, len(nums)):
            if nums[i] != nums[k-1]:
                nums[k] = nums[i]
                k += 1
        nums = nums[0:k]
        return k


