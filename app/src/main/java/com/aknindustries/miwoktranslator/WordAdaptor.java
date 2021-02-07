package com.aknindustries.miwoktranslator;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WordAdaptor extends RecyclerView.Adapter<WordViewHolder> {

    private final ArrayList<Word> words;
    private final ListItemClicked listItemClicked;

    public WordAdaptor(ArrayList<Word> words, ListItemClicked listItemClicked) {
        this.words = words;
        this.listItemClicked = listItemClicked;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item, parent, false);
        WordViewHolder wordViewHolder = new WordViewHolder(view);
        view.setOnClickListener(v -> this.listItemClicked.onClick(this.words.get(wordViewHolder.getAdapterPosition()).getAudioRes()));
        return wordViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String title = this.words.get(position).getMiwok();
        String subtitle = this.words.get(position).getEnglish();
        Drawable image = this.words.get(position).getImage();
        holder.title.setText(title);
        holder.subtitle.setText(subtitle);
        if (image != null)
            holder.image.setImageDrawable(image);
    }

    @Override
    public int getItemCount() {
        return this.words.size();
    }

}

class WordViewHolder extends RecyclerView.ViewHolder {

    final TextView title;
    final TextView subtitle;
    final ImageView image;

    public WordViewHolder(View view) {
        super(view);
        this.title = view.findViewById(R.id.title);
        this.subtitle = view.findViewById(R.id.subtitle);
        this.image = view.findViewById(R.id.image);
    }

}

interface ListItemClicked {

    void onClick(int audioRes);

}