package ie.tudublin;


public class Hexagon extends Shapes
{
   
   

    public Hexagon(UI ui, float x, float y)
    {
       super(ui, x, y);
    }

    public void create()
    {   
        //System.out.println("x is : " + x + "\n");
    
       


        ui.strokeWeight(0.5f);
        ui.line(x - 300, y - 120, x - 270 , y - 120);
        ui.line(x - 300, y - 120, x - 320 , y - 90);
        ui.line(x - 270 , y - 120, x - 250 , y - 90);
       
       //two bottom half verticles left and right
        ui.line(x - 320 , y - 90, x - 300, y - 60);
        ui.line(x - 250 , y - 90, x - 270, y - 60);

        //bottom line
        ui.line(x - 300, y - 60, x - 270 , y - 60);


        // second hex
        //top line
        ui.line(x + 240, y - 370, x + 260, y - 370);

        //two top half verticles
        ui.line(x + 240, y - 370, x + 225, y - 350);
        ui.line(x + 260, y - 370, x + 275, y - 350);

        //two bottom half verticle
        ui.line(x + 225, y - 350, x + 240, y - 330 );
        ui.line(x + 275, y - 350, x + 260, y - 330);

        //bottom line
        ui.line(x + 240, y - 330, x + 260, y - 330);


        // 3rd hex 
        // top line
        ui.line(x + 180, y + 160, x + 200, y + 160);

        //two top half verticles
        ui.line(x + 180, y + 160, x + 165, y + 180);
        ui.line(x + 200, y + 160, x + 215, y + 180);

        //two bottom half verticle
        ui.line(x + 165, y + 180, x + 180, y + 200);
        ui.line(x + 215, y + 180, x + 200, y + 200);

        ui.line(x + 180, y + 200, x + 200, y + 200);

        

    }

}