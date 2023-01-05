package cpsc2150.extendedTicTacToe.models;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @invariant MIN <= width <= MAX
 * @invariant MIN <= height <= MAX
 * @invariant MIN <= win <= WIN
 * @invariant [Board must be a grid]
 *
 * @correspondence self = boardMap<Character, List<BoardPosition>>
 */
public class GameBoardMem extends AbsGameBoard implements IGameBoard
{
    private int r;
    private int c;
    private int win;
    private Map<Character, List<BoardPosition>> boardMap;


    /**
     * Constructor used to initialize the board to map format
     *
     * @param row - # of rows on the board
     * @param col - # of columns on the board
     * @param mToWin - # in a row needed to win
     *
     * @post [Each element of the board is an empty space]
     */
    public GameBoardMem(int row, int col, int mToWin)
    {
        r = row;
        c = col;
        win = mToWin;
        boardMap = new HashMap<>();
    }

    public int getNumRows()
    {
        return r;
    }
    public int getNumColumns()
    {
        return c;
    }
    public int getNumToWin()
    {
        return win;
    }
    public void placeMarker(BoardPosition marker, char player)
    {
        if(boardMap.containsKey(player) == true)
        {
            boardMap.get(player).add(marker);
        }
        else
        {
            List<BoardPosition> tempList = new ArrayList<>();
            tempList.add(marker);
            boardMap.put(player, tempList);
        }
    }

    public char whatsAtPos(BoardPosition pos)
    {
        //Used to check if a spot is free or not
        for(Map.Entry<Character, List<BoardPosition>> col : boardMap.entrySet())
        {
            if(col.getValue().contains(pos))
            {
                return col.getKey();
            }
        }
        return ' ';
    }

    @Override
    public boolean isPlayerAtPos(BoardPosition pos, char player)
    {
        //Checks if map contains player at specified pos, true if so
        for(Map.Entry<Character, List<BoardPosition>> check : boardMap.entrySet())
        {
            if(check.getValue().contains(pos) && check.getKey().equals(player));
            {
                return true;
            }
        }
        return false;
    }
}
