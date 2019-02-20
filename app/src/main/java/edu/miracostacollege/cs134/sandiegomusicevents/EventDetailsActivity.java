package edu.miracostacollege.cs134.sandiegomusicevents;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Shows a details of chosen artist's music event
 *
 * @author Dennis La
 * @version 1.0
 */

public class EventDetailsActivity extends AppCompatActivity {

    private ImageView eventImageView;
    private TextView eventTitleTextView;
    private TextView eventDetailsTextView;

    /**
     * extracts data from intent and updates the textviews. then displays an image from the assets
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        //lets retrieve the intent
        Intent mainIntent = getIntent();

        //lets extract the artist and details from the intent
        String artist = mainIntent.getStringExtra("Artist");
        String details = mainIntent.getStringExtra("Details");

        //remove all the white spaces from the artist name
        String imageName = artist.replaceAll(" ","") + ".png";


        //link the controller with the view
        eventImageView = findViewById(R.id.eventImageView);
        eventTitleTextView = findViewById(R.id.eventTitleTextView);
        eventDetailsTextView = findViewById(R.id.eventDetailsTextView);


        //fill the views with information
        eventTitleTextView.setText(artist);
        eventDetailsTextView.setText(details);

        //use the asset manager to load the correct image
        AssetManager am = getAssets();

        //define and InputStream to the selected image
        try {
            InputStream stream = am.open(imageName);

            //create a drawable object to display
            Drawable eventImage = Drawable.createFromStream(stream, artist);
            eventImageView.setImageDrawable(eventImage);

        } catch (IOException e) {
            Log.e("SD Music", e.getMessage());
        }
    }
}
