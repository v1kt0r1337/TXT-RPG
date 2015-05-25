package game;

import game.world.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

/**
 * The game class of the TXT RPG Project.
 * 
 * @author Viktor
 * @version xx
 */

public class Game implements ResourceBundle
{

    private Player player;
    private Scanner sc;
    
    private World world;
    // Move counter only gets incremented when player does 
    // something time consuming.
    private HashMap<Long, Entity> allEntities;
    private ArrayList<Entity> entityActionPriority;
    private ArrayList<Entity> entityList;
    private ArrayList<Entity> newEntityPriority;
    private static int timeCounter;
    
    boolean playerSameZone;

    /**
      * Create the game and initialise its internal map.
      */
    public Game() 
    {
        timeCounter = 0;  

        this.world = new World();
        allEntities = new HashMap<Long, Entity>();
        
        entityActionPriority = new ArrayList<Entity>();
        newEntityPriority = new ArrayList<Entity>();
        entityList = new ArrayList<Entity>();
        
        play();
    }
    
    /**
     *  Main play routine.  Loops until end of play.
     */
    private void play() 
    {            
        printWelcome();
        createPlayer();

        int time;
        int i;
        while (!player.isGameOver()) {
            getActionPriority();
            playerSameZone = true;
            while (playerSameZone && (!player.isGameOver())) { 
                i = 0;
                while ((playerSameZone) && (i < entityActionPriority.size() 
                      && (!player.isGameOver()))) {
                    
                    if (entityActionPriority.get(i) instanceof Player) {
                        time = timeCounter;
                        while ((time == timeCounter) 
                               && (!player.isGameOver())) {
                            player.action();
                        }
                    }
                    else {
                        ((Character)entityActionPriority.get(i)).action();
                    }
                    i++;
                }
            }
        }
        System.out.println(MSG_BYE);
    }

    /**
     * Creates the player
     * 
     */
    private void createPlayer()
    {
        this.sc = new Scanner(System.in);
        System.out.println(MSG_WHAT_NAME);
        // There needs to be a check to see that first letter is not a number.
        // Also the char ; is NOT allowed.
        String name = sc.next();
        System.out.println(WHICH_RACE_BORN);
        boolean validRace = false;
        String raceTemplate = "";
        while (!validRace) {
            System.out.println(YOU_CAN_CHOOSE + " " + HUMAN + ", " + ELF 
                               + " or " + DWARF);
            raceTemplate = sc.next();
            if (raceTemplate.equals(HUMAN) || raceTemplate.equals(ELF) || 
                raceTemplate.equals(DWARF)) {
                validRace = true;
            }
        }    
        
        player = new Player(name, PLAYER_DESC, raceTemplate, 
                            world.getLocation(STARTLOC_NAME), this);
        
        System.out.println();
        System.out.println(player.getLocation().getLongDescription());
    }

    /**
     * Change the playeSameZone variable;
     * @param newValue the new value
     */
    public void setPlayerSameZone(boolean newValue)
    {
        playerSameZone = newValue;
    }

    /**
     * Initiate entityActionPriority
     */
    private void initiateEntityActionPriority()
    {
        for (Location loc : world.getLocList()) {
            for (Entity entity : loc.getEntityList()) {
                entityActionPriority.add(entity);  
                entityList.add(entity);
                allEntities.put(entity.getId(), entity); 
            }
        }
    }
    
    /**
     * Print out the opening message for the player.
 */
    private void printWelcome()
    {
        System.out.println();
        System.out.println(MSG_WELCOME1);
        System.out.println(MSG_WELCOME2);
        System.out.println(MSG_WELCOME3);
        System.out.println(MSG_WELCOME4);
        System.out.println(MSG_WELCOME5);
        System.out.println();
    }
    
    /**
     * Increment the time by one count
     * 
     */
    public void incrementTime()
    {
        timeCounter += 1;
    }
    
    /**
     * Creates the new action priority list for the
     * worlds entities.
     * 
     */
    public void getActionPriority()
    {
        initiateEntityActionPriority();
        playerSameZone = false;
        
        ArrayList<String> actionPriority = new ArrayList<String>();
        
        int initiativeRoll = 0;
        
        for (Location loc : world.getLocList()) {
            if ((player.getLocation() == loc) && 
                (loc.getEntityList().size() > 1)) {  
                System.out.println("Initiative rolls");
            }
            
            for (Entity entity : loc.getEntityList()) {
                if (entity instanceof Character) {
                    initiativeRoll = ((Character)entity).rollInitiative();
                    if ((player.getLocation() == loc) && 
                        (loc.getEntityList().size() > 1)) {
                        System.out.println(entity.getName() + " " 
                                           + initiativeRoll);
                    }
                    
                    actionPriority.add(initiativeRoll + ";" 
                                       + ((Character)entity).getId());
                }
            }
        }
    Collections.sort(actionPriority);
        long entityId = 0;
        
        newEntityPriority.clear();
        for (int i = actionPriority.size() - 1; i >= 0; i--) {
            entityId = Long.parseLong(actionPriority.get(i).split(";")[1]);
            newEntityPriority.add(allEntities.get(entityId));   
            
        } 
        
        entityActionPriority = newEntityPriority;
    }
    
    /**
     * The main method of the program where the game gets initiated.
     * 
     * @param args the program takes in, this should be empty.
     */
    public static void main(String[] args) 
    {
        Game game = new Game();
    }
}
