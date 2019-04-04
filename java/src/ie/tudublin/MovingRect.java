package ie.tudublin;

import processing.core.PApplet;

public class MovingRect extends Button
{
    private float dx = 10;

    public MovingRect(UI ui, float x, float y, float width, float height, String text)
    {
      super(ui, x, y, width, height, text);
    }

    public void render()
    {
        ui.fill(41, 45, 70);
        ui.noStroke();
        ui.rect(x, y, width, height);
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        //ui.text(text, x + width * 0.9f, y + height * 0.9f);
    }

    public void update()
    {
        x += dx;
        if ((x > ui.width - width) || (x < 0))
        {
            dx *= -1;
        }
    }
}