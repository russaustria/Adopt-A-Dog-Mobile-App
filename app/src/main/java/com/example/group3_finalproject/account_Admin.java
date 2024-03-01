package com.example.group3_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class account_Admin extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Button btn_Add = findViewById(R.id.dogadd);
        Button btn_Show = findViewById(R.id.dogshow);
        Button btn_Update = findViewById(R.id.dogupdate);
        Button btn_Delete = findViewById(R.id.dogdelete);

        btn_Add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(account_Admin.this, AddDogsActivity.class));
            }
        });

        btn_Show.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(account_Admin.this, ShowDogsActivity.class));
            }
        });

        btn_Update.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(account_Admin.this, UpdateDogsActivity.class));
            }
        });

        btn_Delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(account_Admin.this, DeleteDogsActivity.class));
            }
        });
    }
}
