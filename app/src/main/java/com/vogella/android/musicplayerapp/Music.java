package com.vogella.android.musicplayerapp;

/*
 *  A class to represent the song object.
 * The song has an artist and a title.
 * */

public class Music {

    private final String title;
    private final String artist;
    private final int playImage;

    Music(String title, String artist, int playImage) {
        this.title = title;
        this.artist = artist;
        this.playImage = playImage;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public Integer getImage() {
        return playImage;
    }
}
