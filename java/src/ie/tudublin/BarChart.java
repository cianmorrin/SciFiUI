package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class BarChart
{
    
    private PVector pos;
    private UI ui;
  
    private float x = 60;
    private float dx = 220;
    private float cx = 1;

    public BarChart(UI ui, float x, float y)
    {
        this.ui = ui;
        pos = new PVector(x, y);
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

       

        //bar charts
        ui.fill(41, 45, 70);
        ui.rect(pos.x - 110, (pos.y - 110), dx, 50);
        ui.fill(204, 255, 255);
        ui.rect(pos.x - 110, (pos.y - 110), x, 50);
        
    }

    

    public void update()
    {
        
        x += cx;
        if (x > 220 || x < 50 )
        {
            cx *= -1;
        }
       
    }
    
}