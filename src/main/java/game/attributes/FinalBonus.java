package game.attributes;

/**
 * This class is for handling temporary buffs.
 * 
 * There are two sound choices, either using real time, or player
 * move counter. Since this game is still a text rpg, move
 * counter is probably the best option.
 * 
 * ATM this class is using realtime for buffs(BETTER TYPE FAST!).
 * This class is not working atm, due to how the buffs get added and
 * how they try to remove themselves.
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinalBonus extends BaseAttribute {

    private long time;

    // This will not work.
    private Attribute parent;

    /**
     * Constructor for objects of class RawBonus
     *
     * @param value      of the buff
     * @param multiplier setting the multplier as 1.0 will "double the value".
     * @param duration   how long the buff will last.
     */
    public FinalBonus(int value, double multiplier) {
        super(value, multiplier);
    }
}