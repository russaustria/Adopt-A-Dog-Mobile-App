package com.example.group3_finalproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.group3_finalproject.model.Dog;
import com.example.group3_finalproject.retrofit.RetrofitService;
import com.example.group3_finalproject.retrofit.DogApi;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateDogsActivity extends AppCompatActivity {
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_dogs);

        initializeComponents();
    }

    private void initializeComponents() {
        EditText update_dogid = findViewById(R.id.form_inputId);
        EditText update_dogname = findViewById(R.id.form_updatename);
        EditText update_dogbreed = findViewById(R.id.form_updatebreed);
        EditText update_dognature = findViewById(R.id.form_updatenature);
        EditText update_dogcolor = findViewById(R.id.form_updatecolor);
        EditText update_dogsize = findViewById(R.id.form_updatesize);
        EditText update_dogage = findViewById(R.id.form_updateage);
        Button btn_update_dog = findViewById(R.id.form_buttonUpdate);

        RetrofitService retrofitService = new RetrofitService();
        DogApi dogApi = retrofitService.getRetrofit().create(DogApi.class);

        btn_update_dog.setOnClickListener(view ->{
            String dogid = String.valueOf(update_dogid.getText());
            String updatename = String.valueOf(update_dogname.getText());
            String updatebreed = String.valueOf(update_dogbreed.getText());
            String updatenature = String.valueOf(update_dognature.getText());
            String updatecolor = String.valueOf(update_dogcolor.getText());
            String updatesize = String.valueOf(update_dogsize.getText());
            String updateage = String.valueOf(update_dogage.getText());

            Dog dog = new Dog();
            dog.setId(Integer.parseInt(dogid));
            dog.setDogname(updatename);
            dog.setDogbreed(updatebreed);
            dog.setDognature(updatenature);
            dog.setDogcolor(updatecolor);
            dog.setDogsize(updatesize);
            dog.setDogage(updateage);

            dogApi.save(dog)
                    .enqueue(new Callback<Dog>(){
                        @Override
                        public void onResponse(Call<Dog> call, Response<Dog> response) {
                            Toast.makeText(UpdateDogsActivity.this,"Save Successfully!", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Dog> call, Throwable t) {
                            Toast.makeText(UpdateDogsActivity.this, "Save Failed!", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(UpdateDogsActivity.class.getName()).log(Level.SEVERE, "Error Occurred", t);
                        }
                    });
        });
    }

}