package game.spells;

import game.Bank;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * The class MagicBank contain all the magic in the TXT RPG.
 * Since magic contains effects the MagicBank contains an object of
 * EffectBank, so that it can get access to all the effects.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MagicBank extends Bank<Magic>
{
    private EffectBank effectBank;
    /**
     * Constructor for objects of class MagicBank
     * 
     */
    public MagicBank()
    {
        this.effectBank = new EffectBank();
        magicBank();
    }

    /**
     * Bank of all magic.
     */
    private void magicBank()  
    {
        Magic increaseMaxWeight1, noMagic, increaseMaxWeightTemp, decreaseSelfVitality, increaseEnemyStrength;
        
        increaseMaxWeight1 = new MagicOnUse(MAGIC_INCREASE_MAXWEIGHT1_NAME,
                                            MAGIC_INCREASE_MAXWEIGHT1_DESC,
                                            effectBank.getItem(
                                            EFFECT_INCREASE_MAXWEIGHT_NAME), 
                                            1, 1, MAGIC_TARGET_SELF, -1, 0);
                                            
        getBankList().add(increaseMaxWeight1);
        getBankMap().put(MAGIC_INCREASE_MAXWEIGHT1_NAME, increaseMaxWeight1);
        
        increaseMaxWeightTemp = new MagicOnUse(
                                    MAGIC_INCREASE_MAXWEIGHT1_TEMP_NAME, 
                                    MAGIC_INCREASE_MAXWEIGHT1_DESC,
                                    effectBank.getItem(
                                    EFFECT_INCREASE_MAXWEIGHT_NAME), 
                                    1, 1, MAGIC_TARGET_SELF, 30, 0);

        getBankList().add(increaseMaxWeightTemp);
        getBankMap().put(MAGIC_INCREASE_MAXWEIGHT1_TEMP_NAME, 
                         increaseMaxWeightTemp);

        decreaseSelfVitality = new MagicOnHit(
                MAGIC_DECREASED_VITALITY1_NAME,
                MAGIC_DECREASED_VITALITY1_DESC,
                effectBank.getItem(EFFECT_VITALITY),
                1, 1, MAGIC_TARGET_SELF, -1, 0);

        getBankList().add(decreaseSelfVitality);
        getBankMap().put(MAGIC_DECREASED_VITALITY1_NAME,
                decreaseSelfVitality);

        increaseEnemyStrength = new MagicOnHit(
                MAGIC_INCREASE_STRENGTH100_NAME,
                MAGIC_INCREASE_STRENGTH100_DESC,
                effectBank.getItem(EFFECT_STRENGTH),
                100, 100, MAGIC_TARGET_ENEMY, -1, 0);

        getBankList().add(increaseEnemyStrength);
        getBankMap().put(MAGIC_INCREASE_STRENGTH100_NAME,
                increaseEnemyStrength);

        noMagic = new MagicOnUse(MAGIC_NOMAGIC_NAME, MAGIC_NOMAGIC_DESC, 
                            effectBank.getItem(EFFECT_NOEFFECT), 0, 0,
                                               MAGIC_TARGET_SELF, -1, 0);
                            
        getBankList().add(noMagic);
        getBankMap().put(MAGIC_NOMAGIC_NAME, noMagic);

        Magic increaseStrengthOnEquip, increaseVitalityOnEquip, increaseDexterityOnEquip, increaseIntelligenceOnEquip;


        increaseStrengthOnEquip = new MagicEnchantmentPassive(MAGIC_INCREASE_STR1_ONEQUIP_NAME,
                MAGIC_INCREASE_STR1_ONEQUIP_DESC, effectBank.getItem(EFFECT_STRENGTH),
                1);
        getBankList().add(increaseStrengthOnEquip);
        getBankMap().put(MAGIC_INCREASE_STR1_ONEQUIP_NAME,
                increaseStrengthOnEquip);

        increaseVitalityOnEquip = new MagicEnchantmentPassive(MAGIC_INCREASE_VIT1_ONEQUIP_NAME,
                MAGIC_INCREASE_VIT1_ONEQUIP_DESC,
                effectBank.getItem(EFFECT_VITALITY), 1);
        getBankList().add(increaseVitalityOnEquip);
        getBankMap().put(MAGIC_INCREASE_VIT1_ONEQUIP_NAME,
                increaseVitalityOnEquip);

        increaseDexterityOnEquip = new MagicEnchantmentPassive(MAGIC_INCREASE_DEX1_ONEQUIP_NAME,
                MAGIC_INCREASE_DEX1_ONEQUIP_DESC,
                effectBank.getItem(EFFECT_DEXTERITY), 1);
        getBankList().add(increaseDexterityOnEquip);
        getBankMap().put(MAGIC_INCREASE_DEX1_ONEQUIP_NAME,
                increaseDexterityOnEquip);

        increaseIntelligenceOnEquip = new MagicEnchantmentPassive(MAGIC_INCREASE_INT1_ONEQUIP_NAME,
                MAGIC_INCREASE_INT1_ONEQUIP_DESC,
                effectBank.getItem(EFFECT_INTELLIGENCE), 1);
        getBankList().add(increaseIntelligenceOnEquip);
        getBankMap().put(MAGIC_INCREASE_INT1_ONEQUIP_NAME,
                increaseIntelligenceOnEquip);

    }
}
