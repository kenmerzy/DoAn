package ngoclong.example.phanmemthibanglai.ui.hoclythuyet;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ngoclong.example.phanmemthibanglai.R;
import ngoclong.example.phanmemthibanglai.ui.thisathach.CauHoi;
import ngoclong.example.phanmemthibanglai.ui.thisathach.DapAn;


/**
 * A simple {@link Fragment} subclass.
 */
public class HocTheoChuDeFragment extends Fragment {

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
    HocTheoChuDeActivity hocTheoChuDeActivity;
    String dapAnChon = "Empty..." ;
    DapAn dapAnDung;
    int viTriChon = 0;

    public HocTheoChuDeFragment() {
        // Required empty public constructor
    }
    @SuppressLint("ValidFragment")
    public HocTheoChuDeFragment(CauHoi c, ArrayList<DapAn> arrDA, int position, int tongSoCau, HocTheoChuDeActivity hocTheoChuDeActivity, DapAn daDung) {
        this.c = c;
        this.arrDA = arrDA;
        this.position = position;
        this.tongSoCau = tongSoCau;
        this.hocTheoChuDeActivity = hocTheoChuDeActivity;
        dapAnDung = daDung;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hoc_theo_chu_de, container, false);
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

    public void hienThiCauDung() {
        if (viTriChon != 0) {
           checkDapAnVaToMau(viTriChon,dapAnDung.getViTriDung());
        }
    }

    private void checkDapAnVaToMau(int viTriChon, int viTriDung)
    {
        if(viTriChon == viTriDung) {
            if (viTriChon == 1) {
                resetMau();
                dapAn1.setTextColor(Color.parseColor("#FF21E81B"));
            }
            else if (viTriChon == 2)
            {
                resetMau();
                dapAn2.setTextColor(Color.parseColor("#FF21E81B"));

            }
            else if (viTriChon == 3) {
                resetMau();
                dapAn3.setTextColor(Color.parseColor("#FF21E81B"));
            }
            hienGiaiThich(true);
        }
        else if(viTriChon != viTriDung)
        {
            resetMau();
            toMau(viTriChon,"#FFFF0000");
            hienGiaiThich(false);
        }
        else
            return;
    }

    private void resetMau()
    {
        dapAn1.setTextColor(Color.parseColor("#000000"));
        dapAn2.setTextColor(Color.parseColor("#000000"));
        dapAn3.setTextColor(Color.parseColor("#000000"));
    }
    private void toMau(int viTriToMau,String color)
    {
        if(viTriToMau == 1)
            dapAn1.setTextColor(Color.parseColor(color));
        else if(viTriToMau == 2)
            dapAn2.setTextColor(Color.parseColor(color));
        else if (viTriToMau ==3)
            dapAn3.setTextColor(Color.parseColor(color));
        else
            return;
    }

    private void hienGiaiThich(boolean hien)
    {
        if(hien)
        {
            tvGiaiThichDapAn.setText(c.getGiaiThich());
            tvGT.setVisibility(View.VISIBLE);
            tvGiaiThichDapAn.setVisibility(View.VISIBLE);
        }
        else
        {
            tvGT.setVisibility(View.GONE);
            tvGiaiThichDapAn.setVisibility(View.GONE);
        }
    }


}

