package com.kelvinhado.picme.data.source;

/**
 * Created by kelvin on 09/10/2017.
 */

public class Picture {

    private int albumId;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;

    public Picture() {
        // default constructor
    }

    public int getAlbumId() {
        return albumId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}
