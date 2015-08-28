package com.mr.vigoss.t_defender.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.mr.vigoss.t_defender.R;

public class SplashActivity extends AppCompatActivity {
    private Thread splashTread;
    protected boolean _active = true;
    protected int _splashTime = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        showFlashScreen();
    }

    private void showFlashScreen() {
        splashTread = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    int waited = 0;
                    while (_active && waited < _splashTime) {
                        sleep(100);
                        if (_active) {
                            waited += 100;
                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    gotoActivity();
                    interrupt();
                }
            }
        };
        splashTread.start();
    }

    private void gotoActivity() {
    }
}
