package ngoclong.example.phanmemthibanglai.ui.tracuuluat;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class TraCuuLuatAdapter extends FragmentStatePagerAdapter {

    private String listTab[] = {"Xe máy","Ô tô","Khác"};

    private XeMayFragment fragment_xemay;
    private OtoFragment fragment_oto;
    private KhacFragment fragment_khac;


    public TraCuuLuatAdapter(FragmentManager fm) {
        super(fm);
        fragment_xemay = new XeMayFragment();
        fragment_oto = new OtoFragment();
        fragment_khac = new KhacFragment();
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fr = null ;
        switch (i)
        {
            case 0:
                fr = fragment_xemay;
                break;
            case 1:
                fr = fragment_oto;
                break;
            case 2:
                fr = fragment_khac;
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