package com.bry.stumble.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.bry.stumble.Fragments.WebPageFragment;
import com.bry.stumble.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private final String TAG = "MainActivity";
    private FragmentPagerAdapter adapterViewPager;

    @Bind(R.id.vpPager) ViewPager mViewPager;
    @Bind(R.id.previousBtn) ImageButton mPreviousBtn;
    @Bind(R.id.nextBtn) ImageButton mNextBtn;
    @Bind(R.id.shareBtn) ImageButton mShareBtn;
    @Bind(R.id.pinBtn) ImageButton mPinBtn;
    @Bind(R.id.settingsBtn) ImageButton mSettingsBtn;

    private Context mContext;
    private static int mNumberOfItems = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this.getApplicationContext();

        setWebPagePager();
        setClickListeners();
    }

    private void setWebPagePager() {
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapterViewPager);
    }


    public static class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return mNumberOfItems;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            WebPageFragment myFrag = new WebPageFragment();
            myFrag.setPageNo(position);
            return myFrag;
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

    }

    private void setClickListeners() {
        mPreviousBtn.setOnClickListener(this);
        mNextBtn.setOnClickListener(this);
        mShareBtn.setOnClickListener(this);
        mPinBtn.setOnClickListener(this);
        mSettingsBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.equals(mPreviousBtn)){
            int currentPosition = mViewPager.getCurrentItem();
            if(currentPosition>0){
                mViewPager.setCurrentItem(currentPosition-1);
            }
        }else if(view.equals(mNextBtn)){
            int currentPosition = mViewPager.getCurrentItem();
            if(currentPosition<mNumberOfItems){
                mViewPager.setCurrentItem(currentPosition+1);
            }
        }else if(view.equals(mShareBtn)){
            Toast.makeText(mContext,"Share",Toast.LENGTH_SHORT).show();
        }else if(view.equals(mPinBtn)){
            Toast.makeText(mContext,"Pin",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,LoginActivty.class);
            startActivity(intent);
        }else if(view.equals(mSettingsBtn)){
            openSettingsActivity();
        }
    }

    private void openSettingsActivity() {
        Intent intent = new Intent(MainActivity.this,SettingsActivity.class);
        startActivity(intent);
    }

}
