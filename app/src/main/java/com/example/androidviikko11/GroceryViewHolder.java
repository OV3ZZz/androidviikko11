package com.example.androidviikko11;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;

public class GroceryViewHolder extends RecyclerView.ViewHolder {
    TextView txtGroceryName, txtGroceryNote;

    ImageView imageDelete, imageEdit;

    EditText editTextGroceryNote;

    public GroceryViewHolder(@NonNull View itemView) {
        super(itemView);
        txtGroceryName = itemView.findViewById(R.id.textGroceryName);
        txtGroceryNote = itemView.findViewById(R.id.textGroceryNote);
        imageDelete = itemView.findViewById(R.id.imageDelete);
        imageEdit = itemView.findViewById(R.id.imageEdit);
        editTextGroceryNote = itemView.findViewById(R.id.editTextGroceryNote);
    }

}
