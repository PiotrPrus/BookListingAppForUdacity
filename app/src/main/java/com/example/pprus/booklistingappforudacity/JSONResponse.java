package com.example.pprus.booklistingappforudacity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Piotr Prus on 01.08.2017.
 */

public class JSONResponse {
    @SerializedName("items")
    private List<Book> items;

    public List<Book> getItems() {
        return items;
    }
}
