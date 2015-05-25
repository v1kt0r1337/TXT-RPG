package game.commands;

import game.Character;
import game.Player;
import game.items.*;
import game.attributes.*;

import java.util.ArrayList;
import java.util.Random;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by archheretic on 24.05.15.
 */
public abstract class CommandsUsingSpells extends Command{
    protected Timer timer;
    protected TimerTask removeBuff;
    protected Character target;
    protected Character targetOfMagic;

    /**
     * Constructor for objects of class CommandsUsingSpells
     */
    public CommandsUsingSpells(String name, String description)
    {
        super(name, description);
    }

    /**
     * Activates the magic properties of the spell.
     *
     * @param magic an Array containing the magic information.
     *              (this.target, spellEffect, theMagnitude, duration,
     *              totalCost, spellDesc)
     */
    protected void activateMagic(String[] magic) {
        Random rand = new Random();
        int min = Integer.parseInt(magic[2]);
        int max = Integer.parseInt(magic[3]);
        int magnitude = rand.nextInt((max - min) + 1) + min;

        System.out.println("(" + targetOfMagic.getName() + ": " + magic[6]);

        if (Integer.parseInt(magic[4]) < 0) {
            permanentEffect(magic, magnitude);
        } else {
            temporaryEffect(magic, magnitude);
        }
    }

    /**
     * Adds a permanent effect
     */
    protected void permanentEffect(String[] magic, int magnitude) {

        if (EFFECT_INCREASE_MAXWEIGHT_EFFECTS.equals(magic[1])) {
            // the second param "0" should not be hardcoded,
            // this is multiplier.
            RawBonus increaseWeightLimit = new RawBonus(magnitude, 0);
            targetOfMagic.getMaxWeight().addRawBonus(increaseWeightLimit);
        } else if (EFFECT_VITALITY.equals(magic[1])) {
            RawBonus vitality = new RawBonus(magnitude, 0);
            targetOfMagic.getVitality().addRawBonus(vitality);
        } else if (EFFECT_STRENGTH.equals(magic[1])) {
            RawBonus strength = new RawBonus(magnitude, 0);
            targetOfMagic.getStrength().addRawBonus(strength);
        } else if (EFFECT_INTELLIGENCE.equals(magic[1])) {
            RawBonus intelligence = new RawBonus(magnitude, 0);
            targetOfMagic.getIntelligence().addRawBonus(intelligence);
        } else if (EFFECT_DEXTERITY.equals(magic[1])) {
            RawBonus dexterity = new RawBonus(magnitude, 0);
            targetOfMagic.getDexterity().addRawBonus(dexterity);
        }
    }

    /**
     * Adds a Temporary effect
     */
    private void temporaryEffect(String[] magic, int magnitude) {
        timer = new Timer();
        long dur = Integer.parseInt(magic[4]) * 1000;
        if (EFFECT_INCREASE_MAXWEIGHT_EFFECTS.equals(magic[1])) {
            FinalBonus increaseWeightLimit = new FinalBonus(magnitude,
                    0);
            targetOfMagic.getMaxWeight().addFinalBonus(increaseWeightLimit);

            removeBuff = new TimerTask() {
                @Override
                public void run() {
                    onTimerEndRevertMaxWeight(increaseWeightLimit);
                }
            };

            timer.schedule(removeBuff, dur);
        } else if (EFFECT_VITALITY.equals(magic[1])) {
            FinalBonus vitality = new FinalBonus(magnitude,
                    0);

            targetOfMagic.getVitality().addFinalBonus(vitality);

            removeBuff = new TimerTask() {
                @Override
                public void run() {
                    onTimerEndRevertVitality(vitality);
                }
            };

            timer.schedule(removeBuff, dur);
        } else if (EFFECT_STRENGTH.equals(magic[1])) {
            FinalBonus strength = new FinalBonus(magnitude,
                    0);
            targetOfMagic.getStrength().addFinalBonus(strength);

            removeBuff = new TimerTask() {
                @Override
                public void run() {
                    onTimerEndRevertStrength(strength);
                }
            };
        } else if (EFFECT_INTELLIGENCE.equals(magic[1])) {
            FinalBonus intelligence = new FinalBonus(magnitude,
                    0);
            targetOfMagic.getIntelligence().addFinalBonus(intelligence);

            removeBuff = new TimerTask() {
                @Override
                public void run() {
                    onTimerEndRevertIntelligence(intelligence);
                }
            };
        } else if (EFFECT_DEXTERITY.equals(magic[1])) {
            FinalBonus dexterity = new FinalBonus(magnitude,
                    0);
            targetOfMagic.getDexterity().addFinalBonus(dexterity);

            removeBuff = new TimerTask() {
                @Override
                public void run() {
                    onTimerEndRevertDexterity(dexterity);
                }
            };
        }
    }

    /**
     *
     */
    private void onTimerEndRevertMaxWeight(FinalBonus buffToBeRemoved)
    {
        targetOfMagic.getMaxWeight().removeFinalBonus(buffToBeRemoved);
    }

    /**
     *
     */
    private void onTimerEndRevertVitality(FinalBonus buffToBeRemoved)
    {
        targetOfMagic.getVitality().removeFinalBonus(buffToBeRemoved);
    }

    /**
     *
     */
    private void onTimerEndRevertStrength(FinalBonus buffToBeRemoved)
    {
        targetOfMagic.getStrength().removeFinalBonus(buffToBeRemoved);
    }

    /**
     *
     */
    private void onTimerEndRevertIntelligence(FinalBonus buffToBeRemoved)
    {
        targetOfMagic.getIntelligence().removeFinalBonus(buffToBeRemoved);
    }

    /**
     *
     */
    private void onTimerEndRevertDexterity(FinalBonus buffToBeRemoved)
    {
        targetOfMagic.getDexterity().removeFinalBonus(buffToBeRemoved);
    }
}
