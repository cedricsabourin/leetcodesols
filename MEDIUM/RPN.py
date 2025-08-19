class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        # stack will hold all the numbers, we push each number as we traverse
        # when we get an operator, we pop the 2 last numbers added, and perform the operation
        # add the result back to the stack so it is then treated as another number and can participate in operations
        # at the end we just return the number that's left
        stack = []

        if len(tokens) == 1:
            return int(tokens[-1])

        for token in tokens:
            if token != "+" and token != "-" and token != "*" and token != "/":
                stack.append(token)
            else:
                num1 = int(stack.pop())
                num2 = int(stack.pop())
                result = 0
                if (token == "+"):
                    result = num2 + num1
                elif (token == "-"):
                    result = num2 - num1
                elif (token == "*"):
                    result = num2 * num1
                else:
                    result = int(num2 / num1)

                stack.append(result)
        return stack[-1]
