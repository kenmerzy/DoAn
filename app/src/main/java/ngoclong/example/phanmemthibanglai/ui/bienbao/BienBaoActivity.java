package ngoclong.example.phanmemthibanglai.ui.bienbao;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;


import ngoclong.example.phanmemthibanglai.R;

public class BienBaoActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private  TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bien_bao);

        assert  getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Biển báo đường bộ");
        initView();
    }

    private void initView() {
        viewPager = findViewById(R.id.vPager);
        tabLayout =findViewById(R.id.tabLayout);
        viewPager.setAdapter(new BienBaoAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_bien_bao, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.searchView).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Toast.makeText(BienBaoActivity.this, s ,Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Log.d("Search Bien Bao", s);
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
