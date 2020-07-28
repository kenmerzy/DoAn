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
public class MeoThucHanhFragment extends Fragment {
    Spinner spinner4,spinner5,spinner6,spinner7,spinner8;
    public MeoThucHanhFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meo_thuc_hanh, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spinner4 = view.findViewById(R.id.spinner4);
        spinner5 = view.findViewById(R.id.spinner5);
        spinner6 = view.findViewById(R.id.spinner6);
        spinner7 = view.findViewById(R.id.spinner7);
        spinner8 = view.findViewById(R.id.spinner8);

        final ArrayList<String> arrayMeoThi4 = new ArrayList<String>();
        ArrayList<String> arrayMeoThi5 = new ArrayList<String>();
        ArrayList<String> arrayMeoThi6 = new ArrayList<String>();
        ArrayList<String> arrayMeoThi7 = new ArrayList<String>();
        ArrayList<String> arrayMeoThi8 = new ArrayList<String>();
        arrayMeoThi4.add("Giới thiệu");
        arrayMeoThi5.add("Bài 1: Chạy vòng số 8");
        arrayMeoThi6.add("Bài 2: Đi vào đường hẹp");
        arrayMeoThi7.add("Bài 3: Chạy đường quanh co ");
        arrayMeoThi8.add("Bài 4: Chạy đường quanh co");

        ArrayAdapter arrayAdapter4 = new ArrayAdapter(getContext(),R.layout.support_simple_spinner_dropdown_item,arrayMeoThi4);
        ArrayAdapter arrayAdapter5 = new ArrayAdapter(getContext(),R.layout.support_simple_spinner_dropdown_item,arrayMeoThi5);
        ArrayAdapter arrayAdapter6 = new ArrayAdapter(getContext(),R.layout.support_simple_spinner_dropdown_item,arrayMeoThi6);
        ArrayAdapter arrayAdapter7 = new ArrayAdapter(getContext(),R.layout.support_simple_spinner_dropdown_item,arrayMeoThi7);
        ArrayAdapter arrayAdapter8 = new ArrayAdapter(getContext(),R.layout.support_simple_spinner_dropdown_item,arrayMeoThi8);
        spinner4.setAdapter(arrayAdapter4);
        spinner5.setAdapter(arrayAdapter5);
        spinner6.setAdapter(arrayAdapter6);
        spinner7.setAdapter(arrayAdapter7);
        spinner8.setAdapter(arrayAdapter8);
    }
}
