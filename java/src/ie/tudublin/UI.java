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
        size(800, 800);
        // Use fullscreen instead of size to make your interface fullscreen
        //fullScreen(); 
    }

    public void setup()
    {
        b = new Button(this, 50, 50, 100, 50, "I am a button");
        mc = new MovingCircle(this, width / 2, height / 2, 50);
        sk = new Sky();
    }

    public void draw()
    {
        background(0);
        stroke(255);
		noFill();
        
        int numLines = 20;
		float gap = width / numLines;

		for(int l = 0 ; l <= numLines; l ++)
		{
			float x = l * gap;
			line(x, 0, width - x, height);
			line(0, x, width, height - x);
			
        }
        
        b.render();

        

        mc.update();
        mc.render();

        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }

        
    }
}

