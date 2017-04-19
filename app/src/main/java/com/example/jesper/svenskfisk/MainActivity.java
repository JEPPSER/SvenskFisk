package com.example.jesper.svenskfisk;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

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
        onBrowseBtnTap();
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

    public void onBrowseBtnTap() {
        browseBtn = (Button) findViewById(R.id.browseBtn);
        browseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browse = new Intent(MainActivity.this, BrowseActivity.class);

                startActivity(browse);
            }
        });
    }

    public void onIdBtnTap() {
        idBtn = (Button) findViewById(R.id.idBtn);
        idBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent identify = new Intent(MainActivity.this, IdActivity.class);

                startActivity(identify);
            }
        });
    }
}
