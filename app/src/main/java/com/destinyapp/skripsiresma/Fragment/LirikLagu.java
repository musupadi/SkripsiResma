package com.destinyapp.skripsiresma.Fragment;


import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.destinyapp.skripsiresma.R;

import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 */
public class LirikLagu extends Fragment {

    Button Play,Pause;
    TextView namaLagu,lirikLagu;

    public LirikLagu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lirik_lagu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //GetString
        final String NamaLagu = this.getArguments().getString("NamaLagu").toString();
        final String Lirik = this.getArguments().getString("Lirik").toString();
        final String Lagu = this.getArguments().getString("Lagu").toString();
        //Done

        //Get Variable
        namaLagu = (TextView)view.findViewById(R.id.tvNamaLagu);
        lirikLagu = (TextView)view.findViewById(R.id.tvLirikLagu);
        Play = (Button)view.findViewById(R.id.btnPlay);
        Pause = (Button)view.findViewById(R.id.btnPause);
        //Done
        getData(NamaLagu,Lirik);
        getLagu(Lagu);
    }
    private void getData(String NamaLagu,String Lirik){
        namaLagu.setText(NamaLagu);
        lirikLagu.setText(Lirik);
    }
    private void getLagu(String Lagu){
        final MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(Lagu);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mediaPlayer.prepare(); // might take long! (for buffering, etc)
        } catch (IOException e) {
            e.printStackTrace();
        }
        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });
        Pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });
    }
}
