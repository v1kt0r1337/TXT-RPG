package game.enemyfactory;

import game.world.*;
import game.Character;

import static org.hamcrest.CoreMatchers.instanceOf;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfBanditTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfBanditTest
{
    /**
     * Default constructor for test class ElfBanditTest
     */
    public ElfBanditTest()
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
     *  ElfBandit and its super classes.
     */
    @Test
    public void isElfBandit()
    {
        game.enemyfactory.ElfBandit elfBan1 = new game.enemyfactory.ElfBandit();
        assertNotNull(elfBan1);
        assertThat(elfBan1, instanceOf(ElfBandit.class));
        assertThat(elfBan1, instanceOf(Enemy.class));
        assertThat(elfBan1, instanceOf(Character.class));
    }    
}
