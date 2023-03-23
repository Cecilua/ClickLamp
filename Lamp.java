import ecs100.*;
import java.awt.Color;
/**
 * Lamp support class 
 * creates a lamp. 
 * it can turn off and on and change color. 
 *
 * @author CC
 * @version 21/03/23
 */
public class Lamp
{
    // instance variables - replace the example below with your own
    private double lampX;   // lamp x pos 
    private double lampY;   // lamp y pos 
    
    private int lampSize;   // set lamp size 
    private double lampLeft;    // left of lamp
    private double lampTop;     // top of lamp
    private double lampBottom;  // bottom of lamp
    
    private Color color; 
    
    
    /**
     * Constructor for objects of class Lamp
     */
    public Lamp(double x, double y, int size, Color col)
    {
        // initialise instance variables
        lampX = x;
        lampY = y;
        lampSize = size;
        color = col;
        
        // set top, left and bottom of lamp
        setTop();
        setLeft();
        setBottom();
        
        
    }
    
    /**
     * set left 
     */
    public void setLeft() {
        this.lampLeft = this.lampX - this.lampSize/2.0;
    } 
    
    /**
     * set top 
     */
    public void setTop() {
        this.lampTop = this.lampY - this.lampSize/2.0;
    }
    
    /**
     * set bottom
     */
    public void setBottom() {
        this.lampBottom = this.lampY + this.lampSize/2.0; 
    }
    
    /**
     * getter method for left 
     */
    public double getLeft() {
        return this.lampLeft = this.lampX - this.lampSize/2.0;
    } 
    
    /**
     * getter method for right 
     */
    public double getRight() {
         return this.lampLeft + this.lampSize;
    } 
    
    /**
     * getter method for top 
     */
    public double getTop() {
        return this.lampTop = this.lampY - this.lampSize/2.0;
    }
    
    /**
     * getter method for bottom
     */
    public double getBottom() {
        return this.lampBottom = this.lampY + this.lampSize/2.0; 
    }

    /**
     * draw the lamp 
     */
    public void draw() {
        UI.setColor(this.color);
        UI.fillOval(lampLeft, lampTop, lampSize, lampSize); // draw lamp bulb
    } 
    
    /**
     * return true if point (x, y) is on the lamp bulb
     */
    public boolean onBulb(double x, double y) {
        if(x >= this.getLeft() && x <= this.getRight() && y >= this.getTop() && y <= this.getBottom()) {
            return true;
        } else {
            return false; 
        }
    } 
    
    /**
     * erase a rectangle around the lamp bulb
     */
    public void eraseBulb() {
        final int BUFFER = 1; 
        
        UI.eraseRect(lampLeft, lampTop, lampSize + BUFFER, lampBottom + BUFFER);
    }
}
