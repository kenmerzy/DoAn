package ngoclong.example.phanmemthibanglai.ui.caccauhaysai;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ngoclong.example.phanmemthibanglai.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CacCauHaySaiFragment extends Fragment {

    private int position;
    ArrayList<CacCauHaySai> chs;
    public CacCauHaySaiFragment() {
        // Required empty public constructor
    }
    @SuppressLint("ValidFragment")
    public CacCauHaySaiFragment(ArrayList<CacCauHaySai> chs,int position) {
        this.chs = chs;
        this.position = position;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cac_cau_hay_sai, container, false);
    }

}
