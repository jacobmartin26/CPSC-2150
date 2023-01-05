package cpsc2150.extendedTicTacToe.models;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestGameBoard {

    static final int MAXRC = 100;
    static final int MAXWIN = 25;
    static final int MINRCWIN = 3;
    static final int ROUTINERC = 5;
    static final int MIDDLE = 2;
    char p1 = 'X';
    char p2 = 'O';


    private IGameBoard MakeBoard(int rows, int cols, int numToWin)
    {
        return new GameBoard(rows, cols, numToWin);
    }
    private String Compare(char[][] board){
        int row = board.length;
        int column = board.length;

        String myBoard = "   ";
        for(int i = 0; i < column; i++){
            if( i < 10) {
                myBoard += "" + ' ' + i + "|";
            }
            else myBoard += i + "|";
        }
        myBoard += "\n";

        for(int i = 0; i < row; i++){
            if(i < 10) {
                myBoard += " " + i + "|";
            }
            else {
                myBoard += i + "|";
            }

            //each column print character and line
            for(int j = 0; j < column; j++){
                myBoard += board[i][j] + " |";
            }
            myBoard += "\n";
        }
        return myBoard;
    }

    // Constructor
    @Test
    public void Constructor_Lower_Bound()
    {
        IGameBoard board = MakeBoard(MINRCWIN, MINRCWIN, MINRCWIN);

        char[][] boardArray = new char[MINRCWIN][MINRCWIN];
        for (int i = 0; i < MINRCWIN; i++)
        {
            for (int j = 0; j < MINRCWIN; j++)
            {
                boardArray[i][j] = ' ';
            }
        }

        String expected = Compare(boardArray);
        String observed = board.toString();

        assertEquals(observed, expected);
    }

    @Test
    public void Constructor_Upper_Bound()
    {
        IGameBoard board = MakeBoard(MAXRC, MAXRC, MAXWIN);

        char[][] boardArray = new char[MAXRC][MAXRC];
        for (int i = 0; i < MAXRC; i++)
        {
            for (int j = 0; j < MAXRC; j++)
            {
                boardArray[i][j] = ' ';
            }
        }

        String expected = Compare(boardArray);
        String observed = board.toString();

        assertEquals(observed, expected);
    }

    @Test
    public void Constructor_Routine()
    {
        IGameBoard board = MakeBoard(ROUTINERC, ROUTINERC, MINRCWIN);

        char[][] boardArray = new char[ROUTINERC][ROUTINERC];
        for (int i = 0; i < ROUTINERC; i++)
        {
            for (int j = 0; j < ROUTINERC; j++)
            {
                boardArray[i][j] = ' ';
            }
        }

        String expected = Compare(boardArray);
        String observed = board.toString();

        assertEquals(observed, expected);
    }

    // checkSpace
    @Test
    public void checkSpace_Not_Current()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC,ROUTINERC,MINRCWIN);

        char[][] boardArray = new char[ROUTINERC][ROUTINERC];
        for(int i = 0; i < ROUTINERC; i++) {
            for(int j = 0; j < ROUTINERC; j++) {
                boardArray[i][j] = ' ';
            }
        }

        for(int i = 0; i < ROUTINERC; i++) {
            BoardPosition pos = new BoardPosition(i, 0);
            myBoard.placeMarker(pos,p1);
            boardArray[i][0] = p1;
        }

        for(int i = 0; i < ROUTINERC; i++) {
            BoardPosition pos = new BoardPosition(i, 1);
            myBoard.placeMarker(pos,p2);
            boardArray[i][1] = p2;
        }

        BoardPosition pos = new BoardPosition(1, 1);

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        assertEquals(observed,expected);
        assertFalse(myBoard.checkSpace(pos));
    }

    @Test
    public void checkSpace_Empty()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC,ROUTINERC,MINRCWIN);

        char[][] boardArray = new char[ROUTINERC][ROUTINERC];
        for(int i = 0; i < ROUTINERC; i++) {
            for(int j = 0; j < ROUTINERC; j++) {
                boardArray[i][j] = ' ';
            }
        }

        BoardPosition pos = new BoardPosition(0, 0);

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        assertEquals(observed,expected);
        assertTrue(myBoard.checkSpace(pos));
    }

    @Test
    public void checkSpace_Current() {
        IGameBoard myBoard = MakeBoard(ROUTINERC,ROUTINERC,MINRCWIN);

        char[][] boardArray = new char[ROUTINERC][ROUTINERC];
        for(int i = 0; i < ROUTINERC; i++) {
            for(int j = 0; j < ROUTINERC; j++) {
                boardArray[i][j] = ' ';
            }
        }

        for(int i = 0; i < ROUTINERC; i++) {
            BoardPosition pos = new BoardPosition(i, 0);
            myBoard.placeMarker(pos,p1);
            boardArray[i][0] = p1;
        }

        BoardPosition pos = new BoardPosition(0, 0);

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        assertEquals(observed,expected);
        assertFalse(myBoard.checkSpace(pos));
    }

    @Test
    public void Horizontal_Left()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC + 1, ROUTINERC + 1, MINRCWIN + 1);

        char[][] boardArray = new char[ROUTINERC + 1][ROUTINERC + 1];
        for(int i = 0; i < ROUTINERC + 1; i++) {
            for(int j = 0; j < ROUTINERC + 1; j++) {
                boardArray[i][j] = ' ';
            }
        }

        BoardPosition pos = new BoardPosition (0,0);
        for (int i = 0; i < ROUTINERC; i++) {
            pos = new BoardPosition(0, i);
            myBoard.placeMarker(pos, p1);
            boardArray[0][i] = p1;
        }

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        assertEquals(expected,observed);
        assertTrue(myBoard.checkHorizontalWin(pos, 'X'));
    }

    @Test
    public void Horizontal_Right()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC + 1, ROUTINERC + 1, MINRCWIN + 1);

        char[][] boardArray = new char[ROUTINERC + 1][ROUTINERC + 1];
        for(int i = 0; i < ROUTINERC + 1; i++) {
            for(int j = 0; j < ROUTINERC + 1; j++) {
                boardArray[i][j] = ' ';
            }
        }

        BoardPosition pos = new BoardPosition (0,0);
        for (int i = 1; i < ROUTINERC + 1; i++) {
            pos = new BoardPosition(0, i);
            myBoard.placeMarker(pos, p1);
            boardArray[0][i] = p1;
        }
        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        pos = new BoardPosition(0, ROUTINERC);

        assertEquals(expected,observed);
        assertTrue(myBoard.checkHorizontalWin(pos, 'X'));
    }

    @Test
    public void Horizontal_Center()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC,ROUTINERC,MINRCWIN);

        char[][] boardArray = new char[ROUTINERC][ROUTINERC];
        for(int i = 0; i < ROUTINERC; i++) {
            for(int j = 0; j < ROUTINERC; j++) {
                boardArray[i][j] = ' ';
            }
        }

        boardArray[0][0] = p1;
        boardArray[0][1] = p1;
        boardArray[0][3] = p1;
        boardArray[0][4] = p1;
        boardArray[0][2] = p1;

        BoardPosition pos1 = new BoardPosition(0, 0);
        BoardPosition pos2 = new BoardPosition(0, 1);
        BoardPosition pos3 = new BoardPosition(0, 3);
        BoardPosition pos4 = new BoardPosition(0, 4);
        BoardPosition pos5 = new BoardPosition(0, 2);

        //Placing markers
        myBoard.placeMarker(pos1, p1);
        myBoard.placeMarker(pos2, p1);
        myBoard.placeMarker(pos3, p1);
        myBoard.placeMarker(pos4, p1);
        myBoard.placeMarker(pos5, p1);

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        assertEquals(expected,observed);
        assertTrue(myBoard.checkHorizontalWin(pos5, 'X'));
    }

    @Test
    public void Horizontal_Edge()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC + 1, ROUTINERC + 1, MINRCWIN + 1);

        char[][] boardArray = new char[ROUTINERC + 1][ROUTINERC + 1];
        for(int i = 0; i < ROUTINERC + 1; i++) {
            for(int j = 0; j < ROUTINERC + 1; j++) {
                boardArray[i][j] = ' ';
            }
        }

        BoardPosition pos = new BoardPosition (0,0);
        for (int i = 1; i < ROUTINERC + 1; i++) {
            pos = new BoardPosition(ROUTINERC, i);
            myBoard.placeMarker(pos, p1);
            boardArray[ROUTINERC][i] = p1;
        }
        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        pos = new BoardPosition(ROUTINERC, ROUTINERC);

        assertEquals(expected,observed);
        assertTrue(myBoard.checkHorizontalWin(pos, 'X'));
    }

    @Test
    public void Vertical_Top()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC + 1, ROUTINERC + 1, MINRCWIN + 1);

        char[][] boardArray = new char[ROUTINERC + 1][ROUTINERC + 1];
        for(int i = 0; i < ROUTINERC + 1; i++) {
            for(int j = 0; j < ROUTINERC + 1; j++) {
                boardArray[i][j] = ' ';
            }
        }

        BoardPosition pos = new BoardPosition (0,0);
        for (int i = 0; i < ROUTINERC; i++) {
            pos = new BoardPosition(i, ROUTINERC);
            myBoard.placeMarker(pos, p1);
            boardArray[i][ROUTINERC] = p1;
        }

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        pos = new BoardPosition(0, ROUTINERC);

        assertEquals(expected,observed);
        assertTrue(myBoard.checkVerticalWin(pos, 'X'));
    }

    @Test
    public void Vertical_Bottom()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC + 1, ROUTINERC + 1, MINRCWIN + 1);

        char[][] boardArray = new char[ROUTINERC + 1][ROUTINERC + 1];
        for(int i = 0; i < ROUTINERC + 1; i++) {
            for(int j = 0; j < ROUTINERC + 1; j++) {
                boardArray[i][j] = ' ';
            }
        }

        BoardPosition pos = new BoardPosition (0,0);
        for (int i = 1; i <= ROUTINERC; i++) {
            pos = new BoardPosition(i, ROUTINERC);
            myBoard.placeMarker(pos, p1);
            boardArray[i][ROUTINERC] = p1;
        }

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        pos = new BoardPosition(ROUTINERC, ROUTINERC);

        assertEquals(expected,observed);
        assertTrue(myBoard.checkVerticalWin(pos, 'X'));
    }

    @Test
    public void Vertical_Center()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC + 1,ROUTINERC + 1,MINRCWIN + 1);

        char[][] boardArray = new char[ROUTINERC + 1][ROUTINERC + 1];
        for(int i = 0; i < ROUTINERC + 1; i++) {
            for(int j = 0; j < ROUTINERC + 1; j++) {
                boardArray[i][j] = ' ';
            }
        }

        boardArray[0][ROUTINERC] = p1;
        boardArray[1][ROUTINERC] = p1;
        boardArray[3][ROUTINERC] = p1;
        boardArray[4][ROUTINERC] = p1;
        boardArray[2][ROUTINERC] = p1;

        BoardPosition pos1 = new BoardPosition(0, ROUTINERC);
        BoardPosition pos2 = new BoardPosition(1, ROUTINERC);
        BoardPosition pos3 = new BoardPosition(3, ROUTINERC);
        BoardPosition pos4 = new BoardPosition(4, ROUTINERC);
        BoardPosition pos5 = new BoardPosition(2, ROUTINERC);

        //Placing markers
        myBoard.placeMarker(pos1, p1);
        myBoard.placeMarker(pos2, p1);
        myBoard.placeMarker(pos3, p1);
        myBoard.placeMarker(pos4, p1);
        myBoard.placeMarker(pos5, p1);

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        assertEquals(expected,observed);
        assertTrue(myBoard.checkVerticalWin(pos5, 'X'));
    }

    @Test
    public void Vertical_Edge()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC + 1, ROUTINERC + 1, MINRCWIN + 1);

        char[][] boardArray = new char[ROUTINERC + 1][ROUTINERC + 1];
        for(int i = 0; i < ROUTINERC + 1; i++) {
            for(int j = 0; j < ROUTINERC + 1; j++) {
                boardArray[i][j] = ' ';
            }
        }

        BoardPosition pos = new BoardPosition (0,0);
        for (int i = 0; i < ROUTINERC; i++) {
            pos = new BoardPosition(i, 0);
            myBoard.placeMarker(pos, p1);
            boardArray[i][0] = p1;
        }

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        pos = new BoardPosition(0, 0);

        assertEquals(expected,observed);
        assertTrue(myBoard.checkVerticalWin(pos, 'X'));
    }

    @Test
    public void Diagonal_SE()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC + 1, ROUTINERC + 1, MINRCWIN + 1);

        char[][] boardArray = new char[ROUTINERC + 1][ROUTINERC + 1];
        for(int i = 0; i < ROUTINERC + 1; i++) {
            for(int j = 0; j < ROUTINERC + 1; j++) {
                boardArray[i][j] = ' ';
            }
        }

        BoardPosition pos = new BoardPosition (0,0);
        for (int i = 0; i < ROUTINERC; i++) {
            pos = new BoardPosition(i, i);
            myBoard.placeMarker(pos, p1);
            boardArray[i][i] = p1;
        }

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        pos = new BoardPosition(0, 0);

        assertEquals(expected,observed);
        assertTrue(myBoard.checkDiagonalWin(pos, 'X'));
    }

    @Test
    public void Diagonal_NW()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC + 1, ROUTINERC + 1, MINRCWIN + 1);

        char[][] boardArray = new char[ROUTINERC + 1][ROUTINERC + 1];
        for(int i = 0; i < ROUTINERC + 1; i++) {
            for(int j = 0; j < ROUTINERC + 1; j++) {
                boardArray[i][j] = ' ';
            }
        }

        BoardPosition pos = new BoardPosition (0,0);
        for (int i = 0; i < ROUTINERC; i++) {
            pos = new BoardPosition(i, i);
            myBoard.placeMarker(pos, p1);
            boardArray[i][i] = p1;
        }

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        pos = new BoardPosition(ROUTINERC, ROUTINERC);

        assertEquals(expected,observed);
        assertTrue(myBoard.checkDiagonalWin(pos, 'X'));
    }

    @Test
    public void Diagonal_SE_NW()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC + 1, ROUTINERC + 1, MINRCWIN + 1);

        char[][] boardArray = new char[ROUTINERC + 1][ROUTINERC + 1];
        for(int i = 0; i < ROUTINERC + 1; i++) {
            for(int j = 0; j < ROUTINERC + 1; j++) {
                boardArray[i][j] = ' ';
            }
        }

        BoardPosition pos = new BoardPosition (0,0);
        for (int i = 0; i < ROUTINERC; i++) {
            pos = new BoardPosition(i, i);
            myBoard.placeMarker(pos, p1);
            boardArray[i][i] = p1;
        }

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        pos = new BoardPosition(MIDDLE, MIDDLE);

        assertEquals(expected,observed);
        assertTrue(myBoard.checkDiagonalWin(pos, 'X'));
    }

    @Test
    public void Diagonal_NE()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC + 1, ROUTINERC + 1, MINRCWIN + 1);

        char[][] boardArray = new char[ROUTINERC + 1][ROUTINERC + 1];
        for(int i = 0; i < ROUTINERC + 1; i++) {
            for(int j = 0; j < ROUTINERC + 1; j++) {
                boardArray[i][j] = ' ';
            }
        }

        int j = 0;
        BoardPosition pos = new BoardPosition (0,0);
        for (int i = ROUTINERC; i > 0; i--) {
            pos = new BoardPosition(i, j);
            myBoard.placeMarker(pos, p1);
            boardArray[i][j] = p1;
            j++;
        }

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        pos = new BoardPosition(ROUTINERC, 0);

        assertEquals(expected,observed);
        assertTrue(myBoard.checkDiagonalWin(pos, 'X'));
    }

    @Test
    public void Diagonal_SW()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC + 1, ROUTINERC + 1, MINRCWIN + 1);

        char[][] boardArray = new char[ROUTINERC + 1][ROUTINERC + 1];
        for(int i = 0; i < ROUTINERC + 1; i++) {
            for(int j = 0; j < ROUTINERC + 1; j++) {
                boardArray[i][j] = ' ';
            }
        }

        int j = 0;
        BoardPosition pos = new BoardPosition (0,0);
        for (int i = ROUTINERC; i >= 0; i--) {
            pos = new BoardPosition(i, j);
            myBoard.placeMarker(pos, p1);
            boardArray[i][j] = p1;
            j++;
        }

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        pos = new BoardPosition(0, ROUTINERC);

        assertEquals(expected,observed);
        assertTrue(myBoard.checkDiagonalWin(pos, 'X'));
    }

    @Test
    public void Diagonal_NE_SW()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC + 1, ROUTINERC + 1, MINRCWIN + 1);

        char[][] boardArray = new char[ROUTINERC + 1][ROUTINERC + 1];
        for(int i = 0; i < ROUTINERC + 1; i++) {
            for(int j = 0; j < ROUTINERC + 1; j++) {
                boardArray[i][j] = ' ';
            }
        }

        int j = 0;
        BoardPosition pos = new BoardPosition (0,0);
        for (int i = ROUTINERC; i >= 0; i--) {
            pos = new BoardPosition(i, j);
            myBoard.placeMarker(pos, p1);
            boardArray[i][j] = p1;
            j++;
        }

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        pos = new BoardPosition(3, 2);

        assertEquals(expected,observed);
        assertTrue(myBoard.checkDiagonalWin(pos, 'X'));
    }

    @Test
    public void Diagonal_NESW_SENW()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC, ROUTINERC, MINRCWIN);

        char[][] boardArray = new char[ROUTINERC][ROUTINERC];
        for(int i = 0; i < ROUTINERC; i++) {
            for(int j = 0; j < ROUTINERC; j++) {
                boardArray[i][j] = ' ';
            }
        }

        int j = 0;
        BoardPosition pos = new BoardPosition (0,0);
        for (int i = ROUTINERC - 1; i >= 0; i--) {
            pos = new BoardPosition(i, j);
            myBoard.placeMarker(pos, p1);
            boardArray[i][j] = p1;
            j++;
        }

        for (int i = 0; i < ROUTINERC - 1; i++) {
            pos = new BoardPosition(i, i);
            myBoard.placeMarker(pos, p1);
            boardArray[i][i] = p1;
        }

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        pos = new BoardPosition(MIDDLE, MIDDLE);

        assertEquals(expected,observed);
        assertTrue(myBoard.checkDiagonalWin(pos, 'X'));
    }

    @Test
    public void Draw_Full() {
        IGameBoard myBoard = MakeBoard(ROUTINERC,ROUTINERC,MINRCWIN);

        char[][] boardArray = new char[ROUTINERC][ROUTINERC];
        for(int i = 0; i < ROUTINERC; i++) {
            for(int j = 0; j < ROUTINERC; j++) {
                boardArray[i][j] = ' ';
            }
        }

        for(int i = 0; i < ROUTINERC; i++) {
            for(int j = 0; j < ROUTINERC; j++) {
                BoardPosition pos = new BoardPosition(i, j);
                myBoard.placeMarker(pos, p1);
                boardArray[i][j] = p1;
            }
        }

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        assertEquals(observed,expected);
        assertTrue(myBoard.checkForDraw());
    }

    @Test
    public void Draw_Empty() {
        IGameBoard myBoard = MakeBoard(ROUTINERC,ROUTINERC,MINRCWIN);

        char[][] boardArray = new char[ROUTINERC][ROUTINERC];
        for(int i = 0; i < ROUTINERC; i++) {
            for(int j = 0; j < ROUTINERC; j++) {
                boardArray[i][j] = ' ';
            }
        }

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        assertEquals(observed,expected);
        assertFalse(myBoard.checkForDraw());
    }

    @Test
    public void Draw_Last_Cell_Empty() {
        IGameBoard myBoard = MakeBoard(ROUTINERC,ROUTINERC,MINRCWIN);

        char[][] boardArray = new char[ROUTINERC][ROUTINERC];
        for(int i = 0; i < ROUTINERC; i++) {
            for(int j = 0; j < ROUTINERC; j++) {
                boardArray[i][j] = ' ';
            }
        }

        for(int i = 0; i < ROUTINERC; i++) {
            for(int j = 0; j < ROUTINERC; j++) {
                BoardPosition pos = new BoardPosition(i, j);
                myBoard.placeMarker(pos, p1);
                boardArray[i][j] = p1;
                if(i == ROUTINERC - 1 && j == ROUTINERC - 1)
                {
                    break;
                }
            }
        }

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        assertEquals(observed,expected);
        assertTrue(myBoard.checkForDraw());
    }

    @Test
    public void Draw_Only_Last_Cell() {
        IGameBoard myBoard = MakeBoard(ROUTINERC,ROUTINERC,MINRCWIN);

        char[][] boardArray = new char[ROUTINERC][ROUTINERC];
        for(int i = 0; i < ROUTINERC; i++) {
            for(int j = 0; j < ROUTINERC; j++) {
                boardArray[i][j] = ' ';
                if(i == ROUTINERC - 1 && j == ROUTINERC - 1)
                {
                    BoardPosition pos = new BoardPosition(i, j);
                    myBoard.placeMarker(pos, p1);
                    boardArray[i][j] = p1;
                }
            }
        }

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        assertEquals(observed,expected);
        assertFalse(myBoard.checkForDraw());
    }

    @Test
    public void whatsAtPos_Empty_Board()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC,ROUTINERC,MINRCWIN);

        char[][] boardArray = new char[ROUTINERC][ROUTINERC];
        for(int i = 0; i < ROUTINERC; i++) {
            for(int j = 0; j < ROUTINERC; j++) {
                boardArray[i][j] = ' ';
            }
        }

        BoardPosition pos = new BoardPosition(0, 0);

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        assertEquals(observed,expected);
        assertEquals(myBoard.whatsAtPos(pos), ' ');
    }

    @Test
    public void whatsAtPos_Full_Board()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC,ROUTINERC,MINRCWIN);

        char[][] boardArray = new char[ROUTINERC][ROUTINERC];
        for(int i = 0; i < ROUTINERC; i++) {
            for(int j = 0; j < ROUTINERC; j++) {
                boardArray[i][j] = ' ';
            }
        }

        for(int i = 0; i < ROUTINERC; i++) {
            for(int j = 0; j < ROUTINERC; j++) {
                BoardPosition pos = new BoardPosition(i, j);
                myBoard.placeMarker(pos, p1);
                boardArray[i][j] = p1;
            }
        }

        BoardPosition pos = new BoardPosition(ROUTINERC - 1, ROUTINERC - 1);

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        assertEquals(observed,expected);
        assertEquals(myBoard.whatsAtPos(pos), p1);
    }

    @Test
    public void whatsAtPos_Single_Char()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC,ROUTINERC,MINRCWIN);

        char[][] boardArray = new char[ROUTINERC][ROUTINERC];
        for(int i = 0; i < ROUTINERC; i++) {
            for(int j = 0; j < ROUTINERC; j++) {
                if(i == 0 && j == 0)
                {
                    BoardPosition pos = new BoardPosition(i, j);
                    myBoard.placeMarker(pos, p1);
                    boardArray[i][j] = p1;
                }
                else
                    boardArray[i][j] = ' ';
            }
        }

        BoardPosition pos = new BoardPosition(0, 0);

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        assertEquals(observed,expected);
        assertEquals(myBoard.whatsAtPos(pos), p1);
    }

    @Test
    public void whatsAtPos_Char_Surrounded()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC,ROUTINERC,MINRCWIN);

        char[][] boardArray = new char[ROUTINERC][ROUTINERC];
        for(int i = 0; i < ROUTINERC; i++) {
            for(int j = 0; j < ROUTINERC; j++) {
                boardArray[i][j] = ' ';
            }
        }

        BoardPosition pos1 = new BoardPosition(0, 1);
        BoardPosition pos2 = new BoardPosition(1, 0);
        BoardPosition pos3 = new BoardPosition(1, 2);
        BoardPosition pos4 = new BoardPosition(2, 1);
        BoardPosition pos5 = new BoardPosition(1, 1);

        //Placing markers
        boardArray[0][1] = p2;
        boardArray[1][0] = p2;
        boardArray[1][2] = p2;
        boardArray[2][1] = p2;
        boardArray[1][1] = p1;

        myBoard.placeMarker(pos1, p2);
        myBoard.placeMarker(pos2, p2);
        myBoard.placeMarker(pos3, p2);
        myBoard.placeMarker(pos4, p2);
        myBoard.placeMarker(pos5, p1);

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        assertEquals(observed,expected);
        assertEquals(myBoard.whatsAtPos(pos5), p1);
    }

    @Test
    public void whatsAtPos_Space_Surrounded()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC,ROUTINERC,MINRCWIN);

        char[][] boardArray = new char[ROUTINERC][ROUTINERC];
        for(int i = 0; i < ROUTINERC; i++) {
            for(int j = 0; j < ROUTINERC; j++) {
                boardArray[i][j] = ' ';
            }
        }

        BoardPosition pos1 = new BoardPosition(0, 1);
        BoardPosition pos2 = new BoardPosition(1, 0);
        BoardPosition pos3 = new BoardPosition(1, 2);
        BoardPosition pos4 = new BoardPosition(2, 1);
        BoardPosition pos5 = new BoardPosition(1, 1);

        //Placing markers
        boardArray[0][1] = p2;
        boardArray[1][0] = p2;
        boardArray[1][2] = p2;
        boardArray[2][1] = p2;
        boardArray[1][1] = ' ';

        myBoard.placeMarker(pos1, p2);
        myBoard.placeMarker(pos2, p2);
        myBoard.placeMarker(pos3, p2);
        myBoard.placeMarker(pos4, p2);
        myBoard.placeMarker(pos5, ' ');

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        assertEquals(observed,expected);
        assertEquals(myBoard.whatsAtPos(pos5), ' ');
    }

    @Test
    public void isPlayerAtPos_Empty_Board()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC,ROUTINERC,MINRCWIN);

        char[][] boardArray = new char[ROUTINERC][ROUTINERC];
        for(int i = 0; i < ROUTINERC; i++) {
            for(int j = 0; j < ROUTINERC; j++) {
                boardArray[i][j] = ' ';
            }
        }

        BoardPosition pos = new BoardPosition(0, 0);

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        assertEquals(observed,expected);
        assertFalse(myBoard.isPlayerAtPos(pos, p1));
    }

    @Test
    public void isPlayerAtPos_Single_Cell()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC,ROUTINERC,MINRCWIN);

        char[][] boardArray = new char[ROUTINERC][ROUTINERC];
        for(int i = 0; i < ROUTINERC; i++) {
            for(int j = 0; j < ROUTINERC; j++) {
                if(i == 0 && j == 0)
                {
                    BoardPosition pos = new BoardPosition(i, j);
                    myBoard.placeMarker(pos, p1);
                    boardArray[i][j] = p1;
                }
                else
                    boardArray[i][j] = ' ';
            }
        }

        BoardPosition pos = new BoardPosition(0, 0);

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        assertEquals(observed,expected);
        assertTrue(myBoard.isPlayerAtPos(pos, p1));
    }

    @Test
    public void isPlayerAtPos_Single_Wrong_Char()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC,ROUTINERC,MINRCWIN);

        char[][] boardArray = new char[ROUTINERC][ROUTINERC];
        for(int i = 0; i < ROUTINERC; i++) {
            for(int j = 0; j < ROUTINERC; j++) {
                if(i == 0 && j == 0)
                {
                    BoardPosition pos = new BoardPosition(i, j);
                    myBoard.placeMarker(pos, p1);
                    boardArray[i][j] = p1;
                }
                else
                    boardArray[i][j] = ' ';
            }
        }

        BoardPosition pos = new BoardPosition(0, 0);

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        assertEquals(observed,expected);
        assertFalse(myBoard.isPlayerAtPos(pos, p2));
    }

    @Test
    public void isPlayerAtPos_Empty_Surrounded()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC,ROUTINERC,MINRCWIN);

        char[][] boardArray = new char[ROUTINERC][ROUTINERC];
        for(int i = 0; i < ROUTINERC; i++) {
            for(int j = 0; j < ROUTINERC; j++) {
                boardArray[i][j] = ' ';
            }
        }

        BoardPosition pos1 = new BoardPosition(0, 1);
        BoardPosition pos2 = new BoardPosition(1, 0);
        BoardPosition pos3 = new BoardPosition(1, 2);
        BoardPosition pos4 = new BoardPosition(2, 1);
        BoardPosition pos5 = new BoardPosition(1, 1);

        //Placing markers
        boardArray[0][1] = p2;
        boardArray[1][0] = p2;
        boardArray[1][2] = p2;
        boardArray[2][1] = p2;
        boardArray[1][1] = ' ';

        myBoard.placeMarker(pos1, p2);
        myBoard.placeMarker(pos2, p2);
        myBoard.placeMarker(pos3, p2);
        myBoard.placeMarker(pos4, p2);
        myBoard.placeMarker(pos5, ' ');

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        assertEquals(observed,expected);
        assertTrue(myBoard.isPlayerAtPos(pos5, ' '));
    }

    @Test
    public void isPlayerAtPos_Char_At_Last_Cell()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC,ROUTINERC,MINRCWIN);

        char[][] boardArray = new char[ROUTINERC][ROUTINERC];
        for(int i = 0; i < ROUTINERC; i++) {
            for(int j = 0; j < ROUTINERC; j++) {
                boardArray[i][j] = ' ';
            }
        }

        for(int i = 0; i < ROUTINERC; i++) {
            for(int j = 0; j < ROUTINERC; j++) {
                BoardPosition pos = new BoardPosition(i, j);
                myBoard.placeMarker(pos, p1);
                boardArray[i][j] = p1;
            }
        }

        BoardPosition pos = new BoardPosition(ROUTINERC - 1, ROUTINERC - 1);

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        assertEquals(observed,expected);
        assertTrue(myBoard.isPlayerAtPos(pos, p1));
    }

    @Test
    public void placeMarker_First_Char()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC,ROUTINERC,MINRCWIN);

        char[][] boardArray = new char[ROUTINERC][ROUTINERC];
        for(int i = 0; i < ROUTINERC; i++) {
            for(int j = 0; j < ROUTINERC; j++) {
                if(i == 0 && j == 0)
                {
                    BoardPosition pos = new BoardPosition(i, j);
                    myBoard.placeMarker(pos, p1);
                    boardArray[i][j] = p1;
                }
                else
                    boardArray[i][j] = ' ';
            }
        }

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        assertEquals(observed,expected);
    }

    @Test
    public void placeMarker_New_Char()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC,ROUTINERC,MINRCWIN);

        char[][] boardArray = new char[ROUTINERC][ROUTINERC];
        for(int i = 0; i < ROUTINERC; i++) {
            for(int j = 0; j < ROUTINERC; j++) {
                if(i == 0 && j == 0)
                {
                    BoardPosition pos = new BoardPosition(i, j);
                    myBoard.placeMarker(pos, p1);
                    boardArray[i][j] = p1;
                }
                else if(i == 1 && j == 1)
                {
                    BoardPosition pos = new BoardPosition(i, j);
                    myBoard.placeMarker(pos, p2);
                    boardArray[i][j] = p2;
                }
                else
                    boardArray[i][j] = ' ';
            }
        }

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        assertEquals(observed,expected);
    }

    @Test
    public void placeMarker_Final_Cell()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC,ROUTINERC,MINRCWIN);

        char[][] boardArray = new char[ROUTINERC][ROUTINERC];
        for(int i = 0; i < ROUTINERC; i++) {
            for(int j = 0; j < ROUTINERC; j++) {
                if(i == ROUTINERC - 1 && j == ROUTINERC - 1)
                {
                    BoardPosition pos = new BoardPosition(i, j);
                    myBoard.placeMarker(pos, p1);
                    boardArray[i][j] = p1;
                }
                else
                    boardArray[i][j] = ' ';
            }
        }

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        assertEquals(observed,expected);
    }

    @Test
    public void placeMarker_Fill_Board()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC,ROUTINERC,MINRCWIN);

        char[][] boardArray = new char[ROUTINERC][ROUTINERC];
        for(int i = 0; i < ROUTINERC; i++) {
            for(int j = 0; j < ROUTINERC; j++) {
                boardArray[i][j] = ' ';
            }
        }

        for(int i = 0; i < ROUTINERC; i++) {
            for(int j = 0; j < ROUTINERC; j++) {
                BoardPosition pos = new BoardPosition(i, j);
                myBoard.placeMarker(pos, p1);
                boardArray[i][j] = p1;
            }
        }

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        assertEquals(observed,expected);
    }

    @Test
    public void placeMarker_Partial_Fill()
    {
        IGameBoard myBoard = MakeBoard(ROUTINERC,ROUTINERC,MINRCWIN);

        char[][] boardArray = new char[ROUTINERC][ROUTINERC];
        for(int i = 0; i < ROUTINERC; i++) {
            for(int j = 0; j < ROUTINERC; j++) {
                boardArray[i][j] = ' ';
            }
        }

        for(int i = 0; i < ROUTINERC - 1; i++) {
            for(int j = 0; j < ROUTINERC - 1; j++) {
                BoardPosition pos = new BoardPosition(i, j);
                myBoard.placeMarker(pos, p1);
                boardArray[i][j] = p1;
            }
        }

        String expected = Compare(boardArray);
        String observed = myBoard.toString();

        assertEquals(observed,expected);
    }
}