package ngoclong.example.phanmemthibanglai.ui.caccauhaysai;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;

import ngoclong.example.phanmemthibanglai.R;
import ngoclong.example.phanmemthibanglai.ui.thisathach.CauHoi;
import ngoclong.example.phanmemthibanglai.ui.thisathach.CauHoiDAO;
import ngoclong.example.phanmemthibanglai.ui.thisathach.DapAn;
import ngoclong.example.phanmemthibanglai.ui.thisathach.DapAnDAO;
import ngoclong.example.phanmemthibanglai.ui.thisathach.LamBaiThiActivity;
import ngoclong.example.phanmemthibanglai.ui.thisathach.ScreenSlidePageFragment;

public class CacCauHaySaiActivity extends AppCompatActivity {

    ArrayList<CacCauHaySai> arrCauHaySai;

    int tongSoCau;


    private ViewPager mPager;

    private PagerAdapter pagerAdapter;

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

        CacCauHaySaiDAO chs = new CacCauHaySaiDAO(this);
        //arrCauHaySai = chs.getClass();
        tongSoCau = arrCauHaySai.size();
        Collections.shuffle(arrCauHaySai);

    }

    private class CacCauHaySaiAdapter extends FragmentStatePagerAdapter {
        public CacCauHaySaiAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new CacCauHaySaiFragment(arrCauHaySai,position);
        }
//        @Override
//        public void onBackPressed() {
//            if (mPager.getCurrentItem() == 0) {
//                // If the user is currently looking at the first step, allow the system to handle the
//                // Back button. This calls finish() on this activity and pops the back stack.
//                super.onBackPressed();
//            } else {
//                // Otherwise, select the previous step.
//                mPager.setCurrentItem(mPager.getCurrentItem() - 1);
//            }
//
//        }

        @Override
        public int getCount() {
            return tongSoCau;
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
