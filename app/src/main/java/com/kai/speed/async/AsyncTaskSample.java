package com.kai.speed.async;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.kai.speed.MainActivity;

import java.util.Calendar;

public class AsyncTaskSample extends AsyncTask<Integer, Integer, Integer> {

    Context context;
    int id;
    Calendar c;

    public AsyncTaskSample(Context context, int id){
        super();
        this.context = context;
        this.id = id;
    }

    @Override
    protected Integer doInBackground(Integer... ints) {
        for(int intItem: ints){
            for(int i=0; i< intItem; i++){
                publishProgress((int)i);
            }
        }
        return 1;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Integer aLong) {
        super.onPostExecute(aLong);
        //((MainActivity)this.context).AsyncTaskCallback();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        c = Calendar.getInstance();
        Log.d("KTDBG", "[Async][" + id + "] Progress: " + values[0] );
        //Log.d("KTDBG", "[Async] Time in millis: " + c.getTimeInMillis() );
    }

}
