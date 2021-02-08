package com.vogella.android.musicplayerapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

//Extending the ArrayAdapter class to rewrite the getView method
public class customAdapter extends ArrayAdapter<Music> {

    //View Lookup cache
    private static class ViewHolder {
        TextView song;
        TextView artist;
        ImageView playButton;
    }

    //Constructor  is calling the ArrayAdapter's class constructor.
    public customAdapter(Context context, ArrayList<Music> playlist) {
        super(context, 0, playlist);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Get the data item for this position

        //final prevents the value from being change.
        // On line 69 and 70, song.getTitle is being access inside the setOnClickListener Method.
        // To prevent changing the song attributes, the keyword final is used.
        // It is weird that that final has to be use, even though setOnClickListener is just
        // reading the data.
        final Music song = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            //song_layout is a template used by customerAdapter to display the song object
            convertView = inflater.inflate(R.layout.song_layout, parent, false);
            viewHolder.song = (TextView) convertView.findViewById(R.id.Song);
            viewHolder.artist = (TextView) convertView.findViewById(R.id.Artist);
            viewHolder.playButton = (ImageView) convertView.findViewById(R.id.play_button);
            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data from the data object via the viewHolder object
        // into the template view.

        //(position + 1) is used to number the songs.
        String title = (position + 1) + ". " + song.getTitle();
        String artist = song.getArtist();
        viewHolder.song.setText(title);
        viewHolder.artist.setText(artist);
        viewHolder.playButton.setImageResource(song.getImage());

        //On Click listener to launch now playing activity
        viewHolder.playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent NowPlaying = new Intent(getContext(), NowPlayingActivity.class);

                //putExtra is used to add additional information to the Intent

                //The activity that received  the intent will be use to add extra information.
                NowPlaying.putExtra("title", song.getTitle());
                NowPlaying.putExtra("song", song.getArtist());
                NowPlaying.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(NowPlaying);


            }
        });


        // Return the completed view to render on screen
        return convertView;
    }


}
