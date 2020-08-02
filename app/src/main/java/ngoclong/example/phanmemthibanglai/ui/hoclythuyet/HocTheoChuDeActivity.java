package ngoclong.example.phanmemthibanglai.ui.hoclythuyet;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import ngoclong.example.phanmemthibanglai.R;
import ngoclong.example.phanmemthibanglai.ui.thisathach.CauHoi;
import ngoclong.example.phanmemthibanglai.ui.thisathach.CauHoiDAO;
import ngoclong.example.phanmemthibanglai.ui.thisathach.ChonDA;
import ngoclong.example.phanmemthibanglai.ui.thisathach.DapAn;
import ngoclong.example.phanmemthibanglai.ui.thisathach.DapAnDAO;
import ngoclong.example.phanmemthibanglai.ui.thisathach.KetThucDialog;
import ngoclong.example.phanmemthibanglai.ui.thisathach.LamBaiThiActivity;
import ngoclong.example.phanmemthibanglai.ui.thisathach.ScreenSlidePageFragment;

public class HocTheoChuDeActivity extends AppCompatActivity {

    ArrayList<CauHoi> arrCauHoi;
    ArrayList<DapAn> arrDapAnDung;

    ArrayList<ArrayList<DapAn>> arrDapAn;
    ArrayList<ChonDA> arrDapAnChon;
    ArrayList<HocTheoChuDeFragment> listFragment;
    HocTheoChuDeFragment hocTheoChuDeFragment;
    int tongSoCau;

    CauHoiDAO cauHoiDAO;
    MenuItem soCau;
    MenuItem mnuKetThuc;

    private int numPages;
    private ViewPager mPager;
    private PagerAdapter pagerAdapter;

    ArrayList<ChuDeHocLyThuyet> arrChuDe;
    ChuDeHocLyThuyetDAO chuDeHocLyThuyetDAO;
    int count;
    int chuDe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoc_theo_chu_de);


        Bundle b = getIntent().getExtras();
        if (b != null)
            chuDe = b.getInt("chuDe");


        arrChuDe = new ArrayList<ChuDeHocLyThuyet>();
        chuDeHocLyThuyetDAO = new ChuDeHocLyThuyetDAO(HocTheoChuDeActivity.this);
        arrChuDe = chuDeHocLyThuyetDAO.getALLChuDeHocLyThuyet();
        count = arrChuDe.size();


        CauHoiDAO ch = new CauHoiDAO(this);
        arrCauHoi = ch.getCauHoiTheoNhom(String.valueOf(chuDe)); // Chưa code DAO
        tongSoCau = arrCauHoi.size();
        //Collections.shuffle(arrCauHoi);

        DapAnDAO da = new DapAnDAO(this);
        arrDapAn = da.getAllDapAn(arrCauHoi);
        arrDapAnDung = da.getAllDapAnDung(arrCauHoi);
        numPages = tongSoCau;


        arrDapAnChon = new ArrayList<ChonDA>();
        for (int i = 0; i < numPages; i++) {
            ChonDA chd = new ChonDA(0, "Empty...");
            arrDapAnChon.add(chd);
        }

        mPager = (ViewPager) findViewById(R.id.pagerHocLT);
        pagerAdapter = new HocTheoChuDeAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(arrChuDe.get(chuDe).getTenChuDe());

        listFragment = new ArrayList<HocTheoChuDeFragment>();
        for (int i = 0; i < numPages; i++) {
            hocTheoChuDeFragment = new HocTheoChuDeFragment(arrCauHoi.get(i), arrDapAn.get(i), i, numPages, HocTheoChuDeActivity.this, arrDapAnDung.get(i));
            listFragment.add(hocTheoChuDeFragment);
        }
    }

    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    private class HocTheoChuDeAdapter extends FragmentStatePagerAdapter {
        public HocTheoChuDeAdapter(FragmentManager fm) {
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

    public void changedViTriCauHoiDangLam(int viTriDangLam) {
            soCau.setTitle(viTriDangLam + "/" + tongSoCau);
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

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0f);
            }
        }
    }

    public boolean onSupportNavigateUp()
    {
        finish();
        return true;
    }
}










