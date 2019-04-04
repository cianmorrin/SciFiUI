package ie.tudublin;

import processing.core.PApplet;
import java.util.ArrayList;
import processing.data.Table;
import processing.data.TableRow;


public class UI extends PApplet
{
    ArrayList<Alien> aliens = new ArrayList<Alien>();

    Compass s;
    CentreHub ch;
    
    Shapes sh;
    Button b;
    MovingRect mb;
    Radar r;
    int xspacing = 16;   // How far apart should each horizontal location be spaced
    int w;              // Width of entire wave

    float theta = 0.0f;  // Start angle at 0
    float amplitude = 75.0f;  // Height of wave
    float period = 500.0f;  // How many pixels before the wave repeats
    float dx;  // Value for incrementing X, a function of period and xspacing
    float[] yvalues;  // Using an array to store height values for the wave



    
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

    void calcWave() {
        // Increment theta (try different values for 'angular velocity' here
        theta += 0.06;
      
        // For every x value, calculate a y value with sine function
        float x = theta;
        for (int i = 0; i < yvalues.length; i++) {
          yvalues[i] = sin(x)*amplitude;
          x+=dx;
        }
      }
      
      void renderWave() {
        noStroke();
        fill(255);
        // A simple way to draw the wave with an ellipse at each location
        for (int x = 0; x < yvalues.length; x++) {
          ellipse(x*xspacing, (height-200)+yvalues[x], 16, 16);
        }
      }

    
      void loadProducts()
      {
          Table table = loadTable("alien.csv", "header");
          for(TableRow tr:table.rows())
          {
              Alien a = new Alien(tr);
              aliens.add(a);
          }        
      }
  
     
      public void printProducts() {
          for (Alien a : aliens) {
              System.out.println(a);
          }
      }
    

    
    public void settings()
    {
        fullScreen();
        //size(640, 360);
        loadProducts();
        printProducts();

    }

    

    public void setup()
    {
        w = 0+300;
        dx = (TWO_PI / period) * xspacing;
        yvalues = new float[w/xspacing];
        s = new Compass(this, width / 2, height / 2, 5, 50);
        ch = new CentreHub(this, width, height, PI, QUARTER_PI, HALF_PI, TWO_PI, 0, 0); 
        sh = new Shapes(this, width / 2, height / 2);
        b = new Button(this, 50, 50, 100, 50, "I am a button");
        mb = new MovingRect(this, 200, 0, 150, 10, "I am bigger moving button");
        r = new Radar(this, 1, width - 200, 200, 100);
        noLoop();
        
    }

    public void draw()
    {
        
        background(3, 1, 26);
        
       
        stroke(255);
        b.render();
        mb.render();
        mb.update();

        r.update();
        r.render();


        //  s.render();
        // s.update();

        //  calcWave();
        //  renderWave();
        strokeWeight(1);
        //sh.render();
        ch.render();

      
    }

    

}