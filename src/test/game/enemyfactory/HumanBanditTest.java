package game.enemyfactory;

import game.world.*;
import game.Character;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HumanBanditTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class HumanBanditTest
{
    private World world;
    private Location loc;
    private EnemyFactory enemyFactory;

    /**
     * Default constructor for test class HumanBanditTest
     */
    public HumanBanditTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    /**
     *  Checks that the object created is indeed an instance of
     *  HumanBandit and its super classes.
     */
    @Test
    public void isHumanBandit()
    {
        game.enemyfactory.HumanBandit humanBan1 = new game.enemyfactory
                                                      .HumanBandit();
        assertNotNull(humanBan1);
        assertThat(humanBan1, instanceOf(HumanBandit.class));
        assertThat(humanBan1, instanceOf(Enemy.class));
        assertThat(humanBan1, instanceOf(Character.class));
    }
    
    /**
     *  Test that the initialized bandit is not null.
     */
    @Test
    public void notNull()
    {
        game.enemyfactory.HumanBandit humanBan1 = new game.enemyfactory
                                                      .HumanBandit();
    }

    /**
     * Tests the whatFood method of the humanBandit, tests that its 
     * equal to the food that the bandit eats.
     */
    @Test
    public void testWhatFood()
    {
        game.enemyfactory.HumanBandit humanBan1 = new game.enemyfactory
                                                      .HumanBandit();
        assertEquals("I eat burgers.", humanBan1.whatFood());
    }
}



