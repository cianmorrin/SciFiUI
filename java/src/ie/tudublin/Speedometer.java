package ie.tudublin;


import processing.core.PApplet;
import processing.core.PVector;

public class Speedometer extends PApplet
{
    
    private PVector pos;
    private UI ui;
    float xradiusLine;
    float yradiusLine;

    float x; // centre x
    float y; // centre y

    float r=100f; // radius

    int innerRadius =65; // text radius
    public int textCounter = 80; // text counter
   

    public Speedometer(UI ui, float x, float y)
    {
        this.ui = ui;
        pos = new PVector(x, y);
    }

    public void referenceLines() {

       
        ui.noLoop();
    }

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


       
        // Centre point for speedometer
        x = pos.x + 50;
        y = pos.y - 40;

        
        ui.strokeWeight(3); // at-least 2 but atmost 3
        ui.stroke(204, 255, 255);
        ui.fill(41, 45, 70);
        ui.ellipse(x, y, 200, 200); // height = width =200px
        ui.strokeWeight(2); // define stroke weigth of markers
    
        for (int i = 0; i <240 ; i+=30) {
    
            ui.stroke(204, 255, 255);
            xradiusLine=x+r*(cos(radians(30 + i)));
            yradiusLine=y-r*(sin(radians(30+ i)));
            ui.line(x, y, xradiusLine, yradiusLine);
    
        }
    
        ui.stroke(204, 255, 255); // stroke must be removed
        ui.fill(0); // fill must be background color
        ui.ellipse(x, y, 160, 160); // it will hide the marker lines and align text

        ui.noStroke();
        ui.pushMatrix(); // current coordinate system must be saved
        ui.translate(x,y); // it must be called before rotate with centre
        ui.rotate(-PI/3);
        ui.fill(204, 255, 255); // it must be called to set fill of pointer
        ui.triangle(0,10,0,-10,-70,0);
        ui.ellipse(0,0,20,20); // it must be drawn after triangle
        ui.popMatrix(); // previous coordinate system must be restored
    
        int textCounter = 80;
        for (int i = 0; i <240 ; i+=30) {
    
            xradiusLine = x + innerRadius * (cos(radians(30+i)));
            yradiusLine=y- innerRadius *(sin(radians(30+i)));
            ui.stroke(127);
            ui.fill(255);
            //point(x1, y1); // debug text and angle purposes
            ui.textAlign(CENTER,CENTER); // this must be called as mentioned
            ui.text(textCounter,xradiusLine,yradiusLine);
            textCounter -=10;
           // ui.noLoop();
        }

        
    }

    

    public void update()
    {
       
    }

    

    
}