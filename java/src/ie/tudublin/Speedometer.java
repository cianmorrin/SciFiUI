package ie.tudublin;


import processing.core.PApplet;
import processing.core.PVector;

public class Speedometer extends PApplet
{
    
    private PVector pos;
    private UI ui;
    
    //private float diameter = 300;
   

    public Speedometer(UI ui, float x, float y)
    {
        this.ui = ui;
        pos = new PVector(x, y);
    }





    float lerpedAverage = 0;

    public void render()
    {
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

        ui.line((pos.x - 100), (pos.y + 40), (pos.x + 200 ), (pos.y + 40));

        ui.fill(0);
        ui.arc((pos.x + 50),(pos.y + 40), 300, 300, -PI, 0);
        ui.fill(192,192,192);
        ui.noStroke();
        ui.arc((pos.x + 50),(pos.y + 40), 80, 80, -PI, 0);

        ui.fill(0);
        ui.stroke(204, 255, 255);

        //right box
        ui.rect(pos.x + 170, pos.y  - 120, 60, 60);
        //left box
        ui.rect(pos.x - 130, pos.y  - 120, 60, 60);

        ui.stroke(204, 255, 255);
        ui.line(pos.x - 120, pos.y  - 90, pos.x - 80, pos.y  - 90);
        ui.line(pos.x + 180, pos.y  - 90, pos.x + 220, pos.y  - 90);
        ui.line(pos.x + 200, pos.y  - 110, pos.x + 200, pos.y  - 70);


        
    }

    

    public void update()
    {
       
        

        

       

    }

    

    
}