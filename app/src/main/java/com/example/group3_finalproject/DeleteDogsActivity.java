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

public class DeleteDogsActivity extends AppCompatActivity {
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_dogs);

        initializeComponents();
    }
    private void initializeComponents() {
        EditText delete_dogid = findViewById(R.id.delete_id);
        Button btn_delete_dog = findViewById(R.id.form_buttonDelete);

        RetrofitService retrofitService = new RetrofitService();
        DogApi dogApi = retrofitService.getRetrofit().create(DogApi.class);

        btn_delete_dog.setOnClickListener(view ->{
            int id = Integer.parseInt(String.valueOf(delete_dogid.getText()));

            Dog dog = new Dog();
            dog.setId(id);

            dogApi.deleteDog(id)
                    .enqueue(new Callback<Dog>(){
                        @Override
                        public void onResponse(Call<Dog> call, Response<Dog> response) {
                            Toast.makeText(DeleteDogsActivity.this,"Successfully Deleted Data!", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Dog> call, Throwable t) {
                            Toast.makeText(DeleteDogsActivity.this, "Failed to Delete Data!", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(UpdateDogsActivity.class.getName()).log(Level.SEVERE, "Error Occurred", t);
                        }
                    });
        });

    }
}
