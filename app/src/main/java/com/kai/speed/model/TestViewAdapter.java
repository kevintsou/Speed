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
import com.kai.speed.ui.test.TestViewModel;

public class TestViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private TestViewModel testViewModel;

    public TestViewAdapter(Context context, TestViewModel testViewModel){
        this.mContext = context;
        this.testViewModel = testViewModel;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_content_test, parent, false);

        holder = new TestItemViewHolder(view);
        return holder;
    }

    // When the item show up, this func will be called
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((TestItemViewHolder)holder).txTitle.setText(this.testViewModel.getTestItem(position));
        //if((position % 2) != 0){
        //    ((TestItemViewHolder) holder).txSpeed.setText(String.valueOf(this.testViewModel.getSpeed(position)) + "KB/s");
        //}
        //else {
            ((TestItemViewHolder) holder).txSpeed.setText(String.valueOf(this.testViewModel.getSpeed(position)) + "MB/s");
        //}
        ((TestItemViewHolder)holder).progBarSpeed.setProgress(this.testViewModel.getSpeed(position));

    }

    @Override
    public int getItemViewType(int position) {
        return  position;
    }

    @Override
    public int getItemCount() {
        return TestItemType.TEST_ITEM_TYPE_NUM;
    }


    class TestItemViewHolder extends RecyclerView.ViewHolder {
        TextView txTitle, txSpeed;
        ProgressBar progBarSpeed, progBarOnGoing;

        public TestItemViewHolder(View itemView) {
            super(itemView);
            txTitle = (TextView) itemView.findViewById(R.id.tv_date);
            txSpeed = (TextView) itemView.findViewById(R.id.tv_speed);
            progBarSpeed = (ProgressBar) itemView.findViewById(R.id.progressBar_speed);
            progBarOnGoing = (ProgressBar) itemView.findViewById(R.id.progressBar_1);
        }
    }

    public class TestItemType{
        public static final int SEQ_WRITE_TYPE = 0;
        public static final int RAN_WRITE_TYPE = 1;
        public static final int SEQ_READ_TYPE = 2;
        public static final int RAN_READ_TYPE = 3;
        public static final int TEST_ITEM_TYPE_NUM = 4;

        public static final String SEQ_WRITE_TITLE = "Seq Write";
        public static final String RAN_WRITE_TITLE = "Random Write";
        public static final String SEQ_READ_TITLE = "Seq Read";
        public static final String RAN_READ_TITLE = "Random Read";

    }
}
