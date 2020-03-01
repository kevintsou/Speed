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

import com.kai.speed.Interface.AsyncCallbackInterface;
import com.kai.speed.R;
import com.kai.speed.async.AsyncTaskReadFile;
import com.kai.speed.async.AsyncTaskWriteFile;
import com.kai.speed.model.RecyclerViewClickListener;
import com.kai.speed.model.TestViewAdapter;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.concurrent.Executors;


public class TestFragment extends Fragment implements AsyncCallbackInterface {

    private TestViewModel testViewModel;
    private TestViewAdapter testViewAdapter;
    private Long startTime, lastTime;
    private int payload;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        testViewModel =
                ViewModelProviders.of(this).get(TestViewModel.class);

        View root = inflater.inflate(R.layout.fragment_test, container, false);
        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.recycler_test);
        testViewAdapter = new TestViewAdapter(getActivity(), testViewModel);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(testViewAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerViewClickListener(getContext(), recyclerView, new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.d("KTDBG", "[Test] click pos:" + position);
                // multi thread example
                Calendar c = Calendar.getInstance();
                startTime = lastTime = c.getTimeInMillis();
                payload = 0;
                switch (position){
                    case TestViewAdapter.TestItemType.SEQ_WRITE_TYPE:
                        new AsyncTaskWriteFile(getActivity(), TestViewAdapter.TestItemType.SEQ_WRITE_TYPE, 64*1024, TestFragment.this).executeOnExecutor(Executors.newCachedThreadPool(), 100);
                        break;
                    case TestViewAdapter.TestItemType.RAN_WRITE_TYPE:
                        new AsyncTaskWriteFile(getActivity(), TestViewAdapter.TestItemType.RAN_WRITE_TYPE, 4, TestFragment.this).executeOnExecutor(Executors.newCachedThreadPool(), 20000);
                        break;
                    case TestViewAdapter.TestItemType.SEQ_READ_TYPE:
                        new AsyncTaskReadFile(getActivity(), TestViewAdapter.TestItemType.SEQ_READ_TYPE, 32*1024, TestFragment.this).executeOnExecutor(Executors.newCachedThreadPool(), 100);
                        //new AsyncTaskReadFile(getActivity(), TestViewAdapter.TestItemType.SEQ_READ_TYPE, 64*1024, TestFragment.this).executeOnExecutor(Executors.newCachedThreadPool(), 100);
                        break;
                    case TestViewAdapter.TestItemType.RAN_READ_TYPE:
                        new AsyncTaskReadFile(getActivity(), TestViewAdapter.TestItemType.RAN_READ_TYPE, 4, TestFragment.this).executeOnExecutor(Executors.newCachedThreadPool(), 20000);
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onItemLongClick(View view, int position) {
                //Toast.makeText(getContext(),"Long Click  " + shownData.get(position).getTitle(),Toast.LENGTH_SHORT).show();
                // TODO: Move the item to the dedicated location

            }
        }));

        testViewModel.getLiveSpeed().observe(getViewLifecycleOwner(), new Observer<LinkedList<Integer>>() {
            @Override
            public void onChanged(LinkedList<Integer> integers) {

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

    @Override
    public void SeqWriteTaskCallback(int iteration) {
        Calendar c = Calendar.getInstance();
        if((c.getTimeInMillis() - lastTime) < 1000)
        {
            return;
        }
        lastTime = c.getTimeInMillis();
        Long diff = lastTime - startTime;
        diff = (diff + 999)/1000;
        Long speed = (((64*iteration) / diff));
        testViewModel.setSpeed(TestViewAdapter.TestItemType.SEQ_WRITE_TYPE, speed);
        testViewAdapter.notifyItemChanged(TestViewAdapter.TestItemType.SEQ_WRITE_TYPE);
    }

    @Override
    public void RndWriteTaskCallback(int iteration) {
        Calendar c = Calendar.getInstance();

        lastTime = c.getTimeInMillis();
        Long diff = lastTime - startTime;
        diff = (diff + 999)/1000;
        Long speed = (((4*iteration) / diff)/1024);
        testViewModel.setSpeed(TestViewAdapter.TestItemType.RAN_WRITE_TYPE, speed);
        testViewAdapter.notifyItemChanged(TestViewAdapter.TestItemType.RAN_WRITE_TYPE);
    }

    @Override
    public void SeqReadTaskCallback(int iteration) {
        Calendar c = Calendar.getInstance();
        if((c.getTimeInMillis() - lastTime) < 1000)
        {
            //return;
        }
        lastTime = c.getTimeInMillis();
        Long diff = lastTime - startTime;
        diff = (diff + 999)/1000;
        payload += 32;
        Long speed = ((payload / diff));
        testViewModel.setSpeed(TestViewAdapter.TestItemType.SEQ_READ_TYPE, speed);
        testViewAdapter.notifyItemChanged(TestViewAdapter.TestItemType.SEQ_READ_TYPE);
    }

    @Override
    public void RndReadTaskCallback(int iteration) {
        Calendar c = Calendar.getInstance();

        lastTime = c.getTimeInMillis();
        Long diff = lastTime - startTime;
        diff = (diff + 999)/1000;
        Long speed = (((4*iteration) / diff)/1024);
        testViewModel.setSpeed(TestViewAdapter.TestItemType.RAN_READ_TYPE, speed);
        testViewAdapter.notifyItemChanged(TestViewAdapter.TestItemType.RAN_READ_TYPE);
    }
}
