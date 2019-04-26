package ie.tudublin;

import processing.core.PApplet;



public class Shapes
{
    UI ui;
  
    private float x ;
    private float y ;
    
  


public int time_stamp = 1;
    public Shapes(UI ui, float x, float y)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
    }

    public void render()
    {   

        

        ui.strokeWeight(3f);
        ui.line(x + 200, 380, x + 300, 200 );
        ui.line(x + 300, 200, x + 340, 200);
        ui.fill(204, 255, 255);
        ui.circle(x + 340, 200, 30);


        // ui.noFill();
        // ui.strokeWeight(0.5f);
        // ui.rect(x, y, 40, 40);
        // ui.pushMatrix();
        // ui.translate(100, 200);
        // ui.rect(x, y, 40, 40);
        // ui.popMatrix();
        // ui.pushMatrix();
        // ui.translate(30, 50);
        // ui.rect(x, y, 40, 40);
        // ui.popMatrix();
        // ui.pushMatrix();
        // ui.translate(400, 60);
        // ui.rect(x, y, 40, 40);
        // ui.popMatrix();
    }

    public void update()
    {
        
  

    }
}