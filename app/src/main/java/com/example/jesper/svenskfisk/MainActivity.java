package com.example.jesper.svenskfisk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jesper.svenskfisk.search.SearchActivity;

/**
 * Main Activity. This is the start screen with the main functions
 * can be accessed.
 * @author Jesper Bergstrom
 */
public class MainActivity extends AppCompatActivity {

    private Button searchBtn;
    private Button idBtn;
    private Button browseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onSearchBtnTap();
    }

    public void onSearchBtnTap() {
        searchBtn = (Button) findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent search = new Intent(MainActivity.this, SearchActivity.class);

                startActivity(search);
            }
        });
    }
}
