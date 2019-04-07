package com.example.al_quran;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_2 extends Fragment implements MainView{
    List<QuranModel> quranModels = new ArrayList<>();
    QuranAdapter adapter;

    public Fragment_2(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_2, container, false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapter = new QuranAdapter(getContext(), quranModels);
        recyclerView.setAdapter(adapter);
        QuranData data = new QuranData(this,getContext());
        data.setData();
    }

    @Override
    public void onSucces(List<QuranModel> quranModels) {

        this.quranModels.clear();
        this.quranModels.addAll(quranModels);
        this.adapter.notifyDataSetChanged();

    }
}
