package com.example.pprus.booklistingappforudacity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText inputField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSearchTextBox();
        initTheSearchButton();
    }

    private void initSearchTextBox() {
        inputField = (EditText)findViewById(R.id.input_field_text_view);
    }

    private void initTheSearchButton() {
        Button searchButton = (Button)findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BookListActivity.class);
                intent.putExtra(String.valueOf(R.string.book_search_sentence), inputField.getText().toString());
                startActivity(intent);
            }
        });
    }
}

