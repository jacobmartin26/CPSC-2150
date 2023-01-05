package cpsc2150.extendedTicTacToe.controllers;

import cpsc2150.extendedTicTacToe.models.*;
import cpsc2150.extendedTicTacToe.views.*;

/**
 * <p>
 * The {@link TicTacToeController} class will handle communication between our {@link TicTacToeView}
 * and our model ({@link IGameBoard} and {@link BoardPosition})
 * </p>
 *
 * <p>
 * This is where you will write code
 * <p>
 *
 * You will need to include your {@link BoardPosition} class, the {@link IGameBoard} interface
 * and both of the {@link IGameBoard} implementations from Project 4.
 * If your code was correct you will not need to make any changes to your {@link IGameBoard} implementation class.
 *
 * @version 2.0
 */
public class TicTacToeController {

    /**
     * <p>
     * The current game that is being played
     * </p>
     */
    private IGameBoard curGame;

    /**
     * <p>
     * The screen that provides our view
     * </p>
     */
    private TicTacToeView screen;

    /**
     * <p>
     * Constant for the maximum number of players.
     * </p>
     */
    public static final int MAX_PLAYERS = 10;

    /**
     * <p>
     * The number of players for this game. Note that our player tokens are hard coded.
     * </p>
     */
    private int numPlayers;

    /**
     * <p>
     * The player tokens that are assigned one at a time to each player
     * </p>
     */
    private char[] playerTokens = {'X', 'O', 'Y', 'Z', 'M', 'S', 'H', 'F', 'V', 'P'};

    /**
     * <p>
     * Tracks if the game has ended or not
     * </p>
     */
    private boolean Over;

    /**
     * <p>
     * Used to track which player is going this turn
     * </p>
     */
    private int pCount;


    /**
     * <p>
     * This creates a controller for running the Extended TicTacToe game
     * </p>
     *
     * @param model
     *      The board implementation
     * @param view
     *      The screen that is shown
     * @param np
     *      The number of players for this game.
     *
     * @post [the controller will respond to actions on the view using the model.]
     */
    public TicTacToeController(IGameBoard model, TicTacToeView view, int np) {
        this.curGame = model;
        this.screen = view;
        this.numPlayers = np;

        // Some code is needed here.
        pCount = 0;
        Over = false;
    }

    /**
     * <p>
     * This processes a button click from the view.
     * </p>
     *
     * @param row
     *      The row of the activated button
     * @param col
     *      The column of the activated button
     *
     * @post [ will allow the player to place a marker in the position if it is a valid space, otherwise it will display an error
     * and allow them to pick again. Will check for a win as well. If a player wins it will allow for them to play another
     * game hitting any button ]
     */
    public void processButtonClick(int row, int col) {
        // Starts the new game
        if(Over)
        {
            Over = false;
            pCount = 0;
            newGame();
        }

        // user position used throughout the method
        BoardPosition pos = new BoardPosition(row, col);
        screen.setMessage("Player " + playerTokens[(pCount + 1) % numPlayers] + ", please go.");

        // user picks invalid spot
        if(curGame.whatsAtPos(pos) != ' ')
        {
            screen.setMessage("Position invalid, please try a different position.");
        }
        else
        {
            // valid pos, place and display marker on screen
            curGame.placeMarker(pos, playerTokens[pCount]);
            screen.setMarker(row, col, playerTokens[pCount]);

            // move resulted in a win
            if(curGame.checkForWinner(pos))
            {
                screen.setMessage("Player " + curGame.whatsAtPos(pos) + " wins! Click any button to play again.\n");
                pCount = 0;

                // game is over as a result
                Over = true;
            }
            else
            {
                // move resulted in a draw
                if(curGame.checkForDraw())
                {
                    screen.setMessage("Draw. Click any button to play again.");
                    pCount = 0;

                    // game over as a result
                    Over = true;
                }
            }
            // go to next player if game hasn't ended
            pCount = (pCount + 1) % numPlayers;
        }
    }

    /**
     * <p>
     * This method will start a new game by returning to the setup screen and controller
     * </p>
     *
     * @post [ a new game gets started ]
     */
    private void newGame() {
        //close the current screen
        screen.dispose();

        //start back at the set-up menu
        GameSetupScreen screen = new GameSetupScreen();
        GameSetupController controller = new GameSetupController(screen);
        screen.registerObserver(controller);
    }
}