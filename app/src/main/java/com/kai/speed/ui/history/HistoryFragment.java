package com.kai.speed.ui.history;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kai.speed.R;
import com.kai.speed.model.HistoryViewAdapter;
import com.kai.speed.model.RecyclerViewClickListener;

public class HistoryFragment extends Fragment {
    private HistoryViewAdapter historyViewAdapter;
    private HistoryViewModel historyViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        historyViewModel =
                ViewModelProviders.of(this).get(HistoryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_history, container, false);

        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.recycler_history);
        historyViewAdapter = new HistoryViewAdapter(getActivity());

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(historyViewAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerViewClickListener(getContext(), recyclerView, new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.d("KTDBG", "[History] click pos:" + position);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                //Toast.makeText(getContext(),"Long Click  " + shownData.get(position).getTitle(),Toast.LENGTH_SHORT).show();
                // TODO: Move the item to the dedicated location

            }
        }));

        historyViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        return root;
    }
}
