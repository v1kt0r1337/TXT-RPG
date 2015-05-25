package game.enemyfactory;

import game.Entity;
import game.Character;
import game.Player;
import game.ResourceBundle;
import game.commands.Command;
import game.items.*;

import java.util.Iterator;

import java.util.ArrayList;
/**
 * This is an abstract class used by the EnemyFactory pattern to
 * create enemies.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Enemy extends Character implements ResourceBundle
{
    /**
     * This is the main constructor.
     *
     * @param name the name of the enemy
     * @param description the description of the enemy
     * @param raceTemplate the race template used for the enemy.
     */
    public Enemy(String name, String description, String raceTemplate) {
        super(name, description, raceTemplate);
        setPlayerFaction(0);
    }
    /**
     * The action the Enemy is able to do and will do depending on the
     * situations.
     *
     * This method will first check if the Player is in the same location as
     * this enemy. If the player is here, the enemy will then check his
     * standing with the player. If he is not a friend of the Player or the
     * Player is not a friend of the bandits faction, then he will attack.
     *
     */
    @Override
    public void action() {
//          supposed to be <
        if (getCurrentHp() <= 0) {
            dead();
            return;
        }

        else if (getLocation().getEntityList().size() > 1) {
            for (Entity entity : getLocation().getEntityList()) {
                if ((entity instanceof Player) && ((getPlayerFaction() < 4)
                        || ((Player)entity).getBanditFaction() > 6)) {
                    ArrayList<String> cmdLine = new ArrayList<String>();
                    cmdLine.add(ATTACK);
                    cmdLine.add(entity.getName());
                    Command cmd = commands.getCommand(cmdLine.get(0));
                    cmd.execute(this, cmdLine);
                }
            }
        }
    }

    /**
     *
     */
    public void dead()
    {
        System.out.println(getName() + " " + DIED + "!");

        if (getAmountOfInventoryItems() + equipment.getAmountOfEquipedItems() > 0) {
            //                                should have a gender check.
            System.out.println(getName() + "'s items drops to the floorv");

            ArrayList<String> cmdLine = new ArrayList<String>();
            cmdLine.add(UNEQUIP);
            cmdLine.add("all");
            Command cmd = commands.getCommand(cmdLine.get(0));
            cmd.execute(this, cmdLine);

            cmdLine = new ArrayList<String>();
            cmdLine.add(DROP);
            cmdLine.add("all");
            cmd = commands.getCommand(cmdLine.get(0));
            cmd.execute(this, cmdLine);
        }
        getLocation().removeEntity(this);
    }

    /**
     * This method is just to showcase casting,
     * and the difference between dynamic and static type.
     * It returns a String with some info about the class.
     *
     * @return info about the class.
     */
    public static String infoAboutMe()
    {
        return ENEMY_INFO;
    }

    /**
     * This method made to showcase polymorphism.
     * It returns string containing
     * What the enemy likes to eat, since the enemy is not a
     * concrete person, but just and abstract adversery of the player
     * it makes sense that this method is also abstract.
     *
     * @return a string of what the enemy likes to eat.
     */
    abstract public String whatFood();
}