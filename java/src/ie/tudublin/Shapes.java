package ie.tudublin;

import processing.core.PApplet;

public class Shapes
{
    UI ui;
  
    private float bx;
    private float by;
    private int boxSize;
    private boolean overBox;
    private boolean locked;
    private float xOffset; 
    private float yOffset; 


    public Shapes(UI ui, float bx, float by, int boxSize, boolean overBox, boolean locked, float xOffset, float yOffset)
    {
        this.ui = ui;
        this.bx = bx;
        this.by = by;
        this.boxSize = boxSize;
        this.overBox = overBox;
        this.locked = locked;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void render()
    {
        
        // Test if the cursor is over the box 
        if (ui.mouseX > bx-boxSize && ui.mouseX < bx+boxSize && 
        ui.mouseY > by-boxSize && ui.mouseY < by+boxSize) {
        overBox = true;  
        if(!locked) { 
        ui.stroke(255); 
        ui.fill(255);
        } 
        } else {
        ui.stroke(153);
        ui.fill(153);
        overBox = false;
        }

        // Draw the box
        ui.rect(bx + 20, by, boxSize, boxSize + 10);
        ui.rect(bx + -70, by, boxSize, boxSize + 10);
        ui.rect(bx + 20, by - 70, boxSize, boxSize + 10);
        ui.rect(bx + -70, by - 70, boxSize, boxSize + 10);

        
    }
}