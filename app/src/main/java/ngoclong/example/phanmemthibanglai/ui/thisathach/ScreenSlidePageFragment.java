package ngoclong.example.phanmemthibanglai.ui.thisathach;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ngoclong.example.phanmemthibanglai.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlidePageFragment extends Fragment {
    CauHoi c;
    ArrayList<DapAn> arrDA;
    int position;
    TextView tvCauHoi;
    RadioGroup rdGrb;
    RadioButton dapAn1;
    RadioButton dapAn2;
    RadioButton dapAn3;
    ImageView imageView;
    public ScreenSlidePageFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public ScreenSlidePageFragment(CauHoi c, ArrayList<DapAn> arrDA,int position) {
        this.c = c;
        this.arrDA = arrDA;
        this.position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle
            savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvCauHoi = view.findViewById(R.id.tvCauHoi);
        rdGrb = view.findViewById(R.id.grpDapAn);
        dapAn1 = view.findViewById(R.id.rdBtnDapAn1);
        dapAn2 = view.findViewById(R.id.rdBtnDapAn2);
        dapAn3 = view.findViewById(R.id.rdBtnDapAn3);
        imageView = view.findViewById(R.id.imvCauHoi);

        tvCauHoi.setText("Câu "+String.valueOf(position + 1) +": "+c.getNoiDung());
        for (int i = 0; i < rdGrb.getChildCount(); i++) {
            ((RadioButton) rdGrb.getChildAt(i)).setText(arrDA.get(i).getNoiDung());
        }
    }
}
