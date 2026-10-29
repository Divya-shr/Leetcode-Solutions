class Solution:
    def validTicTacToe(self, board: List[str]) -> bool:
        def checkWinState(board_):
            val_x = 0
            val_o = 0
            for i in range(3):
                if board_[i][0] == board_[i][1] and board_[i][1] == board_[i][2] and board_[i][0] != " ":
                    if board_[i][0] == "X":
                        val_x += 1
                    else:
                        val_o += 1

                if board_[0][i] == board_[1][i] and board_[1][i] == board_[2][i] and board_[0][i] != " ":
                    if board_[0][i] == "X":
                        val_x += 1
                    else:
                        val_o += 1
                
            if board_[0][0] == board_[1][1] and board_[1][1] == board_[2][2] and board_[0][0] != " ":
                if board_[0][0] == "X":
                    val_x += 1
                else:
                    val_o += 1

            if board_[0][2] == board_[1][1] and board_[1][1] == board_[2][0] and board_[2][0] != " ":
                if board_[2][0] == "X":
                    val_x += 1
                else:
                    val_o += 1
            
            return val_x, val_o    # returns (how many times x won, how many times o won)
 
        arr = []    #total entry on board
        for i in range(3):
            for j in range(3):
                if board[i][j] != " ":
                    arr.append(board[i][j])
        if len(arr) == 0:
            return True   #If no entry then valid board
        elif len(arr) == 1:
            if arr[0] == "X":
                return True  #if 1st entry is X then valid else not valid
            else:
                return False
        else:
            x = 0    #number of x in board
            o = 0    #number of o in board
            for i in arr:
                if i == "X":
                    x += 1
                else:
                    o += 1
            if abs(x-o) > 1:
                return False
            elif o > x:
                return False
            else:
                win_x = checkWinState(board)[0]   #number of times X wins 
                win_o = checkWinState(board)[1]   #number of times O wins 

                if win_x > 2 or win_o > 2: #If any of them wins more that 2 times then invalis
                    return False
                elif (win_x) > 0 and (win_o) > 0: # if both of them win then Invalid
                    return False
                elif (win_x) > 0 and win_o == 0 and x == o : #if x wins but the number o is same as x then invalid
                    return False
                elif win_o > 0 and win_x == 0 and o < x: #if O wins but the number of O is less than X then Invalid
                    return False
                else:
                    return True  #every condition except these are Valid

        