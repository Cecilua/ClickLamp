import ecs100.*;
import java.awt.Color;
/**
 * driver class for lamp support class 
 *
 * @author CC
 * @version 22/03/23
 */
public class DriverLamp
{
    // instance variables - replace the example below with your own
    Lamp l1 = new Lamp(100, 200, 50, Color.pink);

    /**
     * Constructor for objects of class DriverLamp
     */
    public DriverLamp()
    {
        // initialise instance variables
        l1.draw();
    }
}
