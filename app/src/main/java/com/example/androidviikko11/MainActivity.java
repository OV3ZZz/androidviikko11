package com.example.androidviikko11;

import android.content.Intent;
import android.os.Bundle;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private Button buttonAddNewGrocery;
    private ImageView imageAlphabet;
    private ImageView imageTime;
    private RecyclerView rvGroceries;
    private GroceryListAdapter groceryListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;
        buttonAddNewGrocery = findViewById(R.id.buttonAddNewGrocery);
        imageAlphabet = findViewById(R.id.imageAlphabet);
        imageTime = findViewById(R.id.imageTime);
        rvGroceries = findViewById(R.id.rvGroceries);

        ListGrocery listGrocery = ListGrocery.getInstance();
        ArrayList<Grocery> groceries = listGrocery.getGroceries();

        updateGroceryList();

        groceryListAdapter = new GroceryListAdapter(groceries);
        rvGroceries.setAdapter(groceryListAdapter);
        rvGroceries.setLayoutManager(new LinearLayoutManager(this));

        buttonAddNewGrocery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddGroceryActivity();
            }
        });


        imageAlphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortGroceriesByAlphabet();
            }
        });

        imageTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortGroceriesByTime();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Sort the list whenever the activity is resumed
        sortGroceriesByTime();
    }

    private void openAddGroceryActivity() {
        Intent intent = new Intent(this, AddGroceryActivity.class);
        startActivity(intent);
    }

    private void sortGroceriesByAlphabet() {
        ListGrocery.getInstance().sortGroceriesByAlphabet();
        updateGroceryList();
    }

    private void sortGroceriesByTime() {
        ListGrocery.getInstance().sortGroceriesByTime();
        updateGroceryList();
    }

    private void updateGroceryList() {
        ArrayList<Grocery> groceries = ListGrocery.getInstance().getGroceries();
        groceryListAdapter = new GroceryListAdapter(groceries);
        rvGroceries.setAdapter(groceryListAdapter);
        rvGroceries.getAdapter().notifyDataSetChanged();
    }

}
