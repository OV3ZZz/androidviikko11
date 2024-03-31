package com.example.androidviikko11;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddGroceryActivity extends AppCompatActivity {
    private EditText editGroceryName;
    private EditText editGroceryNote;
    private Button buttonAddGrocery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grocery);

        editGroceryName = findViewById(R.id.editGroceryName);
        editGroceryNote = findViewById(R.id.editGroceryNote);
        buttonAddGrocery = findViewById(R.id.buttonAddGrocery);

        buttonAddGrocery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editGroceryName.getText().toString();
                String note = editGroceryNote.getText().toString();

                if (!name.isEmpty()) {
                    addGroceryToList(name, note);
                    finish();
                }
            }
        });
    }

    private void addGroceryToList(String name, String note) {
        ListGrocery listGrocery = ListGrocery.getInstance();
        Grocery grocery = new Grocery(name, note);
        listGrocery.addGrocery(grocery);
    }
}
