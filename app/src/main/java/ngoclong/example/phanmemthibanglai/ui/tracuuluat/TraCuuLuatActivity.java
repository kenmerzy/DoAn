package ngoclong.example.phanmemthibanglai.ui.tracuuluat;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ngoclong.example.phanmemthibanglai.R;
import ngoclong.example.phanmemthibanglai.ui.bienbao.BienBaoActivity;
import ngoclong.example.phanmemthibanglai.ui.bienbao.BienBaoAdapter;

public class TraCuuLuatActivity extends AppCompatActivity {

    private ArrayList<Luat> arrLuatXeMay;


    TextView tvNoiDung;
    TextView tvTienPhat;
    ImageView imvHinhBienBao;
    ListView listView;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tra_cuu_luat);
        assert  getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Luật xe máy cơ bản");

        TraCuuLuatDAO tcl = new TraCuuLuatDAO(TraCuuLuatActivity.this);
        arrLuatXeMay = new ArrayList<Luat>();
        arrLuatXeMay = tcl.getAllLuatXeMay();

        count = tcl.getSoLuatxeMay();
        listView = findViewById(R.id.listV_LuatXeMay);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
    }


    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_tra_cuu_luat, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.SearchViewTraCuuLuat).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Toast.makeText(TraCuuLuatActivity.this, s ,Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Log.d("Tra Cuu Luat", s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return count;
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
            View view1 = getLayoutInflater().inflate(R.layout.item_luat, null);
            tvNoiDung = view1.findViewById(R.id.txtNoiDungLuat);
            tvTienPhat = view1.findViewById(R.id.txtMucPhat);
            imvHinhBienBao = view1.findViewById(R.id.imvHinhLuat);

            tvNoiDung.setText(arrLuatXeMay.get(i).getNoiDung());
            tvTienPhat.setText(arrLuatXeMay.get(i).getMucPhat());
            String url = "file:///android_asset/images/"+arrLuatXeMay.get(i).getHinh();
            Picasso.with(TraCuuLuatActivity.this).load(url).into(imvHinhBienBao);
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
