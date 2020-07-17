package ngoclong.example.phanmemthibanglai.ui.hoclythuyet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ngoclong.example.phanmemthibanglai.R;

public class HocLyThuyetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoc_ly_thuyet);

        assert  getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Học lý thuyết");

    }
    @Override
    public boolean onSupportNavigateUp()
    {
        finish();
        return true;
    }
}
