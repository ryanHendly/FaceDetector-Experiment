package com.example.ryan.facerecogniser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EngineerMainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engineer_main_menu);
    }

    public void onClickPersonal(View v) {
        startActivity(new Intent(EngineerMainMenu.this, PersonalData.class));

    }

    public void onClickReset(View v) {
        startActivity(new Intent(EngineerMainMenu.this, Camera.class));

    }
}
