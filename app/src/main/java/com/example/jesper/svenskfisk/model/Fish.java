package com.example.jesper.svenskfisk.model;

/**
 * Class representing a Fish.
 * @author Jesper Bergstrom
 */
public class Fish {

    private final String[] allAreas = {"Blekinge", "Bohuslän", "Dalarna", "Dalsland", "Gotland", "Gästrikland",
            "Halland", "Hälsingland", "Härjedalen", "Jämtland", "Lappland", "Medelpad", "Norrbotten", "Närke",
            "Skåne", "Småland", "Södermanland", "Uppland", "Värmland", "Västerbotten", "Västergötland", "Västmanland",
            "Ångermanland", "Öland", "Östergötland", "Hela Sverige"};
    private final String[] allWaters = {"Sötvatten", "Bräckvatten", "Saltvatten"};
    private String name;
    private String sciName;
    private String[] locations;
    private String[] waters;
    private String method;
    private String food;
    private String description;
    private int normalWeight;
    private int maxWeight;

    public Fish(){

    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setSciName(String sciName){
        this.sciName = sciName;
    }

    public String getSciName(){
        return sciName;
    }

    public void setLocations(String[] locations){
        this.locations = locations;
    }

    public String[] getLocations(){
        return locations;
    }

    public void setWaters(String[] waters){
        this.waters = waters;
    }

    public String[] getWaters(){
        return waters;
    }

    public void setMethod(String method){
        this.method = method;
    }

    public String getMethod(){
        return method;
    }

    public void setFood(String food){
        this.food = food;
    }

    public String getFood(){
        return food;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setNormalWeight(int normalWeight){
        this.normalWeight = normalWeight;
    }

    public int getNormalWeight(){
        return normalWeight;
    }

    public void setMaxWeight(int maxWeight){
        this.maxWeight = maxWeight;
    }

    public int getMaxWeight(){
        return maxWeight;
    }
}
