package com.kai.speed.async;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import com.kai.speed.MainActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Calendar;

public class AsyncTaskWriteFile extends AsyncTask<Integer, Integer, Integer> {

    Context context;
    int id, fileSize;
    Calendar c;

    public AsyncTaskWriteFile(Context context, int id, int fileSize){
        super();
        this.context = context;
        this.id = id;
        this.fileSize = fileSize;
    }

    @Override
    protected Integer doInBackground(Integer... ints) {
        File file = new File(Environment.getExternalStorageDirectory() + "/" + File.separator + "test.txt");
        char[] writeFileBuff= new char[1024*this.fileSize];
        Log.d("KTDBG", "data1 length:" + writeFileBuff.length);

//        OutputStreamWriter fo = new OutputStreamWriter(fos );

        for(int intItem: ints){
            for(int i=0; i< intItem; i++){
                publishProgress((int)i);
                try {
                    /*
                     * We have to use the openFileOutput()-method the ActivityContext
                     * provides, to protect your file from others and This is done for
                     * security-reasons. We chose MODE_WORLD_READABLE, because we have
                     * nothing to hide in our file
                     */
                    FileOutputStream fOut = null;
                    fOut = context.openFileOutput("test.txt",
                            Context.MODE_PRIVATE);

                    OutputStreamWriter osw = new OutputStreamWriter(fOut);
                    // Write the string to the file
                    osw.write(writeFileBuff, 0, writeFileBuff.length);
                    // save and close
                    osw.flush();
                    osw.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        file.delete();
        return 1;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Integer aLong) {
        super.onPostExecute(aLong);
        //((MainActivity)this.context).AsyncTaskCallback(2000);
        //((MainActivity)this.context).AsyncTaskCallback();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        //c = Calendar.getInstance();
        ((MainActivity)this.context).AsyncTaskCallback(values[0]);
        Log.d("KTDBG", "[Async][" + id + "] Progress: " + values[0] );
        //Log.d("KTDBG", "[Async] Time in millis: " + c.getTimeInMillis() );
    }

}
