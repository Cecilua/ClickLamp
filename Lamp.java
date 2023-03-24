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
    // instance variables
    private double bulbX;   // bulb x pos 
    private double bulbY;   // bulb y pos 
    
    private int bulbSize;   // set lamp size 
    private double lampLeft;    // left of lamp
    private double lampTop;     // top of lamp
    private double bulbBottom;  // bottom of bulb
    
    private Color color; 
    
    private final int STANDWIDTH = 10; // linewidth of stand
    private int standHeight; // height of stand
    
    private double standTop; // stand top 
    private double standLeft; // left of stand 
    private double standBottom; // bottom of stand
    
    final int BUFFER = 1; 
    
    /**
     * Constructor for objects of class Lamp
     */
    public Lamp(double x, double y, int size, int sHeight, Color col)
    {
        // initialise instance variables
        bulbX = x;
        bulbY = y;
        bulbSize = size;
        standHeight = sHeight;
        color = col;
        
        // set top, left and bottom of bulb
        setTop();
        setLeft();
        setBulbBottom();
        
        // set top, left and bottom of switch
        standTop = bulbBottom + BUFFER;
        setStandLeft();
        setStandBottom();
        
    }
    
    /**
     * set left 
     */
    public void setLeft() {
        this.lampLeft = this.bulbX - this.bulbSize/2.0;
    } 
    
    /**
     * set top 
     */
    public void setTop() {
        this.lampTop = this.bulbY - this.bulbSize/2.0;
    }
    
    /**
     * set bottom
     */
    public void setBulbBottom() {
        this.bulbBottom = this.bulbY + this.bulbSize/2.0; 
    }

    /**
     * set left of stand 
     */
    public void setStandLeft(){
        this.standLeft = this.bulbX - STANDWIDTH/2;
    }
    
    /**
     * set bottom of stand 
     */
    public void setStandBottom(){
        this.standBottom = (this.bulbY + this.bulbSize/2.0) + standHeight;
    }
    
    /**
     * getter method for bulb left 
     */
    public double getBulbLeft() {
        return this.lampLeft = this.bulbX - this.bulbSize/2.0;
    } 
    
    /**
     * getter method for bulb right 
     */
    public double getBulbRight() {
         return this.lampLeft + this.bulbSize;
    } 
    
    /**
     * getter method for bulb top 
     */
    public double getBulbTop() {
        return this.lampTop = this.bulbY - this.bulbSize/2.0;
    }
    
    /**
     * getter method for bulb bottom
     */
    public double getBulbBottom() {
        return this.bulbBottom = this.bulbY + this.bulbSize/2.0; 
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
        return this.bulbX - STANDWIDTH/2;
    } 

    /**
     * getter method for stand right 
     */
    public double getStandRight() {
        return this.bulbX + STANDWIDTH/2;
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
        // draw the stand
        UI.setColor(Color.gray); 
        UI.setLineWidth(STANDWIDTH);
        UI.drawLine(bulbX, standTop, bulbX, standBottom); // draw stand 
        
        // draw the bulb
        UI.setColor(this.color);
        UI.fillOval(lampLeft, lampTop, bulbSize, bulbSize); // draw lamp bulb
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
        UI.eraseRect(lampLeft, lampTop, bulbSize + BUFFER, bulbBottom + BUFFER);
    }
    
    public void changeColor() {
        this.eraseBulb(); // erase the bulb
        color = Color.getHSBColor((float)(Math.random()), 1.0f, 1.0f);
        UI.setColor(color);
        this.draw(); 
    }
    
    public void turnOff() {
        this.eraseBulb(); // erase the bulb
        this.color = Color.black;
        this.draw(); 
    }
    
    public boolean isLampOn() {
        if(color == Color.black) {
            UI.println("lamp is off");
            return false;
        } else {
            UI.println("lamp is on");
            return true;
        }
    }
}
