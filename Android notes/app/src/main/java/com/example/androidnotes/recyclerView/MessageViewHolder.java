package com.example.androidnotes.recyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.androidnotes.R;

public class MessageViewHolder extends RecyclerView.ViewHolder{
    public TextView textView;

    public MessageViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.recycler_text);
    }

}
