class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        stack = [] # this will hold each fleet as their time of arrival 
        pairs = [] # combine both arrays into one
        for i in range(len(position)):
            pairs.append((position[i], speed[i]))

        # Car closest to finish line first. 
        pairs.sort(reverse = True)

        for pair in pairs:
            timeOfArrival = (target-pair[0]) / pair[1] # time = distanceToTravel / speed
            
            # if we have an empty start (probably every start), we add the first car we see's timeOfArrival
            if not stack:
                stack.append(timeOfArrival)

            # or if the timeOfArrival is higher than the last fleet in the stack, it becomes it's own fleet
            elif timeOfArrival > stack[-1]:
                stack.append(timeOfArrival)

            # if the current car's time of arrival is the same or lower as the latest fleet, it'll just join it and 
            # this means we can safely ignore it  

        # return the number of fleets    
        return len(stack)

        
