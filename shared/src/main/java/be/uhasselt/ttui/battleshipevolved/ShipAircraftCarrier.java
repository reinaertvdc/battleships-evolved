package be.uhasselt.ttui.battleshipevolved;

/**
 * ShipAircraftCarrier is a very large 1x5 ship that can perform air strikes, in addition to normal shots.
 *
 * @author Reinaert Van de Cruys
 */
public class ShipAircraftCarrier extends Ship {
    private static final Coordinate SIZE = new Coordinate(1, 5);

    public ShipAircraftCarrier() {
        super(SIZE);
        mWeapons = new Weapon[]{new WeaponShot(), new WeaponAirStrike()};
    }
}
