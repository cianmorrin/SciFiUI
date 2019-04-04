package ie.tudublin;

import processing.data.*;

public class Alien
{
    private String alien;
    private String planet;
	

    public Alien(String alien, String planet)
    {
        this.alien = planet;
        this.planet = planet;
    }

    public String toString()
    {
        return alien + "\t" + planet;
    }

    public Alien(TableRow tr)
    {
        // Constructor chaining
        this(tr.getString("Alien"), tr.getString("Planet"));
    }

    /**
     * @return the alien
     */
    public String getAlien() {
        return alien;
    }

    /**
     * @param alien the alien to set
     */
    public void setAlien(String alien) {
        this.alien = alien;
    }

    /**
     * @return the planet
     */
    public String getPlanet() {
        return planet;
    }

    /**
     * @param planet the planet to set
     */
    public void setPlanet(String planet) {
        this.planet = planet;
    }

    
	
    
}