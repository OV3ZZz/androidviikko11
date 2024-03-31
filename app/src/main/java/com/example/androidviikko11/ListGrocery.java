package com.example.androidviikko11;


import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Comparator;

public class ListGrocery extends AppCompatActivity {

    private ArrayList<Grocery> groceries = new ArrayList<>();

    private static ListGrocery listGrocery = null;


    private ListGrocery() {
    }

    public static ListGrocery getInstance() {
        if(listGrocery == null) {
            listGrocery = new ListGrocery();
        }
        return listGrocery;
    }

    public Grocery getGroceryByIdWithoutRemove(int id) {
        return groceries.get(id);
    }


    public ArrayList<Grocery> getGroceries() {
        return groceries;
    }

    public void addGrocery(Grocery grocery) {
        groceries.add(grocery);
    }


    public void sortGroceriesByAlphabet() {
        groceries.sort(Comparator.comparing(Grocery::getGroceryName));
    }

    public void sortGroceriesByTime() {
        groceries.sort(Comparator.comparingLong(Grocery::getTimeAdded).reversed());
    }
}