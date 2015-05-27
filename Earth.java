import sofia.micro.greeps.*;

//-------------------------------------------------------------------------
/**
 *  The landing zone for the Greeps' space ship.
 *  
 *  DO NOT EDIT THIS CLASS. It will not be included as part of your
 *  solution.
 *
 *  @author Stephen Edwards (stedwar2)
 *  @version 2013.02.25
 */
public class Earth extends Planet
{
    //~ Constructors ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Earth object that will run through all
     * three predefined maps sequentially.
     */
    public Earth()
    {
        super(Greep.class);
    }


    // ----------------------------------------------------------
    /**
     * Creates a new Earth object with a specified map.
     * @param map A number from 1-3 indicating which predefined
     *            map should be used for this new world.
     */
    public Earth(int map)
    {
        super(map, Greep.class);
    }
}
