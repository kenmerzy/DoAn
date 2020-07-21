package ngoclong.example.phanmemthibanglai.ui.thisathach;

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
import android.widget.TextView;

import ngoclong.example.phanmemthibanglai.R;

public class LamBaiThiActivity extends AppCompatActivity {

    TextView timerText;

    String[] items = {"1","2","3","4"};
    private static final int NUM_PAGES = 5;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lam_bai_thi);

        mPager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);

        ViewPager mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());

        assert  getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

    }
    @Override
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
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new ScreenSlidePageFragment();
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_lam_bai_thi, menu);

        MenuItem timerItem = menu.findItem(R.id.countdown);
        MenuItem btnKT = menu.findItem(R.id.mnuKetThuc);
         timerText = (TextView) MenuItemCompat.getActionView(timerItem);

        timerText.setPadding(10, 0, 10, 0); //Or something like that...

        timerText.setTypeface(null, Typeface.BOLD);

        timerText.setTextColor(Color.WHITE);

        timerText.setTextSize(17);

        startTimer(150000, 1000); //One tick every second for 300 seconds



        return super.onCreateOptionsMenu(menu);
    }

    private void startTimer(final long duration, long interval) {

        final CountDownTimer timer = new CountDownTimer(duration, interval) {

            @Override
            public void onFinish() {
                timerText.setText("00:00");
            }

            @Override
            public void onTick(long millisecondsLeft) {
                int secondsLeft = (int) ((millisecondsLeft % 60000)/1000);
                int minuteLeft = (int) ((millisecondsLeft/60000));
                if (minuteLeft < 2)
                    timerText.setTextColor(Color.parseColor("#D14848"));
                String scl = String.valueOf(secondsLeft);
                String mnl = String.valueOf(minuteLeft);
                if (secondsLeft < 10)
                    scl = "0"+secondsLeft;
                if (minuteLeft < 10)
                    mnl = "0"+ minuteLeft;
                timerText.setText(mnl+ ":"+ scl);
            }
        };
        timer.start();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mnuKetThuc) {
            KetThucDialog ktd = new KetThucDialog(LamBaiThiActivity.this);
            ktd.show();
        }
        return super.onOptionsItemSelected(item);
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return items.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.item_dap_an_lam_bai_thi,null);
            TextView dapAn = view1.findViewById(R.id.tvDapAn);
            ImageView image = view1.findViewById(R.id.imvLBT);

            dapAn.setText("Đáp án" + items[i]);
            image.setImageResource(R.drawable.ic_account_circle_green_24dp);
            return view1;
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
