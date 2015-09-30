package com.ken.hadouken;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.IOException;


public class hadouken extends ActionBarActivity{

    final MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hadouken);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hadouken, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent i = new Intent();
        switch (item.getItemId()) {
            case R.id.menu_info:
                i.setClass(this, Info.class);
                startActivity(i);
                return true;
            case R.id.menu_table:
                i.setClass(this, Moves.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public void hadouken(View view) {

            if(mp.isPlaying())
            {
                mp.stop();
            }

            try {
                mp.reset();
                AssetFileDescriptor afd;
                afd = getAssets().openFd("hadouken.mp3");
                mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
                mp.prepare();
                mp.start();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
