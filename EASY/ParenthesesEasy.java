package EASY;
import java.util.Stack;

public class ParenthesesEasy {
    public static void main(String[] args) {
        String case1 = "()";
        String case2 = "()[]{}";
        String case3 = "(]";
        String case4 = "([])";
        System.out.println(case1 + ":  " + isValid(case1));
        System.out.println(case2 + ":  " + isValid(case2));
        System.out.println(case3 + ":  " + isValid(case3));
        System.out.println(case4 + ":  " + isValid(case4));
    }

    public static boolean isValid(String s) {
        // Create a stack that will contain all the opening parentheses
        Stack<Character> s1 = new Stack<>();

        // loop through all characters of the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // add opening to stack
            if (c == '(' || c == '{' || c == '[') {
                s1.push(c);
            } else {
                // if it's a closing, we check if the most recent opening is the corresponding closing we found
                if (s1.isEmpty()) { return false; }
                char top = s1.pop();
                if (!((top == '(' && c == ')')
                 || (top == '{' && c == '}')
                 || (top == '[' && c == ']'))) {
                    return false;
                 }
            }
        }

        // if at the end of the algorithm the stack still has a parentheses, it's false because there are more opening than closing
        if (!s1.isEmpty()) {
            return false;
        }

        // if we reach here it means it's valid
        return true;

    }


}
