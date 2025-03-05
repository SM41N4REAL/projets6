package projet;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

/**
 * The GameManager class handles the game's logic and the management of the game board.
 * It allows placing tiles on the board, rotating them, and retrieving the current state of the board.
 */
public class GameManager {
	
	/** The board that holds the tiles for the game. */
    private final Board board;
    
    /** A map to hold the images corresponding to each tile type. */
    private final Map<TileType, BufferedImage> tileImages;

    /**
     * Constructs a GameManager object that initializes the board and loads the tile images.
     * 
     * @throws IOException If there is an error reading the tile images from files.
     */
    public GameManager() throws IOException {
        this.board = new Board();
        this.tileImages = loadTileImages();
    }

    /**
     * Loads the images for all tile types by reading image files corresponding to each type.
     * 
     * @return A map where the keys are tile types and the values are their corresponding images.
     * @throws IOException If there is an error reading the tile images from files.
     */
    private Map<TileType, BufferedImage> loadTileImages() throws IOException {
        Map<TileType, BufferedImage> images = new HashMap<>();
        for (TileType type : TileType.values()) {
            images.put(type, ImageIO.read(new File(type.getImagePath())));
        }
        return images;
    }

    /**
     * Places a tile on the board at the specified position with the given rotation.
     * The rotation is applied by rotating the tile in 90-degree increments.
     * 
     * @param type The type of tile to be placed.
     * @param position The position (in algebraic notation) on the board where the tile should be placed.
     * @param rotation The rotation of the tile in degrees (must be a multiple of 90).
     * @return True if the tile was successfully placed, false otherwise.
     * @throws IOException If there is an error creating the tile or reading its image.
     */
    public boolean placeTile(TileType type, String position, int rotation) throws IOException {
        Tile tile = new Tile(type);
        for (int i = 0; i < (rotation / 90); i++) {
            tile.rotate();
        }
        return board.placeTile(new Position(position), tile);
    }

    /**
     * Retrieves the current state of the board, including the types of tiles and their rotations.
     * 
     * @return A map containing the current state of the board. The map contains:
     *         - "types": a 2D array of TileType values representing the tile types on the board.
     *         - "rotations": a 2D array of integers representing the rotation (in degrees) of each tile.
     */
    public Map<String, Object> getBoardState() {
        Map<String, Object> state = new HashMap<>();
        TileType[][] types = new TileType[Board.SIZE][Board.SIZE];
        int[][] rotations = new int[Board.SIZE][Board.SIZE];

        for (int i = 0; i < Board.SIZE; i++) {
            for (int j = 0; j < Board.SIZE; j++) {
                Tile tile = board.getTileAt(i, j);
                if (tile != null) {
                    types[i][j] = tile.getType();
                    rotations[i][j] = tile.getOrientation().getDegrees();
                }
            }
        }

        state.put("types", types);
        state.put("rotations", rotations);
        return state;
    }
}
