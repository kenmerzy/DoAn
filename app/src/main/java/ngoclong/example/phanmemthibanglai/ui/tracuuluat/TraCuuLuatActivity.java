package ngoclong.example.phanmemthibanglai.ui.tracuuluat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

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
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_tra_cuu_luat, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onSupportNavigateUp()
    {
        finish();
        return true;
    }
}
