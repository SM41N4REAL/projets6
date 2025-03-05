package projet;

/**
 * Enum representing the possible types of connections for tiles on the board.
 * Each tile can have connections in the four cardinal directions: NORTH, EAST, SOUTH, and WEST.
 * The connection types define the type of path or structure that connects to adjacent tiles.
 */
public enum ConnectionType {
	
	/**
     * No connection in this direction.
     */
    NONE,
    
    /**
     * A highway connection in this direction.
     */
    HIGHWAY,
    
    /**
     * A railway connection in this direction.
     */
    RAILWAY,
    
    /**
     * A station connection in this direction.
     */
    STATION
}