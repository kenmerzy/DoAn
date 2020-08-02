package ngoclong.example.phanmemthibanglai.ui.caccauhaysai;

import android.annotation.SuppressLint;
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

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ngoclong.example.phanmemthibanglai.R;
import ngoclong.example.phanmemthibanglai.ui.hoclythuyet.HocTheoChuDeActivity;
import ngoclong.example.phanmemthibanglai.ui.thisathach.CauHoi;
import ngoclong.example.phanmemthibanglai.ui.thisathach.DapAn;

/**
 * A simple {@link Fragment} subclass.
 */
public class CacCauHaySaiFragment extends Fragment {

    CauHoi c;
    ArrayList<DapAn> arrDA;
    int position;
    TextView tvCauHoi;
    TextView tvGT;
    TextView tvGiaiThichDapAn;
    RadioGroup rdGrp;
    RadioButton dapAn1;
    RadioButton dapAn2;
    RadioButton dapAn3;
    ImageView imageView;
    int tongSoCau;
    int diem = 0;
    CacCauHaySaiActivity cacCauHaySaiActivity;
    String dapAnChon = "Empty..." ;
    DapAn dapAnDung;
    int viTriChon = 0;


    public CacCauHaySaiFragment() {
    }

    @SuppressLint("ValidFragment")
    public CacCauHaySaiFragment(CauHoi c, ArrayList<DapAn> arrDA, int position, int tongSoCau, CacCauHaySaiActivity cacCauHaySaiActivity, DapAn daDung) {
        this.c = c;
        this.arrDA = arrDA;
        this.position = position;
        this.tongSoCau = tongSoCau;
        this.cacCauHaySaiActivity = cacCauHaySaiActivity;
        dapAnDung = daDung;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cac_cau_hay_sai, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvCauHoi = view.findViewById(R.id.tvCauHoi);
        rdGrp = view.findViewById(R.id.grpDapAn);
        dapAn1 = view.findViewById(R.id.rdBtnDapAn1);
        dapAn2 = view.findViewById(R.id.rdBtnDapAn2);
        dapAn3 = view.findViewById(R.id.rdBtnDapAn3);
        tvGT = view.findViewById(R.id.tvGT);
        tvGiaiThichDapAn = view.findViewById(R.id.tvGiaiThichDapAn);
        imageView = view.findViewById(R.id.imvCauHoi);


        tvCauHoi.setText("Câu "+String.valueOf(position + 1) +": "+c.getNoiDung());
        String url = "file:///android_asset/images/"+c.getHinhAnh();
        Picasso.with(getContext()).load(url).into(imageView);
        for (int i = 0; i < rdGrp.getChildCount(); i++) {
            ((RadioButton) rdGrp.getChildAt(i)).setText(arrDA.get(i).getNoiDung());
        }


        rdGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(dapAn1.isChecked()) {
                    viTriChon = 1;
                    dapAnChon = dapAn1.getText().toString();
                    hocTheoChuDeActivity.updateListDapAnChon(position, 1, dapAn1.getText().toString());
                    hienThiCauDung();
                }
                else if(dapAn2.isChecked()) {
                    viTriChon = 2;
                    dapAnChon = dapAn2.getText().toString();
                    hocTheoChuDeActivity.updateListDapAnChon(position, 2, dapAn2.getText().toString());
                    hienThiCauDung();
                }
                else if(dapAn3.isChecked()) {
                    viTriChon = 3;
                    dapAnChon = dapAn3.getText().toString();
                    hocTheoChuDeActivity.updateListDapAnChon(position, 3, dapAn3.getText().toString());
                    hienThiCauDung();
                }
            }
        });
    }
}
