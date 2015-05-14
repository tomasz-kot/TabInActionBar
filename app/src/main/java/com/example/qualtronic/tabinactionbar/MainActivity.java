package com.example.qualtronic.tabinactionbar;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;


public class MainActivity extends Activity {

    public Fragment myFragmentTemp;
    public Class Fragment1;


    private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Log.d("Test", "onCreate ________++++++++++" + myFragmentTemp);


        if (savedInstanceState == null){
            myFragmentTemp = new Fragment1();

            FragmentManager fm1 = getFragmentManager();
            FragmentTransaction ft1 = fm1.beginTransaction();
            ft1.add(R.id.content_layout, myFragmentTemp, null);


            //ft.add(R.id.content_layout, myFragment);
            //myFragment.setArguments(myBundle);   //Musi być do przesyłania bundle
             Log.d("Test", "savedInstanceState ________" + myFragmentTemp);
             ft1.commit();
        }

/////////    ACTON BAR  ----------------------------------------------------------------------------


        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


/*        actionBar tab = actionBar.newTab()
                .setText(R.string.artist)
                .setTabListener(new TabListener<ArtistFragment>(
                        this, "artist", ArtistFragment.class));
        actionBar.addTab(tab);*/

        android.support.v7.app.ActionBar.Tab tab1 = actionBar
                .newTab()
                .setText("First")
                .setTabListener(
                        new FragmentTabListener<tabListener>(R.id.content_layout, this, "first",
                                Fragment1.class));

        // for each of the sections in the app, add a tab to the action bar.
        actionBar.addTab(actionBar.newTab().setText("ULUBIONE")
                .setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("PUNKTY SWIETLNE")
                .setTabListener(tabListener));

        // setIcon() można też ikonę

///--------------------------------------------------------------------------------------------------




    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore the previously serialized current tab position.
        if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
            getActionBar().setSelectedNavigationItem(savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Serialize the current tab position.
        outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar()
                .getSelectedNavigationIndex());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

   // @Override

    ActionBar.TabListener tabListener = new ActionBar.TabListener() {
        public void onTabSelected(ActionBar.Tab tab,
                                  FragmentTransaction ft) {

            if (myFragmentTemp == null) {
              //  myFragmentTemp = new Fragment1();

              //  String ala = "Fragment" + tab.getPosition();
                // Fragment myFragmentTemp1 = new Fragment1();

              //  ft.add(R.id.content_layout, myFragmentTemp, null);

               // Log.d("Test", "onTabSelected ________INICIALIZE:   " + ala);
            }


            Log.d("Test", "Click ________" + tab.getPosition());


            //ft.hide(myFragmentTemp);

            //ft.show (myFragmentTemp);
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab,
                                    FragmentTransaction ft) {

            if (myFragmentTemp != null) {
                // Detach the fragment, because another one is being attached
                // ft.detach(myFragmentFav);
            }
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab,
                                    FragmentTransaction fragmentTransaction) {
        }


    };



}