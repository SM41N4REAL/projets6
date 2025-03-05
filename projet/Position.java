package projet;
import java.util.Objects;

/**
 * Represents a position on the game board using a row and column.
 */
public class Position {
	
	 /**
     * The row index of the position on the board.
     * Row indices are 0-based, where 0 is the topmost row.
     */
    private final int row;
    
    /**
     * The column index of the position on the board.
     * Column indices are 0-based, where 0 is the leftmost column.
     */
    private final int col;

    /**
     * Constructs a Position using row and column values.
     *
     * @param row the row index (0-based)
     * @param col the column index (0-based)
     */
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Constructs a Position from a string notation (e.g., "A1", "B3").
     * The string is assumed to follow algebraic board notation.
     *
     * @param positionNotation a string representing the position in board notation (e.g., "A1", "B3")
     */
    public Position(String positionNotation) {
        this.col = positionNotation.charAt(0) - 'A';
        this.row = 6 - (positionNotation.charAt(1) - '1');
    }

    /**
     * Converts the Position to a string representing its board notation (e.g., "A1", "B3").
     *
     * @return the position in board notation as a string
     */
    public String toBoardNotation() {
        return String.format("%c%d", (char)('A' + col), 7 - row);
    }

    /**
     * Checks if two positions are equal based on their row and column values.
     *
     * @param o the object to compare to
     * @return true if the two positions are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return row == position.row && col == position.col;
    }

    /**
     * Returns a hash code for the Position.
     *
     * @return the hash code of the Position
     */
    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
    
    /**
     * Gets the row index of the Position.
     *
     * @return the row index
     */
    public int getRow() {
        return row;
    }

    /**
     * Gets the column index of the Position.
     *
     * @return the column index
     */
    public int getCol() {
        return col;
    }
}
