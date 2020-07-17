package ngoclong.example.phanmemthibanglai.ui.meothikqcao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ngoclong.example.phanmemthibanglai.R;

public class MeoThiKQCao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meo_thi_k_q_cao);

        assert  getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Mẹo thi kết quả cao");

    }
    @Override
    public boolean onSupportNavigateUp()
    {
        finish();
        return true;
    }
}
