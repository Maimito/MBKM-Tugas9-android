package com.mbkm.tugas9_gits;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {

    private ArrayList<Daftar> daftar;
    private Context context;



    public AdapterRecyclerView(Context context, ArrayList<Daftar> daftar) {
        this.context = context;
        this.daftar = daftar;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.nama.setText(daftar.get(i).getNama());
        Glide.with(context).load(daftar.get(i).getUrl()).override(100, 100).into(viewHolder.gambar);

        final String link = daftar.get(i).getLink();

        WebViewActivity webViewActivity = new WebViewActivity();
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WebViewActivity.class);
                intent.putExtra("link", link);
                context.startActivity(intent);
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nama;
        ImageView gambar;
        CardView cardView;

        public ViewHolder(View view) {
            super(view);

            nama = (TextView) view.findViewById(R.id.judul);
            gambar = (ImageView) view.findViewById(R.id.imageView);
            cardView = (CardView) view.findViewById(R.id.Card);
        }
    }

    @Override
    public int getItemCount() {
        return daftar.size();
    }
}
