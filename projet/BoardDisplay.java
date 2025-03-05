package projet;

import javax.swing.*;
import java.awt.*;

/**
 * A JPanel that displays a grid of tiles on the screen.
 * The board is represented as a 2D array of {@link Tile} objects.
 */
public class BoardDisplay extends JPanel {
	
	/**
     * The 2D array representing the board's tiles.
     */
    private Tile[][] board;

    /**
     * Constructs a new {@link BoardDisplay} instance.
     * 
     * @param board the 2D array of {@link Tile} objects representing the game board.
     * The size of the board determines the preferred size of the panel.
     */
    public BoardDisplay(Tile[][] board) {
        this.board = board;
        setPreferredSize(new Dimension(board[0].length * 100, board.length * 100));  // Ajuste la taille du panneau en fonction du plateau
    }

    /**
     * Paints the components of the panel, including the tiles.
     * This method is called automatically by the Swing framework when the component needs to be redrawn.
     * It draws the tiles on the board using their corresponding images.
     * 
     * @param g the Graphics object used for drawing the tiles.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                Tile tile = board[row][col];
                if (tile != null) {
                    g.drawImage(tile.getImage(), col * 100, row * 100, this); // Dessine l'image de la tuile
                }
            }
        }
    }
}
