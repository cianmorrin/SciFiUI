package ie.tudublin;

import processing.core.PApplet;

public class Shapes
{
    UI ui;
  
    private float x ;
    private float y ;
    

    public Shapes(UI ui, float x, float y)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
    }

    public void render()
    {   
        ui.fill(0);
        ui.rect(x, y, 40, 40);
        ui.pushMatrix();
        ui.translate(60, 80);
        ui.rect(x, y, 40, 40);
        ui.popMatrix();
    }
}