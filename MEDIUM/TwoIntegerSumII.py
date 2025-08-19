class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        # l points to leftmost and r points to rightmost
        l, r = 0, len(numbers)-1

        # we iterate until the two pointers cross eachother
        while l < r:
            # if we're below target, then the left number needs to increase to get a higher sum
            if numbers[l] + numbers[r] < target:
                l += 1
            # then if we're too high, we lower the right number to get a lower sum
            elif numbers[l] + numbers[r] > target:
                r -= 1
            # if we didn't meet the past conditions, it means we are chilin and have the solution
            # (return 1-indexed)
            else:
                return [l+1, r+1]
