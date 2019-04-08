package ie.tudublin;

import processing.core.PApplet;
import java.util.ArrayList;
import processing.data.Table;
import processing.data.TableRow;


public class UI extends PApplet
{
    ArrayList<Alien> aliens = new ArrayList<Alien>();
    ArrayList<Alien> alieninfo = new ArrayList<Alien>();
    private ArrayList<Planet> stars = new ArrayList<Planet>();

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


    int selected1 = -1;
    int selected2 = -1;
    
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

      public void printBill() {
        for (Alien a1 : alieninfo) {
            System.out.println(a1);
        }
    }

    float border = 80;
    float yborder = 700;
    float buttonWidth = 150;
    float buttonHeight = 36;
    String alienPick = " ";
    

      void drawProductButtons()
    {
      stroke(204, 255, 255);
      line(0, 675, width, 675);
        textSize(15);
        for(int i = 0 ; i < aliens.size() ; i += 2)
        {
            Alien p = aliens.get(i); //get the product into p 
            float y = yborder + (i * (buttonHeight )); // y contains y co-ordinate of button 
            float x = border; // x co-ordinate
            fill(41, 45, 70);
            stroke(204, 255, 255);
            rect(x, y, buttonWidth, buttonHeight); // rectangle
            
            textAlign(LEFT, CENTER);
            fill(204, 255, 255);
            text(p.getPlanet() ,  x +  10, y + buttonHeight * 0.5f);
        }

        for(int i = 1 ; i < aliens.size() ; i += 2)
        {
            Alien p = aliens.get(i); //get the product into p 
            float y = yborder + ((i - 1)  * (buttonHeight )); // y contains y co-ordinate of button 
            float x = border; // x co-ordinate
            fill(41, 45, 70);
            stroke(204, 255, 255);
            rect(x * 3, y, buttonWidth , buttonHeight); // rectangle
            
            textAlign(LEFT, CENTER);
            fill(204, 255, 255);
            text(p.getPlanet() ,  (x * 3) +  10, y + buttonHeight * 0.5f);

        }
    }

    
    public void mouseClicked() // when the mouse is clicked 
    {
        int which = -1; //the variable which is initialised to -1

        if (mouseX > (border * 3) && mouseX < (border * 3) + buttonWidth) // mouse's x co-ordinate is in between a button go in
        {
            for(int i = 0 ; i < aliens.size() ; i ++) // iterating over all items 
            {
                float y = yborder + (i * (buttonHeight )); // y is the y co-ordinate for each button
                if (mouseY > y && mouseY < y + buttonHeight) //inbetween y co-ordinates of button
                {
                    which = i + 1; // which is given the value of the place of whatever button is clicked
                    break;
                }
            }
        }

        if (mouseX > border && mouseX < border + buttonWidth) // mouse's x co-ordinate is in between a button go in
        {
            for(int i = 0 ; i < aliens.size() ; i ++) // iterating over all items 
            {
                float y = yborder + (i * (buttonHeight )); // y is the y co-ordinate for each button
                if (mouseY > y && mouseY < y + buttonHeight) //inbetween y co-ordinates of button
                {
                    which = i; // which is given the value of the place of whatever button is clicked
                    break;
                }
            }
        }
        
        if (which != -1) //if a button was succesfully clicked
        {
            //System.out.println(products.get(which)); // it prints out which one 
           alienPick = aliens.get(which).toString();
        }



        for (int i = 0; i < stars.size(); i++) {
          Planet s = stars.get(i);

          float x = map(s.getxG(), -5, 5, border, width - border);
          float y = map(s.getyG(), -5, 5, border, height - border);

          if (dist(mouseX, mouseY, x, y) < s.getAbsMag() / 2) {
              if (selected1 == -1) {
                  selected1 = i;
              } else if (selected2 == -1) {
                  selected2 = i;
              } else {
                  selected1 = i;
                  selected2 = -1;
              }
          }
      }
        
    }

    
    public void displayBill() {
      fill(41, 45, 70);
      stroke(204, 255, 255);
      rect( (width / 2) - 200, 700, buttonWidth + 240, 180); // rectangle
    
      fill(204, 255, 255);
      textAlign(LEFT, CENTER);

      text("Alien Type : \nWanted Ranking : \nWeight : \nHeight : \nKills : \nWeapon : " , (width / 2) - 180, 780 );
      text(alienPick, (width / 2) - 50, 780 );
      
  }
    

    
    public void settings()
    {
        fullScreen();
        loadProducts();
        printProducts();
        printBill();
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
       // noLoop();

       loadData();
       printStars();
       planetborder = width * 0.1f;
        
    }

    public void loadData() {
      Table table = loadTable("planets.csv", "header");

    

      for (TableRow row : table.rows()) {
        Planet star = new Planet(row);
          stars.add(star);
      }
  }

  public void printStars() {
    for (Planet star : stars) {
        System.out.println(star);
    }
}

float planetborder;

private void drawGrid() {
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
}

public void drawStars() {
  textAlign(LEFT, CENTER);
  for (Planet s : stars) {
      float x = map(s.getxG(), -5, 5, border, width - border);
      float y = map(s.getyG(), -5, 5, border, height - border);

      stroke(255, 255, 0);
      noFill();
      ellipse(x, y, s.getAbsMag(), s.getAbsMag());

      stroke(0, 255, 255);
      line(x, y - 5, x, y + 5);
      line(x - 5, y, x + 5, y);
      fill(255);
      text(s.getDisplayName(), x + 20, y);
  }
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
        
        drawProductButtons();
       displayBill();


       drawGrid();
       drawStars();

       if (selected1 != -1 && selected2 == -1) {
        Planet star1 = stars.get(selected1);
        stroke(255, 255, 0);
        float x = map(star1.getxG(), -5, 5, border, width - border);
        float y = map(star1.getyG(), -5, 5, border, height - border);

        line(x, y, mouseX, mouseY);
    } else if (selected1 != -1 && selected2 != -1) {
      Planet star1 = stars.get(selected1);
        float x1 = map(star1.getxG(), -5, 5, border, width - border);
        float y1 = map(star1.getyG(), -5, 5, border, height - border);

        Planet star2 = stars.get(selected2);
        float x2 = map(star2.getxG(), -5, 5, border, width - border);
        float y2 = map(star2.getyG(), -5, 5, border, height - border);

        stroke(255, 255, 0);
        line(x1, y1, x2, y2);
        fill(255);
        float dist = dist(star1.getxG(), star1.getyG(), star1.getzG(), star2.getxG(), star2.getyG(), star2.getzG());
        text("Distance from " + star1.getDisplayName() + " to " + star2.getDisplayName() + " is " + dist + " parsecs", border,
                height - 25);
    }

        //  s.render();
        // s.update();

        //  calcWave();
        //  renderWave();
        strokeWeight(1);
        //sh.render();
        ch.render();

        

      
    }

    

}