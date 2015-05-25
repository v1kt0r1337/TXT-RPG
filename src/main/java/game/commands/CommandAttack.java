package game.commands;

import game.Character;
import game.Player;
import game.ResourceBundle;
import game.items.*;
import game.attributes.*;


import java.util.ArrayList;
import java.util.Random;

/**
 * The class CommandAttack is for when a 
 * character executes an attack.
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CommandAttack extends CommandsUsingSpells {

    /**
     * Constructor for objects of class CommandAttack
     */
    public CommandAttack() {
        super(ATTACK, ATTACK_DESC);
    }

    /**
     * Executes the attack.
     *
     * @param c       the character that attacks
     * @param cmdLine should contain the name of the target.
     */
    public void execute(Character c, ArrayList<String> cmdLine) {
        this.c = c;
        String targetName = "";
        if (cmdLine.size() == 1) {
            System.out.println(ATTACK_WHO);
            return;
        } else if (cmdLine.size() == 2) {
            targetName = cmdLine.get(1);
        } else {
            targetName = "";
            for (int i = 1; i < cmdLine.size(); i++) {
                targetName = targetName + " " + cmdLine.get(i);
            }
        }

        target = ((Character) c.getLocation()
                .getEntityByName(targetName.trim()));

        if (target == null) {
            // if there is no second word, we don't know what to pick up...
            System.out.println(NO_TARGET_BY_THAT_NAME + "!");
            return;
        } else {
            attack();
        }
    }

    /**
     * Attacks the targeted character.
     */
    public void attack() {

        Random rand = new Random();
        int minDmg = c.getDamageBonusFromAttributes()
                + c.getEquiped().getItemMinDamage();

        int maxDmg = c.getDamageBonusFromAttributes()
                + c.getEquiped().getItemMaxDamage();

        int theDmg = rand.nextInt((maxDmg - minDmg) + 1) + minDmg;

        target.setCurrentHp(target.getCurrentHp() - theDmg);

        System.out.println(c.getName() + " dealt " + theDmg
                + " dmg to " + target.getName());

        System.out.println(target.getName() + "'s" + " Health: "
                + target.getCurrentHp() + "/"
                + target.getMaxHealth());

        System.out.println("");
        if ((target.getCurrentHp() <= 0) && (target instanceof Player)) {
            System.out.println("You got killed by " + c.getName() + "!");
            System.out.println("Game over!");
            ((Player) target).setGameOver(true);
        }

        onHitSpellEffects();
    }

    /**
     * Activates all the on hit Magics of the spell binded into the weapons.
     */
    private void onHitSpellEffects() {

        for (ItemEquipable item : c.getEquiped().getEquipmentList()) {
            if (item.getItemSlot().equals(HAND_SLOT)) {
                for (String magic1 : item.SpellOnHit()) {
                    String[] magic = magic1.split("#");

                    if (MAGIC_TARGET_SELF.equals(magic[0])) {
                        targetOfMagic = c;
                        activateMagic(magic);
                    } else if (MAGIC_TARGET_ENEMY.equals(magic[0])) {
                        targetOfMagic = target;
                        activateMagic(magic);
                    } else {
                        System.out.println("MAGIC EFFECT WITH INVALID TARGET");
                    }
                }
            }
        }
        if (c instanceof Player) {
            ((Player) c).getGame().incrementTime();
        }
    }
///*
//
//    */
//     * Activates The magic effect of the spell.
//     *
//     * @param magic an Array containing the magic information.
//     *              (this.target, spellEffect, theMagnitude, duration,
//     *              totalCost, spellDesc)
//     *//*
//
//    private void activateHitMagic(String[] magic) {
//        Random rand = new Random();
//        int min = Integer.parseInt(magic[2]);
//        int max = Integer.parseInt(magic[3]);
//        int magnitude = rand.nextInt((max - min) + 1) + min;
//
//
//        if (EFFECT_INCREASE_MAXWEIGHT_EFFECTS.equals(magic[1])) {
//            // -1 in this case means that its a permanent effect.
//            if (Integer.parseInt(magic[4]) == -1) {
//                // the second param "0" should not be hardcoded,
//                // this is multiplier.
//                RawBonus increaseWeightLimit = new RawBonus(magnitude, 0);
//                targetOfMagic.getMaxWeight().addRawBonus(increaseWeightLimit);
//            } else {
//
//                FinalBonus increaseWeightLimit = new FinalBonus(magnitude,
//                        0);
//
//                targetOfMagic.getMaxWeight().addFinalBonus(increaseWeightLimit);
//            }
//        }
//
//        else if (EFFECT_VITALITY.equals(magic[1])) {
//            // -1 in this case means that its a permanent effect.
//            if (Integer.parseInt(magic[4]) == -1) {
//                // the second param "0" should not be hardcoded,
//                // this is multiplier.
//                RawBonus vitality = new RawBonus(magnitude, 0);
//                targetOfMagic.getVitality().addRawBonus(vitality);
//            } else {
//
//                FinalBonus vitality = new FinalBonus(magnitude,
//                        0);
//
//                targetOfMagic.getVitality().addFinalBonus(vitality);
//            }
//        }
//
//        else if (EFFECT_STRENGTH.equals(magic[1])) {
//            // -1 in this case means that its a permanent effect.
//            if (Integer.parseInt(magic[4]) == -1) {
//                // the second param "0" should not be hardcoded,
//                // this is multiplier.
//                RawBonus strength = new RawBonus(magnitude, 0);
//                targetOfMagic.getStrength().addRawBonus(strength);
//            } else {
//
//                FinalBonus strength = new FinalBonus(magnitude,
//                        0);
//
//                targetOfMagic.getStrength().addFinalBonus(strength);
//            }
//        }
//
//        else if (EFFECT_INTELLIGENCE.equals(magic[1])) {
//            // -1 in this case means that its a permanent effect.
//            if (Integer.parseInt(magic[4]) == -1) {
//                // the second param "0" should not be hardcoded,
//                // this is multiplier.
//                RawBonus intelligence = new RawBonus(magnitude, 0);
//                targetOfMagic.getIntelligence().addRawBonus(intelligence);
//            } else {
//
//                FinalBonus intelligence = new FinalBonus(magnitude,
//                        0);
//
//                targetOfMagic.getIntelligence().addFinalBonus(intelligence);
//            }
//        }
//    }
//
//
//
//*/



}
