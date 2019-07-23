package com.example.androidnotes.recyclerView.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidnotes.R;
import com.example.androidnotes.recyclerView.MessageViewHolder;
import com.example.androidnotes.recyclerView.model.DataInfo;

import java.util.List;

public class firtstAdapter extends RecyclerView.Adapter {

    private Context mContent;
    private List<DataInfo> list;


    public firtstAdapter(Context context, List<DataInfo> dataInfos){
        mContent = context;
        list = dataInfos;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContent).inflate(R.layout.item_view,viewGroup,false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        DataInfo info = list.get(i);
        ((MessageViewHolder)viewHolder).textView.setText(info.toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
