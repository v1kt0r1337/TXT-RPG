package game.spells;

/**
 * The class Effect is ment to be an attribute to objects of the class Item, 
 * and maybe in the future I can be used to other classes too. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Effect
{
    private String effectName;
    private String changeVariable;
    //private int effect;
    

    

    /**
     * Constructor for effects.
     * 
     * @param effectName the name of the effect
     * @param changeVariable whats the effect will effect. 
     */
    public Effect(String effectName, String changeVariable)//, int effect)
    {
        this.effectName = effectName;
        this.changeVariable = changeVariable;
        //this.effect = effect;
    }

    
    /**
     * A method to get the name of the effect.
     * 
     * @return the name of the effect 
     */
    public String getEffectName()
    {
        return this.effectName;
    }
    
    /**
     * A method to get the variable that the effect its gonna do changes on.
     * 
     * @return the variable to change.
     */
    public String getChangeVariable()
    {
        return this.changeVariable;
    }
    
    /**
     * This method overrides the Object class equals method.
     * THis method is used to check if two objects are equal to one another.
     *
     * @param obj the object to be tested for equality with this 
     *            instance of effect
     * @return true if equal, false if not.
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Effect)) {
            return false;
        }
        // Gain access to the other effect's fields.
        Effect other = (Effect) obj;
        
        return effectName.equals(other.effectName) 
               && changeVariable == other.changeVariable;
        
    }
}
