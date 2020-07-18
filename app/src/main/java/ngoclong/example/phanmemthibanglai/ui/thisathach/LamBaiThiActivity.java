package ngoclong.example.phanmemthibanglai.ui.thisathach;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lam_bai_thi);

        assert  getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

//        listView = findViewById(R.id.listDapAn);
//        LamBaiThiActivity.CustomAdapter customAdapter = new LamBaiThiActivity.CustomAdapter();
//        listView.setAdapter(customAdapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                // xử lí khi nhấn chọn đáp án
//            }
//        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_lam_bai_thi, menu);

        MenuItem timerItem = menu.findItem(R.id.countdown);
         timerText = (TextView) MenuItemCompat.getActionView(timerItem);

        timerText.setPadding(10, 0, 400, 0); //Or something like that...

        timerText.setTextSize(18);

        startTimer(30000, 1000,15); //One tick every second for 30 seconds



        return super.onCreateOptionsMenu(menu);
    }

    private void startTimer(long duration, long interval,int minute) {

        CountDownTimer timer = new CountDownTimer(duration, interval) {
            @Override
            public void onFinish() {
                // Code Nộp bài (H)
            }

            @Override
            public void onTick(long millisecondsLeft) {
                int secondsLeft = (int) Math.round((millisecondsLeft / (double) 1000));
                timerText.setText(String.valueOf(secondsLeft));
            }
        };
        timer.start();
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mnuKetThuc) {
            Toast.makeText(LamBaiThiActivity.this,"NÚT KẾT THÚC ĐƯỢC NHẤN", Toast.LENGTH_LONG).show();
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
