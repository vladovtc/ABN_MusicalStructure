package com.gmail.vtc.vlado.musicalstructure;

/**
 * Created by user on 12.3.2018..
 */

public class Songs {

    private String artistAndSong;
    private int picture;

    public Songs(String artist, int picture) {
        this.artistAndSong = artist;
        this.picture = picture;
    }

    public String getArtistAndSong() {
        return artistAndSong;
    }

    public int getPicture() {
        return picture;
    }
}
