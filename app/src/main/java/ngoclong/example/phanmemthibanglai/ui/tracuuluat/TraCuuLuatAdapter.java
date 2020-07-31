package ngoclong.example.phanmemthibanglai.ui.tracuuluat;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class TraCuuLuatAdapter extends FragmentStatePagerAdapter {

    private String listTab[] = {"Xe máy"};

    private XeMayFragment fragment_xemay;




    public TraCuuLuatAdapter(FragmentManager fm) {
        super(fm);
        fragment_xemay = new XeMayFragment();
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fr = null ;
        switch (i)
        {
            case 0:
                fr = fragment_xemay;
                break;

            default:
                break;
        }
        return fr;
    }

    @Override
    public int getCount() {
        return listTab.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTab[position];
    }
}