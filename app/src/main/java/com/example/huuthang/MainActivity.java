package com.example.huuthang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    RecyclerView rcv;
    CustomRecyclerView adt;
    List<Song> mSongs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv = findViewById(R.id.rcv);
        mSongs = new ArrayList<Song>();

        mSongs.add(new Song("Phía Sau Một Cô Gái","Justin Biber",R.drawable.image,R.raw.phiasau));
        mSongs.add(new Song("Giá Như","Biber",R.drawable.image2,R.raw.bonchu));
        mSongs.add(new Song("Úm ba la","Biber",R.drawable.image,R.raw.chuabao));

        adt = new CustomRecyclerView(mSongs,this);
        rcv.setHasFixedSize(true);
        rcv.setAdapter(adt);
        rcv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

    }

    @Override
    public void clickItem(Song song) {
        Intent intent  = new Intent(MainActivity.this,PlaySong.class);
        intent.putExtra("song",song);
        intent.putExtra("listMusic", (Serializable) mSongs);
        intent.putExtra("index",mSongs.indexOf(song));
        startActivity(intent);
    }
}