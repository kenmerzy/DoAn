package ngoclong.example.phanmemthibanglai.ui.tracuuluat;

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

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ngoclong.example.phanmemthibanglai.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OtoFragment extends Fragment {

    private ArrayList<Luat> arrLuatOto;


    TextView tvNoiDung;
    TextView tvTienPhat;
    ImageView imvHinhBienBao;
    ListView listView;
    int count;
    public OtoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_oto, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TraCuuLuatDAO tcl = new TraCuuLuatDAO(getContext());
        arrLuatOto = new ArrayList<Luat>();
        arrLuatOto = tcl.getAllLuatOto();

        count = tcl.getSoLuatOto();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = view.findViewById(R.id.listV_LuatOto);
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
            View view1 = getLayoutInflater().inflate(R.layout.item_luat, null);
            tvNoiDung = view1.findViewById(R.id.txtNoiDungLuat);
            tvTienPhat = view1.findViewById(R.id.txtMucPhat);
            imvHinhBienBao = view1.findViewById(R.id.imvHinhLuat);

            tvNoiDung.setText(arrLuatOto.get(i).getNoiDung());
            tvTienPhat.setText(arrLuatOto.get(i).getMucPhat());
            String url = "file:///android_asset/images/"+arrLuatOto.get(i).getHinh();
            Picasso.with(getContext()).load(url).into(imvHinhBienBao);
            return view1;
        }
    }
}
