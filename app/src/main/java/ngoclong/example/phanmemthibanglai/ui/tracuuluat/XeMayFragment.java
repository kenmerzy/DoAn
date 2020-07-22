package ngoclong.example.phanmemthibanglai.ui.tracuuluat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ngoclong.example.phanmemthibanglai.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class XeMayFragment extends Fragment {

    public XeMayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_xe_may, container, false);
    }
}
