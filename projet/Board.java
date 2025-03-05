package projet;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents the game board where tiles are placed.
 * The board is a square grid of size defined by {@link Board#SIZE}.
 */
public class Board {
	
	/**
     * The grid representing the game board, a 2D array of tiles with size {@link Board#SIZE} x {@link Board#SIZE}.
     */
    private final Tile[][] grid;
    
    /**
     * The size of the board, defined as a constant.
     */
    public static final int SIZE = 7;
    
    /**
     * The set of exit positions on the board.
     * Initialized with predefined positions.
     */
    private static final Set<Position> EXITS = initializeExits();

    /**
     * Constructs a new {@link Board} instance.
     * Initializes the grid with a size of {@link Board#SIZE} x {@link Board#SIZE}.
     */
    public Board() {
        grid = new Tile[SIZE][SIZE];
    }

    /**
     * Initializes the set of exit positions on the board.
     * 
     * @return a set of exit positions.
     */
    private static Set<Position> initializeExits() {
        Set<Position> exits = new HashSet<>();
        // Exemple d'ajout de sorties pour le jeu
        exits.add(new Position(0, 1));
        exits.add(new Position(6, 3));
        return exits;
    }

    /**
     * Checks if placing a tile at the given position is valid.
     * A placement is valid if the position is within the bounds of the board,
     * if the cell is empty, and if the tile's connections are compatible with its neighboring tiles.
     * 
     * @param pos the position to check.
     * @param tile the tile to place.
     * @return {@code true} if the placement is valid, otherwise {@code false}.
     */
    public boolean isValidPlacement(Position pos, Tile tile) {
        if (!isPositionValid(pos)) return false;
        if (grid[pos.getRow()][pos.getCol()] != null) return false;
        return checkConnections(pos, tile);
    }

    /**
     * Checks if the given position is valid, meaning it is within the bounds of the board.
     * 
     * @param pos the position to check.
     * @return {@code true} if the position is valid, otherwise {@code false}.
     */
    private boolean isPositionValid(Position pos) {
        return pos.getRow() >= 0 && pos.getRow() < SIZE && pos.getCol() >= 0 && pos.getCol() < SIZE;
    }

    /**
     * Checks if the connections of the tile at the given position are compatible with its neighboring tiles.
     * 
     * @param pos the position of the tile to check.
     * @param tile the tile to check.
     * @return {@code true} if the connections are compatible, otherwise {@code false}.
     */
    private boolean checkConnections(Position pos, Tile tile) {
        // Vérification des connexions vers le haut (Nord)
        if (pos.getRow() > 0 && grid[pos.getRow() - 1][pos.getCol()] != null) {
            if (!areConnectionsCompatible(
                tile.getConnections()[0], 
                grid[pos.getRow() - 1][pos.getCol()].getConnections()[2])) {
                return false;
            }
        }
        // Vérification des connexions vers la droite (Est)
        if (pos.getCol() < SIZE - 1 && grid[pos.getRow()][pos.getCol() + 1] != null) {
            if (!areConnectionsCompatible(
                tile.getConnections()[1], 
                grid[pos.getRow()][pos.getCol() + 1].getConnections()[3])) {
                return false;
            }
        }
        // Vérification des connexions vers le bas (Sud)
        if (pos.getRow() < SIZE - 1 && grid[pos.getRow() + 1][pos.getCol()] != null) {
            if (!areConnectionsCompatible(
                tile.getConnections()[2], 
                grid[pos.getRow() + 1][pos.getCol()].getConnections()[0])) {
                return false;
            }
        }
        // Vérification des connexions vers la gauche (Ouest)
        if (pos.getCol() > 0 && grid[pos.getRow()][pos.getCol() - 1] != null) {
            if (!areConnectionsCompatible(
                tile.getConnections()[3], 
                grid[pos.getRow()][pos.getCol() - 1].getConnections()[1])) {
                return false;
            }
        }
        return true;
    }


    /**
     * Checks if two connection types are compatible.
     * 
     * @param newConn the new connection to check.
     * @param existingConn the existing connection to check.
     * @return {@code true} if the connections are compatible, otherwise {@code false}.
     */
    private boolean areConnectionsCompatible(ConnectionType newConn, ConnectionType existingConn) {
        return newConn == existingConn || newConn == ConnectionType.NONE || existingConn == ConnectionType.NONE;
    }

    /**
     * Places a tile on the board at the given position.
     * 
     * @param pos the position where to place the tile.
     * @param tile the tile to place.
     * @return {@code true} if the tile was successfully placed, otherwise {@code false}.
     */
    public boolean placeTile(Position pos, Tile tile) {
        if (!isValidPlacement(pos, tile)) return false;
        grid[pos.getRow()][pos.getCol()] = tile;
        return true;
    }

    /**
     * Gets the tile at a given position on the board.
     * 
     * @param row the row of the tile.
     * @param col the column of the tile.
     * @return the tile at the specified position.
     */
    public Tile getTileAt(int row, int col) {
        return grid[row][col];
    }
    
    /**
     * Gets the entire grid representing the board.
     * 
     * @return the grid of tiles.
     */
    public Tile[][] getGrid() {
        return grid;
    }

}
