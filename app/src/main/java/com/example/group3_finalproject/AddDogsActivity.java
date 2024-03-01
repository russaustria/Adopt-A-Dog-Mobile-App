package com.example.group3_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.group3_finalproject.model.Dog;
import com.example.group3_finalproject.retrofit.RetrofitService;
import com.example.group3_finalproject.retrofit.DogApi;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddDogsActivity extends AppCompatActivity{
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dogs);

        initializeComponents();
    }

    private void initializeComponents() {
        EditText input_dogname = findViewById(R.id.input_name);
        EditText input_dogbreed = findViewById(R.id.input_breed);
        EditText input_dognature = findViewById(R.id.input_nature);
        EditText input_dogcolor = findViewById(R.id.input_color);
        EditText input_dogsize = findViewById(R.id.input_size);
        EditText input_dogage = findViewById(R.id.input_age);
        Button btn_add_dog = findViewById(R.id.form_buttonAdd);

        RetrofitService retrofitService = new RetrofitService();
        DogApi dogApi = retrofitService.getRetrofit().create(DogApi.class);

        btn_add_dog.setOnClickListener(view ->{
            String dogname = String.valueOf(input_dogname.getText());
            String dogbreed = String.valueOf(input_dogbreed.getText());
            String dognature = String.valueOf(input_dognature.getText());
            String dogcolor = String.valueOf(input_dogcolor.getText());
            String dogsize = String.valueOf(input_dogsize.getText());
            String dogage = String.valueOf(input_dogage.getText());

            Dog dog = new Dog();
            dog.setDogname(dogname);
            dog.setDogbreed(dogbreed);
            dog.setDognature(dognature);
            dog.setDogcolor(dogcolor);
            dog.setDogsize(dogsize);
            dog.setDogage(dogage);

            dogApi.save(dog)
                    .enqueue(new Callback<Dog>(){
                        @Override
                        public void onResponse(Call<Dog> call, Response<Dog> response) {
                            Toast.makeText(AddDogsActivity.this,"Save Successfully!", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Dog> call, Throwable t) {
                            Toast.makeText(AddDogsActivity.this, "Save Failed!", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(AddDogsActivity.class.getName()).log(Level.SEVERE, "Error Occurred", t);
                        }
                    });
        });
    }
}
