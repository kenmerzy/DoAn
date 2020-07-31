package ngoclong.example.phanmemthibanglai.ui.thisathach;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class CauHoiDAO {
    Cursor csr = null;
    DatabaseAccess databaseAccess;
    public CauHoiDAO(Context context){
        databaseAccess = DatabaseAccess.getInstance(context);
    }

    public ArrayList<CauHoi> getAllCauHoi(){
        databaseAccess.open();
        ArrayList<CauHoi> arr = new ArrayList<>();
        String sql = "select * from CauHoi";
        csr = databaseAccess.getDb().rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    int maCauHoi = csr.getInt(0);
                    String noiDung = csr.getString(1);
                    String giaiThich = csr.getString(2);
                    String nhomCauHoi = csr.getString(3);
                    String hinhAnh = csr.getString(4);
                    arr.add(new CauHoi(maCauHoi,noiDung,giaiThich,nhomCauHoi,hinhAnh));
                } while (csr.moveToNext());
            }
        }
        databaseAccess.close();
        return arr;
    }
}
