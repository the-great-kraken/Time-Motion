package com.example.timemotion.Reminder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.timemotion.About.AboutActivity;
import com.example.timemotion.AppDefault.AppDefaultActivity;
import com.example.timemotion.Main.MainFragment;
import com.example.timemotion.R;
import com.example.timemotion.Utility.StoreRetrieveData;
import com.example.timemotion.Utility.ToDoItem;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import fr.ganfra.materialspinner.MaterialSpinner;

public class ReminderActivity extends AppDefaultActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        String theme = getSharedPreferences(MainFragment.THEME_PREFERENCES, MODE_PRIVATE).getString(MainFragment.THEME_SAVED, MainFragment.LIGHTTHEME);
        if (theme.equals(MainFragment.LIGHTTHEME)) {
            setTheme(R.style.CustomStyle_LightTheme);
        } else {
            setTheme(R.style.CustomStyle_DarkTheme);
        }

        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_reminder, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toDoReminderDoneMenuItem:
                new ReminderFragment().doneClick();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected int contentViewLayoutRes() {
        return R.layout.reminder_layout;
    }

    @NonNull
    @Override
    protected ReminderFragment createInitialFragment() {
        return ReminderFragment.newInstance();
    }

}
