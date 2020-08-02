package ngoclong.example.phanmemthibanglai.ui.hoclythuyet;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import ngoclong.example.phanmemthibanglai.ui.thisathach.CauHoi;
import ngoclong.example.phanmemthibanglai.ui.thisathach.DatabaseAccess;

public class ChuDeHocLyThuyetDAO {

    Cursor csr = null;
    DatabaseAccess databaseAccess;
    public ChuDeHocLyThuyetDAO(Context context){
        databaseAccess = DatabaseAccess.getInstance(context);
    }

    public ArrayList<ChuDeHocLyThuyet> getALLChuDeHocLyThuyet(){
        databaseAccess.open();
        ArrayList<ChuDeHocLyThuyet> arr = new ArrayList<>();
        String sql = "select * from NhomCauHoi ";
        csr = databaseAccess.getDb().rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    int maChuDe = csr.getInt(0);
                    String TenChuDe = csr.getString(1);
                    String hinhAnh = csr.getString(2);
                    arr.add(new ChuDeHocLyThuyet(maChuDe,TenChuDe,hinhAnh));
                } while (csr.moveToNext());
            }
        }
        databaseAccess.close();
        return arr;
    }
}
