package ngoclong.example.phanmemthibanglai.ui.tracuuluat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ngoclong.example.phanmemthibanglai.R;

public class TraCuuLuatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tra_cuu_luat);

        assert  getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tra cứu luật");

    }


    @Override
    public boolean onSupportNavigateUp()
    {
        finish();
        return true;
    }
}
