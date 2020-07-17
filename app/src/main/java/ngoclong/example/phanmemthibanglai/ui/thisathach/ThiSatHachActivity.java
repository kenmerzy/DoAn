package ngoclong.example.phanmemthibanglai.ui.thisathach;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import ngoclong.example.phanmemthibanglai.R;
import ngoclong.example.phanmemthibanglai.ui.bienbao.BienBaoActivity;
import ngoclong.example.phanmemthibanglai.ui.caccauhaysai.CacCauHaySaiActivity;
import ngoclong.example.phanmemthibanglai.ui.hoclythuyet.HocLyThuyetActivity;
import ngoclong.example.phanmemthibanglai.ui.home.HomeFragment;
import ngoclong.example.phanmemthibanglai.ui.meothikqcao.MeoThiKQCao;
import ngoclong.example.phanmemthibanglai.ui.tracuuluat.TraCuuLuatActivity;

public class ThiSatHachActivity extends AppCompatActivity {

    private GridView gridView;
    String[] items = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thi_sat_hach);

        assert  getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Thi sát hạch");

        gridView = findViewById(R.id.gridViewTSH);

        ThiSatHachActivity.CustomAdapter customAdapter = new ThiSatHachActivity.CustomAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {
                Intent intent = new Intent(ThiSatHachActivity.this, LamBaiThiActivity.class);
                startActivity(intent);
            }
        });
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
            View view1 = getLayoutInflater().inflate(R.layout.item_thi_sat_hach,null);
            TextView name = view1.findViewById(R.id.txtTenBoDe);

            name.setText("Bộ đề " + items[i]);

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
