package ie.tudublin;


public class Shapes
{
    UI ui;
  
    public float x ;
    public float y ;
    
  

    public Shapes(UI ui, float x, float y)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
    }

    public void create()
    {   
       // System.out.println("i am a shape");
       ui.noFill();
       ui.strokeWeight(1.5f);
       ui.circle(x - 200, y + 100, 30);
       ui.fill(204, 255, 255); 
       ui.circle(x - 200, y + 100, 15);


      
    }

    public void update()
    {
        
  

    }
}