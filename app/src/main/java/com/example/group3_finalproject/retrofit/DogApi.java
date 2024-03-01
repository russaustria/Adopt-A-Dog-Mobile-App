package com.example.group3_finalproject.retrofit;

import com.example.group3_finalproject.model.Dog;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface DogApi {
    @GET("/api/dogs")
    Call<List<Dog>> getAllDogs();

    @POST("/api/add-dog")
    Call <Dog> save(@Body Dog dog);

    @PUT("/api/update-dog")
    Call <Dog> updateDog(@Body Dog dog);

    @DELETE("/api/dogs/{id}")
    Call <Dog> deleteDog(@Path("id") int id);
}