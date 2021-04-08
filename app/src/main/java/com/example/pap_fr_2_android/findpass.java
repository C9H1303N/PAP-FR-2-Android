package com.example.pap_fr_2_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pap_fr_2_android.ui.main.ui.login.LoginActivity;

public class findpass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findpass);
        System.out.println("msdk");
        Button changelog = (Button) findViewById(R.id.back);
        changelog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findpass.this.finish();
            }
        });
    }
}