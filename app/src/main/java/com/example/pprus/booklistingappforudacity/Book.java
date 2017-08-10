package com.example.pprus.booklistingappforudacity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Piotr Prus on 01.08.2017.
 */

public class Book {
    @SerializedName("volumeInfo")
    private VolumeInfo volumeInfo;

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }
}
