package be.uhasselt.ttui.battleshipevolved;

/**
 * Ship is the abstract base class for all ships.
 *
 * @author Reinaert Van de Cruys
 */
public abstract class Ship {
    private Coordinate mSize;
    private int mHitPoints;
    protected Board mBoard;
    protected Weapon[] mWeapons;

    protected Ship(Board board, Coordinate size) {
        mSize = size;
        mHitPoints = size.getRow() * size.getColumn();
        mBoard = board;
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
}