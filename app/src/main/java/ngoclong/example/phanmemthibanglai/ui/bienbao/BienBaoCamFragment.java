package ngoclong.example.phanmemthibanglai.ui.bienbao;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ngoclong.example.phanmemthibanglai.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BienBaoCamFragment extends Fragment {

    public BienBaoCamFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bien_bao_cam, container, false);
    }
}
