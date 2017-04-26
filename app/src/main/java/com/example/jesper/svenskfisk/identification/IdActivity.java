package com.example.jesper.svenskfisk.identification;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.jesper.svenskfisk.R;

import java.util.ArrayList;

public class IdActivity extends AppCompatActivity {

    private CheckBox sotBox;
    private CheckBox saltBox;
    private CheckBox brackBox;
    private CheckBox gronBox;
    private CheckBox rodBox;
    private CheckBox brunBox;
    private CheckBox silverBox;
    private CheckBox morkBox;
    private CheckBox ljusBox;
    private CheckBox smalBox;
    private CheckBox tjockBox;
    private CheckBox plattBox;
    private Button okBtn;
    private String[] tags;
    private CheckBox[] boxes;
    private final String[] allTags = {"Sötvatten", "Saltvatten", "Bräckvatten", "Grön", "Röd", "Brun", "Silver", "Mörk", "Ljus", "Smal", "Tjock", "Platt",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id);

        // Set checkboxes
        sotBox = (CheckBox) findViewById(R.id.sotBox);
        saltBox = (CheckBox) findViewById(R.id.saltBox);
        brackBox = (CheckBox) findViewById(R.id.brackBox);
        gronBox = (CheckBox) findViewById(R.id.gronBox);
        rodBox = (CheckBox) findViewById(R.id.rodBox);
        brunBox = (CheckBox) findViewById(R.id.brunBox);
        silverBox = (CheckBox) findViewById(R.id.silverBox);
        morkBox = (CheckBox) findViewById(R.id.morkBox);
        ljusBox = (CheckBox) findViewById(R.id.ljusBox);
        smalBox = (CheckBox) findViewById(R.id.smalBox);
        tjockBox = (CheckBox) findViewById(R.id.tjockBox);
        plattBox = (CheckBox) findViewById(R.id.plattBox);

        CheckBox[] temp = {sotBox, saltBox, brackBox, gronBox, rodBox, brunBox, silverBox, morkBox, ljusBox, smalBox, tjockBox, plattBox};
        boxes = temp;

        // Set button
        okBtn = (Button) findViewById(R.id.okBtn);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<String> tempTags = new ArrayList<String>();

                for(int i=0; i<boxes.length; i++){
                    if(boxes[i].isChecked()){
                        tempTags.add(allTags[i]);
                    }
                }

                tags = new String[tempTags.size()];
                tags = tempTags.toArray(tags);
                Intent list = new Intent(IdActivity.this, FishListActivity.class);
                list.putExtra("tags", tags);
                startActivity(list);
            }
        });
    }
}
