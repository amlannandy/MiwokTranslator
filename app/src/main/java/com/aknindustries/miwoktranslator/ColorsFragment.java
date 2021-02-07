package com.aknindustries.miwoktranslator;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ColorsFragment extends Fragment implements ListItemClicked {

    public ColorsFragment() { }

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_colors, container, false);

        final ArrayList<Word> words = new ArrayList<>(List.of(
                new Word("red", "weṭeṭṭi", AppCompatResources.getDrawable(getActivity(), R.drawable.color_red), R.raw.color_red),
                new Word("mustard yellow", "chiwiiṭә", AppCompatResources.getDrawable(getActivity(), R.drawable.color_mustard_yellow), R.raw.color_mustard_yellow),
                new Word("dusty yellow", "ṭopiisә", AppCompatResources.getDrawable(getActivity(), R.drawable.color_dusty_yellow), R.raw.color_dusty_yellow),
                new Word("green", "chokokki", AppCompatResources.getDrawable(getActivity(), R.drawable.color_green), R.raw.color_dusty_yellow),
                new Word("brown", "ṭakaakki", AppCompatResources.getDrawable(getActivity(), R.drawable.color_brown), R.raw.color_brown),
                new Word("gray", "ṭopoppi", AppCompatResources.getDrawable(getActivity(), R.drawable.color_gray), R.raw.color_gray),
                new Word("black", "kululli", AppCompatResources.getDrawable(getActivity(), R.drawable.color_black), R.raw.color_green),
                new Word("white", "kelelli", AppCompatResources.getDrawable(getActivity(), R.drawable.color_white), R.raw.color_white)
        ));

        RecyclerView recyclerView = rootView.findViewById(R.id.colors_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        WordAdaptor wordAdaptor = new WordAdaptor(words, this);
        recyclerView.setAdapter(wordAdaptor);

        return rootView;
    }

    @Override
    public void onClick(int audioRes) {
        MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(), audioRes);
        mediaPlayer.start();
    }
}