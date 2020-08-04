package ngoclong.example.phanmemthibanglai.ui.hdsd;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import ngoclong.example.phanmemthibanglai.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HDSDFragment extends Fragment {
    ListView listView;
    private HDSD_DAO hdsd;
    private ArrayList<HDSD> arrHDSD;
    TextView tviewHDSD;
    int count;
    public HDSDFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_h_d_s_d, container, false);

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hdsd = new HDSD_DAO(getContext());
        arrHDSD = new ArrayList<HDSD>();
        count = hdsd.getHDSD();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = view.findViewById(R.id.LV_HDSD);
        loadAllHDSD();
    }
    private void loadAllHDSD() {
        arrHDSD = hdsd.getAllHDSD();
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
    }
    private class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return arrHDSD.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.item_hdsd, null);
            tviewHDSD = view1.findViewById(R.id.tvHDSD);
            tviewHDSD.setText( arrHDSD.get(i).getNoidung());
            return view1;
        }
    }


}
