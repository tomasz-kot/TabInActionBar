package com.example.qualtronic.tabinactionbar;


import android.app.Fragment;
import android.app.FragmentManager;



/**
 * Created by Tomasz on 14/05/2015.
 */
public class Tabsadapter  extends FragmentPagerAdapter {

    private int TOTAL_TABS = 2;

    public Tabsadapter(FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Fragment getItem(int index) {
        // TODO Auto-generated method stub
        switch (index) {
            case 0:
                return new Fragment1();

            case 1:
                return new Fragment2();


        }

        return null;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return TOTAL_TABS;
    }

}
