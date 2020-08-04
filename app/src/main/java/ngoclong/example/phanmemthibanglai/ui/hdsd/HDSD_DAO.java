package ngoclong.example.phanmemthibanglai.ui.hdsd;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import ngoclong.example.phanmemthibanglai.ui.thisathach.DatabaseAccess;

public class HDSD_DAO {
    Cursor csr = null;
    DatabaseAccess databaseAccess;

    public HDSD_DAO(Context context) {
        databaseAccess = DatabaseAccess.getInstance(context);
    }

    public ArrayList<HDSD> getAllHDSD() {
        databaseAccess.open();
        ArrayList<HDSD> arr = new ArrayList<>();

        String sql = "select * from HuongDanSuDung";
        csr = databaseAccess.getDb().rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    String noiDung = csr.getString(0);
                    arr.add(new HDSD(noiDung));
                } while (csr.moveToNext());
            }
        }
        databaseAccess.close();
        return arr;
    }

    public int getHDSD() {
        databaseAccess.open();
        String countQuery = "SELECT  * FROM HuongDanSuDung";
        Cursor cursor = databaseAccess.getDb().rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        databaseAccess.close();
        return count;
    }
}
