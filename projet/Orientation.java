package projet;

/**
 * The {@code Orientation} enum represents the four cardinal directions (NORTH, EAST, SOUTH, WEST),
 * with each direction associated with an angle in degrees.
 */
public enum Orientation {
	
	/** Represents the North direction (0 degrees). */
    NORTH(0),
    
    /** Represents the East direction (90 degrees). */
    EAST(90),
    
    /** Represents the South direction (180 degrees). */
    SOUTH(180),
    
    /** Represents the West direction (270 degrees). */
    WEST(270);

	/** The angle in degrees associated with the orientation. */
    private final int degrees;

    /**
     * Constructs an Orientation enum with the specified angle in degrees.
     * 
     * @param degrees The angle in degrees associated with the orientation.
     */
    Orientation(int degrees) {
        this.degrees = degrees;
    }

    /**
     * Returns the angle in degrees associated with this orientation.
     * 
     * @return The angle in degrees of the orientation.
     */
    public int getDegrees() {
        return degrees;
    }

    /**
     * Returns the {@code Orientation} corresponding to the specified angle in degrees.
     * The angle is normalized to be within the range [0, 360).
     * 
     * @param degrees The angle in degrees.
     * @return The {@code Orientation} corresponding to the given angle.
     */
    public static Orientation fromDegrees(int degrees) {
        degrees = ((degrees % 360) + 360) % 360;
        for (Orientation o : values()) {
            if (o.degrees == degrees) return o;
        }
        return NORTH;
    }

    /**
     * Rotates the current orientation by 90 degrees in a clockwise direction.
     * 
     * @return The new {@code Orientation} after rotation.
     */
    public Orientation rotate() {
        return fromDegrees(degrees + 90);
    }
}