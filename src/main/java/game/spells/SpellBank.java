package game.spells;

import game.Bank;

/**
 * The SpellBank contains all the spells in the TXT RPG.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpellBank extends Bank<Spell>
{
    private MagicBank magicBank;

    /**
     * Constructor for objects of class SpellBank
     */
    public SpellBank()
    {
        this.magicBank = new MagicBank();
        spellBank();
    }

    /**
     * List of all the spells in the spellbank
     */
    private void spellBank()
    {
        Spell increaseMaxWeight1, noSpell, increaseMaxWeightTwice,
              increaseMaxWeight1Temp, badSpell, minorAllStatOnEquip;
        
        increaseMaxWeight1 = new Spell();
        increaseMaxWeight1.addMagic(magicBank.getItem(
                                    MAGIC_INCREASE_MAXWEIGHT1_NAME));
        
        getBankList().add(increaseMaxWeight1);
        getBankMap().put(SPELL_INCREASE_MAXWEIGHT1_NAME,
                         increaseMaxWeight1);
        
        increaseMaxWeightTwice = new Spell();
        increaseMaxWeightTwice.addMagic(magicBank.getItem(
                                        MAGIC_INCREASE_MAXWEIGHT1_NAME));
                                        
        increaseMaxWeightTwice.addMagic(magicBank.getItem(
                                        MAGIC_INCREASE_MAXWEIGHT1_NAME));
                                        
        getBankList().add(increaseMaxWeightTwice);
        getBankMap().put(SPELL_INCREASE_MAXWEIGHT_TWICE_NAME, 
                         increaseMaxWeightTwice);
        
        increaseMaxWeight1Temp = new Spell(); 
        increaseMaxWeight1Temp.addMagic(magicBank.getItem(
                                        MAGIC_INCREASE_MAXWEIGHT1_TEMP_NAME));
        getBankList().add(increaseMaxWeight1Temp);
        getBankMap().put(SPELL_INCREASE_MAXWEIGHT1_TEMP_NAME, 
                         increaseMaxWeight1Temp);
        
        
        noSpell = new Spell();
        noSpell.addMagic(magicBank.getItem(MAGIC_NOMAGIC_NAME));
        getBankList().add(noSpell);
        getBankMap().put(SPELL_NOSPELL_NAME, noSpell);


        badSpell = new Spell();
        badSpell.addMagic(magicBank.getItem(MAGIC_INCREASE_STRENGTH100_NAME));
        badSpell.addMagic(magicBank.getItem(MAGIC_DECREASED_VITALITY1_NAME));
        getBankList().add(badSpell);
        getBankMap().put(SPELL_BAD_SHIT, badSpell);

        minorAllStatOnEquip = new Spell();
        minorAllStatOnEquip.addMagic(magicBank.getItem(MAGIC_INCREASE_STR1_ONEQUIP_NAME));
        minorAllStatOnEquip.addMagic(magicBank.getItem(MAGIC_INCREASE_VIT1_ONEQUIP_NAME));
        minorAllStatOnEquip.addMagic(magicBank.getItem(MAGIC_INCREASE_DEX1_ONEQUIP_NAME));
        minorAllStatOnEquip.addMagic(magicBank.getItem(MAGIC_INCREASE_INT1_ONEQUIP_NAME));
        getBankList().add(minorAllStatOnEquip);
        getBankMap().put(SPELL_MINOR_ALL_STAT_ON_EQUIP, minorAllStatOnEquip);
    }
}
