package ie.tudublin;

import processing.core.PApplet;

public class Sky extends PApplet
{	
	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		dx = 0;
		dy = 0;
		cx = width / 2;
		cy = height / 2;

	}

	float dx, dy;
	float cx, cy;

	void problem1()
	{
		int numLines = 20;
		float gap = width / numLines;

		for(int l = 0 ; l <= numLines; l ++)
		{
			float x = l * gap;
			line(x, 0, width - x, height);
			line(0, x, width, height - x);
			
		}
	}

	public void draw()
	{			
		background(0);
		stroke(255);
		noFill();	
				
		problem1();
		//problem2();
		//problem3();
		//problem4();
		//problem5();
		//problem6();
	}

}
