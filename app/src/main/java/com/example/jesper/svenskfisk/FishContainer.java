package com.example.jesper.svenskfisk;

import java.util.ArrayList;

/**
 * Class holding a list for all the fish that are to be displayed.
 * @author Jesper Bergstrom
 */
public class FishContainer {

    private ArrayList<Fish> fishList;

    public FishContainer(){
        fishList = new ArrayList<>();
    }

    public void add(Fish fish){
        fishList.add(fish);
    }

    public void remove(Fish fish){
        fishList.remove(fish);
    }

    public ArrayList<Fish> getList(){
        return fishList;
    }
}
