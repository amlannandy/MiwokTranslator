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

public class NumbersFragment extends Fragment implements ListItemClicked {

    public NumbersFragment() {

    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_numbers, container, false);

        final ArrayList<Word> numbers = new ArrayList<>(List.of(
                new Word("One", "lutti", AppCompatResources.getDrawable(getActivity(), R.drawable.number_one), R.raw.number_one),
                new Word("Two", "otiiko", AppCompatResources.getDrawable(getActivity(), R.drawable.number_two), R.raw.number_two),
                new Word("Three", "tolookosu", AppCompatResources.getDrawable(getActivity(), R.drawable.number_three), R.raw.number_three),
                new Word("Four", "oyyisa", AppCompatResources.getDrawable(getActivity(), R.drawable.number_four), R.raw.number_four),
                new Word("Five", "massokka", AppCompatResources.getDrawable(getActivity(), R.drawable.number_five), R.raw.number_five),
                new Word("Six", "temmokka", AppCompatResources.getDrawable(getActivity(), R.drawable.number_six), R.raw.number_six),
                new Word("Seven", "kenekaku", AppCompatResources.getDrawable(getActivity(), R.drawable.number_seven), R.raw.number_seven),
                new Word("Eight", "kawinta", AppCompatResources.getDrawable(getActivity(), R.drawable.number_eight), R.raw.number_eight),
                new Word("Nine", "wo’e", AppCompatResources.getDrawable(getActivity(), R.drawable.number_nine), R.raw.number_nine),
                new Word("Ten", "na’aacha", AppCompatResources.getDrawable(getActivity(), R.drawable.number_ten), R.raw.number_ten)
        ));

        RecyclerView recyclerView = rootView.findViewById(R.id.numbers_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        WordAdaptor wordAdaptor = new WordAdaptor(numbers, this);
        recyclerView.setAdapter(wordAdaptor);

        return rootView;
    }

    @Override
    public void onClick(int audioRes) {
        MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(), audioRes);
        mediaPlayer.start();
    }

}