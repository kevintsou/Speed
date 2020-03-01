package com.kai.speed.ui.test;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kai.speed.model.TestViewAdapter;

import java.util.LinkedList;

public class TestViewModel extends ViewModel {

    private MutableLiveData<LinkedList<String>> mTestItem;
    private MutableLiveData<LinkedList<Integer>> mSpeed;

    public TestViewModel() {
        mTestItem = new MutableLiveData<>();
        mSpeed = new MutableLiveData<>();
        LinkedList<String> titleList = new LinkedList<>();
        titleList.add(TestViewAdapter.TestItemType.SEQ_WRITE_TITLE);
        titleList.add(TestViewAdapter.TestItemType.RAN_WRITE_TITLE);
        titleList.add(TestViewAdapter.TestItemType.SEQ_READ_TITLE);
        titleList.add(TestViewAdapter.TestItemType.RAN_READ_TITLE);
        mTestItem.setValue(titleList);

        LinkedList<Integer> speedList = new LinkedList<>();
        speedList.add(new Integer(0));
        speedList.add(new Integer(0));
        speedList.add(new Integer(0));
        speedList.add(new Integer(0));
        mSpeed.setValue(speedList);
    }

    public String getTestItem(int idx) {
        return mTestItem.getValue().get(idx);
    }

    public void setTestItem(LinkedList<String> mTestItem) {
        this.mTestItem.setValue(mTestItem);
    }

    public MutableLiveData<LinkedList<Integer>> getLiveSpeed() {
        return mSpeed;
    }

    public Integer getSpeed(int idx) {
        return mSpeed.getValue().get(idx);
    }

    public void setSpeed(int idx, long speed) {
        Integer i = (int) (long)speed;
        this.mSpeed.getValue().remove(idx);
        this.mSpeed.getValue().add(idx, i);
    }
}