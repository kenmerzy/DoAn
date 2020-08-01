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

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ngoclong.example.phanmemthibanglai.R;
import ngoclong.example.phanmemthibanglai.ui.thisathach.CauHoi;
import ngoclong.example.phanmemthibanglai.ui.thisathach.CauHoiDAO;

public class HocLyThuyetActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<CauHoi> arrCauHoi;
    ArrayList<ArrayList<CauHoi>>arrayListsCH;
    CauHoiDAO cauHoiDAO;
    String[] icons = {"1","2","3","4"};
    String[] titles = {"20 CÂU HỎI ĐIỂM LIỆT","KHÁI NIỆM VÀ QUY TẮC","VĂN HÓA VÀ ĐẠO ĐỨC LÁI XE","KỸ THUẬT LÁI XE"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoc_ly_thuyet);

        assert  getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Học lý thuyết");
        arrayListsCH = new ArrayList<ArrayList<CauHoi>>();
        cauHoiDAO = new CauHoiDAO(HocLyThuyetActivity.this);
        for(int i=0 ; i< titles.length; i++) {
            arrCauHoi = new ArrayList<CauHoi>();
            arrCauHoi = cauHoiDAO.getCauHoiTheoNhom(String.valueOf(i));
            arrayListsCH.add(arrCauHoi);

        }


        listView = findViewById(R.id.List_view);


        CustomAdapter customAdapter = new CustomAdapter();
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
            return titles.length;
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
            ImageView imv = view1.findViewById(R.id.imvHLT);



            title.setText(titles[i]);
            description.setText("Gồm "+ arrayListsCH.get(i).size() +" câu hỏi");

            //String url = "file:///android_asset/images/" + icons[i];
            String url = "file:///android_asset/images/l8.jpg";
            Picasso.with(HocLyThuyetActivity.this).load(url).into(imv);
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
