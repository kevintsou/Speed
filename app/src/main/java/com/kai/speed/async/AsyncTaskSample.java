package com.kai.speed.async;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class AsyncTaskSample extends AsyncTask<Integer, Integer, Integer> {

    Context context;

    public AsyncTaskSample(Context context){
        super();
        this.context = context;
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
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.d("KTDBG", "[Async] Progress: "+values[0] );
    }

}
