package ie.tudublin;


public class Lines
{
    UI ui;
  
    private float x ;
    private float y ;
    

    public Lines(UI ui, float x, float y)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
    }

    public void render()
    {   

        
        // Line to top right box
        ui.strokeWeight(3f);
        ui.line(x + 200, 380, x + 300, 200 );
        ui.line(x + 300, 200, x + 340, 200);
        ui.fill(204, 255, 255);
        ui.circle(x + 340, 200, 30);

        // Line to top left box
        ui.line(x - 200, 380, x - 300, 200 );
        ui.line(x - 300, 200, x - 340, 200);
        ui.circle(x - 340, 200, 30);

        // Line to bottom right box
        ui.line(x + 170, 580, x + 220, 600);
        ui.line(x + 220, 600, x + 240, 580);
        ui.circle(x + 240, 580, 30);

        // Line to bottom left box
        ui.line(x - 170, 580, x - 220, 600);
        ui.line(x - 220, 600, x - 240, 580);
        ui.circle(x - 240, 580, 30);

    }

    public void update()
    {
        
  

    }
}