package cpsc2150.extendedTicTacToe;

import cpsc2150.extendedTicTacToe.models.BoardPosition;
import cpsc2150.extendedTicTacToe.models.GameBoard;
import cpsc2150.extendedTicTacToe.models.GameBoardMem;
import cpsc2150.extendedTicTacToe.models.IGameBoard;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameScreen {
    public static void main(String[] args) {
        Scanner choice = new Scanner((System.in)); //Takes in user choices
        int numChoiceR; //Row Choice
        int numChoiceC; //Column Choice
        int player; //Tracks which player's turn
        int numPlayers = 0; //Number of players
        int r = -1; //Hold row
        int c = -1; //Hold Column
        final int MINpick = 3; //Minimum pick for a row or column
        final int MAXpick = 100; //Maximum pick for row or column
        final int MINrange = 0;
        final int MINplayers = 2;
        final int MAXplayers = 10;
        final int MINwin = 3;
        final int Maxwin = 25;
        new BoardPosition(r, c);
        BoardPosition pos; //Position on board
        IGameBoard tempBoard; //Temporary board

        boolean reset; //Used to loop until they don't want to play again
        reset = true;

        while(reset == true) //Loop while play again
        {
            //Get # of players
            System.out.println("How many players for the game?");
            numPlayers = choice.nextInt();
            choice.nextLine();

            //Validation
            while(numPlayers < MINplayers || numPlayers > MAXplayers)
            {
                //Too few
                if(numPlayers < MINplayers)
                {
                    System.out.println("Game needs at least 2 players");
                }

                //Too many
                else if(numPlayers > MAXplayers)
                {
                    System.out.println("A game cannot have over 10 players");
                }

                //Ask again
                System.out.println("How many players for the game?");
                numPlayers = Integer.parseInt(choice.nextLine());
            }

            //Holds player characters
            List<Character> pChar = new ArrayList<>();

            for(int i = 1; i <= numPlayers; i++)
            {
                //Get characters
                System.out.println("Enter character for player " + i);
                String playerIChar = choice.nextLine();
                char playerMarker = playerIChar.charAt(0);
                playerMarker = Character.toUpperCase(playerMarker);

                //Validation
                while(pChar.contains(playerMarker))
                {
                    System.out.println("That character is already taken");
                    System.out.println("Enter character for player " + i);
                    playerIChar = choice.nextLine();
                    playerMarker = playerIChar.charAt(0);
                    playerMarker = Character.toUpperCase(playerMarker);
                }
                //Add character to list
                pChar.add(playerMarker);
            }

            //Get # of rows
            System.out.println("How many rows?");
            int rows = Integer.parseInt(choice.nextLine());

            //Validation
            while(rows < MINpick || rows > MAXpick)
            {
                //Too few
                if(rows < MINpick)
                {
                    System.out.println("Board requires " + MINpick + " rows at least");
                }

                //Too many
                else if(rows > MAXpick)
                {
                    System.out.println("Board only can have " + MAXpick + " rows at most");
                }

                //Ask again
                System.out.println("How many rows?");
                rows = Integer.parseInt(choice.nextLine());
            }

            //Get # of columns
            System.out.println("How many columns?");
            int cols =  Integer.parseInt(choice.nextLine());

            //Validation
            while(cols < MINpick || cols > MAXpick)
            {
                //Too few
                if(cols < MINpick)
                {
                    System.out.println("Board requires " + MINpick + " columns at least");
                }

                //Too many
                else if(cols > MAXpick)
                {
                    System.out.println("Board only can have " + MAXpick + " columns at most");
                }

                //Ask again
                System.out.println("How many columns?");
                cols = Integer.parseInt(choice.nextLine());
            }

            //Get # to win
            System.out.println("How many to win?");
            int win = Integer.parseInt(choice.nextLine());

            //Validation
            while(win < MINwin || win > Maxwin)
            {
                //Too few
                if(win < MINwin)
                {
                    System.out.println("Must have " + MINwin + " in a row at least to win");
                }

                //Too many
                else if(win > Maxwin)
                {
                    System.out.println("Can only have " + Maxwin + " at most in a row to win");
                }

                //Ask again
                System.out.println("How many to win?");
                win = Integer.parseInt(choice.nextLine());
            }

            //More win validation
            while(win > rows || win > cols)
            {
                //Bigger than # of rows
                if(win > rows)
                {
                    System.out.println("Cannot have number to win be greater than number of rows");
                }

                //Bigger than # of columns
                else if(win > cols)
                {
                    System.out.println("Cannot have number to win be greater than number of columns");
                }

                //Ask again
                System.out.println("How many to win?");
                win = Integer.parseInt(choice.nextLine());
            }

            //Fast or efficient prompt
            System.out.println("Would you like a Fast Game (F/f) or a Memory Efficient Game (M/m)?");
            String gameChoice = choice.nextLine();
            char charChoice = gameChoice.charAt(0);

            //Choice invalid character
            while(charChoice != 'M' && charChoice != 'm' && charChoice != 'F' && charChoice != 'f')
            {
                System.out.println("Invalid choice");

                //Ask again
                System.out.println("Would you like a Fast Game (F/f) or a Memory Efficient Game (M/m)?");
                gameChoice = choice.nextLine();
                charChoice = gameChoice.charAt(0);
            }

            //Create Board depending on choice
            if(charChoice == 'F' || charChoice == 'f')
            {
                //Fast
                tempBoard = new GameBoard(rows, cols, win);
            }
            else
            {
                //Efficient
                tempBoard = new GameBoardMem(rows, cols, win);
            }

            player = -1; //Starting val
            System.out.println(tempBoard); //Print initial board
            do {
                player++; //Player = 0 in first run

                //Able to find which player with remainder 0 = p1 and remainder 1 = p2
                System.out.println("Player " + pChar.get(player % numPlayers) +
                        ", Please enter your ROW");
                numChoiceR = Integer.parseInt(choice.nextLine()); //Get row choice

                //Input validation
                while(numChoiceR < MINrange || numChoiceR >= tempBoard.getNumRows())
                {
                    System.out.println("Row choice out of range, please try again");
                    numChoiceR = Integer.parseInt(choice.nextLine());
                }

                System.out.println("Player " + pChar.get(player % numPlayers) +
                        ", Please enter your COLUMN");
                numChoiceC = Integer.parseInt(choice.nextLine()); //Get column choice

                //Input validation
                while(numChoiceC < MINrange || numChoiceC >= tempBoard.getNumColumns())
                {
                    System.out.println("Column choice out of range, please try again");
                    numChoiceC = Integer.parseInt(choice.nextLine());
                }

                //Set the starting point at 0,0
                pos = new BoardPosition(numChoiceR, numChoiceC);

                //Makes sure the chosen spot is not already taken
                while(tempBoard.whatsAtPos(pos) != ' ')
                {
                    System.out.println("SPACE OCCUPIED, TRY AGAIN");
                    System.out.println("Player " + pChar.get(player % numPlayers) +
                            ", Please enter your ROW");
                    numChoiceR = Integer.parseInt(choice.nextLine());
                    while(numChoiceR < MINrange || numChoiceR >= tempBoard.getNumRows())
                    {
                        System.out.println("Row choice out of range, please try again");
                        numChoiceR = Integer.parseInt(choice.nextLine());
                    }

                    System.out.println("Player " + pChar.get(player % numPlayers) +
                            ", Please enter your COLUMN");
                    numChoiceC = Integer.parseInt(choice.nextLine());
                    while(numChoiceC < MINrange || numChoiceC >= tempBoard.getNumColumns())
                    {
                        System.out.println("Column choice out of range, please try again");
                        numChoiceC = Integer.parseInt(choice.nextLine());
                    }
                    //Sets new position, loops if spot still invalid/taken
                    pos = new BoardPosition(numChoiceR, numChoiceC);
                }
                if(!tempBoard.checkSpace(pos))
                {
                    System.out.println(tempBoard.toString());
                    System.out.println("Invalid position, please pick a new space");
                }
                else
                {
                    //Spot must be valid, so place marker
                    tempBoard.placeMarker(pos, pChar.get(player % numPlayers));
                    System.out.println(tempBoard); //Print new board
                }
            } while (!tempBoard.checkForWinner(pos) && !tempBoard.checkForDraw()); //Loops until a win or draw

            if (tempBoard.checkForWinner(pos))
            {
                System.out.println("Player " + pChar.get(player % numPlayers) + " wins");
            }
            else if (tempBoard.checkForDraw())
            {
                System.out.println("Draw");
            }

            System.out.println(("Play again? Enter 'Y' or 'y' for yes, 'N' or 'n' for no"));
            String playAgain = choice.nextLine(); //Holds letter to play again or not

            //Input validation
            while (!playAgain.equals("n") && !playAgain.equals("N") &&
                    !playAgain.equals("y") && !playAgain.equals("Y"))
            {
                System.out.println(("Play again? Enter 'Y' or 'y' for yes, 'N' or 'n' for no"));
                playAgain = choice.nextLine();
            }

            //Doesn't play again, exit
            if (playAgain.equals("N") || playAgain.equals("n"))
            {
                System.out.println("Exiting game");
                reset = false; //Ends overarching loop
            }

            //Play again, restart loop
            if(playAgain.equals("Y") || playAgain.equals("y"))
            {
                System.out.println("Restarting game");
            }
        }
    }
}