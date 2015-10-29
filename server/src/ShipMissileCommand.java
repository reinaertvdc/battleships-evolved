/**
 * ShipMissileCommand is a large 2x2 ship that can call for artillery.
 *
 * @author Reinaert Van de Cruys
 */
public class ShipMissileCommand extends Ship {
    private static final Coordinate SIZE = new Coordinate(2, 2);
    private static final int NUMBER_OF_WEAPONS = 1;

    public ShipMissileCommand(Board board) {
        super(board, SIZE);
        mWeapons = new Weapon[NUMBER_OF_WEAPONS];
        mWeapons[0] = new WeaponArtillery(mBoard);
    }
}
