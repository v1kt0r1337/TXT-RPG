package game.enemyfactory;

/**
 * Objects of HumanBandit are made with the purpose of being enemies
 * of the Player.
 * Objects of HumanBandit are made by the EnemyFactory which is
 * part of a factory pattern.
 * 
 * It extends Enemy which contains some logic regarding actions versus
 * the player. Enemy extends character which is the true foundation of 
 * the class.
 *
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HumanBandit extends Enemy {
    
    /**
     * Constructor of the HumanBandit class.
     */
    public HumanBandit()
    {
        super(HUMAN_BANDIT_NAME, HUMAN_BANDIT_DESC, HUMAN);
    }
    
    /**
     * This method is just to showcase casting, 
     * and the difference between dynamic and static type.
     * 
     * It returns a String with some info about the class.  
     *
     * @return info about the class.
     */
    static public String infoAboutMe()
    {
        return HUMAN_BANDIT_INFO;
    }
    
    /**
     * This method is not used by the project, but only to showcase
     * how polymorphism works when it comes to method calls and overriding.
     * 
     * What the HumanBandit likes to eat.
     * @return a String of what a human bandit eats.
     */
    @Override
    public String whatFood() 
    {
        return HUMAN_EAT;
    }
}
