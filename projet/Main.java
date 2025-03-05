package projet;

import javax.swing.*;

import java.awt.BorderLayout;
import java.io.IOException;

/**
 * Main class to initialize the game board, create tiles, and display the board in a window.
 * This class serves as a test setup for the board. The graphical user interface (GUI) will
 * eventually be managed by JavaScript, but this serves as a prototype for the board initialization.
 */
public class Main {
	/**
     * Main method to create tiles for the board, initialize the board, and display it in a window.
     * This method is used for testing the tile setup and board display. The final GUI will be implemented
     * in JavaScript. If an IOException occurs while loading images for the tiles, the error is printed to the stack trace.
     *
     * @param args the command-line arguments (not used in this application)
     */
    public static void main(String[] args) {
    	// Create tiles for the board
        try {
            Tile tile1 = new Tile(TileType.HIGHWAY_STRAIGHT);
            Tile tile2 = new Tile(TileType.RAILWAY_STRAIGHT);
            Tile tile3 = new Tile(TileType.HIGHWAY_CURVE);
            Tile tile4 = new Tile(TileType.RAILWAY_CURVE);

            // Create a 3x3 board
            Tile[][] board = new Tile[3][3];
            board[0][0] = tile1;
            board[0][1] = tile2;
            board[0][2] = tile3;
            board[1][0] = tile4;

            // Create a window to display the board
            JFrame frame = new JFrame("Affichage du Plateau");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            // Add the panel to display the board
            frame.add(new BoardDisplay(board), BorderLayout.CENTER);

            // Adjust the window size and make it visible
            frame.pack();
            frame.setVisible(true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
