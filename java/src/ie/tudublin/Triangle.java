package ie.tudublin;


public class Triangle extends Shapes
{

    public Triangle(UI ui, float x, float y)
    {
       super(ui, x, y);
    }

    public void create()
    {   
        //System.out.println("x is : " + x + "\n");

        ui.noFill();
        ui.strokeWeight(0.5f);
        ui.triangle(x - 220, y - 170, x - 220, y - 190, x - 200, y - 185);
        ui.triangle(x + 220, y - 200, x + 220, y - 220, x + 200, y - 215);
        ui.triangle(x + 180, y - 400, x + 180, y - 420, x + 160, y - 415);
        ui.triangle(x - 300, 20, x - 330, 45, x - 310, 60);
        ui.triangle( x + 320, y - 100, x + 330, y - 90, x + 310, y - 88);

    }
}