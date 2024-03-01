package com.example.group3_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class account_User extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Button btn_show = findViewById(R.id.user_show);
        Button btn_adopt = findViewById(R.id.user_adopt);

        btn_show.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(account_User.this, ShowDogsActivity.class));
            }
        });

        btn_adopt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(account_User.this, AdoptDogs.class));
            }
        });
    }
}
