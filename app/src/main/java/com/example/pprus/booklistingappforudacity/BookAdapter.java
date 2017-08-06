package com.example.pprus.booklistingappforudacity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Piotr Prus on 01.08.2017.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private List<Book> bookList;

    public BookAdapter(List<Book> bookList) {
        this.bookList = bookList;
    }


    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cutom_book_card, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookAdapter.ViewHolder holder, int position) {
        holder.bookTitle.setText(bookList.get(position).getVolumeInfo().getTitle());
        holder.bookAuthors.setText(bookList.get(position).getVolumeInfo().getPublisher());
    }

    @Override
    public int getItemCount() {
        if (bookList != null && !bookList.isEmpty()) {
            return bookList.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView bookTitle;
        private TextView bookAuthors;

        public ViewHolder(View itemView) {
            super(itemView);

            bookTitle = (TextView) itemView.findViewById(R.id.book_title_text_view);
            bookAuthors = (TextView) itemView.findViewById(R.id.book_author_text_view);
        }
    }
}
