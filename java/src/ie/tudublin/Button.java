package ie.tudublin;

import processing.core.PApplet;

public class Button
{
    UI ui;
    protected float x;
    protected float y;
    protected float width;
    protected float height;
    protected String text;

    public Button(UI ui, float x, float y, float width, float height, String text)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
    }

    public void render()
    {
        ui.noFill();
        ui.stroke(0, 0, 255);
        ui.rect(x, y, width, height);
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.fill(255);
        ui.text(text, x + width * 0.5f, y + height * 0.5f);
    }
}