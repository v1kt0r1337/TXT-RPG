package game;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Bank is an abstract class Bank that stores 
 * a generic type <T>.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * @param <T> generic Type of collection, the subclasses replaces
 *           this type with their own collection type.
 */
public abstract class Bank<T> implements ResourceBundle
{
    private ArrayList<T> bankList;
    private HashMap<String, T> bankMap;
        
    /**
     * The constuctor of the Bank class.
     * Initialising the instance variables
     */
    public Bank()
    {
        this.bankList = new ArrayList<T>();
        this.bankMap = new HashMap<String, T>();
    }
        
    /**
     * Method to access the bankList field
     * 
     * @return the bankList field of this class (super class).
     */  
    public ArrayList<T> getBankList()
    {
        return this.bankList;
    }
    
    /**
     * Method to access bankMap field
     * 
     * @return the bankMap field.
     */
    public HashMap<String, T> getBankMap()
    {
        return this.bankMap;
    }        
    
    /**
     * Get an item from the bank, by providing item name.
     * 
     * @param itemName  The name of the item we want to return.
     * 
     * @return the item that gets returned.
     */
    public T getItem(String itemName) 
    {
        T theItem = bankMap.get(itemName);
        return theItem;
    }
    
//      /**
//      * This method is currently not in use, only if I feel like adding
//      * Items from the outside
//      * 
//      * @param newItem   the new item that gets added to the allItems.
//      */
//     public void addItem(T newItem)
//     {
//         this.bankList.add(newItem);                     
//         String itemName = newItem.getItemName();
//         bankMap.put(itemName, newItem);            
//     }
    
}