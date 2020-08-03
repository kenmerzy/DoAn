package ngoclong.example.phanmemthibanglai.ui.tracuuluat;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.AttributeSet;
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

public class TraCuuLuatActivity extends AppCompatActivity {

    private ArrayList<Luat> arrLuatXeMay;
    private SearchView searchView;
    private SearchView.OnQueryTextListener queryTextListener;
    private TraCuuLuatDAO tcl;

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
        arrLuatXeMay = new ArrayList<Luat>();
        tcl = new TraCuuLuatDAO(getBaseContext());
        count = tcl.getSoLuatxeMay();
        listView = findViewById(R.id.listV_LuatXeMay);
        loadAllTCL();
    }

    private void loadAllTCL() {
        arrLuatXeMay = tcl.getAllLuatXeMay();
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
    }//
    private void loadTCLTheoSearch(String search) {
        arrLuatXeMay = tcl.getAllLuatXeMayBySearch(search);
        if(arrLuatXeMay.size() > 0) {
            CustomAdapter customAdapter = new CustomAdapter();
            listView.setAdapter(customAdapter);
            listView.setVisibility(View.VISIBLE);
        }
        else
            listView.setVisibility(View.GONE);
    }//

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_tra_cuu_luat, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.SearchViewTraCuuLuat).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if(s.length() != 0)
                    loadTCLTheoSearch(s);
                else
                    loadAllTCL();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if(s.length() != 0)
                    loadTCLTheoSearch(s);
                else
                    loadAllTCL();
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return arrLuatXeMay.size();
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
