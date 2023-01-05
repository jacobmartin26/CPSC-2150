package cpsc2150.extendedTicTacToe.models;

public abstract class AbsGameBoard implements IGameBoard {
    /**
     * Method used to return a string representation of an object
     *
     * @post myBoard = #myBoard and
     *      [myBoard formatted to a string and returned]
     *
     * @return string representation of myBoard
     */
    @Override
    public String toString()
    {
        String myBoard = " "; //Empty board

        int x = 0;
        myBoard = myBoard + "   " + x;

        for(int i = 1; i < getNumColumns(); i++) //Top row of numbers (0|1|2|...)
        {
            if(i <= 9)
            {
                myBoard = myBoard + "| " + i;
            }
            else
            {
                myBoard = myBoard + "|" + i;
            }
        }
        myBoard = myBoard + "|" + "\n";

        for(int i = 0; i < getNumRows(); i++) //Side column of numbers
        {
            for(int j = 0; j < getNumColumns(); j++)
            {
                BoardPosition temp = new BoardPosition(i, j);

                if(j == 0)
                {
                    myBoard = myBoard.concat(String.format("%2d", i));
                }

                myBoard = myBoard + "|" + whatsAtPos(temp) + " ";
            }
            myBoard = myBoard + "|" + "\n";
        }
        return myBoard;
    }
}
