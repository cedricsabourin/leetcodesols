class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for row in range(9):
            seen = set()
            for col in range(9):
                if board[row][col] in seen:
                    return False # duplicate number in a row
                if board[row][col] != ".":
                    seen.add(board[row][col])
        
        for col in range(9):
            seen = set()
            for row in range(9):
                if board[row][col] in seen:
                    return False # duplicate number in a column
                if board[row][col] != ".":
                    seen.add(board[row][col])
        

        # There are 9 decks to check
        for square in range(9):
            # same as other checks, have a set that keeps track of seen elements
            seen = set()
            for i in range(3):
                for j in range(3):
                    # check square 0
                    #       [0][0], [0][1], [0][2],   #
                    #       [1][0], [1][1], [1][2],   #
                    #       [2][0], [2][1], [2][2].   #
                    # then  square 1                  #
                    #       [0][3], [0][4], [0][5],   #
                    #       [1][3], [1][4], [1][5],   #
                    #       [2][3], [2][4], [2][5]    #
                    # square 7 would be               #
                    #       [6][3], [6][4], [6][5],   #
                    #       [7][3], [7][4], [7][5],   #
                    #       [8][3], [8][4], [8][5],   #
                    # # # # # # # # # # # # # # # # # #
                    row = (square // 3) * 3 + i
                    col = (square % 3) * 3 + j
                    if board[row][col] in seen:
                        return False
                    if board[row][col] != ".":
                        seen.add(board[row][col])
        
        return True
