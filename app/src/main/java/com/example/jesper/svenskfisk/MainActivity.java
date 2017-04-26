package com.example.jesper.svenskfisk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.jesper.svenskfisk.identification.IdActivity;
import com.example.jesper.svenskfisk.search.SearchActivity;

/**
 * Main Activity. This is the start screen with the main functions
 * can be accessed.
 * @author Jesper Bergstrom
 * @name MainActivity.java
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
        onIdBtnTap();
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

    public void onIdBtnTap() {
        idBtn = (Button) findViewById(R.id.idBtn);
        idBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent id = new Intent(MainActivity.this, IdActivity.class);

                startActivity(id);
            }
        });
    }
}
