package com.example.group3_finalproject.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.group3_finalproject.R;

public class DogHolder extends RecyclerView.ViewHolder{
    TextView dogid, dogname, dogbreed;

    public DogHolder(@NonNull View itemView) {
        super(itemView);
        dogid = itemView.findViewById(R.id.list_id);
        dogname = itemView.findViewById(R.id.list_Name);
        dogbreed = itemView.findViewById(R.id.list_breed);
    }
}
