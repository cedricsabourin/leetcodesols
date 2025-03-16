// Source code is decompiled from a .class file using FernFlower decompiler.
package EASY;

public class PalindromeNumberEasy {
   public PalindromeNumberEasy() {
   }

   public static void main(String[] var0) {
      System.out.println("Test Case: 121 => " + isPalindrome(121));
      System.out.println("Test Case: -121 => " + isPalindrome(-121));
      System.out.println("Test Case: 10 => " + isPalindrome(10));
      System.out.println("Test Case: 12321 => " + isPalindrome(12321));
      System.out.println("Test Case: 123321 => " + isPalindrome(123321));
   }

   public static boolean isPalindrome(int x) {
    if (x < 0) {return false;} // negatives are not palindrom because of the '-'
    if (x == 0) {return true;} // 0 is palindrome
    if (x%10 == 0) {return false;} // no number starts with 0 other than 0 itself


    // the reverse of the number. 
    int rev = 0;

    while (rev < x) {
        // move every digit one to the left 
        rev *= 10;

        // add the last digit to rev (for 12321, rev is now 1, then 12, then 123)
        rev += x%10;

        // divide x by 10 ignoring the decimal (12321 becomes 1232)
        x = Math.floorDiv(x, 10);
    }

    // Depending on number of digits.
    // (123321), we get rev = 123 and x = 123, this is the first case
    // (12321, we get rev = 123 and x = 12. this is the second case)
    return (rev == x || x == Math.floorDiv(rev, 10));
}
}
