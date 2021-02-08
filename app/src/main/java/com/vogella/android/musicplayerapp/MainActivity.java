package com.vogella.android.musicplayerapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //display_song_list is a layout use by MainActivity to display the lists of songs.
        //display_song_list is a List view.
        setContentView(R.layout.display_song_list);

        //Creating an ArrayList to hold music object define in the Music.java file.
        ArrayList<Music> songs = new ArrayList<Music>();


        //Adding songs to the Music List.
        songs.add(new Music(getString(R.string.song1), getString(R.string.artist1), R.drawable.play_button));
        songs.add(new Music(getString(R.string.song2), getString(R.string.artist2), R.drawable.play_button));
        songs.add(new Music(getString(R.string.song3), getString(R.string.artist3), R.drawable.play_button));
        songs.add(new Music(getString(R.string.song4), getString(R.string.artist4), R.drawable.play_button));
        songs.add(new Music(getString(R.string.song5), getString(R.string.artist5), R.drawable.play_button));
        songs.add(new Music(getString(R.string.song6), getString(R.string.artist6), R.drawable.play_button));
        songs.add(new Music(getString(R.string.song7), getString(R.string.artist7), R.drawable.play_button));
        songs.add(new Music(getString(R.string.song8), getString(R.string.artist8), R.drawable.play_button));
        songs.add(new Music(getString(R.string.song9), getString(R.string.artist9), R.drawable.play_button));
        songs.add(new Music(getString(R.string.song10), getString(R.string.artist10), R.drawable.play_button));
        songs.add(new Music(getString(R.string.song11), getString(R.string.artist11), R.drawable.play_button));
        songs.add(new Music(getString(R.string.song12), getString(R.string.artist12), R.drawable.play_button));
        songs.add(new Music(getString(R.string.song13), getString(R.string.artist13), R.drawable.play_button));


        //Creating a Adapter.
        //Adapter is a device for connecting pieces of equipment that cannot be connected directly
        //The ArrayList and ListView in the display_song_list cannot be connected together.
        //Therefore, an adapter is needed  to connect the two.
        /*
            @this -> the activity
            @songs -> the ArrayList of songs
         */
        customAdapter songListAdapter = new customAdapter(this, songs);

        //Selecting the ListView with id list in the display_song_list.xml
        ListView listview = (ListView) findViewById(R.id.list);

        //Displaying the list items in the display_song_list.xml file
        listview.setAdapter(songListAdapter);


    }
}

