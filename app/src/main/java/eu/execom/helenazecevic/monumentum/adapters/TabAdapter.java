package eu.execom.helenazecevic.monumentum.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;

import eu.execom.helenazecevic.monumentum.fragments.AllMonumentsFragment_;
import eu.execom.helenazecevic.monumentum.fragments.MonumentTypesFragment_;
import eu.execom.helenazecevic.monumentum.fragments.MyMonumentsFragment_;

/**
 * Created by Helena Zecevic on 12.05.2016..
 */
public class TabAdapter extends FragmentStatePagerAdapter {

    private static final int MAX_TABS = 3;

    private Context context;

    public TabAdapter(AppCompatActivity activity) {
        super(activity.getSupportFragmentManager());
        this.context = activity;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return AllMonumentsFragment_.builder().build();
            case 1:
                return MyMonumentsFragment_.builder().build();
            case 2:
                return MonumentTypesFragment_.builder().build();
            default:
                throw new RuntimeException("Invalid number of tabs");
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "StreetArt";
            case 1:
                return "Profile";
            case 2:
                return "Author";
            default:
                throw new RuntimeException("Invalid number of tabs!");
        }
    }

    @Override
    public int getCount() {
        return MAX_TABS;
    }
}
