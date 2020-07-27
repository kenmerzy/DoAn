package ngoclong.example.phanmemthibanglai.ui.tracuuluat;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

import ngoclong.example.phanmemthibanglai.R;
import ngoclong.example.phanmemthibanglai.ui.bienbao.BienBaoActivity;
import ngoclong.example.phanmemthibanglai.ui.bienbao.BienBaoAdapter;

public class TraCuuLuatActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tra_cuu_luat);
        assert  getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tra cứu luật");
        initView();

    }
    private void initView() {
        viewPager = findViewById(R.id.vPager);
        tabLayout =findViewById(R.id.tabLayout);
        viewPager.setAdapter(new TraCuuLuatAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
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

    @Override
    public boolean onSupportNavigateUp()
    {
        finish();
        return true;
    }
}
