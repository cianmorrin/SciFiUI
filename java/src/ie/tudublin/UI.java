package ie.tudublin;

import processing.core.PApplet;

public class UI extends PApplet
{
    Button b;
    MovingCircle mc;
    Sky sk;

    boolean[] keys = new boolean[1024];

    public void keyPressed()
    {
        keys[keyCode] = true;
    }
    
    public void keyReleased()
    {
        keys[keyCode] = true;
    }

    public boolean checkKey(int c)
    {
        return keys[c] || keys [Character.toUpperCase(c)];
    }
    

    public void settings()
    {
        //size(800, 800);
        // Use fullscreen instead of size to make your interface fullscreen
        fullScreen(); 
    }

    public void setup()
    {
      
        b = new Button(this, 50, 50, 100, 50, "I am a big button");
        mc = new MovingCircle(this, width / 2, height / 2, 50);
        sk = new Sky();
        
    }

    

    public void draw()
    {
        background(0);
        
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


        
        
        b.render();

        

        mc.update();
        mc.render();

        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }

        
    }
}

