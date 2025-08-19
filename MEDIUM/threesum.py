class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        output = []

        sortednums = sorted(nums)

        for i in range(len(sortednums)):
            
            # If there are two consecutive numbers, we need to ignore the second one to avoid duplicates
            if i > 0 and sortednums[i] == sortednums[i - 1]:
                continue

            # Left and Right pointers, classic two-sum
            L, R = i+1, (len(sortednums)-1)
            target = -sortednums[i]

            while L < R:
                if sortednums[L] + sortednums[R] < target:
                    L += 1
                elif sortednums[L] + sortednums[R] > target:
                    R -= 1
                else: 
                    # Once we add the triplet to the list, we move our pointers over so we can keep searching for triplets
                    output.append([sortednums[i], sortednums[L], sortednums[R]])
                    L += 1
                    R -= 1

                    # as long as we find duplicates keep moving to find unique numbers
                    while L < R and sortednums[L] == sortednums[L-1]:
                        L += 1
                    while L < R and sortednums[R] == sortednums[R+1]:
                        R -= 1

        return output
