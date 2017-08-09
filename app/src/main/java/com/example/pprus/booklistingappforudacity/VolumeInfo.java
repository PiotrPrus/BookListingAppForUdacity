package com.example.pprus.booklistingappforudacity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Piotr Prus on 04.08.2017.
 */

public class VolumeInfo {
    @SerializedName("title")
    private String title;
    @SerializedName("subtitle")
    private String subtitle;
    @SerializedName("authors")
    private String[] authors;
    @SerializedName("publishedDate")
    private String publishedDate;
    @SerializedName("imageLinks")
    private ImageLinks imageLinks;

    public String getTitle() {
        return title;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public ImageLinks getImageLinks() {
        return imageLinks;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String[] getAuthors() {
        return authors;
    }
}

