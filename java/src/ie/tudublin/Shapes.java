package ie.tudublin;


public class Shapes
{
    UI ui;
  
    public float x ;
    public float y ;
    private int alpha = 1, delta = 1;
  

    public Shapes(UI ui, float x, float y)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
    }

    public void create()
    {   
        if (alpha == 0 || alpha == 255) { delta = -delta; }
        alpha += delta;
        ui.fill(255,255,224, alpha);
        ui.ellipse(x, y, 250, 250);


       // System.out.println("i am a shape");
       ui.noFill();
       ui.strokeWeight(0.5f);
       ui.circle(x - 200, y + 100, 30 );
       ui.fill(204, 255, 255, alpha); 
       ui.circle(x - 200, y + 100, 15);

       ui.noFill();
       ui.strokeWeight(0.5f);
       ui.circle(x - 250, y - 380, 30);
       ui.fill(204, 255, 255, alpha); 
       ui.circle(x - 250, y - 380, 15);

       ui.noFill();
       ui.strokeWeight(0.5f);
       ui.circle(30, y + 150, 30);
       ui.fill(204, 255, 255, alpha); 
       ui.circle(30, y + 150, 15);

       ui.noFill();
       ui.strokeWeight(0.5f);
       ui.circle(x + 220, y - 150, 30);
       ui.fill(204, 255, 255, alpha); 
       ui.circle(x + 220, y - 150, 15);

       ui.noFill();
       ui.strokeWeight(0.5f);
       ui.circle(x - 150, y - 210, 30);
       ui.fill(204, 255, 255, alpha); 
       ui.circle(x - 150, y - 210, 15);


        ui.noFill();
       ui.strokeWeight(0.5f);
       ui.circle(x + 670, y - 80, 30);
       ui.fill(204, 255, 255, alpha); 
       ui.circle(x + 670, y - 80, 15);

      
    }

    public void update()
    {
        
  

    }
}