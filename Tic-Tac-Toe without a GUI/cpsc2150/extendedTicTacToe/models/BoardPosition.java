package cpsc2150.extendedTicTacToe.models;

/**
 * Jacob Martin
 * CPSC 2150-002
 * Project 1 - Part 2
 */

/**
 * @invariant MAX_ROW = 5 AND 0 <= row <= MAX_ROW
 * @invariant MAX_COL = 8 AND 0 <= col <= MAX_COL
 */
public class BoardPosition
{

    private final int ROW;
    private final int COL;

    /**
     * Constructor for the class
     *
     * @param r is row selected by user
     * @param c is column selected by user
     *
     * @post ROW = r and COL = c
     */
    public BoardPosition(int r, int c)
    {
        ROW = r;
        COL = c;
    }

    /**
     * Getter method to retrieve the row
     *
     * @pre [row must not be NULL]
     *
     * @post getRow = row AND 0 <= row <= MAX_ROW
     *       and row = #row and [row returned]
     *
     * @return row selected by user
     */
    public int getRow()
    {
        return ROW;
    }

    /**
     * Getter method to retrieve the column
     *
     * @pre [column must not be NULL]
     *
     * @post getColumn = col AND 0 <= col <= MAX_COL
     *       and col = #col and [col returned]
     *
     * @return column selected by user
     */
    public int getColumn()
    {
        return COL;
    }

    /**
     * Method used to return a string representation of an object
     *
     * @post [class instance formatted to a string] and
     *       [string form of object returned]
     *
     * @return string representation of the object
     */
    @Override
    public String toString()
    {
        String coord = getRow() + "," + getColumn();

        return coord;
    }

    /**
     * Indicates whether two BoardPositions are equal
     * by having the same row and column
     *
     * @param myObj – the reference object with which to compare
     *
     * @pre [myObj must have been initialized]
     *
     * @post myObj = #myObj and [returns true if myObj == this]
     *
     * @return returns true if and only if this and myObj refer to the same object
     */
    @Override
    public boolean equals(Object myObj)
    {
        if(myObj == this)
        {
            return true;
        }

        if(myObj instanceof BoardPosition)
        {
            BoardPosition temp = (BoardPosition)myObj;

            if(COL == temp.getColumn() && ROW == temp.getRow())
            {
                return true;
            }
        }
        return false;
    }
}