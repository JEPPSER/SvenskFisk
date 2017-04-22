package com.example.jesper.svenskfisk.display;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
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
    private ImageView fishImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_fish);

        fishText = (TextView) findViewById(R.id.fishText);
        Bundle b = this.getIntent().getExtras();
        Fish fish = (Fish) b.getSerializable("fish");
        fishText.setText(fish.getName());

        fishImage = (ImageView) findViewById(R.id.fishImage);

        String name = fish.getName().toLowerCase();
        String result = "";

        for(int i=0; i<name.length(); i++){
            if(name.charAt(i) == 'ö')
                result += "o";
            else if(name.charAt(i) == 'å' || name.charAt(i) == 'ä')
                result += "a";
            else
                result += name.charAt(i);
        }
        name = result;

        int reIm = this.getResources().getIdentifier(name, "drawable", this.getPackageName());
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), reIm);
        fishImage.setImageBitmap(bitmap);
    }
}
