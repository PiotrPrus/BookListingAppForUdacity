package com.example.pprus.booklistingappforudacity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Piotr Prus on 09.08.2017.
 */

public class ImageLinks {
    @SerializedName("thumbnail")
    String thumbnail;

    public String getThumbnail() {
        return thumbnail;
    }
}
