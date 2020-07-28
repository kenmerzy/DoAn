package ngoclong.example.phanmemthibanglai.ui.meothikqcao;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import ngoclong.example.phanmemthibanglai.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeoLyThuyetFragment extends Fragment {
    Spinner spinner,spinner2,spinner3;
    public MeoLyThuyetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meo_ly_thuyet, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spinner = view.findViewById(R.id.spinner);
        spinner2 = view.findViewById(R.id.spinner2);
        spinner3 = view.findViewById(R.id.spinner3);

        final ArrayList<String> arrayMeoThi = new ArrayList<String>();
        ArrayList<String> arrayMeoThi2 = new ArrayList<String>();
        ArrayList<String> arrayMeoThi3 = new ArrayList<String>();
        arrayMeoThi.add("Khái niệm và quy tắc");
        arrayMeoThi2.add("Hệ thống biển báo");
        arrayMeoThi3.add("Sa hình");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),R.layout.support_simple_spinner_dropdown_item,arrayMeoThi);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(getContext(),R.layout.support_simple_spinner_dropdown_item,arrayMeoThi2);
        ArrayAdapter arrayAdapter3 = new ArrayAdapter(getContext(),R.layout.support_simple_spinner_dropdown_item,arrayMeoThi3);
        spinner.setAdapter(arrayAdapter);
        spinner2.setAdapter(arrayAdapter2);
        spinner3.setAdapter(arrayAdapter3);
    }
}
