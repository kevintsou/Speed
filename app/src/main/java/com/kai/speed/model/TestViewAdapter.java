package com.kai.speed.model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TestViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private Integer mListChange;

    public TestViewAdapter(Context context){
        this.mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder holder = null;
        View view;
        return holder;
    }

    // When the item show up, this func will be called
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    }

    @Override
    public int getItemViewType(int position) {
        return  position;

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    class NoteViewHolder extends RecyclerView.ViewHolder {

        public NoteViewHolder(View itemView) {
            super(itemView);
        }
    }

}
