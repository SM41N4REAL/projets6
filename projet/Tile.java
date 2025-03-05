package projet;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Represents a tile on the game board. The tile has a type, an orientation, and connections to other tiles.
 * Each tile is also associated with an image.
 */
public class Tile {
	
	/**
     * The type of the tile (e.g., HIGHWAY, RAILWAY, STATION).
     */
    private final TileType type;
    
    /**
     * The current orientation of the tile (e.g., NORTH, EAST, etc.).
     */
    private Orientation orientation;
    
    /**
     * The image representing the tile.
     */
    private final BufferedImage image;
    
    /**
     * The connections of the tile in each direction (North, East, South, West).
     * The possible connection types are HIGHWAY, RAILWAY, STATION, or NONE.
     */
    private final ConnectionType[] connections; // [NORTH, EAST, SOUTH, WEST]

    /**
     * Constructs a tile with a specific type, initializes its orientation to NORTH,
     * loads its image, and sets up its connections based on the tile type.
     *
     * @param type the type of the tile (e.g., HIGHWAY, RAILWAY, STATION)
     * @throws IOException if there is an issue loading the tile image
     */
    public Tile(TileType type) throws IOException {
        this.type = type;
        this.orientation = Orientation.NORTH;
        this.image = ImageIO.read(new File(type.getImagePath()));
        this.connections = initializeConnections();
    }

    /**
     * Initializes the connections of the tile based on its type.
     * Each tile type has predefined connections in each of the four directions: NORTH, EAST, SOUTH, and WEST.
     *
     * @return an array of ConnectionType representing the tile's connections
     */
    private ConnectionType[] initializeConnections() {
        switch (type) {
            case HIGHWAY_STRAIGHT:
                return new ConnectionType[]{ConnectionType.HIGHWAY, ConnectionType.NONE, ConnectionType.HIGHWAY, ConnectionType.NONE};
            case HIGHWAY_CURVE:
                return new ConnectionType[]{ConnectionType.HIGHWAY, ConnectionType.HIGHWAY, ConnectionType.NONE, ConnectionType.NONE};
            case HIGHWAY_JUNCTION:
                return new ConnectionType[]{ConnectionType.HIGHWAY, ConnectionType.HIGHWAY, ConnectionType.HIGHWAY, ConnectionType.HIGHWAY};
            case HIGHWAY_CROSS:
                return new ConnectionType[]{ConnectionType.HIGHWAY, ConnectionType.HIGHWAY, ConnectionType.HIGHWAY, ConnectionType.HIGHWAY};
            case RAILWAY_STRAIGHT:
                return new ConnectionType[]{ConnectionType.RAILWAY, ConnectionType.NONE, ConnectionType.RAILWAY, ConnectionType.NONE};
            case RAILWAY_CURVE:
                return new ConnectionType[]{ConnectionType.RAILWAY, ConnectionType.RAILWAY, ConnectionType.NONE, ConnectionType.NONE};
            case RAILWAY_JUNCTION:
                return new ConnectionType[]{ConnectionType.RAILWAY, ConnectionType.RAILWAY, ConnectionType.RAILWAY, ConnectionType.RAILWAY};
            case RAILWAY_CROSS:
                return new ConnectionType[]{ConnectionType.RAILWAY, ConnectionType.RAILWAY, ConnectionType.RAILWAY, ConnectionType.RAILWAY};
            case STATION_STRAIGHT:
                return new ConnectionType[]{ConnectionType.STATION, ConnectionType.NONE, ConnectionType.STATION, ConnectionType.NONE};
            case STATION_CURVE:
                return new ConnectionType[]{ConnectionType.STATION, ConnectionType.STATION, ConnectionType.NONE, ConnectionType.NONE};
            case STATION_CROSS:
                return new ConnectionType[]{ConnectionType.STATION, ConnectionType.STATION, ConnectionType.STATION, ConnectionType.STATION};
            case STATION_REFLECT:
                return new ConnectionType[]{ConnectionType.STATION, ConnectionType.STATION, ConnectionType.STATION, ConnectionType.STATION};
            case STATION_HIGHWAY_JUNCTION:
                return new ConnectionType[]{ConnectionType.STATION, ConnectionType.HIGHWAY, ConnectionType.STATION, ConnectionType.HIGHWAY};
            case STATION_RAILWAY_JUNCTION:
                return new ConnectionType[]{ConnectionType.STATION, ConnectionType.RAILWAY, ConnectionType.STATION, ConnectionType.RAILWAY};
            case OVERPASS:
                return new ConnectionType[]{ConnectionType.HIGHWAY, ConnectionType.RAILWAY, ConnectionType.HIGHWAY, ConnectionType.RAILWAY};
            default:
                return new ConnectionType[]{ConnectionType.NONE, ConnectionType.NONE, ConnectionType.NONE, ConnectionType.NONE}; // Connexions par défaut
        }
    }

    /**
     * Rotates the tile 90 degrees clockwise and adjusts the connections accordingly.
     */
    public void rotate() {
        orientation = orientation.rotate();
        ConnectionType temp = connections[0];
        for (int i = 0; i < 3; i++) {
            connections[i] = connections[i + 1];
        }
        connections[3] = temp;
    }
    
    /**
     * Returns the type of the tile.
     *
     * @return the type of the tile
     */
    public TileType getType() {
        return type;
    }

    /**
     * Returns the current orientation of the tile.
     *
     * @return the orientation of the tile
     */
    public Orientation getOrientation() {
        return orientation;
    }

    /**
     * Returns the array of connections for the tile.
     *
     * @return an array of ConnectionType representing the connections (NORTH, EAST, SOUTH, WEST)
     */
    public ConnectionType[] getConnections() {
        return connections;
    }
    
    /**
     * Returns the image representing the tile.
     *
     * @return the image of the tile
     */
    public BufferedImage getImage() {
        return image;
    }

}