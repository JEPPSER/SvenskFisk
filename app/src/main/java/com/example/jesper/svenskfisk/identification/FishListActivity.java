package com.example.jesper.svenskfisk.identification;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.jesper.svenskfisk.R;
import com.example.jesper.svenskfisk.display.DisplayFishActivity;
import com.example.jesper.svenskfisk.model.Fish;
import com.example.jesper.svenskfisk.model.FishContainer;
import com.example.jesper.svenskfisk.model.FishSorter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FishListActivity extends AppCompatActivity {

    private FishContainer container = new FishContainer();
    private LinearLayout vbox;
    private ArrayList<Fish> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_list);

        String[] tags = this.getIntent().getExtras().getStringArray("tags");

        search(); // Populates container.
        FishSorter sorter = new FishSorter();
        list = sorter.sort(container.getList(), tags); // Sorts container
        ImageView[] iv = new ImageView[list.size()];

        vbox = (LinearLayout) findViewById(R.id.vbox);

        for(int i=0; i<list.size(); i++){
            iv[i] = new ImageView(this);

            String name = list.get(i).getName().toLowerCase();
            String result = "";

            for(int j=0; j<name.length(); j++){
                if(name.charAt(j) == 'ö')
                    result += "o";
                else if(name.charAt(j) == 'å' || name.charAt(j) == 'ä')
                    result += "a";
                else
                    result += name.charAt(j);
            }
            name = result;

            int reIm = this.getResources().getIdentifier(name, "drawable", this.getPackageName());
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), reIm);
            iv[i].setImageBitmap(bitmap);
            iv[i].setAdjustViewBounds(true);
            iv[i].setId(i);
            vbox.addView(iv[i]);
            iv[i].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Fish fish = list.get(v.getId());
                    Intent display = new Intent(FishListActivity.this, DisplayFishActivity.class);
                    Bundle b = new Bundle();
                    b.putSerializable("fish", fish);
                    display.putExtras(b);
                    startActivity(display);
                }
            });
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
