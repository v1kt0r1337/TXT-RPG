package game.spells;

import game.Bank;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * The purpose of the EffectBank is to contain all the effect in the game
 * 
 * @author Viktor 
 * @version 11.05.2015
 */
public class EffectBank extends Bank<Effect>
{
    /**
     * Constructor for objects of class EffectBank
     */
    public EffectBank()
    {
        effectBank();
    }

    /**
     * This method works as a collection/bank of all the effects in the game.
     */
    private void effectBank()
    {
        Effect maxWeight, noEffect, vitality, strength, intelligence, dexterity;
        
        maxWeight = new Effect(EFFECT_INCREASE_MAXWEIGHT_NAME, 
                               EFFECT_INCREASE_MAXWEIGHT_EFFECTS);
        
        getBankList().add(maxWeight);
        getBankMap().put(EFFECT_INCREASE_MAXWEIGHT_NAME, maxWeight);
        
        noEffect = new Effect(EFFECT_NOEFFECT, EFFECT_NOEFFECT);
        getBankList().add(noEffect);
        getBankMap().put(EFFECT_NOEFFECT, noEffect);

        vitality = new Effect(EFFECT_VITALITY, EFFECT_VITALITY);
        getBankList().add(vitality);
        getBankMap().put(EFFECT_VITALITY, vitality);


        strength = new Effect(EFFECT_STRENGTH, EFFECT_STRENGTH);
        getBankList().add(strength);
        getBankMap().put(EFFECT_STRENGTH, strength);

        intelligence = new Effect(EFFECT_INTELLIGENCE, EFFECT_INTELLIGENCE);
        getBankList().add(intelligence);
        getBankMap().put(EFFECT_INTELLIGENCE, intelligence);

        dexterity = new Effect(EFFECT_DEXTERITY, EFFECT_DEXTERITY);
        getBankList().add(dexterity);
        getBankMap().put(EFFECT_DEXTERITY, dexterity);
    }
}
