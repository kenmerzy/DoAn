package ngoclong.example.phanmemthibanglai.ui.thisathach;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import ngoclong.example.phanmemthibanglai.R;

public class KetThucDialog extends Dialog implements android.view.View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button btn_ketThuc, btn_huyBo;

    public KetThucDialog(Activity a) {
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
                dismiss();
                break;
            case R.id.btn_huyBo:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}
