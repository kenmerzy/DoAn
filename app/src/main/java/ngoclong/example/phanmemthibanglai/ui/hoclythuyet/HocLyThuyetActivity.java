package ngoclong.example.phanmemthibanglai.ui.hoclythuyet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import ngoclong.example.phanmemthibanglai.R;

public class HocLyThuyetActivity extends AppCompatActivity {
    ListView listView;
    String[] items = {"1","2","3","4","5","6","7","8","9"};
    int[] icons = {R.drawable.drivingicon, R.drawable.bookicon,
            R.drawable.drivingicon, R.drawable.icon1,
            R.drawable.iconaway, R.drawable.caricon,R.drawable.icon1,
            R.drawable.iconaway, R.drawable.caricon};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoc_ly_thuyet);

        assert  getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Học lý thuyết");

        listView = findViewById(R.id.List_view);

        HocLyThuyetActivity.CustomAdapter customAdapter = new HocLyThuyetActivity.CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {

            }
        });
    }
    private class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return items.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.hoc_ly_thuyet_listview_item,null);
            TextView title = view1.findViewById(R.id.txtHLTTitle);
            TextView description = view1.findViewById(R.id.txtHLTDesription);
            TextView soCauHoi = view1.findViewById(R.id.txtHLTSoCauHoi);
            ImageView imv = view1.findViewById(R.id.imvHLT);
            imv.setImageResource(icons[i]);


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
