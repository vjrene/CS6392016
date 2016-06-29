package com.example.fabianpatino.appdocknative;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.net.*;
import android.widget.*;

import java.net.URL;

public class EducationActivity extends AppCompatActivity {

    //embed this: https://www.youtube.com/watch?v=GzxMtrr1AZE

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edu_page);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        VideoView videoView =(VideoView)findViewById(R.id.beyeInterview);
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri=Uri.parse("rtsp://r3---sn-p5qlsnz6.googlevideo.com/Cj0LENy73wIaNAmRAfW6tkw8GxMYDSANFC2B3nJXMOCoAUIASARg2Yb58ObsyflVigELbWc3RGRFM29LV3MM/29B17F889CCE5FB7CF256C58CC8C108555EED441.31F791D6F7EAACCDB6E0B5F0D68F15587FD364B3/yt6/1/video.3gp");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

    }


}
