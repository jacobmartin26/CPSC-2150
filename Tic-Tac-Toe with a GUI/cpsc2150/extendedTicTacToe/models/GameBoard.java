package cpsc2150.extendedTicTacToe.models;

/**
 * Jacob Martin
 * CPSC 2150-002
 * Project 1 - Part 3
 */

/**
 * @invariant MIN <= ROWS <= MAX_R
 * @invariant MIN <= COLUMNS <= MAX_C
 * @invariant WIN_COND = mToWin
 * @invariant [Board must be a grid]
 *
 * @correspondence self = myBoard[0..ROWS - 1][0..COLUMNS - 1]
 */
public class GameBoard extends AbsGameBoard implements IGameBoard {
    private Character myBoard[][];
    static private int ROWS;
    static private int COLUMNS;
    static private int WIN_COND;

    /**
     * Constructor used to initialize the board to array format
     *
     * @param row - # of rows on the board
     * @param col - # of columns on the board
     * @param mToWin - # in a row needed to win
     *
     * @post [Each element of the board is an empty space]
     */
    public GameBoard(int row, int col, int mToWin)
    {
        ROWS = row;
        COLUMNS = col;
        WIN_COND = mToWin;

        myBoard = new Character[ROWS][COLUMNS]; //Create board

        for(int i = 0; i < ROWS; i++)
        {
            for(int j = 0; j < COLUMNS; j++)
            {
                myBoard[i][j] = ' '; //Make all spots empty
            }
        }
    }
    public int getNumRows()
    {
        return ROWS;
    }
    public int getNumColumns()
    {
        return COLUMNS;
    }
    public int getNumToWin()
    {
        return WIN_COND;
    }
    public void placeMarker(BoardPosition marker, char player)
    {
        //Places player's marker on designated spot on board
        myBoard[marker.getRow()][marker.getColumn()] = player;
    }
    public char whatsAtPos(BoardPosition pos)
    {
        //Used to check if a spot is free or not
        return myBoard[pos.getRow()][pos.getColumn()];
    }
}