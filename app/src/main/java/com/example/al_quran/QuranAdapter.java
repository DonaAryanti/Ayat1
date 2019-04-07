package com.example.al_quran;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QuranAdapter extends RecyclerView.Adapter<QuranAdapter.ViewHolder> {
    Context context;
    List<QuranModel> quranModels = new ArrayList<>();

    public QuranAdapter (Context context, List<QuranModel> quranModels) {
        this.context = context;
        this.quranModels = quranModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_view, viewGroup, false);
        ViewHolder holder =  new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuranAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.tvName.setText(quranModels.get(i).getName());
        viewHolder.imageView.setImageResource(quranModels.get(i).getGambar());
        viewHolder.overview.setText(quranModels.get(i).getOverview());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, quranModels.get(i).getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return quranModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, overview;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_1);
            imageView = itemView.findViewById(R.id.iv_g1);
            overview = itemView.findViewById(R.id.tv_overview);
        }
    }
}
