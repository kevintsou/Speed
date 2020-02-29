package com.kai.speed.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kai.speed.R;

public class HistoryViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private Integer mListChange;

    public HistoryViewAdapter(Context context){
        this.mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_content_history, parent, false);

        holder = new HistoryViewHolder(view);
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
        return 4;
    }


    class HistoryViewHolder extends RecyclerView.ViewHolder {
        TextView txDate, txPerformance1, txPerformance2, txPerformance3, txPerformance4;
        ProgressBar progBar1, progBar2, progBar3, progBar4;

        public HistoryViewHolder(View itemView) {
            super(itemView);
            txDate = (TextView) itemView.findViewById(R.id.tv_date);
            txPerformance1 = (TextView) itemView.findViewById(R.id.textView1);
            txPerformance2 = (TextView) itemView.findViewById(R.id.textView2);
            txPerformance3 = (TextView) itemView.findViewById(R.id.textView3);
            txPerformance4 = (TextView) itemView.findViewById(R.id.textView4);
            progBar1 = (ProgressBar) itemView.findViewById(R.id.progressBar_1);
            progBar2 = (ProgressBar) itemView.findViewById(R.id.progressBar_2);
            progBar3 = (ProgressBar) itemView.findViewById(R.id.progressBar_3);
            progBar4 = (ProgressBar) itemView.findViewById(R.id.progressBar_4);
        }
    }

}
