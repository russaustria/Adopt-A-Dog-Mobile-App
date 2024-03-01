package com.example.group3_finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.group3_finalproject.adapter.DogAdapter;
import com.example.group3_finalproject.model.Dog;
import com.example.group3_finalproject.retrofit.RetrofitService;
import com.example.group3_finalproject.retrofit.DogApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowDogsActivity extends AppCompatActivity{
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_dogs);

        recyclerView = findViewById(R.id.recycler_dogList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadDogs();
    }

    private void loadDogs() {
        RetrofitService retrofitService = new RetrofitService();
        DogApi dogApi = retrofitService.getRetrofit().create(DogApi.class);
        dogApi.getAllDogs()
                .enqueue(new Callback<List<Dog>>() {
                    @Override
                    public void onResponse(Call<List<Dog>> call, Response<List<Dog>> response) {
                        populateListView(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Dog>> call, Throwable t) {
                        Toast.makeText(ShowDogsActivity.this, "Failed to load users", Toast.LENGTH_SHORT).show();
                    }
                });
    }
        private void populateListView(List<Dog> dogList){
            DogAdapter dogAdapter = new DogAdapter(dogList);
            recyclerView.setAdapter(dogAdapter);
    }
}
