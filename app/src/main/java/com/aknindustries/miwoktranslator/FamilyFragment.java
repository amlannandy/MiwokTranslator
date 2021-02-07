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

public class FamilyFragment extends Fragment implements ListItemClicked {

    public FamilyFragment() { }

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_family, container, false);

        final ArrayList<Word> words = new ArrayList<Word>(List.of(
                new Word("father", "әpә", AppCompatResources.getDrawable(getActivity(), R.drawable.family_father), R.raw.family_father),
                new Word("mother", "әṭa", AppCompatResources.getDrawable(getActivity(), R.drawable.family_mother), R.raw.family_mother),
                new Word("son", "angsi", AppCompatResources.getDrawable(getActivity(), R.drawable.family_son), R.raw.family_son),
                new Word("daughter", "tune", AppCompatResources.getDrawable(getActivity(), R.drawable.family_daughter), R.raw.family_daughter),
                new Word("older brother", "taachi", AppCompatResources.getDrawable(getActivity(), R.drawable.family_older_brother), R.raw.family_older_brother),
                new Word("younger brother", "chalitti", AppCompatResources.getDrawable(getActivity(), R.drawable.family_younger_brother), R.raw.family_younger_brother),
                new Word("older sister", "teṭe", AppCompatResources.getDrawable(getActivity(), R.drawable.family_older_sister), R.raw.family_older_sister),
                new Word("younger sister", "kolliti", AppCompatResources.getDrawable(getActivity(), R.drawable.family_younger_sister), R.raw.family_younger_sister),
                new Word("grandmother ", "ama", AppCompatResources.getDrawable(getActivity(), R.drawable.family_grandmother), R.raw.family_grandmother),
                new Word("grandfather", "paapa", AppCompatResources.getDrawable(getActivity(), R.drawable.family_grandfather), R.raw.family_grandfather)
        ));

        RecyclerView recyclerView = rootView.findViewById(R.id.family_list);
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