package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class Radar
{
    private float radius;
    private PVector pos;
    private float frequency;
    private UI ui;
    private float theta = 0;
    private float x1;
    private float y1;

    public Radar(UI ui, float frequency, float x, float y, float radius)
    {
        this.ui = ui;
        this.frequency = frequency;
        pos = new PVector(x, y);
        this.radius = radius;
    }

    public void render()
    {
        ui.noStroke();
        ui.fill(41, 45, 70);
        ui.rect((pos.x - 150 ) , (pos.y - 150), 300, 300);

        ui.stroke(204, 255, 255);
        //top left
        ui.line((pos.x - 150 ), (pos.y - 150), (pos.x - 110 ), (pos.y - 150));
        ui.line((pos.x - 150 ), (pos.y - 150), (pos.x - 150 ), (pos.y - 110));

        //top right
        ui.line((pos.x + 150 ), (pos.y - 150), (pos.x + 110 ), (pos.y - 150));
        ui.line((pos.x + 150 ), (pos.y - 150), (pos.x + 150 ), (pos.y - 110));

        //bottom left
        ui.line((pos.x - 150 ), (pos.y + 150), (pos.x - 110 ), (pos.y + 150));
        ui.line((pos.x - 150 ), (pos.y + 150), (pos.x - 150 ), (pos.y + 110));

        //bottom right
        ui.line((pos.x + 150 ), (pos.y + 150), (pos.x + 110 ), (pos.y + 150));
        ui.line((pos.x + 150 ), (pos.y + 150), (pos.x + 150 ), (pos.y + 110));


        ui.fill(0);
        ui.ellipse(pos.x, pos.y, radius * 2, radius * 2);
        float x2 = pos.x + (float) Math.sin(theta) * radius;
        float y2 = pos.y - (float) Math.cos(theta) * radius;
        ui.line(pos.x, pos.y, x2, y2);
    }

    float timeDelta = 1.0f / 60.0f;

    public void update()
    {
        theta += PApplet.TWO_PI * timeDelta * frequency;


        float pointillize = ui.map(100, 0, ui.width,2 , 78);
        float x1 = (ui.random(0, 2000));
        float y1 = (ui.random(120, 250));
       
        ui.fill(255);
        
        if( x1 > 1170 && x1 < 1270){
            ui.ellipse(x1, y1, pointillize, pointillize);
        }
        
        
           
        
       
        
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
     * @return the frequency
     */
    public float getFrequency() {
        return frequency;
    }

    /**
     * @param frequency the frequency to set
     */
    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }

    
}