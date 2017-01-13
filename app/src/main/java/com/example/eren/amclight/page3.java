package com.example.eren.amclight;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eren.amclight.fragment.tab_alert;
import com.example.eren.amclight.fragment.tab_insect;
import com.example.eren.amclight.fragment.tab_light;
import com.example.eren.amclight.fragment.tab_option;
import com.example.eren.amclight.fragment.tab_timer;

public class page3 extends AppCompatActivity {
    private Context mContext;

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager viewpager;
    private Toolbar toolbar;
    private TabLayout tabLayout;


    private ImageView tab_view[] = new ImageView[5];
    private int[] tabIcons = {R.drawable.page3_tabicon_light, R.drawable.page3_tabicon_timer, R.drawable.page3_tabicon_alert,
            R.drawable.page3_tabicon_insect, R.drawable.page3_tabicon_option    };

    //ble notification 같은 서비스 등록해야함

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        mContext = getApplicationContext();

//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        viewpager = (ViewPager) findViewById(R.id.container);
        viewpager.setAdapter(mSectionsPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewpager);
        setupTabIcons();
    }


    public static class PlaceholderFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_page3_light, container, false);
            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter
    {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position) {
                case 0:
                    return new tab_light(mContext);
                case 1:
                    return new tab_timer(mContext);
                case 2:
                    return new tab_alert(mContext);
                case 3:
                    return new tab_insect(mContext);
                case 4:
                    return new tab_option(mContext);
            }
            return null;
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }

    //-------------------------- private --------------------------
    private void setupTabIcons()
    {
        for(int i=0; i<5; i++)
        {
            tab_view[i] = (ImageView) LayoutInflater.from(getApplicationContext()).inflate(R.layout.custom_tab,null);
            tab_view[i].setImageResource(tabIcons[i]);
            tabLayout.getTabAt(i).setCustomView(tab_view[i]);
        }
    }
}
