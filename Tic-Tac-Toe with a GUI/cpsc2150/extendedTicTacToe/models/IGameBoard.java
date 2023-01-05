package cpsc2150.extendedTicTacToe.models;

import cpsc2150.extendedTicTacToe.models.BoardPosition;

/**
 * This interface contains the operations used on the 2D game board. The board
 * is initially empty with a dimension of row * col. The top left space is
 * (0,0), the rightmost column is col - 1, and the bottommost row is row - 1.
 *
 * Initialization Ensures:[the board is empty] AND
 *                        [the board is of size row * col]
 *
 * Defines: row: Z
 *          col: Z
 *          win: Z
 *
 * Constraints: row <= MAX_R
 *              col <= MAX_C
 *              win <= WIN
 */
public interface IGameBoard {
    /**
     * Gets the number of rows in the board
     *
     * @post getNumRows = ROWS and [returns number of rows]
     *
     * @return returns ROWS
     */
    public int getNumRows();

    /**
     * Gets the number of columns in the board
     *
     * @post getNumColumns = COLUMNS and [returns number of columns]
     *
     * @return returns COLUMNS
     */
    public int getNumColumns();

    /**
     * Gets the number of markers in a row needed to win
     *
     * @post getNumToWin = WIN_COND and [returns number needed to win]
     *
     * @return returns WIN_COND
     */
    public int getNumToWin();

    /**
     * Places a marker at the designated position,
     *         assuming that position is valid
     *
     * @param marker = marks where to place symbol
     * @param player = determines which symbol to place at marker
     *
     * @pre [marker and player must be of valid types] and
     *      [board must exist] and checkSpace() = true
     *
     * @post marker = #marker and player = #player and row = getRow()
     *       and col = getColumn() and [position has new marker]
     *       and [rest of board unchanged]
     */
    public void placeMarker(BoardPosition marker, char player);

    /**
     * Determines what is on the board at a specified position
     *
     * @param pos = position that is checked to see what is there
     *
     * @pre [board must exist] and [pos must be a valid type and
     *       in valid range]
     *
     * @post [determines what is at pos] and pos = #pos and [returns
     *        either an empty space, or a marker depending on what is there]
     *
     * @return char or blank space that is at pos
     */
    public char whatsAtPos(BoardPosition pos);

