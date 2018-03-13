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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Initialize toolbar and properties
         */

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        /**
         * Set layout manager
         */

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        /**
         * Initialize RecyclerView and set view to layout manager and populate it
         *      with Adapter
         */

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(linearLayoutManager);
        createList();
        songsAdapter = new SongsAdapter(songsList);
        recyclerView.addItemDecoration(new DividerItemDecoration(this
                , LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(songsAdapter);
    }

    /**
     * Populate list
     */

    private void createList() {

        songsList.add(new Songs(getString(R.string.chuck_berry_johnny), R.drawable.chuck_berry_johnny));
        songsList.add(new Songs(getString(R.string.elvis_presley_jailhouse), R.drawable.elvis_jailhouse));
        songsList.add(new Songs(getString(R.string.eddie_cochran_summertime), R.drawable.eddy_summertime));
        songsList.add(new Songs(getString(R.string.chuck_berry_maybellene), R.drawable.chuck_maybellene));
        songsList.add(new Songs(getString(R.string.carl_perkins_blue_suede_shoes), R.drawable.carl_blue));
        songsList.add(new Songs(getString(R.string.everley_brothers_bye_bye), R.drawable.everly_bye));
        songsList.add(new Songs(getString(R.string.jeery_lee_lewis_great_balls), R.drawable.lewis_fire));
        songsList.add(new Songs(getString(R.string.penguins_earth_angel), R.drawable.penguins_angel));
        songsList.add(new Songs(getString(R.string.gene_vincent_be_bop), R.drawable.gene_lula));
        songsList.add(new Songs(getString(R.string.ritchie_valens_la_bamba), R.drawable.valens_bamba));
        songsList.add(new Songs(getString(R.string.everly_brothers_all_i_have_is), R.drawable.everly_dream));
    }
}
