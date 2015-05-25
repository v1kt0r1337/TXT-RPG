package game.enemyfactory;

/**
 * Objects of DwarfBandit are made with the purpose of being enemies
 * of the Player.
 *  
 * Objects of DwarfBandit are made by the EnemyFactory which is
 * part of a factory pattern.
 * 
 * It extends Enemy which contains some logic regarding actions versus
 * the player. Enemy extends character which is the true foundation
 * of the class.
 *
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DwarfBandit extends Enemy {
    
    /**
     * Constructor of the DwarfBandit class.
     */
    public DwarfBandit()
    {
        super(DWARF_BANDIT_NAME, DWARF_BANDIT_DESC, DWARF);
    }
    
    /**
     * This method is just to showcase casting, 
     * and the difference between dynamic and static type.
     * 
     * It returns a String with some info about the object.  
     *
     * @return info about the object.
     */
    static public String infoAboutMe()
    {
        return DWARF_BANDIT_INFO;
    }
    
    /**
     * This method is not used by the project, but only to showcase
     * how polymorphism works when it comes to method calls and overriding.
     * 
     * What the DwarfBandit likes to eat.
     * @return a String of what a dwarf bandit eats.
     */
    @Override
    public String whatFood() 
    {
        return DWARF_EAT;
    }
    
}
