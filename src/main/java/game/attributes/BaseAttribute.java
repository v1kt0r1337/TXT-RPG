package game.attributes;

/**
 * 
 * This class contains the base values of the Attributes.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BaseAttribute
{
    //Should perhaps shift from private to protected.
    private int baseValue;
    private double baseMultiplier;

    /**
     * This constructor is for objects of class BaseAttributes
     * with the default baseMultiplier of 0.0
     * 
     * @param value the baseValue of the attribute
     */
    public BaseAttribute(int value)
    {
        this(value, 0.0);
    }
    
    /**
     * This constructor is for objects of class BaseAttributes
     * with another baseMultiplier then the default value.
     * 
     * @param value the baseValue of the attribute
     * @param multiplier the baseMultiplier of the attribute.
     */
    public BaseAttribute(int value, double multiplier)
    {
        baseValue = value;
        baseMultiplier = multiplier;
    }

    /**
     * Gets the baseValue
     * 
     * @return baseValue
     */
    public int getBaseValue()
    {
        return baseValue;
    }
    
    /**
     * Gets the baseMultiplier
     * 
     * @return baseMultiplier
     */
    public double getBaseMultiplier()
    {
        return baseMultiplier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseAttribute that = (BaseAttribute) o;

        if (baseValue != that.baseValue) return false;
        return Double.compare(that.baseMultiplier, baseMultiplier) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = baseValue;
        temp = Double.doubleToLongBits(baseMultiplier);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
