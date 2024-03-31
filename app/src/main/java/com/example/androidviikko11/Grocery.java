package com.example.androidviikko11;


public class Grocery {
    private String groceryName;

    protected long timeAdded;

    protected String id;

    private String groceryNote;

    public Grocery(String groceryName, String groceryNote) {
        this.groceryName = groceryName;
        this.groceryNote = groceryNote;
        this.timeAdded = System.currentTimeMillis();
    }

    public String getGroceryName() {
        return groceryName;
    }

    public String getGroceryNote() {
        return groceryNote;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setGroceryNote(String groceryNote) {
        this.groceryNote = groceryNote;
    }

    public long getTimeAdded() {
        return timeAdded;
    }

}
