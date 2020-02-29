package com.kai.speed.ui.test;

import android.content.Context;
import android.content.SharedPreferences;
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
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kai.speed.R;
import com.kai.speed.model.RecyclerViewClickListener;
import com.kai.speed.model.TestViewAdapter;



public class TestFragment extends Fragment {

    private TestViewModel testViewModel;
    private TestViewAdapter testViewAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        testViewModel =
                ViewModelProviders.of(this).get(TestViewModel.class);
        View root = inflater.inflate(R.layout.fragment_test, container, false);
        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.recycler_test);
        testViewAdapter = new TestViewAdapter(getActivity());

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(testViewAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerViewClickListener(getContext(), recyclerView, new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.d("KTDBG", "[Test] click pos:" + position);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                //Toast.makeText(getContext(),"Long Click  " + shownData.get(position).getTitle(),Toast.LENGTH_SHORT).show();
                // TODO: Move the item to the dedicated location

            }
        }));

        //final TextView textView = root.findViewById(R.id.text_home);
        testViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        handlePreference(getActivity());
        return root;
    }

    private void handlePreference(Context context){
        boolean isTaskShowWithoutDue, isNoteContentShow, isProgressShow;

            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

            // Note Content
            isNoteContentShow = preferences.getBoolean("note_content", true);
            isProgressShow = preferences.getBoolean("progress_content", true);
            isTaskShowWithoutDue = preferences.getBoolean("show_item_without_due", true);

            Log.d("KTDBG", "[TEST] Preference, note content:" + isNoteContentShow +
                    ", progress:" + isProgressShow +
                    ", task show without due:" + isTaskShowWithoutDue);

    }
}
