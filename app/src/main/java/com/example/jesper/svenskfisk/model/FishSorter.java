package com.example.jesper.svenskfisk.model;

import java.util.ArrayList;

/**
 * Class for sorting a list of fish.
 * @author Jesper Bergstrom
 * @version 0.00.00
 * @name FishSorter.java
 */
public class FishSorter {

    public FishSorter(){

    }

    /**
     * Sort method that sorts a list of fish by how many tag matches the fish have.
     * @param list
     * @param tags
     */
    public ArrayList<Fish> sort(ArrayList<Fish> list, String[] tags){

        ArrayList<Fish> result = new ArrayList<Fish>();
        int matches;

        // Wat is dis??
        for(int i=0; i<list.size(); i++){
            matches = 0;
            // Getting the number of matching tags for current fish.
            for(int j=0; j<tags.length; j++){
                for(int k=0; k<list.get(i).getTags().length; k++){
                    if(tags[j].equals(list.get(i).getTags()[k])){
                        matches++;
                        break;
                    }
                }
            }
            list.get(i).setMatches(matches);
            if(i == 0){
                result.add(list.get(i));
            } else{
                for(int j=0; j<result.size(); j++){
                    if(list.get(i).getMatches() > result.get(j).getMatches()){
                        result.add(j, list.get(i));
                        break;
                    }
                    else if(j == result.size() - 1){
                        result.add(list.get(i));
                        break;
                    }
                }
            }
        }
        return result;
    }
}
