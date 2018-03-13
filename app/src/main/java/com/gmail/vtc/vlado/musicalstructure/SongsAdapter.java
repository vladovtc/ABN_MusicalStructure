package com.gmail.vtc.vlado.musicalstructure;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user on 12.3.2018..
 */

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.MyViewHolder> {

    private List<Songs> songsList;

    public SongsAdapter(List<Songs> songsList) {
        this.songsList = songsList;
    }

    /**
     * View holder class
     */

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_row_picture);
            textView = itemView.findViewById(R.id.tv_row_title);
        }
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        final Songs songs = songsList.get(position);

        String s = String.valueOf(position + 1) + ". " + songs.getArtistAndSong();

        holder.imageView.setImageResource(songs.getPicture());
        holder.textView.setText(s);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), NowPlayingActivity.class);
                intent.putExtra("artist_name", songs.getArtistAndSong());
                intent.putExtra("artist_image", songs.getPicture());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return songsList.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_layout, parent, false);

        return new MyViewHolder(v);
    }
}