package ngoclong.example.phanmemthibanglai.ui.thisathach;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import ngoclong.example.phanmemthibanglai.R;

public class LamBaiThiActivity extends AppCompatActivity {
    private ListView listView;
    String[] items = {"1","2","3","4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lam_bai_thi);

//        listView = findViewById(R.id.listDapAn);
//        LamBaiThiActivity.CustomAdapter customAdapter = new LamBaiThiActivity.CustomAdapter();
//        listView.setAdapter(customAdapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                // xử lí khi nhấn chọn đáp án
//            }
//        });
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return items.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.item_dap_an_lam_bai_thi,null);
            TextView dapAn = view1.findViewById(R.id.tvDapAn);
            ImageView image = view1.findViewById(R.id.imvLBT);

            dapAn.setText("Đáp án" + items[i]);
            image.setImageResource(R.drawable.ic_account_circle_green_24dp);
            return view1;
        }
    }
}
