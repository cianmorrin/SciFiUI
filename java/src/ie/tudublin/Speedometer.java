package ie.tudublin;


import processing.core.PApplet;
import processing.core.PVector;

public class Speedometer extends PApplet
{
    
    private PVector pos;
    private UI ui;

    private float xradiusLine;
    private float yradiusLine;
    private float x; 
    private float y; 
    private float pointerLineX;
    private float pointerLineY;
    private float moverX = 210;
    private float moverY = 210;

    float radius=100f; // radius
    

    int innerRadius =65; // text radius
    public int textCounter = 80; // text counter
   

    public Speedometer(UI ui, float x, float y)
    {
        this.ui = ui;
        pos = new PVector(x, y);
        
    }

    

    public void render()
    {
        ui.strokeWeight(3); 
        ui.noStroke();
        ui.fill(41, 45, 70);
        ui.rect((pos.x - 150 ) , (pos.y - 150), 400, 220);

        ui.stroke(204, 255, 255);
        //top left
        ui.line((pos.x - 150 ), (pos.y - 150), (pos.x - 110 ), (pos.y - 150));
        ui.line((pos.x - 150 ), (pos.y - 150), (pos.x - 150 ), (pos.y - 110));

        //top right
        ui.line((pos.x + 250 ), (pos.y - 150), (pos.x + 210 ), (pos.y - 150));
        ui.line((pos.x + 250 ), (pos.y - 150), (pos.x + 250 ), (pos.y - 110));

        //bottom left
        ui.line((pos.x - 150 ), (pos.y + 70), (pos.x - 110 ), (pos.y + 70));
        ui.line((pos.x - 150 ), (pos.y + 70), (pos.x - 150 ), (pos.y + 30));

        //bottom right
        ui.line((pos.x + 250 ), (pos.y + 70), (pos.x + 210 ), (pos.y + 70));
        ui.line((pos.x + 250 ), (pos.y + 70), (pos.x + 250 ), (pos.y + 30));

       
       
        // Centre point for speedometer
        x = pos.x + 50;
        y = pos.y - 40;

        // Large ellipse
        ui.strokeWeight(3); 
        ui.stroke(204, 255, 255);
        ui.fill(41, 45, 70);
        ui.ellipse(x, y, 200, 200); 
        ui.strokeWeight(2); 

        // Markers lines behind ellipse
        for (int i = 0; i <240 ; i+=30) 
        {
            ui.stroke(204, 255, 255);
            xradiusLine=x+radius*(cos(radians(30 + i)));
            yradiusLine=y-radius*(sin(radians(30+ i)));
            ui.line(x, y, xradiusLine, yradiusLine);
        }
        
        // Smaller ellipse infront
        ui.stroke(204, 255, 255); 
        ui.fill(0); 
        ui.ellipse(x, y, 160, 160); 

        // USed for pointer, will be manipulated in draw method
        pointerLineX=x+radius*(cos(radians(30 + moverX)));
        pointerLineY=y-radius*(sin(radians(30 + moverY)));



        ui.line(x, y, pointerLineX, pointerLineY);

        // Example use of pushMatrix, Translate etc
        ui.noStroke();
        ui.pushMatrix(); 
        ui.translate(x,y); 
        ui.rotate(-PI/3);
        ui.fill(204, 255, 255);
        ui.ellipse(0,0,20,20);
        ui.popMatrix(); 
        
       
    
        int speedNums = 800;

        // Method for drawing numbers in correct position
        for (int i = 0; i <240 ; i+=30) 
        {
            xradiusLine = x + innerRadius * (cos(radians(30+i)));
            yradiusLine= y- innerRadius *(sin(radians(30+i)));
            ui.stroke(127);
            ui.fill(255);
            ui.textAlign(CENTER,CENTER); 
            ui.text(speedNums,xradiusLine,yradiusLine);
            speedNums -=100;
          
        }
        ui.strokeWeight(3);
    }

    
    public void update()
    {
        // Space bar acts as an accelerator
        // Decreases when it is let off
        // Has max and min limits
        if (ui.checkKey(' '))
        {
            moverX -= 2;
            moverY -= 2;
            if(pointerLineX > 1276.6025 && pointerLineY > 470.0)
            {
                moverX += 2;
                moverY += 2;
            }
           
        }
        else
        {
            moverX += 0.2;
            moverY += 0.2;
            if(pointerLineX > 1140.0 && pointerLineY > 606.60254)
            {
                moverX -= 0.2;
                moverY -= 0.2;
            }
        }
        
    }

    /**
     * @return the pos
     */
    public PVector getPos() {
        return pos;
    }

    /**
     * @param pos the pos to set
     */
    public void setPos(PVector pos) {
        this.pos = pos;
    }

    /**
     * @return the ui
     */
    public UI getUi() {
        return ui;
    }

    /**
     * @param ui the ui to set
     */
    public void setUi(UI ui) {
        this.ui = ui;
    }

    /**
     * @return the xradiusLine
     */
    public float getXradiusLine() {
        return xradiusLine;
    }

    /**
     * @param xradiusLine the xradiusLine to set
     */
    public void setXradiusLine(float xradiusLine) {
        this.xradiusLine = xradiusLine;
    }

    /**
     * @return the yradiusLine
     */
    public float getYradiusLine() {
        return yradiusLine;
    }

    /**
     * @param yradiusLine the yradiusLine to set
     */
    public void setYradiusLine(float yradiusLine) {
        this.yradiusLine = yradiusLine;
    }

    /**
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public float getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * @return the pointerLineX
     */
    public float getPointerLineX() {
        return pointerLineX;
    }

    /**
     * @param pointerLineX the pointerLineX to set
     */
    public void setPointerLineX(float pointerLineX) {
        this.pointerLineX = pointerLineX;
    }

    /**
     * @return the pointerLineY
     */
    public float getPointerLineY() {
        return pointerLineY;
    }

    /**
     * @param pointerLineY the pointerLineY to set
     */
    public void setPointerLineY(float pointerLineY) {
        this.pointerLineY = pointerLineY;
    }

    /**
     * @return the moverX
     */
    public float getMoverX() {
        return moverX;
    }

    /**
     * @param moverX the moverX to set
     */
    public void setMoverX(float moverX) {
        this.moverX = moverX;
    }

    /**
     * @return the moverY
     */
    public float getMoverY() {
        return moverY;
    }

    /**
     * @param moverY the moverY to set
     */
    public void setMoverY(float moverY) {
        this.moverY = moverY;
    }

    /**
     * @return the radius
     */
    public float getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(float radius) {
        this.radius = radius;
    }

    /**
     * @return the innerRadius
     */
    public int getInnerRadius() {
        return innerRadius;
    }

    /**
     * @param innerRadius the innerRadius to set
     */
    public void setInnerRadius(int innerRadius) {
        this.innerRadius = innerRadius;
    }

    /**
     * @return the textCounter
     */
    public int getTextCounter() {
        return textCounter;
    }

    /**
     * @param textCounter the textCounter to set
     */
    public void setTextCounter(int textCounter) {
        this.textCounter = textCounter;
    }
    
}