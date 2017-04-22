package com.example.jesper.svenskfisk.display;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.jesper.svenskfisk.R;
import com.example.jesper.svenskfisk.model.Fish;

/**
 * Activity that displays a fish and it's information that has been
 * selected from a list in the parent activity.
 * @author Jesper Bergstrom
 */
public class DisplayFishActivity extends AppCompatActivity {

    private TextView fishText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_fish);
        fishText = (TextView) findViewById(R.id.fishText);
        Bundle b = this.getIntent().getExtras();
        Fish fish = (Fish) b.getSerializable("fish");
        fishText.setText(fish.getName());
    }
}
