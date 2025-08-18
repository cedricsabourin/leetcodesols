class Solution:

    # convert to lowercase to ease comparison
    # make pointers for the start of substring and end
    # We keep checking whether or not the *letter/number* on the start pointer and end pointer are the same
    # They keep moving to the center until they don't match
    # Once they pass eachother, we've gone through each character, and if we haven't caught a difference, then the string must be a palindrome
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        start = 0
        end = len(s) - 1
        while start < end:
            while start < end and not self.alphaNum(s[start]):
                start += 1
            while start < end and not self.alphaNum(s[end]):
                end -= 1

            if s[start] != s[end]:
                return False
            
            start += 1
            end -= 1
        return True

    def alphaNum(self, c: str) -> bool:
        return (ord('a') <= ord(c) <= ord('z') or
                ord('0') <= ord(c) <= ord('9'))        
