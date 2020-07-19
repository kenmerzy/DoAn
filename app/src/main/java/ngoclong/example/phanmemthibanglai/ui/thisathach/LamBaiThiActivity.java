package ngoclong.example.phanmemthibanglai.ui.thisathach;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import ngoclong.example.phanmemthibanglai.R;

public class LamBaiThiActivity extends AppCompatActivity {
    private ListView listView;
    TextView timerText;
    int hour,minute,second;
    String[] items = {"1","2","3","4"};
    private float x1,x2;
    static final int MIN_DISTANCE = 150;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lam_bai_thi);

        assert  getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");


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
    public boolean onTouchEvent(MotionEvent event)
    {
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                float deltaX = x2 - x1;

                if (Math.abs(deltaX) > MIN_DISTANCE)
                {

                    if (x2 > x1)
                    {
                        Toast.makeText(this, "Right to Left swipe [Next]", Toast.LENGTH_SHORT).show ();
                    }


                    else
                    {
                        Toast.makeText(this, "Left to Right swipe [Previous]", Toast.LENGTH_SHORT).show ();
                    }

                }
                else
                {
                    Toast.makeText(this, "Ngan", Toast.LENGTH_SHORT).show ();
                }
                break;
        }
        return super.onTouchEvent(event);
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
    @Override
    public boolean onSupportNavigateUp()
    {
        finish();
        return true;
    }
}
