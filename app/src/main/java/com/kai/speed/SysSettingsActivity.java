package com.kai.speed;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.preference.PreferenceFragmentCompat;

public class SysSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sys_settings);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings, new SettingsFragment())
                .commit();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            //actionBar.setTitle(R.string.title_activity_settings);
        }

    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
/*
            Preference myPref = findPreference("night_mode");
            myPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                public boolean onPreferenceClick(Preference preference) {
                    SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getActivity());
                    MainActivity.changeLayoutBackgroundColor(pref.getBoolean("night_mode", false));
                    Log.d("KTDBG", "night_mode:" + pref.getBoolean("night_mode", false));
                    return true;
                }


            });
*/
        }
    }

    @Override
    public void onBackPressed(){
        Log.d("KTDBG", "In order to let onCreate() of main activity run again");
        NavUtils.navigateUpTo(this, new Intent(this,
                MainActivity.class));
        //super.onBackPressed();
    }
}
