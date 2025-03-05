package projet;


/**
 * Enum representing the different types of tiles on the game board.
 * Each tile type has an associated image name, which is used to load the corresponding image for the tile.
 */
public enum TileType {
	HIGHWAY_STRAIGHT("highway-straight"),
    HIGHWAY_CURVE("highway-curve"),
    HIGHWAY_JUNCTION("highway-junction"),
    HIGHWAY_CROSS("highway-cross"),
    RAILWAY_STRAIGHT("railway-straight"),
    RAILWAY_CURVE("railway-curve"),
    RAILWAY_JUNCTION("railway-junction"),
    RAILWAY_CROSS("railway-cross"),
    STATION_STRAIGHT("station-straight"),
    STATION_CURVE("station-curve"),
    STATION_CROSS("station-cross"),
    STATION_REFLECT("station-reflect"),
    STATION_HIGHWAY_JUNCTION("station-highway-junction"),
    STATION_RAILWAY_JUNCTION("station-railway-junction"),
    OVERPASS("overpass");

	/**
     * The name of the image file associated with this tile type.
     * This name is used to construct the path to the tile's image.
     */
    private final String imageName;

    /**
     * Constructor for the `TileType` enum.
     * 
     * @param imageName the name of the image associated with this tile type
     */
    TileType(String imageName) {
        this.imageName = imageName;
    }

    /**
     * Returns the full path to the image associated with this tile type.
     * The path is constructed by prefixing the image file name with "graphics/" and adding the ".png" extension.
     *
     * @return the full path to the image as a string
     */
    public String getImagePath() {
        return "graphics/" + imageName + ".png";
    }
}
