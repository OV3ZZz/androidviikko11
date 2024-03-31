package com.example.androidviikko11;


public class Grocery {
    private String groceryName;

    protected long timeAdded;

    private String groceryNote;

    public Grocery(String groceryName, String groceryNote) {
        this.groceryName = groceryName;
        this.groceryNote = groceryNote;
        this.timeAdded = System.currentTimeMillis();
    }

    public String getName() {
        return groceryName;
    }

    public String getNote() {
        return groceryNote;
    }

    public void setGroceryNote(String groceryNote) {
        this.groceryNote = groceryNote;
    }

    public long getTimeAdded() {
        return timeAdded;
    }

}
