package com.example.pprus.booklistingappforudacity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookListActivity extends AppCompatActivity {

    private static final String TAG = BookListActivity.class.getSimpleName();

    private static final String MAIN_URL = "https://www.googleapis.com/books/v1/";

    private RecyclerView recyclerView;
    private List<Book> data;
    private String searchValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
        initSearchValue();
        initViews();
    }

    private void initSearchValue() {
        Intent intent = getIntent();
        searchValue = intent.getStringExtra(String.valueOf(R.string.book_search_sentence));
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadJSON();
    }

    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MAIN_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<JSONResponse> call = request.getJSON(searchValue);
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {

                JSONResponse jsonResponse = response.body();
                data = jsonResponse.getItems();
                Log.d(TAG, "Number of books received: " + data.size());
//                Log.d("Data from server: ", String.valueOf(data));
                recyclerView.setAdapter(new BookAdapter(getApplicationContext(), data));
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Log.d("Error trying parse Json", t.getMessage());
            }
        });
    }
}
