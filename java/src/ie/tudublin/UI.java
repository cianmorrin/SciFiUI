package ie.tudublin;

import processing.core.PApplet;

public class UI extends PApplet
{
    Compass s;
    
    boolean[] keys = new boolean[1024];

    public void keyPressed()
    {
        keys[keyCode] = true;
    }
    public void keyReleased()
    {
        keys[keyCode] = false;
    }

    public boolean checkKey(int c)
    {
        return keys[c] || keys [Character.toUpperCase(c)];
    }
    
    public void settings()
    {
        fullScreen();

    }

    public void setup()
    {
        s = new Compass(this, width / 2, height / 2, 5, 50);
        
    }

    public void draw()
    {
        background(255);
        
        fill(135,206,250);
        noStroke();
        rect(0, (height / 2) + 100, width, height / 2);
        fill(135,206,250);
        rect(0,0,0 + 100, height);
        
        fill(135,206,250);
        rect(width - 100 , 0, width, height);

        fill(255,0,0);
        triangle(0, 0, 150, 0, 0, 150);
        triangle(width - 150, 0, width, 0, width, 150);
        
        s.render();
        s.update();

        
    }


}