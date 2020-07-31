package ngoclong.example.phanmemthibanglai.ui.thisathach;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import ngoclong.example.phanmemthibanglai.R;

public class ThiSatHachActivity extends AppCompatActivity {

    private GridView gridView;
    TextView thiNgauNhien;
    String[] items = {"1","2","3","4","5","6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thi_sat_hach);

        assert  getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Thi sát hạch");

        gridView = findViewById(R.id.gridViewTSH);
        thiNgauNhien = (TextView) findViewById(R.id.tvThiNgauNhien);
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
        thiNgauNhien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
