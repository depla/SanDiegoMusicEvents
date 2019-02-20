package edu.miracostacollege.cs134.sandiegomusicevents;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import edu.miracostacollege.cs134.sandiegomusicevents.model.MusicEvent;

/**
 * Shows a list of artists to choose from
 *
 * @author Dennis La
 * @version 1.0
 */

public class MainActivity extends ListActivity {

    private ListView eventsListView;


    /**
     * extract data from MusicEvent.java and go to the details activity
     * @param l
     * @param v
     * @param position
     * @param id
     */
    //position is what the user clicked ie ariana grande is position 3
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        //extract the info we need
        String artist = MusicEvent.titles[position];
        String details = MusicEvent.details[position];

        //lets make the intent
        //navigate from this class to the EventDetailsActivity class
        Intent detailsIntent = new Intent(this, EventDetailsActivity.class);
        detailsIntent.putExtra("Artist", artist);
        detailsIntent.putExtra("Details", details);

        //start the activity
        startActivity(detailsIntent);

    }

    /**
     * inflates the activity with a listview
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //since the layout is being inflated with "android.R.layout.simple_expandable_list_item_1" ,
        // DON'T set the content view
        //setContentView(R.layout.activity_main);

        eventsListView = findViewById(R.id.eventsListView);

        //connect the listview with an ArrayAdpater to fill out the data
                                                                //this = show in this activity  simple..= layout item = text
        ArrayAdapter<String> eventsAdapter =
                new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, MusicEvent.titles);

        //set the adapter
        setListAdapter(eventsAdapter);

    }
}
