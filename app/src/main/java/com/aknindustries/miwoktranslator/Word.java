package com.aknindustries.miwoktranslator;

import android.graphics.drawable.Drawable;

public class Word {

    private final String english;
    private final String miwok;
    private final int audioRes;
    private Drawable image = null;

    Word(String english, String miwok, int audioRes) {
        this.english = english;
        this.miwok = miwok;
        this.audioRes = audioRes;
    }

    Word(String english, String miwok, Drawable image, int audioRes) {
        this.english = english;
        this.miwok = miwok;
        this.image = image;
        this.audioRes = audioRes;
    }

    public String getEnglish() {
        return this.english;
    }

    public String getMiwok() {
        return this.miwok;
    }

    public Drawable getImage() { return this.image; }

    public int getAudioRes() { return  this.audioRes; }

}
