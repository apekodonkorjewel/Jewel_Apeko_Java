package com.company.chatterbook.models;

public class ChatterPost {
    private String text;

    public ChatterPost(String text){
           setText(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}