package com.gmail.vtc.vlado.musicalstructure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Songs> songsList = new ArrayList<>();

    SongsAdapter songsAdapter;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        createList();
        songsAdapter = new SongsAdapter(songsList);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(songsAdapter);
    }

    private void createList() {

        songsList.add(new Songs("Chuck Berry - Johnny B. Goode", R.drawable.chuck_berry_johnny));
        songsList.add(new Songs("Elvis Presley - Jailhouse Rock", R.drawable.elvis_jailhouse));
        songsList.add(new Songs("Eddie Cochran - Summertime Blues", R.drawable.eddy_summertime));
        songsList.add(new Songs("Chuck Berry - Maybellene", R.drawable.chuck_maybellene));
        songsList.add(new Songs("Carl Perkins - Blue Suede Shoes", R.drawable.carl_blue));
        songsList.add(new Songs("Everly Brothers - Bye Bye Love", R.drawable.everly_bye));
        songsList.add(new Songs("Jerry Lee Lewis - Great Balls Of Fire", R.drawable.lewis_fire));
        songsList.add(new Songs("Penguins - Earth Angel", R.drawable.penguins_angel));
        songsList.add(new Songs("Gene Vincent & the Bluecaps - Be-Bop-A-Lula", R.drawable.gene_lula));
        songsList.add(new Songs("Ritchie Valens - La Bamba", R.drawable.valens_bamba));
        songsList.add(new Songs("Everly Brothers - All I Have To Do Is Dream", R.drawable.everly_dream));
    }
}
