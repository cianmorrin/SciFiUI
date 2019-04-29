package ie.tudublin;

import processing.core.PApplet;
import processing.core.PFont;

import java.util.ArrayList;
import processing.data.Table;
import processing.data.TableRow;

import ddf.minim.AudioInput;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;


public class UI extends PApplet
{
    ArrayList<Alien> aliens = new ArrayList<Alien>();
    ArrayList<Alien> alieninfo = new ArrayList<Alien>();
    private ArrayList<Planet> planets = new ArrayList<Planet>();

    CentreHub ch;
    Lines li;
    Button b;
    MovingRect mb;
    Radar r;
    BarChart bc;
    Speedometer sp;
    VoiceComs vc;
    PFont myFont;

    Shapes sh, tr, hex;

    public static int SAMPLE_RATE = 44100;
    public static int RESOLUTION = 8;
    public static int FRAME_SIZE = 1024;

    Minim minim;
    AudioInput ai;
    FFT fft;
    

    int selected1 = -1;
    int selected2 = -1;
    int startCircle = 0;
    boolean[] keys = new boolean[1024];


    public void settings()
    {
        fullScreen();
        loadAliens();
        printAliens();
        printAlienInfo();

        minim = new Minim(this);
        ai = minim.getLineIn(Minim.MONO,  FRAME_SIZE, SAMPLE_RATE, RESOLUTION);
        fft = new FFT(FRAME_SIZE, SAMPLE_RATE);
        
        noLoop();    
    }


    public void setup()
    {
        ch = new CentreHub(this, width, height, PI, QUARTER_PI, HALF_PI, TWO_PI, 0, 0); 
        li = new Lines(this, width / 2, 200);
        b = new Button(this, 50, 50, 100, 50, "I am a button");
        mb = new MovingRect(this, 200, 0, 150, 10, "I am bigger moving button");
        r = new Radar(this, 1, width - 200, 200, 100);
        bc = new BarChart(this, 200, 200);
        vc = new VoiceComs(this, 200, 560);
        sp = new Speedometer(this, width - 300, 560);
        
        sh = new Shapes(this, width / 2, height / 2);
        tr = new Triangle(this, width / 2, height / 2);
        hex = new Hexagon(this, width / 2, height / 2);

        loadData();
        printPlanets();
    
    }

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

    
    void loadAliens()
    {
        Table table = loadTable("alien.csv", "header");
        for(TableRow tr:table.rows())
        {
           Alien a = new Alien(tr);
           aliens.add(a);
       }        
    }
  
     
    public void printAliens() 
    {
          for (Alien a : aliens) {
              System.out.println(a);
          }
      }

      public void printAlienInfo() {
        for (Alien a1 : alieninfo) {
            System.out.println(a1);
        }
    }

    float border = 80;
    float yborder = 700;
    float buttonWidth = 150;
    float buttonHeight = 36;
    String alienPick = " ";


    float speedPlus = 500;
    float speedNeg = 500;
    

