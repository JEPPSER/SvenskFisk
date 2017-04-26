package com.example.jesper.svenskfisk.identification;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.jesper.svenskfisk.R;
import com.example.jesper.svenskfisk.model.Fish;
import com.example.jesper.svenskfisk.model.FishContainer;
import com.example.jesper.svenskfisk.model.FishSorter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FishListActivity extends AppCompatActivity {

    FishContainer container = new FishContainer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_list);

        String[] tags = this.getIntent().getExtras().getStringArray("tags");

        search(); // Populates container.
        FishSorter sorter = new FishSorter();
        ArrayList<Fish> list = sorter.sort(container.getList(), tags); // Sorts container

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i).getName());
        }
    }

    public void search(){
        InputStream iS;
        try {
            iS = getAssets().open("fish.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(iS, "ISO-8859-1"));
            String temp = reader.readLine();
            // Read the fish file
            while(!temp.equals("end")) {
                String[] parts = temp.split(":");
                temp = parts[1];
                if (parts[0].equals("Name")) {
                    Fish fish = new Fish();
                    fish.setName(temp);
                    container.add(fish);

                    // Set Scientific name
                    temp = reader.readLine();
                    parts = temp.split(":");
                    fish.setSciName(parts[1]);

                    // Set locations
                    temp = reader.readLine();
                    parts = temp.split(":");
                    fish.setLocations(parts[1]);

                    // Set waters
                    temp = reader.readLine();
                    parts = temp.split(":");
                    parts = parts[1].split(",");
                    fish.setWaters(parts);

                    // Set methods
                    temp = reader.readLine();
                    parts = temp.split(":");
                    fish.setMethod(parts[1]);

                    // Set food
                    temp = reader.readLine();
                    parts = temp.split(":");
                    fish.setFood(parts[1]);

                    // Set looks
                    temp = reader.readLine();
                    parts = temp.split(":");
                    parts = parts[1].split(",");
                    fish.setLooks(parts);

                    // Set normal weight
                    temp = reader.readLine();
                    parts = temp.split(":");
                    fish.setNormalWeight(Integer.parseInt(parts[1]));

                    // Set max weight
                    temp = reader.readLine();
                    parts = temp.split(":");
                    fish.setMaxWeight(Integer.parseInt(parts[1]));
                }
                else {
                    temp = reader.readLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
