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


    public ArrayList<Grocery> getGroceries() {
        return groceries;
    }

    public void addGrocery(Grocery grocery) {
        groceries.add(grocery);
    }

    public void removeGrocery(String name) {
        Grocery groceryToRemove = null;
        for (Grocery grocery : groceries) {
            if (grocery.getName().equals(name)) {
                groceryToRemove = grocery;
                break;
            }
        }
        if (groceryToRemove != null) {
            groceries.remove(groceryToRemove);
        }
    }

    public Grocery getGroceryByName(String name) {
        for (Grocery grocery : groceries) {
            if (grocery.getName().equals(name)) {
                return grocery;
            }
        }
        return null;
    }


    public void sortGroceriesByAlphabet() {
        groceries.sort(Comparator.comparing(Grocery::getName));
    }

    public void sortGroceriesByTime() {
        groceries.sort(Comparator.comparingLong(Grocery::getTimeAdded).reversed());
    }
}