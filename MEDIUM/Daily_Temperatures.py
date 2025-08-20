class Solution:
    # stack holds values' indices until we find something greater than them
    # We traverse through the temperatures, when we hit a temperature greater than the top of the stack,
    # we set the number of days between to the different in index and stackIndex

    #sim:
    # temperatures = [30, 38, 32, 35, 40]
    # output = [0, 0, 0, 0, 0]
    # stack = bottom [] top
    # temperatures = [30, 38, 32, 35, 40]   
    # output = [0, 0, 0, 0, 0]
    # stack = bottom [0] top
    # temperatures = [30, 38, 32, 35, 40]   
    # output = [1, 0, 0, 0, 0]
    # stack = bottom [1] top
    # temperatures = [30, 38, 32, 35, 40]   
    # output = [1, 0, 0, 0, 0]
    # stack = bottom [1 2] top
    # temperatures = [30, 38, 32, 35, 40]   
    # output = [1, 1, 0, 0, 0]
    # stack = bottom [1, 3] top
    # temperatures = [30, 38, 32, 35, 40]   
    # output = [1, 1, 3, 1, 0]
    # stack = bottom [] top

    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = [] # holds indices
        output = [0] * len(temperatures)
        
        for i in range(len(temperatures)):
            # while the current temperature is greater than the one at the top of the stack, 
            # we add to the output the difference in days between itself and the current day
            while stack and temperatures[i] > temperatures[stack[-1]]:
                stackIndex = stack.pop()
                output[stackIndex] = i - stackIndex
            stack.append(i)
        
        return output
