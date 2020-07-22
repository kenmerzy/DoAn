package ngoclong.example.phanmemthibanglai.ui.tracuuluat;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import ngoclong.example.phanmemthibanglai.ui.bienbao.BienBaoCamFragment;
import ngoclong.example.phanmemthibanglai.ui.bienbao.BienBaoChiDanFragment;
import ngoclong.example.phanmemthibanglai.ui.bienbao.BienBaoHieuLenhFragment;
import ngoclong.example.phanmemthibanglai.ui.bienbao.BienBaoNguyHiemFragment;


public class TraCuuLuatAdapter extends FragmentStatePagerAdapter {

    private String listTab[] = {"Xe máy","Ô tô","Khác"};

    private BienBaoCamFragment fragment_bienbaocam;
    private BienBaoHieuLenhFragment fragment_bienhieulenh;
    private BienBaoChiDanFragment fragment_chidan;
    private BienBaoNguyHiemFragment fragment_nguyhiem;

    public TraCuuLuatAdapter(FragmentManager fm) {
        super(fm);
        fragment_bienbaocam = new BienBaoCamFragment();
        fragment_bienhieulenh = new BienBaoHieuLenhFragment();
        fragment_chidan = new BienBaoChiDanFragment();
        fragment_nguyhiem = new BienBaoNguyHiemFragment();
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fr = null ;
        switch (i)
        {
            case 0:
                fr = fragment_bienbaocam;
                break;
            case 1:
                fr = fragment_bienhieulenh;
                break;
            case 2:
                fr = fragment_chidan;
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