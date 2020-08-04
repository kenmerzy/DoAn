package ngoclong.example.phanmemthibanglai.ui.thisathach;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ngoclong.example.phanmemthibanglai.R;

public class LamBaiThiActivity extends AppCompatActivity {

    TextView timerText;
    TextView tienTrinhHoanThanh;
    TextView tvDiem;
    public CountDownTimer timer;
    public static boolean daThiXong;
    ArrayList<CauHoi> arrCauHoi;
    ArrayList<DapAn> arrDapAnDung;
    ArrayList<ArrayList<DapAn>> arrDapAn;
    ArrayList<ChonDA> arrDapAnChon;
    ArrayList<ScreenSlidePageFragment> listFragment;
    ScreenSlidePageFragment ssf;
    int tongSoCau;
    int ketQua;

    private boolean ketThuc;
    MenuItem mnuKetThuc;
    MenuItem mnuDiem;
    MenuItem soCau;
    MenuItem timerItem;
    CauHoiDAO ch;
    int boDe;

    private static final int NUM_PAGES = 20;

    private ViewPager mPager;

    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lam_bai_thi);

        daThiXong = false;

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle b = getIntent().getExtras();
        if (b != null) {
            boDe = b.getInt("boDe");
        }

        ch = new CauHoiDAO(LamBaiThiActivity.this);
        if(boDe == 0) {
            arrCauHoi = ch.getAllCauHoi();
//            tongSoCau = arrCauHoi.size();
            Collections.shuffle(arrCauHoi);
            getSupportActionBar().setTitle("Thi ngẫu nhiên");
        }
        else
        {
            arrCauHoi = ch.getCauHoiTheoBoDe(String.valueOf(boDe));
            getSupportActionBar().setTitle("Bộ đề " +boDe );
        }
        DapAnDAO da = new DapAnDAO(LamBaiThiActivity.this);
        arrDapAn = da.getAllDapAn(arrCauHoi);
        arrDapAnDung = da.getAllDapAnDung(arrCauHoi);
        arrDapAnChon = new ArrayList<ChonDA>();
        for (int i = 0; i < NUM_PAGES; i++) {
            ChonDA chd = new ChonDA(0, "Empty...");
            arrDapAnChon.add(chd);
        }

        mPager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());



        listFragment = new ArrayList<ScreenSlidePageFragment>();
        for (int i = 0; i < NUM_PAGES; i++) {
            ssf = new ScreenSlidePageFragment(arrCauHoi.get(i), arrDapAn.get(i), i, NUM_PAGES, LamBaiThiActivity.this, arrDapAnDung.get(i));
            listFragment.add(i,ssf);
        }
    }

//    @Override
//    public void onBackPressed() {
//        if (mPager.getCurrentItem() == 0) {
//            // If the user is currently looking at the first step, allow the system to handle the
//            // Back button. This calls finish() on this activity and pops the back stack.
//            super.onBackPressed();
//        } else {
//            // Otherwise, select the previous step.
//            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
//        }
//    }
    @Override
    public void onBackPressed() {
            super.onBackPressed();
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return listFragment.get(position);
        }


        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_lam_bai_thi, menu);

        timerItem = menu.findItem(R.id.countdown);

        mnuKetThuc = menu.findItem(R.id.mnuKetThuc);

        mnuDiem = menu.findItem(R.id.mnuDiem);

        soCau = menu.findItem(R.id.mnuTienTrinhHoanThanh);

        tienTrinhHoanThanh = (TextView) MenuItemCompat.getActionView(soCau);

        tvDiem = (TextView) MenuItemCompat.getActionView(mnuDiem);

        tienTrinhHoanThanh.setPadding(10, 0, 20, 0); //Or something like that...

        tienTrinhHoanThanh.setTypeface(null, Typeface.BOLD);

        tienTrinhHoanThanh.setTextColor(Color.WHITE);

        tienTrinhHoanThanh.setTextSize(17);

        tienTrinhHoanThanh = (TextView) MenuItemCompat.getActionView(mnuDiem);

        tvDiem.setPadding(10, 0, 40, 0); //Or something like that...

        tvDiem.setTypeface(null, Typeface.BOLD);

        tvDiem.setTextColor(Color.WHITE);

        tvDiem.setTextSize(17);

        timerText = (TextView) MenuItemCompat.getActionView(timerItem);

        timerText.setPadding(10, 0, 40, 0); //Or something like that...

        timerText.setTypeface(null, Typeface.BOLD);

        timerText.setTextColor(Color.WHITE);

        timerText.setTextSize(17);

        startTimer(140000, 1000);


        return super.onCreateOptionsMenu(menu);
    }

    private void startTimer(final long duration, long interval) {

        timer = new CountDownTimer(duration, interval) {

            @Override
            public void onFinish() {
                timerText.setText("00:00");
                ketThucBaiThi();

            }

            @Override
            public void onTick(long millisecondsLeft) {
                int secondsLeft = (int) ((millisecondsLeft % 60000) / 1000);
                int minuteLeft = (int) ((millisecondsLeft / 60000));
                if (minuteLeft < 2)
                    timerText.setTextColor(Color.parseColor("#FF0000"));
                String scl = String.valueOf(secondsLeft);
                String mnl = String.valueOf(minuteLeft);
                if (secondsLeft < 10)
                    scl = "0" + secondsLeft;
                if (minuteLeft < 10) {
                    mnl = "0" + minuteLeft;

                }
                timerText.setText(mnl + ":" + scl);
            }
        };
        timer.start();
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

    public int chamDiem() {
        int diem = 0;
        for (int i = 0; i < NUM_PAGES; i++) {
            if (arrDapAnDung.get(i).getViTriDung() == arrDapAnChon.get(i).getViTri())
                diem++;
        }
        return diem;
    }

    public void ketThucBaiThi() {
        for (int i = 0; i < NUM_PAGES; i++) {
            listFragment.get(i).setThiXong(true);
        }
        daThiXong = true;
        ketQua = chamDiem();
        tvDiem.setText("Điểm: " + String.valueOf(ketQua) + "/" + NUM_PAGES);
        mnuKetThuc.setVisible(false);
        mnuDiem.setVisible(true);


        if(mPager.getCurrentItem()>2)
            mPager.setCurrentItem(0);
        else
            mPager.setCurrentItem(mPager.getCurrentItem()+2);


    }
    public void setKetThuc(boolean value)
    {
        ketThuc = value;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mnuKetThuc) {
            KetThucDialog ktd = new KetThucDialog(LamBaiThiActivity.this,timer);
            ktd.show();
        }
        return super.onOptionsItemSelected(item);
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
