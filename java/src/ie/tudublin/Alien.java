package ie.tudublin;

import processing.data.*;

public class Alien
{
    private String alien;
    private String planet;
    private String wanted;
    private String height;
    private String weight;
    private String kills;
    private String weapons;

	
    public String toString()
    {
        return "\n" + alien + "\n" + planet + "\n" + wanted + "\n" + height + "\n" + weight + "\n" + kills + "\n" + weapons  ;
    }

    
    public Alien(String alien, String planet, String wanted, String height, String weight, String kills, String weapons)
    {
        this.alien = alien;
        this.planet = planet;
        this.wanted = wanted;
        this.height = height;
        this.weight = weight;
        this.kills = kills;
        this.weapons = weapons;
    }

 
    public Alien(TableRow tr)
    {
        // Constructor chaining
        this(tr.getString("Alien"), tr.getString("Planet"),  tr.getString("Wanted"), tr.getString("Height"), tr.getString("Weight"), tr.getString("Kills"), tr.getString("Weapon"));
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

    /**
     * @return the wanted
     */
    public String getWanted() {
        return wanted;
    }

    /**
     * @param wanted the wanted to set
     */
    public void setWanted(String wanted) {
        this.wanted = wanted;
    }

    /**
     * @return the height
     */
    public String getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * @return the weight
     */
    public String getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * @return the kills
     */
    public String getKills() {
        return kills;
    }

    /**
     * @param kills the kills to set
     */
    public void setKills(String kills) {
        this.kills = kills;
    }

    /**
     * @return the weapons
     */
    public String getWeapons() {
        return weapons;
    }

    /**
     * @param weapons the weapons to set
     */
    public void setWeapons(String weapons) {
        this.weapons = weapons;
    }

   
	
    
}