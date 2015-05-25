package game;

import java.util.Random;

/**
 * Abstract class Entity 
 * The base class for all the entities in the game.
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Entity
{
    protected String name;
    protected String description;
    protected long id;
    
    /**
     * The constructor for the entity class
     * 
     * @param name the name of the entity
     * @param description the decription of the entity
     */
    public Entity(String name, String description)
    {
        this.name = name;
        this.description = description;
        setId();
    }
    
    /**
     * Sets the id of the entity.
     * The id is a random long number which should be enforced
     * to be unique.
     */
    public void setId()
    {
        Random random = new Random();
        id = random.nextLong();
    }
    
    /**
     * Gets the id of the entity
     * 
     * @return the personal id of the entity
     */
    public long getId()
    {
        return id;
    }
    
    /**
     * Gets the name of the entity
     * 
     * @return the name of the entity.
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Sets the name of the entity
     * 
     * @param name the entitys name.
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Gets the description of the entity
     * 
     * @return the description of the entity.
     */
    public String getDescription()
    {
        return this.description;
    }
    
    /**
     * Sets the description of the entity
     * 
     * @param description sets the description of the entity.
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    
}

