package game.items;

import game.Bank;
import game.spells.SpellBank;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * ItemBank store all the items in the TXT RPG.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ItemBank extends Bank<Item>
{
    private SpellBank spellBank;
    
    /**
     * Constructor for objects of class ItemBank
     */
    public ItemBank()
    {
        super();
        this.spellBank = new SpellBank();
        itemBank();
    }
    /**
     * List of items.
     */
    public void itemBank()
    {
        Item steroids, bigSyringe, hammer, energyDrink, badSpear, AmuletMinorAllStats;

        
        steroids = new ItemUseAbles(ITEM_STEROIDS_NAME, 1, ITEM_STEROIDS_DESC, 
                   ITEM_STEROIDS_ONUSE_MSG, true, spellBank.getItem(
                        SPELL_INCREASE_MAXWEIGHT1_NAME), 1);
                            
        getBankList().add(steroids);
        getBankMap().put(ITEM_STEROIDS_NAME, steroids);
        
        bigSyringe = new ItemUseAbles(ITEM_BIG_SYRINGE_NAME, 2, 
                     ITEM_BIG_SYRINGE_DESC, ITEM_BIG_SYRINGE_ONUSE_MSG, true,
                     spellBank.getItem(SPELL_INCREASE_MAXWEIGHT_TWICE_NAME), 1);
                              
        getBankList().add(bigSyringe);
        getBankMap().put(ITEM_BIG_SYRINGE_NAME, bigSyringe);
        
        hammer = new ItemHandHeld(ITEM_HAMMER_NAME, HAND_SLOT, 51, 
                 ITEM_HAMMER_DESC, ITEM_HAMMER_ONUSE_MSG, 
                 spellBank.getItem(SPELL_NOSPELL_NAME), true, 1, 1);
                          
        getBankList().add(hammer);
        getBankMap().put(ITEM_HAMMER_NAME, hammer);


        badSpear = new ItemHandHeld(ITEM_CURSEDSPEAR_NAME, HAND_SLOT, 1,
                   ITEM_CURSEDSPEAR_DESC, ITEM_BADSPEAR_ONUSE_MSG,
                   spellBank.getItem(SPELL_BAD_SHIT), false, 2, 4);

        getBankList().add(badSpear);
        getBankMap().put(ITEM_CURSEDSPEAR_NAME, badSpear);

        energyDrink = new ItemUseAbles(ITEM_ENERGYDRINK_NAME, 2, 
                      ITEM_ENERGYDRINK_DESC, ITEM_ENERGYDRINK_ONUSE_MSG, true, 
                      spellBank.getItem(SPELL_INCREASE_MAXWEIGHT1_TEMP_NAME), 
                      1);
                               
        getBankList().add(energyDrink);
        getBankMap().put(ITEM_ENERGYDRINK_NAME, energyDrink);


        AmuletMinorAllStats = new ItemAccessories(ITEM_AMULET_MINOR_ALL_STATS_NAME, AMULET_SLOT, 1,
                ITEM_AMULET_MINOR_ALL_STATS_DESC, AMULET_MINOR_ALL_STATS_ONUSE_MSG,
                spellBank.getItem(SPELL_MINOR_ALL_STAT_ON_EQUIP));
        getBankList().add(AmuletMinorAllStats);
        getBankMap().put(ITEM_AMULET_MINOR_ALL_STATS_NAME, AmuletMinorAllStats);

        
        Item crudeIronSword, crudeLeatherArmor, crudeLeatherHelm, 
             crudeLeatherGloves, crudeLeatherBoots, crudeLeatherPants,
             crudeLeatherShoulder, copperRing, copperAmulet;
             
        crudeIronSword = new ItemHandHeld(ITEM_CRUDE_IRON_SWORD_NAME, HAND_SLOT,
                         7, ITEM_CRUDE_IRON_SWORD_DESC, ITEM_SWORD_ONUSE_MSG, 
                         spellBank.getItem(SPELL_NOSPELL_NAME),
                         false, 3, 6);
                                          
        getBankList().add(crudeIronSword);
        getBankMap().put(ITEM_CRUDE_IRON_SWORD_NAME, crudeIronSword);   
        
        
        crudeLeatherArmor = new ItemArmor(ITEM_CRUDE_LEATHER_ARMOR_NAME, 
                            CHEST_SLOT, 8, ITEM_CRUDE_LEATHER_ARMOR_DESC,
                            ITEM_SWORD_ONUSE_MSG, spellBank.getItem(
                                SPELL_NOSPELL_NAME), 3);
                                          
        getBankList().add(crudeLeatherArmor);                                  
        getBankMap().put(ITEM_CRUDE_LEATHER_ARMOR_NAME, crudeLeatherArmor);   
        
        
        crudeLeatherBoots = new ItemArmor(ITEM_CRUDE_LEATHER_BOOTS_NAME, 
                            BOOTS_SLOT, 4, ITEM_CRUDE_LEATHER_BOOTS_DESC,
                            ITEM_SWORD_ONUSE_MSG, spellBank.getItem(
                                SPELL_NOSPELL_NAME), 1);
                                          
        getBankList().add(crudeLeatherBoots);                                  
        getBankMap().put(ITEM_CRUDE_LEATHER_BOOTS_NAME, crudeLeatherBoots);
        
        
        crudeLeatherHelm = new ItemArmor(ITEM_CRUDE_LEATHER_HELM_NAME, 
                           HELM_SLOT, 3, ITEM_CRUDE_LEATHER_HELM_DESC, 
                           ITEM_SWORD_ONUSE_MSG, spellBank.getItem(
                                SPELL_NOSPELL_NAME), 1);
                                         
        getBankList().add(crudeLeatherHelm);                                  
        getBankMap().put(ITEM_CRUDE_LEATHER_HELM_NAME, crudeLeatherHelm);
        
        
        crudeLeatherGloves = new ItemArmor(ITEM_CRUDE_LEATHER_GLOVES_NAME,
                             GLOVES_SLOT, 3, ITEM_CRUDE_LEATHER_GLOVES_DESC, 
                             ITEM_SWORD_ONUSE_MSG, spellBank.getItem(
                                 SPELL_NOSPELL_NAME), 1);
                                           
        getBankList().add(crudeLeatherGloves);                                  
        getBankMap().put(ITEM_CRUDE_LEATHER_GLOVES_NAME, crudeLeatherGloves);
        
        
        crudeLeatherPants = new ItemArmor(ITEM_CRUDE_LEATHER_PANTS_NAME, 
                            PANTS_SLOT, 5, ITEM_CRUDE_LEATHER_PANTS_DESC, 
                            ITEM_SWORD_ONUSE_MSG, spellBank.getItem(
                                SPELL_NOSPELL_NAME), 1);
                                          
        getBankList().add(crudeLeatherPants);                                  
        getBankMap().put(ITEM_CRUDE_LEATHER_PANTS_NAME, crudeLeatherPants);
        
        
        crudeLeatherShoulder = new ItemArmor(ITEM_CRUDE_LEATHER_SHOULDERS_NAME, 
                               SHOULDER_SLOT, 3, 
                               ITEM_CRUDE_LEATHER_SHOULDERS_DESC,
                               ITEM_SWORD_ONUSE_MSG, spellBank.getItem(
                                    SPELL_NOSPELL_NAME), 1);
                                             
        getBankList().add(crudeLeatherShoulder);
        getBankMap().put(ITEM_CRUDE_LEATHER_SHOULDERS_NAME, 
                         crudeLeatherShoulder);
    }
}