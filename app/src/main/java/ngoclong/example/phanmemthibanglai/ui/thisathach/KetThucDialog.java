package ngoclong.example.phanmemthibanglai.ui.thisathach;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.util.Timer;

import ngoclong.example.phanmemthibanglai.R;

public class KetThucDialog extends Dialog implements android.view.View.OnClickListener {

    public LamBaiThiActivity c;
    public Dialog d;
    CountDownTimer timer;
    public Button btn_ketThuc, btn_huyBo;

    public KetThucDialog(LamBaiThiActivity a, CountDownTimer timer) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
        this.timer = timer;
    }
    public KetThucDialog(LamBaiThiActivity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.ket_thuc_dialog);
        btn_ketThuc = (Button) findViewById(R.id.btn_ketThuc);
        btn_huyBo = (Button) findViewById(R.id.btn_huyBo);
        btn_ketThuc.setOnClickListener(this);
        btn_huyBo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ketThuc:
                timer.cancel();
                c.setKetThuc(true);
                c.ketThucBaiThi();
                dismiss();
                break;
            case R.id.btn_huyBo:
                c.setKetThuc(false);
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}
