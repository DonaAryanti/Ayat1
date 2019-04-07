package com.example.al_quran;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class QuranData {

    Context context ;
    List<QuranModel> quranModels = new ArrayList<>();
    MainView view ;

    public QuranData (MainView view, Context context){
        this.view=view;
        this.context=context;
    }
    public void setData (){
        QuranModel quran;

        quran= new QuranModel("",R.drawable.coverquran, "");
        quranModels.add(quran);
        quran= new QuranModel("",R.drawable.coverquran, "");
        quranModels.add(quran);


        view.onSucces(quranModels);


    }
}
