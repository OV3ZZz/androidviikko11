package com.example.androidviikko11;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddGroceryActivity extends AppCompatActivity {
    private EditText editGroceryName;
    private EditText editGroceryNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grocery);

        editGroceryName = findViewById(R.id.editGroceryName);
        editGroceryNote = findViewById(R.id.editGroceryNote);
        Button buttonAddGrocery = findViewById(R.id.buttonAddGrocery);

        buttonAddGrocery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editGroceryName.getText().toString();
                String note = editGroceryNote.getText().toString();

                Grocery grocery = new Grocery(name, note);
                ListGrocery.getInstance().addGrocery(grocery);

                finish();
            }
        });
    }

}
