package ngoclong.example.phanmemthibanglai.ui.bienbao;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import ngoclong.example.phanmemthibanglai.R;


public class BienBaoHieuLenhFragment extends Fragment {


    private ArrayList<BienBao> arrBienBaoHieuLenh;

    TextView tvTenBienBao;
    TextView tvMoTa;
    ImageView imvHinhBienBao;
    ListView listView;
    int count;
    public BienBaoHieuLenhFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bien_bao_hieu_lenh, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BienBaoDAO bb = new BienBaoDAO(getContext());
        arrBienBaoHieuLenh = new ArrayList<BienBao>();
        arrBienBaoHieuLenh = bb.getAllBienBaoHieuLenh();

        count = bb.getSoBienBaoHieuLenh();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = view.findViewById(R.id.listV_BienBaoHieuLenh);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

    }

    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return count;
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
            View view1 = getLayoutInflater().inflate(R.layout.item_bien_bao, null);
            tvTenBienBao = view1.findViewById(R.id.tvTenBienBao);
            tvMoTa = view1.findViewById(R.id.tvMoTaBienBao);
            imvHinhBienBao = view1.findViewById(R.id.imvBienBao);

            tvTenBienBao.setText(arrBienBaoHieuLenh.get(i).getTenBB());
            tvMoTa.setText(arrBienBaoHieuLenh.get(i).getNoiDung());
            return view1;
        }
    }
}
