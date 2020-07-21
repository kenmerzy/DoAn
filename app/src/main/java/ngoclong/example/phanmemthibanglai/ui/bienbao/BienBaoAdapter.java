package ngoclong.example.phanmemthibanglai.ui.bienbao;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class BienBaoAdapter extends FragmentStatePagerAdapter {

    private String listTab[] = {"1","2"};
    private BienBaoCamFragment fragment_bienbaocam;
    private BienBaoHieuLenhFragment fragment_bienhieulenh;
    public BienBaoAdapter(FragmentManager fm) {
        super(fm);
        fragment_bienbaocam = new BienBaoCamFragment();
        fragment_bienhieulenh = new BienBaoHieuLenhFragment();

    }

    @Override
    public Fragment getItem(int i) {
        if (i == 0){
            return  fragment_bienbaocam;
        }else if (i == 1) {
            return fragment_bienhieulenh;
        }
        return null;
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