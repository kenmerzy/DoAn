package ngoclong.example.phanmemthibanglai.ui.meothikqcao;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.ListView;

import ngoclong.example.phanmemthibanglai.R;

public class MeoThiKQCao extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meo_thi_k_q_cao);

        assert  getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Mẹo thi kết quả cao");

        initView();
    }
    private void initView() {
        viewPager = findViewById(R.id.vPager);
        tabLayout =findViewById(R.id.tabLayout);
        viewPager.setAdapter(new MeoThiKQCaoAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onSupportNavigateUp()
    {
        finish();
        return true;
    }
}
