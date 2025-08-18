class Solution:
  #  Prefix array contains the product of everything that comes before a certain index
  #  Postfixe array contains the product of everything that comes after a certain index
  #  
  #  [1, 2, 4, 6]
  #  pre = [1*1, 1*2, 2*4, 4*6] =    [1,   2, 8, 24]
  #  post = [1*48, 2*24, 4*6, 6*1] = [48, 48, 24, 6]
  #  returns [1*48, 1*24, 2*6, 8*1] = [48, 24, 12, 8]
  #
  #
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prefixes = [1] * len(nums)
        postfixes = [1] * len(nums)
        tbr = [1] * len(nums)
        for i in range (len(nums)):
            if i == 0:
                prefixes[i] = nums[i]
            else:
                prefixes[i] = prefixes[i-1] * nums[i]
        
        for i in range (len(nums)-1, -1, -1):
            if i == (len(nums) - 1):
                postfixes[i] = nums[i]
            else:
                postfixes[i] = postfixes[i+1] * nums[i]
        
        for i in range(len(nums)):
            if i == 0:
                tbr[i] = postfixes[i + 1]
            elif i == len(nums) - 1:
                tbr[i] = prefixes[i - 1]
            else:
                tbr[i] = prefixes[i-1] * postfixes[i+1]
        
        return tbr
