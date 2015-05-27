import sofia.micro.*;
import sofia.micro.greeps.*;
import static sofia.micro.jeroo.RelativeDirection.*;
import sofia.util.Random;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your test class here.
 *  Summarize what your test objectives are.
 *
 *  @author your name (your-pid)
 *  @version (place the date here, in this format: yyyy.mm.dd)
 */
public class GreepTest extends TestCase
{
    //~ Fields ................................................................
    private Greep carrier;
    private Greep loader;
    private Earth island;
    private Ship ship;

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new GreepTest test object.
     */
    public GreepTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }

    //~ Methods ...............................................................
    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        island = new Earth();
        carrier = new Greep();
        loader = new Greep();
        Tomato t = new Tomato();
        ship = island.getObjects(Ship.class).iterator().next();

        island.add(carrier, 18, 48);
        island.add(loader, 19, 48);
        island.add(t, 19, 48);
        island.add(ship, 10, 48);
    }

    // ----------------------------------------------------------
    /**
     * 
     */
    public void testLoadingTomato()
    {
        assertFalse(carrier.hasTomato());

        loader.turn(LEFT);
        loader.turn(LEFT);
        loader.loadTomato(AHEAD);

        assertTrue(carrier.hasTomato());

    }

    /**
     * 
     */
    public void testActLoadTomato()
    {
        Random.setNextInts(0);
        assertFalse(carrier.hasTomato());

        loader.turn(LEFT);
        loader.turn(LEFT);
        loader.act();

        assertTrue(carrier.hasTomato());

    }

    /**
     * 
     */
    public void testUnloadTomato()
    {
        assertFalse(carrier.hasTomato());

        loader.turn(LEFT);
        loader.turn(LEFT);
        loader.loadTomato(AHEAD);
        carrier.turnTowardShip();
        carrier.hop();
        carrier.hop();
        carrier.hop();
        carrier.hop();
        carrier.hop();
        carrier.hop();
        carrier.hop();
        carrier.unloadTomato();

        assertFalse(carrier.hasTomato());

    }    
}
