package game;

/**
 * The interface ResourceBundle handles all the printable strings
 * and strings that will be compared with user input.
 * This will make it easier to translate the game into an other language, 
 * and will also ensure that the output is consistent.
 * 
 * 
 * Later on I might put all t into a clear text format like JSON or XML(?)
 * To make it as easy as possible to change language and values.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface ResourceBundle
{

    // Exam specific strings
    
    String ENEMY_INFO = "I'm your enemy";
    String DWARF_BANDIT_INFO = "Ḯ'm a dwarf and a bandit";
    String ELF_BANDIT_INFO = "Ḯ'm an elf and a bandit";
    String HUMAN_BANDIT_INFO = "Ḯ'm a human and a bandit";
    
    String SIMULATE_WHAT = "Simulate \"normal\" process, "
                           + "or showcase \"polymorphism\"";
    
    String SIMULATE_NORMAL = "normal";
    String SHOWCASE_POLYMORP = "polymorphism"; 
    
    String DWARF_EAT = "I eat stone.";
    String ELF_EAT = "I eat flowers.";
    String HUMAN_EAT = "I eat burgers.";
    
    String WHAT_ENEMY_TYPE = "What type of Enemy? ";
    
    String CHOOSE = "Choose: ";
    String OR = " or ";
    
    String WHICH_ITEMS_PART1 = "Which item set should the enemy use? (only \""; 
    
    String WHICH_ITEMS_PART2 =  "\" implemented)";
    
    
    // Locations
    public static final String STARTLOC_NAME = "outside";
    public static final String STARTLOC_DESC = "at the start location of the RPG. \"go\" \"west\" to test items, \"east\" "
                                               + "to meet multiple enemies,\nsouth to meet an enemy and find an item";

    //public static final String ENTR_PREP = "at";
    public static final String THEATRE_NAME = "theatre";
    public static final String THEATRE_DESC = "in a test area for multiple enemies";
    //public static final String THEATRE_PREP = "in";
    public static final String PUB_NAME = "pub";
    public static final String PUB_DESC = "in the test area for items.\nSome of these items can be used by the \"use\""
            + " command, others are equipable.\nThe amulet contains passive buffs. The"
            + " spear contains magic that gets activated when you attack a target.\n"
            + "The spear can also be tested by the attack command followed by your name."
            + "\nAll these 3 types of magic effects can at the same time be binded into a single items.\n"
            + "The hammer requires 2 hands, while the spears only require 1 hand,"
            + "which makes the character able to dual wield them.\n"
            + "To this date proper detailed information is unfortunatly not implemented into the look command";

    //public static final String PUB_PREP = "in";
    public static final String LAB_NAME = "lab";
    public static final String LAB_DESC = "in a test area were there is both an item and an enemy";


//     public static final String LAB_PREP = "in";
    public static final String OFFICE_NAME = "office";
    public static final String OFFICE_DESC = "This area is not used for any test purposes yet";
//     public static final String OFFICE_PREP = "in";


    // Directions
    public static final String DIR_UP = "up";
    public static final String DIR_DOWN = "down";
    public static final String DIR_EAST = "east";
    public static final String DIR_WEST = "west";
    public static final String DIR_NORTH = "north";
    public static final String DIR_SOUTH = "south";
    
   
    
    // Commands
    public static final String ATTACK = "attack";
    public static final String BACK = "back";
    public static final String CHARACTER_SHEET = "charactersheet";
    public static final String DROP = "drop";
    public static final String EQUIP = "equip";
    public static final String EQUIPMENT = "equipment";
    public static final String GO = "go";
    public static final String HELP = "help";
    public static final String INVENTORY = "inventory";
    public static final String LOOK = "look";
    public static final String TAKE = "take";
    public static final String UNEQUIP = "unequip";
    public static final String USE = "use";
    public static final String QUIT = "quit";
    
    // Command descriptions:
 
    public static final String ATTACK_DESC = "Attack + \"X\", you attack X.";
    public static final String BACK_DESC = "Goes back to the last location.";
    public static final String CHARACTER_SHEET_DESC = "Information about the" 
                                                      + " player.";    
    public static final String DROP_DESC = "Drop 'item'. if drop is used in combination with \"all\", then all items"
                                          + "will be dropped.";
    public static final String EQUIP_DESC = "Equip \"item\".";
    public static final String EQUIPMENT_DESC = "Lists up all the equiped "
                                                + "items.";
    public static final String GO_DESC = "Go to the desired allocated " 
                                         + "location.";
    public static final String HELP_DESC = "Help + Command gives you a"
                                           + " description of the commands.";
    public static final String INVENTORY_DESC = "Lists up all the items in" 
                                                + "  players inventory.";
    public static final String LOOK_DESC = "Looking around might reveal items" 
                                           + " and things of interest.";
    public static final String TAKE_DESC = "Take + 'item' you want to take.";
    
    public static final String UNEQUIP_DESC = "unequip \"item name\". if unequip is used in combination with \"all\", "
                                              + "then all items will be unequiped";
    public static final String UNKNOWN_DESC = "?";
    public static final String USE_DESC = "Use + X were X is what you want "
                                          + "to use.";    
    public static final String QUIT_DESC = "Quits the game!";    

    // COMMAND ATTACK RELATED
    public static final String ATTACK_WHO = "Attack who?";
    public static final String NO_TARGET_BY_THAT_NAME = "No target by that "
                                                        + "name";
    
    // COMMAND DROP RELATED
    public static final String DROP_WHAT = "Drop what?";
    public static final String NO_ITEM_TO_DROP = "There are no items to drop!";
    public static final String DONT_HAVE_ITEM = "You got no ";
    public static final String ITEM_TO_DROP1 = "You dropped ";
    public static final String ITEM_TO_DROP2 = " from your inventory ";

    // COMMAND EQUIP RELATED
    public static final String CANT_EQUIP_THAT_ITEM = "Can't equip ";
    public static final String EQUIP_WHAT = "Equip what?";
    
    // COMMAND EQUIPMENT RELATED
    public static final String NO_ITEM_EQUIPED = "There are no items "
                                             + " equiped.";
    
    // COMMAND GO RELATED
    public static final String GO_WRONG_DIR = "That direction is not viable!";
    public static final String GO_NODIR_MSG = "Go were?";
    
    // COMMAND HELP RELATED
    public static final String HELP_MSG_EVIL = "You are lost. You wander. "
                                               + "You are alone.";
    public static final String HELP_MSG = "Your command words are:";
    public static final String HELP_CMD_LIST = "";
    public static final String HELP_NOCMD_MSG = "Help with what?";
    
    // COMMAND UNEQUIP RELATED
    public static final String UNEQUIP_WHAT = "Unequip what?";
    
    // COMMAND USE RELATED
    public static final String ITEM_USED = "You used the ";
    public static final String USE_WHAT_MSG = "Use what?";
    public static final String USE_UNUSABLE_MSG = "You can't use.";
    public static final String THROW_AWAY_EMPTY = "You throw away the empty ";
    public static final String IS_REMOVED_FROM_INV = " is removed from your" 
                                                     + " inventory";  
    
    //COMMAND TAKE RELATED
    public static final String TAKE_WHAT = "Take what?";
    public static final String TAKE_MSG = "You take ";
    public static final String TAKE_HEAVY_MSG1 = " is too heavy!";
    public static final String TAKE_HEAVY_MSG2 = "You are carrying too much to"
                                                  + " pick up the item, drop "
                                                  + "some load!";
    public static final String TAKE_NOITEM_MSG = "Can't take "; 
    public static final String ITEM_ADDED_INV = " added to the inventory";
    public static final String NO_ITEM_TO_ADD = "There are no ";

    //COMMAND LOOK RELATED
    public static final String NO_ITEM_IN_LOC = "There are no items in the " 
                                                + "area\n";
    public static final String ONE_ITEM_IN_LOC = "There seems to be 1 item in " 
                                                  + "the Location:\n\n";
    public static final String MULT_ITEMS_IN_LOC1 = "There seems to be ";
    public static final String MULT_ITEMS_IN_LOC2 = " items in the Location:"
                                                    + "\n\n";
    

    // OTHER COMMAND RELATED STUFF    
    public static final String QUIT_HAS_SECOND = "Quit what?";    
    public static final String UNKNOWN_COMMAND = "I don't know what you "
                                                 + "mean...";

    
    // Player
    public static final String PLAYER_NAME = "You";
    public static final String PLAYER_DESC = "The player.";

    // Character
    String DIED = "died";
    String DROPPED = "dropped";
    
    // Race
    public static final String WHICH_RACE_BORN = "Of which race are you born?";
    public static final String YOU_CAN_CHOOSE = "you can choose ";
    public static final String HUMAN = "Human";
    public static final String ELF = "Elf";
    public static final String DWARF = "Dwarf";
    
    // NPCs
    public static final String HUMAN_BANDIT = "humanBandit";
    public static final String HUMAN_BANDIT_NAME = "Human Bandit";
    public static final String HUMAN_BANDIT_DESC = "A human bandit";    
    public static final String ELF_BANDIT = "elfBandit";
    public static final String ELF_BANDIT_NAME = "Elf Bandit";
    public static final String ELF_BANDIT_DESC = "An elf bandit";    
    public static final String DWARF_BANDIT = "dwarfBandit";
    public static final String DWARF_BANDIT_NAME = "Dwarf Bandit";
    public static final String DWARF_BANDIT_DESC = "A dwarf bandit";
    
    // LOCATIONS
    public static final String PLAYER_LOCATION1 = "You are ";
    public static final String PLAYER_LOCATION_ITEM = "There seems to be "
                                                      + "something here, maybe "
                                                      + "you should take a look"
                                                      + "?\n";
    public static final String EXITS = "Exits:";
    
    
    // ITEM RELATED STUFF 
    public static final String ITEM = "Item ";
    public static final String NO_ITEM_INV = "There are no items in your"
                                             + " inventory.";
    
    // ITEM SLOTS
    public static final String HAND_SLOT = "handSlot";
    public static final String CHEST_SLOT = "chestSlot";
    public static final String HELM_SLOT = "helmSlot";
    public static final String BOOTS_SLOT = "bootsSlot";
    public static final String GLOVES_SLOT = "glovesSlot";
    public static final String PANTS_SLOT = "pantsSlot";
    public static final String SHOULDER_SLOT = "shoulderSlot";
    public static final String RING_SLOT = "ringSlot";
    public static final String AMULET_SLOT = "amuletSlot";
    
    // ITEM SETS
    public static final String CRUDE_ITEMS = "crudeItems";
    
    // ITEMS
    String ITEM_AMULET_MINOR_ALL_STATS_NAME = "AmuletOfMinorWitchcraft";
    String ITEM_AMULET_MINOR_ALL_STATS_DESC = "An amulet, looks like some fancy non-expensive bling.";
    String AMULET_MINOR_ALL_STATS_ONUSE_MSG = "";

    public static final String ITEM_STEROIDS_NAME = "Syringe";
    public static final String ITEM_STEROIDS_DESC = "A syringe, looks like it "
                                                    + "contain some kind of "
                                                    + "experimental fluids"; 

    public static final String ITEM_STEROIDS_ONUSE_MSG = "You feel the steroids"
                                                         + " pumping through "
                                                         + "your veins, making "
                                                         + "you stronger.";
    
    public static final String ITEM_BIG_SYRINGE_NAME = "BigSyringe";
    public static final String ITEM_BIG_SYRINGE_DESC = "A big syringe, look "
                                                       + "like it contains a "
                                                       + "massive dose drugs.";
                                                       
    public static final String ITEM_BIG_SYRINGE_ONUSE_MSG = "You feel the " 
                                                            + "steroids pumping"
                                                            + "through your "
                                                            + "veins, making "
                                                            + "you stronger.";
                                                            
    public static final String ITEM_ENERGYDRINK_NAME = "EnergyDrink";
    public static final String ITEM_ENERGYDRINK_DESC = "A can of energy drink";
    public static final String ITEM_ENERGYDRINK_ONUSE_MSG = "You feel a rush of"
                                                            + " energy.";    
    
    
    public static final String ITEM_HAMMER_NAME = "Hammer";
    public static final String ITEM_HAMMER_DESC = "A good old fashion sturdy "
                                                  + "hammer, looks heavy.";
    public static final String ITEM_HAMMER_ONUSE_MSG = "You smash the air "
                                                       + "infront of you.";
    
    // ITEM SWORD
    public static final String ITEM_CRUDE_IRON_SWORD_NAME = "Crude Iron Sword";
    public static final String ITEM_CRUDE_IRON_SWORD_DESC = "An old iron sword,"
                                                            + " that have seen "
                                                            + "better days";
    // ITEM SPEAR
    String ITEM_CURSEDSPEAR_NAME = "CursedSpear";
    String ITEM_CURSEDSPEAR_DESC = "A two handed spear, pointy on point ends!";
    String ITEM_BADSPEAR_ONUSE_MSG = "Nothing happens";

    public static final String ITEM_SWORD_ONUSE_MSG = "You swing the sword ";
    
    // ITEM ARMOR
    public static final String ITEM_CRUDE_LEATHER_ARMOR_NAME = "Crude Leather "
                                                               + "Armor";
                                                               
    public static final String ITEM_CRUDE_LEATHER_ARMOR_DESC = "Old leather " 
                                                               + "armor, "
                                                               + "atleast it "
                                                               + "gives some "
                                                               + "protection.";
    
    // ITEM BOOT
    public static final String ITEM_CRUDE_LEATHER_BOOTS_NAME = "Crude Leather"
                                                               + " Boots";
    public static final String ITEM_CRUDE_LEATHER_BOOTS_DESC = "Old leather "
                                                               + "boots, "
                                                               + "atleast it "
                                                               + "gives some "
                                                               + "protection.";
    
    // ITEM HELM
    public static final String ITEM_CRUDE_LEATHER_HELM_NAME = "Crude Leather "
                                                              + "Helm";
                                                              
    public static final String ITEM_CRUDE_LEATHER_HELM_DESC = "Old leather "
                                                              + "helm, atleast"
                                                              + " it gives some"
                                                              + " protection."; 
    // ITEM GLOVES
    public static final String ITEM_CRUDE_LEATHER_GLOVES_NAME = "Crude Leather "
                                                                + "Gloves";
    public static final String ITEM_CRUDE_LEATHER_GLOVES_DESC = 
                        "Old leather gloves, atleast it gives some protection.";
    
    // ITEM PANTS
    public static final String ITEM_CRUDE_LEATHER_PANTS_NAME = 
                               "Crude Leather Pants";
    public static final String ITEM_CRUDE_LEATHER_PANTS_DESC = 
                        "Old leather pants, atleast it gives some protection.";
    
    // ITEM SHOULDERS
    public static final String ITEM_CRUDE_LEATHER_SHOULDERS_NAME = 
                               "Crude Leather Shoulders";
    public static final String ITEM_CRUDE_LEATHER_SHOULDERS_DESC =   
                  "Old leather shoulders, atleast it gives some protection.";  
                               
    //MAGIC RELATED STUFF
    public static final String MAGIC_TARGET_SELF = "self";
    public static final String MAGIC_TARGET_ENEMY = "enemy";
    
    // MAGIC
    public static final String MAGIC_INCREASE_MAXWEIGHT1_NAME = 
                               "increaseMaxWeight1";
    public static final String MAGIC_INCREASE_MAXWEIGHT1_DESC = 
                               "Increased Carry Capacity by +1)";
    
    public static final String MAGIC_INCREASE_MAXWEIGHT1_TEMP_NAME = 
                               "increaseMaxWeight1Temp";
    
    public static final String MAGIC_NOMAGIC_NAME = "noSpell";
    public static final String MAGIC_NOMAGIC_DESC = 
                               "There are no magic bound to this item!";

    String MAGIC_INCREASE_STRENGTH100_NAME = "increaseStrength100";
    String MAGIC_INCREASE_STRENGTH100_DESC = "Increased Strength by + 100)";

    String MAGIC_INCREASE_VITALITY1_NAME = "increaseVitality1";
    String MAGIC_INCREASE_VITALITY1_DESC = "Increased Vitality by + 1)";

    String MAGIC_DECREASED_VITALITY1_NAME = "DecreasedVitality1";
    String MAGIC_DECREASED_VITALITY1_DESC = "Increased Vitality by - 1)";


    String MAGIC_INCREASE_VIT1_ONEQUIP_NAME = "increaseVit1OnEquip";
    String MAGIC_INCREASE_VIT1_ONEQUIP_DESC = MAGIC_INCREASE_VITALITY1_DESC;

    String MAGIC_INCREASE_STR1_ONEQUIP_NAME = "increaseStr1OnEquip";
    String MAGIC_INCREASE_STR1_ONEQUIP_DESC = "Increased Strength by + 1)";

    String MAGIC_INCREASE_INT1_ONEQUIP_NAME = "increaseInt1OnEquip";
    String MAGIC_INCREASE_INT1_ONEQUIP_DESC = "Increased intelligence by + 1)";

    String MAGIC_INCREASE_DEX1_ONEQUIP_NAME = "increaseDex1OnEquip";
    String MAGIC_INCREASE_DEX1_ONEQUIP_DESC = "Increased dexterity by + 1)";


    
    //SPELL 
    public static final String SPELL_INCREASE_MAXWEIGHT1_NAME = 
                               MAGIC_INCREASE_MAXWEIGHT1_NAME;
                               
    public static final String SPELL_INCREASE_MAXWEIGHT_TWICE_NAME = 
                               "increaseMaxWeightTwice";
    public static final String SPELL_NOSPELL_NAME = MAGIC_NOMAGIC_NAME;
    
    public static final String SPELL_INCREASE_MAXWEIGHT1_TEMP_NAME = 
                               MAGIC_INCREASE_MAXWEIGHT1_TEMP_NAME;
    
    String SPELL_BAD_SHIT = "spellBadShit";

    String SPELL_MINOR_ALL_STAT_ON_EQUIP = "SpellMinorAllStatOnEquip";
    
    // EFFECTS
    public static final String EFFECT_INCREASE_MAXWEIGHT_NAME = 
                               "increaseMaxWeight";
    public static final String EFFECT_INCREASE_MAXWEIGHT_EFFECTS = "maxWeight";
    public static final String EFFECT_NOEFFECT = "noEffect";

    String EFFECT_VITALITY = "vitality";
    String EFFECT_STRENGTH = "strength";
    String EFFECT_INTELLIGENCE = "intelligence";
    String EFFECT_DEXTERITY = "dexterity";


    // GENERIC
    public static final String GENERIC_NOTHING_HAPPENS = "Nothing happens.";
    public static final String GENERIC_NOTHING_HAPPENS2 = 
                               "but nothing happens...";
    public static final String GENERIC_NOTHING_HAPPENS3 = "Nothing happens...";
    public static final String GENERIC_NAME = "name: ";
    public static final String GENERIC_DESC = "description: ";
    public static final String GENERIC_WEIGHT = "weight: ";
    
    
    
    // Messages
    public static final String MSG_BYE = "Thank you for playing. Good bye!";
    public static final String MSG_WELCOME1 = 
                        "Welcome to this test environment for my \"Text RPG\"";
    public static final String MSG_WELCOME2 = 
                  "The current state of the game is not ment to look pretty.";
    public static final String MSG_WELCOME3 = 
                        "The game is il-balanced and tells no story.";
    public static final String MSG_WELCOME4 = 
                  "It's only ment for testing and showcasing functionality.";
    public static final String MSG_WELCOME5 = "Type 'help' if you need help.";
    
    public static final String MSG_WHAT_NAME = "What is your name?";    
}
