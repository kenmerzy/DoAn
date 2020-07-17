package ngoclong.example.phanmemthibanglai.ui.bienbao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ngoclong.example.phanmemthibanglai.R;

public class BienBaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bien_bao);

        assert  getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Biển báo đường bộ");

    }
    @Override
    public boolean onSupportNavigateUp()
    {
        finish();
        return true;
    }
}
