/**
 * WeaponArtillery hits the same coordinate on all fields and takes 3 turns to cool down.
 *
 * @author Reinaert Van de Cruys
 */
public class WeaponArtillery extends Weapon {
    private static final int COOL_DOWN = 3;

    public WeaponArtillery(Board board) {
        super(board, COOL_DOWN, COOL_DOWN);
    }

    protected void execute(Field field, Coordinate coordinate) {
        // TODO implement method
    }
}