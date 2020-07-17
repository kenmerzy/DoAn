package ngoclong.example.phanmemthibanglai.ui.caccauhaysai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ngoclong.example.phanmemthibanglai.R;

public class CacCauHaySaiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cac_cau_hay_sai);
        assert  getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Các câu hỏi hay sai");

    }
    @Override
    public boolean onSupportNavigateUp()
    {
        finish();
        return true;
    }
}