    /**
     * Determines if there is a player at a designated position
     *          on the board or not
     *
     * @param pos = position that is checked to see if a player is there
     * @param player = used to determine which player is at pos if there is one
     *
     * @pre [board must exist] and [pos must be valid type]
     *       and [player must be valid type]
     *
     * @post [returns boolean value indicating if there is a player at pos or not]
     *        and pos = #pos and player = #player
     *
     * @return [true if player at pos, false otherwise]
     */
    default boolean isPlayerAtPos(BoardPosition pos, char player)
    {
        BoardPosition temp = new BoardPosition(pos.getRow(), pos.getColumn());
        if(whatsAtPos(temp) == player)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Takes in a position from the board and checks if
     * that space is available or not
     *
     * @param pos = position checked on board for availability
     *
     * @pre [pos must have been initialized to correct type] and
     *       MIN <= pos <= (MAX_C && MAX_R)
     *
     * @post pos = #pos and [boolean value returned indicating
     *       if spot is available or not]
     *
     * @return [true if pos is valid, false if not]
     */
    default boolean checkSpace(BoardPosition pos)
    {
        BoardPosition space = null; //Will hold a new position

        for (int i = 0; i < this.getNumRows(); i++)
        {
            space = new BoardPosition(i, pos.getColumn()); //Space to be checked
            if(whatsAtPos(space) == ' ') //Check if free or not
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Will check to see if the lastPos placed resulted
     *     in a winner.
     *
     * @param lastPos = last position to check for a win
     *
     * @pre  [board must exist] and [lastPos must be valid type]
     *       and [there must have been a last position] and
     *       MIN <= pos <= (MAX_C && MAX_R)
     *
     * @post  lastPos = #lastPos and [returns true if marker
     *        last needed in a row to win]
     *
     * @return  [true if (checkHorizontalWin || checkVerticalWin
     *          || checkDiagonalWin are true)]
     */
    default boolean checkForWinner(BoardPosition lastPos)
    {
        for (int i = 0; i < getNumRows(); i++)
        {
            BoardPosition check = new BoardPosition(i, lastPos.getColumn());
            if(whatsAtPos(check) != ' ')
            {
                //Checks every win method to see if one has occurred or not
                if(checkHorizontalWin(check, whatsAtPos(check))
                        || checkVerticalWin(check, whatsAtPos(check)) ||
                        checkDiagonalWin(check, whatsAtPos(check)))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Will check to see if the game has ended in a tie
     *
     * @pre [board must exist] and [no win has occurred yet]
     *
     * @post [indicator returned based on draw or not]
     *        and myBoard = #myBoard
     *
     * @return true if board has no empty spaces
     */
    default boolean checkForDraw()
    {
        int r = getNumRows();
        int c = getNumColumns();

        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                //Space to be checked
                BoardPosition temp = new BoardPosition(i, j);
                if(whatsAtPos(temp) == ' ') //If empty space, cannot have a draw
                {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if the last marker played resulted in a horizontal win
     *
     * @param lastPos = last position played
     * @param player = determines which symbol to use/look for
     *
     * @pre  [lastPos must be valid type] and
     *       [there must have been a last position]
     *       and [player must be valid] and
     *       MIN <= pos.getRow() <= getNumRows() and
     *       MIN <= pos.getColumn() getNumColumns()
     *
     * @post [boolean value returned] and lastPos = #lastPos
     *        and player = #player
     *
     * @return true if getNumToWin() in a row horizontally
     */
    default boolean checkHorizontalWin(BoardPosition lastPos, char player)
    {
        int r = lastPos.getRow();
        int inARow = 0;
        int col = 0;

        while(col < getNumColumns() && inARow != getNumToWin())
        {
            BoardPosition temp = new BoardPosition(r, col);
            if(whatsAtPos(temp) == player)
            {
                inARow++;
                if(inARow == getNumToWin())
                {
                    return true;
                }
            }
            else
                inARow = 0;
            col++;
        }
        return false;
    }

    /**
     * Checks if the last marker played resulted in a vertical win
     *
     * @param lastPos = last position played
     * @param player = determines which symbol to use/look for
     *
     * @pre  [lastPos must be valid type] and
     *       [there must have been a last position]
     *       and [player must be valid] and
     *       MIN <= pos.getRow() <= getNumRows() and
     *       MIN <= pos.getColumn() getNumColumns()
     *
     * @post [boolean value returned] and lastPos = #lastPos
     *        and player = #player
     *
     * @return true if getNumToWin() in a row vertically
     */
    default boolean checkVerticalWin(BoardPosition lastPos, char player)
    {
        int c = lastPos.getColumn();
        int inARow = 0;
        int row = 0;

        while(row < getNumRows() && inARow != getNumToWin())
        {
            BoardPosition temp = new BoardPosition(row, c);
            if(whatsAtPos(temp) == player)
            {
                inARow++;
                if(inARow == getNumToWin())
                {
                    return true;
                }
            }
            else
                inARow = 0;
            row++;
        }
        return false;
    }

    /**
     * Checks if the last marker played resulted in a diagonal win
     *
     * @param lastPos = last position played
     * @param player = determines which symbol to use/look for
     *
     * @pre  [lastPos must be valid type] and
     *       [there must have been a last position]
     *       and [player must be valid] and
     *       MIN <= pos.getRow() <= getNumRows() and
     *       MIN <= pos.getColumn() getNumColumns()
     *
     * @post [boolean value returned] and lastPos = #lastPos
     *        and player = #player
     *
     * @return true if getNumToWin() in a row diagonally
     */
    default boolean checkDiagonalWin(BoardPosition lastPos, char player)
    {
        int inARow = 1;
        int r = lastPos.getRow();
        int c = lastPos.getColumn();
        int cNum = getNumColumns();
        int rNum = getNumRows();

        for(int i = r - 1, j = c + 1; i >= 0 && j < cNum; i--, j++) //up, right
        {
            BoardPosition temp = new BoardPosition(i, j);
            if(whatsAtPos(temp) == player)
            {
                inARow++;
            }
            else
            {
                break; //Cannot have win in this direction
            }

            if(inARow >= getNumToWin())
            {
                return true;
            }
        }

        for(int i = r + 1, j = c - 1; i < rNum && j >= 0; i++, j--) //down, left
        {
            BoardPosition temp = new BoardPosition(i, j);
            if(whatsAtPos(temp) == player)
            {
                inARow++;
            }
            else
            {
                break; //Cannot have win in this direction
            }

            if(inARow >= getNumToWin())
            {
                return true;
            }
        }

        inARow = 1;
        for(int i = r + 1, j = c + 1; i < rNum && j < cNum; i++, j++) //down, right
        {
            BoardPosition temp = new BoardPosition(i, j);
            if(whatsAtPos(temp) == player)
            {
                inARow++;
            }
            else
            {
                break; //Cannot have win in this direction
            }

            if(inARow >= getNumToWin())
            {
                return true;
            }
        }

        for(int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) //up, left
        {
            BoardPosition temp = new BoardPosition(i, j);
            if(whatsAtPos(temp) == player)
            {
                inARow++;
            }
            else
            {
                break; //Cannot have win in this direction
            }

            if(inARow >= getNumToWin())
            {
                return true;
            }
        }
        return false;
    }
}