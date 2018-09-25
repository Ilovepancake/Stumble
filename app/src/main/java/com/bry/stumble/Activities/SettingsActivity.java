package com.bry.stumble.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.bry.stumble.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SettingsActivity extends AppCompatActivity {
    @Bind(R.id.darkThemeLayout) LinearLayout mDarkThemeLayout;
    @Bind(R.id.DarkModeSwitch) Switch DarkModeSwitch;
    @Bind(R.id.FilterBtn) LinearLayout mFilterBtn;
    @Bind(R.id.LogoutLayout) LinearLayout mLogoutLayout;
    @Bind(R.id.FeedbackView) LinearLayout mFeedbackView;
    @Bind(R.id.VersiontLayout) LinearLayout mVersiontLayout;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);
        mContext = getApplicationContext();
        settingsBtnListener();
    }

    public void settingsBtnListener(){
        mDarkThemeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDarkMode();
            }
        });

        DarkModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                setDarkMode();
            }
        });

        mFilterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterContent();
            }
        });
        mLogoutLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });

        mFeedbackView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFeedBackFragment();
            }
        });

        mVersiontLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"App version 1.0",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setDarkMode(){
        DarkModeSwitch.setChecked(false);
        Toast.makeText(mContext,"Comimg soon",Toast.LENGTH_SHORT).show();
    }

    private void filterContent(){
        Toast.makeText(mContext,"Filter content",Toast.LENGTH_SHORT).show();
    }

    private void logout(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Logout.");
        builder.setMessage("Are you sure you want to log out?")
                .setCancelable(true)
                .setPositiveButton("Yes.", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        logoutUser();
                    }
                }).show();
    }

    private void logoutUser() {
        Toast.makeText(mContext,"Logout",Toast.LENGTH_SHORT).show();
    }

    private void loadFeedBackFragment(){
        Toast.makeText(mContext,"Feedback",Toast.LENGTH_SHORT).show();
    }
}
