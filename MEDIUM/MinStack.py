class MinStack:
    def __init__(self):
        # stack holds each value as they are added
        # minStack holds the minimum values at the time that an element is added
        # ex.
        # [1, 4, 2, 0, 3] stack
        # [1, 1, 1, 0, 0] minStack
        #
        self.stack = []
        self.minStack = []

    def push(self, val: int) -> None:
        # if the value IS the minimum, or if there isnt already a minimum, add it to the minStack
        if not self.minStack or val < self.minStack[-1]:
            self.minStack.append(val)
        # if not we add the current min value back to the minstack
        else:
            self.minStack.append(self.minStack[-1])

        # we always add the value to the regular stack
        self.stack.append(val)

    # if there are values to pop, we simply pop them, nothing more
    def pop(self) -> None:
        if self.stack:
            self.stack.pop()
            self.minStack.pop()
        
    # if there is a value to return we return it
    def top(self) -> int:
        if self.stack:
            return self.stack[-1]

    # if there is a minvalue we return it
    def getMin(self) -> int:
        if self.minStack:
            return self.minStack[-1]
