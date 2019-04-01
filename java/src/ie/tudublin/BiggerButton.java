package ie.tudublin;

import processing.core.PApplet;

public class BiggerButton extends Button
{
    private float dx = 1;

    public BiggerButton(UI ui, float x, float y, float width, float height, String text)
    {
      super(ui, x, y, width, height, text);
    }

    public void render()
    {
        ui.noFill();
        ui.stroke(255);
        ui.rect(x, y, width, height);
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.text(text, x + width * 0.9f, y + height * 0.9f);
    }

    public void update()
    {
        x += dx;
        if ((x > ui.width - width) || (x < width))
        {
            dx *= -1;
        }
    }
}