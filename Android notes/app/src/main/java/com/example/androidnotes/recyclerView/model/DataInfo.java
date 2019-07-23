package com.example.androidnotes.recyclerView.model;

public class DataInfo {
    private String message;

    public DataInfo(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
