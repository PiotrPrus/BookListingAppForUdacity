package com.example.pprus.booklistingappforudacity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Piotr Prus on 04.08.2017.
 */

public class VolumeInfo {
    @SerializedName("title")
    private String title;
    @SerializedName("publisher")
    private String publisher;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
