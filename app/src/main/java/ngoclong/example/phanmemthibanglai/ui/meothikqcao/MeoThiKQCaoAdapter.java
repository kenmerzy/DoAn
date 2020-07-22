package ngoclong.example.phanmemthibanglai.ui.meothikqcao;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MeoThiKQCaoAdapter extends FragmentStatePagerAdapter {

    private String listTab[] = {"Mẹo lý thuyết","Mẹo thực hành"};

    private MeoLyThuyetFragment fragment_meolythuyet;
    private MeoThucHanhFragment fragment_meothuchanh;


    public MeoThiKQCaoAdapter(FragmentManager fm) {
        super(fm);
        fragment_meolythuyet = new MeoLyThuyetFragment();
        fragment_meothuchanh = new MeoThucHanhFragment();

    }

    @Override
    public Fragment getItem(int i) {
        Fragment fr = null ;
        switch (i)
        {
            case 0:
                fr = fragment_meolythuyet;
                break;
            case 1:
                fr = fragment_meothuchanh;
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
