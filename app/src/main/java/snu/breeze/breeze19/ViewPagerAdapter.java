package snu.breeze.breeze19;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final String TAG = ViewPagerAdapter.class.getSimpleName();

    public ViewPagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position){
        Fragment fragment = null;
        switch(position){
            default:
                fragment = new MainPage();
        }
        return fragment;
    }

    @Override
    public int getCount(){
        return Constants.BOTTOM_TAB_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position){
        String title = null;
        switch(position){
            default :
                title = "Main";
        }
        return title;
    }

}
