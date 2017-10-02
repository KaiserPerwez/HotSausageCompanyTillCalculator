package com.hotsausagecompany.app.hotsausagecompanytillcalculator;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer extends Activity {

    Button return_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        VideoView videoView = (VideoView)findViewById(R.id.VideoView);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoView.setVideoPath("/sdcard/app-tutorial.mp4");
        videoView.start();

        Button return_nav = (Button) findViewById(R.id.return_nav);
        return_nav.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent returnIntent = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(returnIntent, 0);
            }

        });


        }



    }
