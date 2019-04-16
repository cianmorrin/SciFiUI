package ie.tudublin;

import processing.core.PVector;

public class Power
{
    private PVector pos;
    private PVector forward;
    private float speed;
    private float size;
    private UI yasc;

    int[] data = { 30, 10, 45, 35, 60, 38, 75, 67 };

    public Power(UI yasc, float x, float y, float speed, float size)
    {
        this.yasc = yasc;
        pos = new PVector(x, y);
        forward = new PVector(0, -1);
        this.speed = speed;
        this.size = size;


    }

    public void render()
    {
        float lastAngle = 0;
  for (int i = 0; i < data.length; i++) {
    float gray = yasc.map(i, 0, data.length, 0, 255);
    yasc.fill(gray);
    yasc.arc(yasc.width/2, yasc.height/2, size, size, lastAngle, lastAngle+yasc.radians(data[i]));
    lastAngle += yasc.radians(data[i]);
  }
    }

    public void update()
    {
        
    }


    /**
     * @return the pos
     */
    public PVector getPos() {
        return pos;
    }

    /**
     * @param pos the pos to set
     */
    public void setPos(PVector pos) {
        this.pos = pos;
    }

    /**
     * @return the speed
     */
    public float getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    /**
     * @return the size
     */
    public float getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    

	/**
	 * @return the yasc
	 */
	public UI getYasc() {
		return yasc;
	}

	/**
	 * @param yasc the yasc to set
	 */
	public void setYasc(UI yasc) {
		this.yasc = yasc;
    }
    public void setSize(float size) {
        this.size = size;
    }

    
}