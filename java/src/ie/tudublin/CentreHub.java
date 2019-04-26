package ie.tudublin;

import processing.core.PApplet;

public class CentreHub
{
    UI ui;
    private float width;
    private float height;
    private float PI;
    private float QUARTER_PI;
    private float HALF_PI;
    private float TWO_PI;
    private float angle;
    private float jitter;


    public CentreHub(UI ui, float width, float height, float PI, float QUARTER_PI, float HALF_PI, float TWO_PI, float angle, float jitter )
    {
        this.ui = ui;
        this.width = width;
        this.height = height;
        this.PI = PI;
        this.QUARTER_PI = QUARTER_PI;
        this.HALF_PI = HALF_PI;
        this.TWO_PI = TWO_PI;
        this.angle = angle;
        this.jitter = jitter;
    }

    public void render()
    {
        // Drawing of centre circle
        ui.noFill();
        ui.stroke(204, 255, 255);
       
        ui.strokeWeight(6);
        ui.circle(width/2, height/2, 300);

        ui.strokeWeight(4);
        ui.circle(width/2, height/2, 250);
       
        ui.strokeWeight(8);
        ui.arc(width/2, height/2, 310, 310, PI+QUARTER_PI, TWO_PI);

        ui.strokeWeight(2);
        ui.arc(width/2, height/2, 340, 340, HALF_PI, PI);

        ui.strokeWeight(1);
        ui.arc(width/2, height/2, 320, 320, PI, PI+QUARTER_PI);

        // From here all arcs rotate 
        if (PApplet.second() % 2 == 0)
         {  
            jitter = ui.random(-0.1f, 0.1f);
          }
          
          angle = angle + jitter;
          float c = PApplet.cos(angle);
          ui.translate(width/2, height/2);
          ui.rotate(c);

        ui.strokeWeight(8);
        ui.arc(0, 0, 400, 400, PI+QUARTER_PI, TWO_PI);

        ui.strokeWeight(7);
        ui.arc(0, 0, 360, 360, HALF_PI, PI);

        ui.strokeWeight(1);
        ui.arc(0, 0, 350, 350, PI, PI+QUARTER_PI);

        ui.strokeWeight(4);
        ui.arc(0, 0, 350, 350, 0, HALF_PI);


        ui.strokeWeight(14);
        ui.arc(0, 0, 405, 405, PI, PI+QUARTER_PI);

        ui.strokeWeight(12);
        ui.arc(0, 0, 405, 405, 0, HALF_PI);

        ui.strokeWeight(6);
        ui.arc(0, 0, 400, 400, HALF_PI, PI);

       
        ui.strokeWeight(4);
        ui.arc(0, 0, 370, 370, PI+QUARTER_PI, TWO_PI);

    }
}