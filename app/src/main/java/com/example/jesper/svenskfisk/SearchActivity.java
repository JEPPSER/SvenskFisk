package com.example.jesper.svenskfisk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SearchView;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Activity for searching for fish. A list of matching results will be displayed.
 * @author Jesper Bergstrom
 */
public class SearchActivity extends AppCompatActivity {

    private SearchView searchView;
    private FishContainer container = new FishContainer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        search();
    }

    /**
     * Search method that searches through the fish database to see if
     * there are any matches with the search word. All matching fish will
     * get added to the FishContainer.
     */
    public void search(){
        searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {

                container.getList().clear();
                InputStream iS = null;
                try {
                    iS = getAssets().open("fish.txt");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(iS));
                    String temp = reader.readLine();
                    String[] parts = temp.split(":");
                    temp = parts[1];

                    if(parts[0].equals("Name") && temp.toLowerCase().contains(query.toLowerCase())){
                        Fish fish = new Fish();
                        fish.setName(temp);
                        //TODO: Set all other properties

                        container.add(fish);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(container.getList().size());
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
}
