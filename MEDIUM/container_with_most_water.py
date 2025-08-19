class Solution:
    def maxArea(self, heights: List[int]) -> int:
        # two pointers one left and one right 
        # maxArea = 0
        # maxArea = highest from maxArea and area of (R-L)*min(heights[L], heights[R])
        # move L and R depending on which of the two is smallest, as that is the one limiting the area
        # if they're even, we move either as it won't make a difference 
        # one L and R meet, then maxArea should hold the value we need to output

        maxArea = 0
        L, R = 0, (len(heights) - 1)

        while L < R:
            maxArea = max(maxArea, ((R-L) * min(heights[L], heights[R])) )
            if heights[L] > heights[R]:
                R -= 1
            else:
                L += 1
        return maxArea
