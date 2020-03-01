package com.kai.speed.async;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import androidx.fragment.app.FragmentActivity;

import com.kai.speed.Interface.AsyncCallbackInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Calendar;

public class AsyncTaskReadFile extends AsyncTask<Integer, Integer, Integer> {

    AsyncCallbackInterface asyncCallback;
    FragmentActivity activity;
    Context context;
    int id, fileSize;
    Calendar c;

    public AsyncTaskReadFile(Context context, int id,
                             int fileSize, AsyncCallbackInterface asyncCallback){
        super();
        this.context = context;
        this.id = id;
        this.fileSize = fileSize;
        this.asyncCallback = asyncCallback;
    }

    @Override
    protected Integer doInBackground(Integer... ints) {

        char[] writeFileBuff= new char[this.fileSize];
        Log.d("KTDBG", "data1 length:" + writeFileBuff.length);

        try {
            /*
             * We have to use the openFileOutput()-method the ActivityContext
             * provides, to protect your file from others and This is done for
             * security-reasons. We chose MODE_WORLD_READABLE, because we have
             * nothing to hide in our file
             */
            FileOutputStream fOut = null;
            fOut = context.openFileOutput("asyncTask"+id+".txt",
                    Context.MODE_PRIVATE);

            OutputStreamWriter osw = new OutputStreamWriter(fOut);
            // Write the string to the file
            for(int idx = 0; idx < 1024; idx++) {
                osw.write(writeFileBuff, 0, writeFileBuff.length);
            }
            // save and close
            osw.flush();
            osw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int intItem: ints){
            for(int i=0; i< intItem; i++){
                publishProgress((int)i);
                try {
                    /*
                     * We have to use the openFileInput()-method the ActivityContext
                     * provides. Again for security reasons with openFileInput(...)
                     */
                    FileInputStream fIn = context.openFileInput("asyncTask"+id+".txt");
                    InputStreamReader isr = new InputStreamReader(fIn);
                    BufferedReader inBuff = new BufferedReader(isr);
                    int j=0;
                    while ((inBuff.read(writeFileBuff)) != -1){
                        //Log.d("KTDBG", "[AsyncReadFile] Progress: " + i + ", j:" + (j++));
                    };
                    inBuff.close();
                    fIn.close();
                    isr.close();

                } catch (IOException e) {
                    e.printStackTrace();
                    return 1;
                }
            }
        }
        //publishProgress(ints[0]);
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
        switch (id){
            case 2:
                this.asyncCallback.SeqReadTaskCallback(values[0]);
                break;
            case 3:
                this.asyncCallback.RndReadTaskCallback(values[0]);
                break;
            default:
                break;
        }


        Log.d("KTDBG", "[AsyncReadFile][" + id + "] Progress: " + values[0] );
    }

}
