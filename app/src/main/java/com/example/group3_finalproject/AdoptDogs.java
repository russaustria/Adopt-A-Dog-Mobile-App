package com.example.group3_finalproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.group3_finalproject.model.Dog;
import com.example.group3_finalproject.retrofit.DogApi;
import com.example.group3_finalproject.retrofit.RetrofitService;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdoptDogs extends AppCompatActivity {
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopt_dog);

        initializeComponents();
    }

    private void initializeComponents() {
        EditText adopt_dogid = findViewById(R.id.input_name);
        Button btn_submit_dog = findViewById(R.id.adopt_dog);

        RetrofitService retrofitService = new RetrofitService();
        DogApi dogApi = retrofitService.getRetrofit().create(DogApi.class);

        String dogname = String.valueOf(adopt_dogid);

        btn_submit_dog.setOnClickListener(view ->{

            Toast.makeText(AdoptDogs.this,"Thank you for adopting a dog! Your request has been sent to Veterinarian Clinic.", Toast.LENGTH_SHORT).show();

        });
    }
}