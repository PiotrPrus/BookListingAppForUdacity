package com.example.pprus.booklistingappforudacity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Piotr Prus on 01.08.2017.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private List<Book> bookList;
    private Context context;

    public BookAdapter(Context context, List<Book> bookList) {
        this.context = context;
        this.bookList = bookList;
    }


    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cutom_book_card, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookAdapter.ViewHolder holder, int position) {
        holder.bookTitleTextView.setText(bookList.get(position).getVolumeInfo().getTitle());
        holder.bookSubtitleTextView.setText(bookList.get(position).getVolumeInfo().getSubtitle());
        String publishedDate = context.getString(R.string.published_in) + bookList.get(position).getVolumeInfo().getPublishedDate();
        holder.bookPublishedDateTextView.setText(publishedDate);
        holder.bookAuthorsTextView.setText(concatenateAuthorsText(position));
        Picasso.with(context).load(bookList.get(position).getVolumeInfo().getImageLinks().getThumbnail()).into(holder.bookCoverImageView);
    }

    @NonNull
    private String concatenateAuthorsText(int position) {
        StringBuilder sb = new StringBuilder();
        String[] authors = bookList.get(position).getVolumeInfo().getAuthors();
        for (String author : authors) {
            sb.append(author);
            sb.append("\n");
        }
        String authorsMultiline = sb.toString();
        return context.getString(R.string.written_by) + authorsMultiline;
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
        private TextView bookTitleTextView;
        private TextView bookAuthorsTextView;
        private TextView bookPublishedDateTextView;
        private TextView bookSubtitleTextView;
        private ImageView bookCoverImageView;

        public ViewHolder(View itemView) {
            super(itemView);

            bookTitleTextView = (TextView) itemView.findViewById(R.id.book_title_text_view);
            bookAuthorsTextView = (TextView) itemView.findViewById(R.id.book_author_text_view);
            bookCoverImageView = (ImageView) itemView.findViewById(R.id.book_cover_image_view);
            bookPublishedDateTextView = (TextView) itemView.findViewById(R.id.published_date_text_view);
            bookSubtitleTextView = (TextView) itemView.findViewById(R.id.book_subtitle_text_view);
        }
    }
}
