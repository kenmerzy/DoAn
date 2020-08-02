package ngoclong.example.phanmemthibanglai.ui.caccauhaysai;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;

import ngoclong.example.phanmemthibanglai.R;
import ngoclong.example.phanmemthibanglai.ui.hoclythuyet.ChuDeHocLyThuyet;
import ngoclong.example.phanmemthibanglai.ui.hoclythuyet.ChuDeHocLyThuyetDAO;
import ngoclong.example.phanmemthibanglai.ui.hoclythuyet.HocTheoChuDeActivity;
import ngoclong.example.phanmemthibanglai.ui.hoclythuyet.HocTheoChuDeFragment;
import ngoclong.example.phanmemthibanglai.ui.thisathach.CauHoi;
import ngoclong.example.phanmemthibanglai.ui.thisathach.CauHoiDAO;
import ngoclong.example.phanmemthibanglai.ui.thisathach.ChonDA;
import ngoclong.example.phanmemthibanglai.ui.thisathach.DapAn;
import ngoclong.example.phanmemthibanglai.ui.thisathach.DapAnDAO;
import ngoclong.example.phanmemthibanglai.ui.thisathach.LamBaiThiActivity;
import ngoclong.example.phanmemthibanglai.ui.thisathach.ScreenSlidePageFragment;

public class CacCauHaySaiActivity extends AppCompatActivity {

    ArrayList<CauHoi> arrCauHaySai;
    ArrayList<DapAn> arrDapAnDung;
    ArrayList<ArrayList<DapAn>> arrDapAn;
    ArrayList<ChonDA> arrDapAnChon;
    ArrayList<CacCauHaySaiFragment> listFragment;
    CacCauHaySaiFragment cacCauHaySaiFragment;
    int tongSoCau;

    CauHoiDAO cauHoiDAO;
    MenuItem soCau;
    MenuItem mnuKetThuc;


    private int numPages;
    private ViewPager mPager;
    private PagerAdapter pagerAdapter;
    int count;
    int chuDe;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cac_cau_hay_sai);
        mPager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new CacCauHaySaiAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);


        ViewPager mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());

        assert  getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        cauHoiDAO = new CauHoiDAO(this);
        arrCauHaySai = cauHoiDAO.getCauHoiTheoNhom(String.valueOf(0));
        tongSoCau = arrCauHaySai.size();
        //Collections.shuffle(arrCauHaySai);

        DapAnDAO da = new DapAnDAO(this);
        arrDapAn = da.getAllDapAn(arrCauHaySai);
        arrDapAnDung = da.getAllDapAnDung(arrCauHaySai);
        numPages = tongSoCau;


        arrDapAnChon = new ArrayList<ChonDA>();
        for (int i = 0; i < numPages; i++) {
            ChonDA chd = new ChonDA(0, "Empty...");
            arrDapAnChon.add(chd);
        }

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Bộ câu hỏi đa số người thi hay làm sai");

        listFragment = new ArrayList<CacCauHaySaiFragment>();
        for (int i = 0; i < numPages; i++) {
            CacCauHaySaiFragment cacCauHaySaiFragment = new CacCauHaySaiFragment(arrCauHaySai.get(i), arrDapAn.get(i), i, numPages, CacCauHaySaiActivity.this, arrDapAnDung.get(i));
            listFragment.add(cacCauHaySaiFragment);
        }

    }

    private class CacCauHaySaiAdapter extends FragmentStatePagerAdapter {
        public CacCauHaySaiAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return listFragment.get(position);
        }


        @Override
        public int getCount() {
            return numPages;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_lam_bai_thi, menu);

        mnuKetThuc = menu.findItem((R.id.mnuKetThuc));
        mnuKetThuc.setVisible(false);

        soCau = menu.findItem(R.id.mnuTienTrinhHoanThanh);

        soCau.setVisible(true);

        soCau.setTitle("Số câu đã làm");


        return super.onCreateOptionsMenu(menu);
    }


    public void updateListDapAnChon(int viTriCauHoi, int dapAnChon, String noiDung) {
        if (dapAnChon == 1) {
            arrDapAnChon.remove(viTriCauHoi);
            ChonDA chd = new ChonDA(1, noiDung);
            arrDapAnChon.add(viTriCauHoi, chd);
        } else if (dapAnChon == 2) {
            arrDapAnChon.remove(viTriCauHoi);
            ChonDA chd = new ChonDA(2, noiDung);
            arrDapAnChon.add(viTriCauHoi, chd);
        } else if (dapAnChon == 3) {
            arrDapAnChon.remove(viTriCauHoi);
            ChonDA chd = new ChonDA(3, noiDung);
            arrDapAnChon.add(viTriCauHoi, chd);
        }
    }

    public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0f);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            }
            else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0f);
            }
        }
    }
    @Override
    public boolean onSupportNavigateUp()
    {
        finish();
        return true;
    }
}
