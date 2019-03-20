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
        border = width * 0.1f;
    }

    float border;

    public void draw()
    {
        background(0);
        textAlign(CENTER, CENTER);
        for (int i = -5; i <= 5; i++) {
            float x = map(i, -5, 5, border, width - border);
            stroke(0, 0, 255);
            line(x, border, x, height - border);
            fill(255);
            text(i, x, border / 2);
            stroke(0, 0, 255);
            line(border, x, width - border, x);
            fill(255);
            text(i, border / 2, x);
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

