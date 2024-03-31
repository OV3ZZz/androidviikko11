package com.example.androidviikko11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GroceryListAdapter extends RecyclerView.Adapter<GroceryViewHolder> {

    private Context context;
    private ArrayList<Grocery> groceries;

    public GroceryListAdapter(ArrayList<Grocery> groceries) {
        this.groceries = groceries;
    }

    @NonNull
    @Override
    public GroceryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new GroceryViewHolder(LayoutInflater.from(context).inflate(R.layout.grocery_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryViewHolder holder, int position) {
        Grocery grocery = groceries.get(position);
        holder.txtGroceryName.setText(grocery.getGroceryName());
        holder.txtGroceryNote.setText(grocery.getGroceryNote());

        holder.imageEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.editTextGroceryNote.getVisibility() == View.VISIBLE) {
                    String newNote = holder.editTextGroceryNote.getText().toString();
                    grocery.setGroceryNote(newNote);
                    holder.editTextGroceryNote.setVisibility(View.GONE);
                    notifyDataSetChanged();
                } else {
                    holder.editTextGroceryNote.setVisibility(View.VISIBLE);
                    holder.editTextGroceryNote.requestFocus(); // Set focus to EditText
                }

            }
        });

        holder.imageDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Remove grocery from the list
                String name = grocery.getGroceryName();
                ListGrocery.getInstance().removeGrocery(name);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return groceries.size();
    }

}
