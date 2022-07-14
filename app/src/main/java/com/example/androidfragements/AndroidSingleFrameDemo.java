package com.example.androidfragements;

import androidx.appcompat.app.AppCompatActivity;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;

public class AndroidSingleFrameDemo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration configuration = getResources().getConfiguration();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        /*Checking Configuration of Device*/

        if(configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){

            /*Landscape Mode of the Device*/

            landscapeModeFragment lm  = new landscapeModeFragment();
            fragmentTransaction.replace(android.R.id.content, lm);
        }else if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT){

            /*Portrait Mode will be displayed*/

            portraitModeFragment pm = new portraitModeFragment();
            fragmentTransaction.replace(android.R.id.content, pm);
        }
        fragmentTransaction.commit();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        onDestroy();
    }


}