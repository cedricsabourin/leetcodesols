class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        # create a hashset out of nums to get O(1) access
        sett = set(nums)
        longest = 0

        # traverse the set. if there is nothing 1 lower than it, it is the start of a streak of length 1
        # while there is a number 1 higher, the length of the streak increases. Then we check if the streak's length
        # is bigger than the longest streak's length.
        # do this for all numbers of the set and return the longest streak we kept track of
        for num in sett:
            if (num-1) not in sett:
                length = 1
                while (num + 1) in sett:
                    length += 1
                    num += 1
                longest = max(length, longest)
        return longest
