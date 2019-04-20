package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class BarChart
{
    
    private PVector pos;
    private UI ui;
  
    private float x1 = 60;
    private float x2 = 70;
    private float x3 = 40;

    private float dx = 220;
    private float cx1 = 1;
    private float cx2 = 0.8f;
    private float cx3 = 1.1f;


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

       

        //bar chart 1
        ui.fill(41, 45, 70);
        ui.rect(pos.x - 110, (pos.y - 110), dx, 50);
        ui.fill(204, 255, 255);
        ui.rect(pos.x - 110, (pos.y - 110), x1, 50);

        //bar chart 1
        ui.fill(41, 45, 70);
        ui.rect(pos.x - 110, (pos.y - 50), dx, 50);
        ui.fill(204, 255, 255);
        ui.rect(pos.x - 110, (pos.y - 50), x2, 50);

        //bar chart 1
        ui.fill(41, 45, 70);
        ui.rect(pos.x - 110, (pos.y + 10), dx, 50);
        ui.fill(204, 255, 255);
        ui.rect(pos.x - 110, (pos.y + 10), x3, 50);
        
    }

    

    public void update()
    {
        
        x1 += cx1;
        if (x1 > 220 || x1 < 20 )
        {
            cx1 *= -1;
        }

        x2 += cx2;
        if (x2 > 220 || x2 < 10 )
        {
            cx2 *= -1;
        }

        x3 += cx3;
        if (x3 > 220 || x3 < 30 )
        {
            cx3 *= -1;
        }
       
    }
    
}