package com.aknindustries.miwoktranslator;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class PhrasesFragment extends Fragment implements ListItemClicked {

    public PhrasesFragment() { }

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_phrases, container, false);

        final ArrayList<Word> words = new ArrayList<>(List.of(
                new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going),
                new Word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name),
                new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is),
                new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling),
                new Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good),
                new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming),
                new Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming),
                new Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming),
                new Word("Let’s go.", "yoowutis", R.raw.phrase_lets_go),
                new Word("Come here.", "әnni'nem", R.raw.phrase_come_here)
        ));

        RecyclerView recyclerView = rootView.findViewById(R.id.phrases_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        WordAdaptor wordAdaptor = new WordAdaptor(words, this);
        recyclerView.setAdapter(wordAdaptor);

        return  rootView;
    }

    @Override
    public void onClick(int audioRes) {
        MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(), audioRes);
        mediaPlayer.start();
    }

}