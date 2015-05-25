package game.enemyfactory;

/**
 * Objects of ElfBandit are made with the purpose of being enemies
 * of the Player.
 * 
 * Objects of ElfBandit are made by the EnemyFactory which is
 * part of a factory pattern.
 * 
 * It extends Enemy which contains some logic regarding actions versus
 * the player. Enemy extends character which is the true foundation of
 * the class.
 *
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElfBandit extends Enemy {
    
    /**
     * Constructor of the ElfBandit class.
     */
    public ElfBandit()
    {
        super(ELF_BANDIT_NAME, ELF_BANDIT_DESC, ELF);
    }
    
    /**
     * This method is just to showcase casting, 
     * and the difference between dynamic and static type.
     * 
     * It returns a String with some info about the object.  
     *
     * @return info about the class.
     */
    static public String infoAboutMe()
    {
        return ELF_BANDIT_INFO;
    }
    
    /**
     * This method is not used by the project, but only to showcase
     * how polymorphism works when it comes to method calls and overriding.
     * 
     * What the ElfBandit likes to eat.
     * @return a String of what a elf bandit eats.
     */
    @Override
    public String whatFood() 
    {
        return ELF_EAT;
    }
}
