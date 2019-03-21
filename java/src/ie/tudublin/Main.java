package ie.tudublin;

import processing.core.PVector;

public class Main
{	

	
	public void ui()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new UI());
		
	}

	

	public static void main(String[] args)
	{

		// PVector a = new PVector(0, 5);
		// PVector b = new PVector(10, -2);
		// PVector c = new PVector();

		// // a += b;
		// a.add(b);
		// // c = a + b;
		// c = PVector.add(a, b);
		// // static method call, on the class not the instance
		// c.normalize();
		// c.mag(); 

		
		Main main = new Main();
		main.ui();		
		
		
	}
}