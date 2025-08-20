class Solution:
    def search(self, nums: List[int], target: int) -> int:
        L, R = 0, (len(nums) - 1)

        while L <= R:
            # here mid = (L + R) // 2 works as well, although it can cause overflow if L and R are both huge numbers
            mid = L + ((R - L) // 2)
            
            # classic binary search. if too small we look at right half
            if nums[mid] < target:
                L = mid + 1

            # if too big we look at left half
            elif nums[mid] > target:
                R = mid - 1
            
            # if it's neither then we got the right answer
            else:
                return mid
        
        return -1
