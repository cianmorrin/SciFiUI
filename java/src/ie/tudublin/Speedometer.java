package ie.tudublin;


import processing.core.PApplet;
import processing.core.PVector;

public class Speedometer extends PApplet
{
    
    private PVector pos;
    private UI ui;
   

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

        ui.line((pos.x + 50), (pos.y + 40), (pos.x + 50 ), (pos.y - 100));


        
    }

    

    public void update()
    {
       
        

        

       

    }

    

    
}