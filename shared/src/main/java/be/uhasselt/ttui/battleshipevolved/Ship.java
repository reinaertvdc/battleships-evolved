package be.uhasselt.ttui.battleshipevolved;

/**
 * Ship is the abstract base class for all ships.
 *
 * @author Reinaert Van de Cruys
 */
public abstract class Ship {
    private Coordinate mSize;
    protected int mHitPoints;
    protected Weapon[] mWeapons;

    protected Ship(Coordinate size) {
        mSize = size;
        mHitPoints = size.getRow() * size.getColumn();
        mWeapons = new Weapon[0];
    }

    public Coordinate getSize() {
        return mSize;
    }

    public Weapon[] getWeapons() {
        return mWeapons;
    }

    public void hit() {
        if (mHitPoints > 0) {
            mHitPoints--;
        }
    }

    public boolean isSunk() {
        return mHitPoints <= 0;
    }

    public void refreshCooldowns() {
        for (int i = 0; i < mWeapons.length; i++) {
            Weapon weapon = mWeapons[i];
            weapon.coolDown();
        }
    }
}