    public void drawAlienButtons()
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
            fill(255);
            text(p.getAlien() ,  x +  10, y + buttonHeight * 0.5f);
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
            fill(255);
            text(p.getAlien() ,  (x * 3) +  10, y + buttonHeight * 0.5f);

        }
    }
    
    public void mouseClicked() // when the mouse is clicked 
    {

      if (mouseX > (width /2 - 50) && mouseX < (width /2 + 50)) // mouse's x co-ordinate is in between a button go in
      {
        if (mouseY > (height / 2 - 50) && mouseY < (height / 2 + 50)) //inbetween y co-ordinates of button
        {
           startCircle = 255;
           loop();
        }
          
      }
    
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



        for (int i = 0; i < planets.size(); i++) {
          Planet s = planets.get(i);

          float x = map(s.getxG(), -5, 5, (width / 2) + 300, width - 50);
          float y = map(s.getyG(), -5, 5, 700, height - 50);

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

    }

    
    public void displayAlienInfo() {
      fill(41, 45, 70);
      stroke(204, 255, 255);
      rect( (width / 2) - 200, 700, buttonWidth + 240, 180); // rectangle
    
      fill(255);
      textAlign(LEFT, CENTER);
      text("\nAlien Type : \nOrigin Planet : \nWanted Ranking : \nWeight : \nHeight : \nKills : \nWeapon : " , (width / 2) - 180, 780 );
      text(alienPick, (width / 2) - 50, 780 );
      
  }
    


    public void loadData() 
    {
      Table table = loadTable("planets.csv", "header");

      for (TableRow row : table.rows()) 
      {
          Planet star = new Planet(row);
          planets.add(star);
      }
    }

     public void printPlanets() 
     {
         for (Planet star : planets) 
         {
            System.out.println(star);
         }
}


    private void drawGrid() 
    {
    textAlign(CENTER, CENTER);
    for (int i = -5; i <= 5; i++) 
    {
        float x = map(i, -5, 5, (width / 2) + 300, width - 50);
        stroke(41, 45, 70);
        line(x, 700, x, height - 50);
        fill(255);
        text(i, x, 690 );
        stroke(41, 45, 70);
        float y = map(i, -5, 5, 700, height - 50);
        line((width / 2) + 300, y, width - 50, y);
        fill(255);
        text(i, (width /2 ) + 270, y);
    }
    }

    public void drawStars()
    {
        textAlign(LEFT, CENTER);
        for (Planet s : planets) 
        {
          float x = map(s.getxG(), -5, 5, (width / 2) + 300, width - 50);
          float y = map(s.getyG(), -5, 5, 700, height - 50);

            strokeWeight(1.5f);
            stroke(229, 204, 255);
            noFill();
            ellipse(x, y, s.getAbsMag(), s.getAbsMag());

            stroke(0, 255, 255);
            line(x, y - 5, x, y + 5);
            line(x - 5, y, x + 5, y);
            fill(255);
            text(s.getDisplayName(), x + 20, y);
         }
    }

    public void writeTitles()
    {
        textSize(18);  
        fill(204, 255, 255); 
        text("INTERGALACTIC SPEEDOMETER",1190, 395);
        text("ALIEN RADAR", 1240, 35);
        text("EXTRATERRESTRIAL VOICE COMS",250, 395);
        text("SHIP STATUS", 200, 35);

        // for bar charts
        
        text("Nuclear power : ", 150, 75);
        text("Boosters :  ", 128, 157);
        text("Heat pipe : ", 128, 235);
    }


    public void draw()
    {
      background(3, 1, 26);
      myFont = createFont("Copperplate-Light", 80);
      fill(255);
      textFont(myFont);
      textAlign(CENTER, CENTER);
      text("ALIEN \n HUNTER XCON", width / 2, 100);

      sh.create();
      tr.create();
      hex.create();

      li.render();
      li.update();
      strokeWeight(3f);

      fill(startCircle);
      stroke(204, 255, 255);
      circle(width/2, height/2, 100);
     
      fill(255);
      stroke(255);
      
      
      mb.render();
      mb.update();

      r.render();
      r.update();
      

      bc.render();
      bc.update();

      
      sp.render();
      sp.update();
    

      vc.render();

     //Code for Voice Coms
       
      float halfH = height / 2 + 75;

      
      float total = 0;

      for( int i = 50; i < ai.bufferSize() - 580; i ++)
      {
          stroke(192,192,192);
          line(i, halfH, i, halfH + ai.left.get(i) * 100);

          total += (float) Math.abs(ai.left.get(i));
      }

        
      drawAlienButtons();
      displayAlienInfo();


      drawGrid();
      drawStars();

      if (selected1 != -1 && selected2 == -1) 
      {
        Planet planet1 = planets.get(selected1);
        stroke(255);
        float x = map(planet1.getxG(), -5, 5, (width / 2) + 300, width - 50);
        float y = map(planet1.getyG(), -5, 5, 700, height - 50);
        strokeWeight(1);
        line(x, y, mouseX, mouseY);
        }
     
        else if (selected1 != -1 && selected2 != -1) 
        {
            Planet planet1 = planets.get(selected1);
            float x1 = map(planet1.getxG(), -5, 5, (width / 2) + 300, width - 50);
            float y1 = map(planet1.getyG(), -5, 5, 700, height - 50);

            Planet planet2 = planets.get(selected2);
            float x2 = map(planet2.getxG(), -5, 5, (width / 2) + 300, width - 50);
            float y2 = map(planet2.getyG(), -5, 5, 700, height - 50);

            strokeWeight(1);
            stroke(255);
            line(x1, y1, x2, y2);
            fill(255);
            float dist = dist(planet1.getxG(), planet1.getyG(), planet1.getzG(), planet2.getxG(), planet2.getyG(), planet2.getzG());
            text("Distance from " + planet1.getDisplayName() + " to " + planet2.getDisplayName() + " is " + dist + " parsecs", (width / 2) + 240,
                    height - 25);
          }

       
     
        sp.render();
        sp.update();

        writeTitles();

        
        
        strokeWeight(1);
        
        ch.render();

 
    }

  
}