package ngoclong.example.phanmemthibanglai.ui.meothikqcao;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import ngoclong.example.phanmemthibanglai.ui.thisathach.DatabaseAccess;

public class MeoThiDAO {
    Cursor csr = null;
    DatabaseAccess databaseAccess;

    public MeoThiDAO(Context context) {
        databaseAccess = DatabaseAccess.getInstance(context);
    }

    public ArrayList<MeoThi> getAllMeoLyThuyet() {
        databaseAccess.open();
        ArrayList<MeoThi> arr = new ArrayList<>();

        String sql = "select * from MeoLyThuyet";
        csr = databaseAccess.getDb().rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    String noiDung = csr.getString(0);
                    arr.add(new MeoThi(noiDung));
                } while (csr.moveToNext());
            }
        }
        databaseAccess.close();
        return arr;
    }

    public int getMeoLyThuyet() {
        databaseAccess.open();
        String countQuery = "SELECT  * FROM MeoLyThuyet";
        Cursor cursor = databaseAccess.getDb().rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        databaseAccess.close();
        return count;
    }

    public ArrayList<MeoThi> getAllMeoThucHanh() {
        databaseAccess.open();
        ArrayList<MeoThi> arr = new ArrayList<>();

        String sql = "select * from MeoThucHanh";
        csr = databaseAccess.getDb().rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    String noiDung = csr.getString(0);
                    arr.add(new MeoThi(noiDung));
                } while (csr.moveToNext());
            }
        }
        databaseAccess.close();
        return arr;
    }

    public int getMeoThucHanh() {
        databaseAccess.open();
        String countQuery = "SELECT  * FROM MeoThucHanh";
        Cursor cursor = databaseAccess.getDb().rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        databaseAccess.close();
        return count;
    }
}