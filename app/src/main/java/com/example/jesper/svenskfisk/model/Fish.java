package com.example.jesper.svenskfisk.model;

import java.io.Serializable;

/**
 * Class representing a Fish.
 * @author Jesper Bergstrom
 * @name Fish.java
 */
public class Fish implements Serializable{

    private final String[] allLooks = {"Grön", "Röd", "Mörk", "Ljus", "Silver", "Brun", "Smal", "Tjock", "Platt",};
    private final String[] allWaters = {"Sötvatten", "Bräckvatten", "Saltvatten"};
    private String[] looks;
    private String name;
    private String sciName;
    private String locations;
    private String[] waters;
    private String method;
    private String food;
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

    public void setLocations(String locations){
        this.locations = locations;
    }

    public String getLocations(){
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

    public void setLooks(String[] looks){
        this.looks = looks;
    }

    public String[] getLooks(){
        return looks;
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
