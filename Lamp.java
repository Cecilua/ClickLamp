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
    

    
    
    private final int STANDWIDTH = 10; // linewidth of stand
    private int standHeight; // height of stand
    
    private double standTop; // stand top 
    private double standLeft; // left of stand 
    private double standBottom; // bottom of stand
    
    
    //private double switchLeft; // switch left
    //private double switchTop; // switch top 
    //private double switchBottom; // switch bottom
    
    //private int switchHeight; // height of the switch
    //private final int SWITCHWIDTH = 10; // width of the switch 
    
    /**
     * Constructor for objects of class Lamp
     */
    public Lamp(double x, double y, int size, int sHeight, Color col)
    {
        // initialise instance variables
        lampX = x;
        lampY = y;
        lampSize = size;
        standHeight = sHeight;
        color = col;
        
        // set top, left and bottom of lamp
        setTop();
        setLeft();
        setBottom();
        
        // set top, left and bottom of switch
        standTop = lampBottom;
        setStandLeft();
        setStandBottom();
        
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
     * set left of stand 
     */
    public void setStandLeft(){
        this.standLeft = this.lampX - STANDWIDTH/2;
    }
    
    /**
     * set bottom of stand 
     */
    public void setStandBottom(){
        this.standBottom = (this.lampY + this.lampSize/2.0) + standHeight;
    }
    
    /**
     * getter method for bulb left 
     */
    public double getBulbLeft() {
        return this.lampLeft = this.lampX - this.lampSize/2.0;
    } 
    
    /**
     * getter method for bulb right 
     */
    public double getBulbRight() {
         return this.lampLeft + this.lampSize;
    } 
    
    /**
     * getter method for bulb top 
     */
    public double getBulbTop() {
        return this.lampTop = this.lampY - this.lampSize/2.0;
    }
    
    /**
     * getter method for bulb bottom
     */
    public double getBulbBottom() {
        return this.lampBottom = this.lampY + this.lampSize/2.0; 
    }
    
    /**
     * getter method for stand top 
     */
    public double getStandTop() {
        return this.standTop;
    } 
    
    /**
     * getter method for stand left 
     */
    public double getStandLeft() {
        return this.lampX - STANDWIDTH/2;
    } 

    /**
     * getter method for stand right 
     */
    public double getStandRight() {
        return this.lampX + STANDWIDTH/2;
    } 
    
    /**
     * getter method for stand bottom 
     */
    public double getStandBottom() {
        return this.standTop + standHeight;
    } 
    
    /**
     * draw the lamp 
     */
    public void draw() {
        UI.setColor(this.color);
        UI.fillOval(lampLeft, lampTop, lampSize, lampSize); // draw lamp bulb
        
        // draw the stand
        UI.setColor(Color.gray); 
        UI.setLineWidth(STANDWIDTH);
        UI.drawLine(lampX, standTop, lampX, standBottom); // draw stand 
        
    } 
    
    /**
     * return true if point (x, y) is on the lamp bulb
     */
    public boolean onBulb(double x, double y) {
        if(x >= this.getBulbLeft() && x <= this.getBulbRight() && y >= this.getBulbTop() && y <= this.getBulbBottom()) {
            return true;
        } else {
            return false; 
        }
    } 
    
    /**
     * return true if point (x, y) is on the lamp stand
     */
    public boolean onStand(double x, double y){
        if(x >= this.getStandLeft() && x <= this.getStandRight() && y >= this.getStandTop() && y <= this.getStandBottom()) {
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
    
    public void changeColor() {
        this.eraseBulb(); // erase the bulb
        color = Color.getHSBColor((float)(Math.random()), 1.0f, 1.0f);
        UI.setColor(color);
        this.draw(); 
    
    }
    
    public void turnOff() {
        this.eraseBulb(); // erase the bulb
        UI.setColor(Color.black);
        this.draw(); 
    }
}
