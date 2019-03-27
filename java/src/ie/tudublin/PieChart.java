package ie.tudublin;

import processing.core.PApplet;

public class PieChart
{
    UI ui;
    private float width;
    private float height;
    private float diameter;
    private int CHORD;
    private int[] angles = { 40, 40, 40, 40, 40, 40, 40, 40, 40 };


    public PieChart(UI ui, float width, float height, float diameter, int CHORD)
    {
        this.ui = ui;
        this.width = width;
        this.height = height;
        this.diameter = diameter;
        this.CHORD = CHORD;
        
    }

    public void render()
    {
        
        ui.noStroke();

        float lastAngle = 0;
        for (int i = 0; i < angles.length; i++) {
          float gray = PApplet.map(i, 0, angles.length, 0, 255);
          
          ui.arc(width/2, height/2, diameter, diameter, lastAngle, lastAngle+PApplet.radians(angles[i]));
          if (ui.mousePressed) {
            ui.fill(gray);
          } else {
            ui.fill(0);
          }
          lastAngle += PApplet.radians(angles[i]);
        }


    }
}