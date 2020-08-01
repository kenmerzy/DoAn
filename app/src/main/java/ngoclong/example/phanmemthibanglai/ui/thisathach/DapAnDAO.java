package ngoclong.example.phanmemthibanglai.ui.thisathach;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class DapAnDAO {
    Cursor csr = null;
    DatabaseAccess databaseAccess;
    public DapAnDAO(Context context){
        databaseAccess = DatabaseAccess.getInstance(context);
    }

    public int getSoCauHoi()

    {
        databaseAccess.open();
        String countQuery = "SELECT  * FROM CauHoi" ;
        Cursor cursor = databaseAccess.getDb().rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        databaseAccess.close();
        return count;
    }
    public ArrayList<ArrayList<DapAn>> getAllDapAn(ArrayList<CauHoi> arrCauHoi){
        databaseAccess.open();
        ArrayList<ArrayList<DapAn>> arrBig = new ArrayList<ArrayList<DapAn>>();
        ArrayList<DapAn> arrSmall;
        String sql;
        for (int i = 0; i < arrCauHoi.size() ; i++) {
            arrSmall = new ArrayList<DapAn>();
            sql = "select * from DapAn where maCauHoi = " + arrCauHoi.get(i).getMaCauHoi();
            csr = databaseAccess.getDb().rawQuery(sql, null);
            if (csr != null) {
                if (csr.moveToFirst()) {
                    do {
                        int maDapAn = csr.getInt(0);
                        String noiDung = csr.getString(1);
                        int dungSai = csr.getInt(2);
                        int maCauHoi = csr.getInt(3);
                        int vitriDung = csr.getInt(4);
                        arrSmall.add(new DapAn(maDapAn, noiDung, dungSai, maCauHoi,vitriDung));

                    } while (csr.moveToNext());
                }
            }
            arrBig.add(arrSmall);
        }
        databaseAccess.close();
        return arrBig;
    }
    public ArrayList<DapAn> getAllDapAnDung(ArrayList<CauHoi> arrCauHoi){
        databaseAccess.open();
        ArrayList<DapAn> arr = new ArrayList<DapAn>();
        String sql;
        for (int i = 0; i < arrCauHoi.size() ; i++) {
            sql = "select * from DapAn where dungSai = 1 and maCauHoi =" + arrCauHoi.get(i).getMaCauHoi();
            csr = databaseAccess.getDb().rawQuery(sql, null);
            if (csr != null) {
                if (csr.moveToFirst()) {
                    do {
                        int maDapAn = csr.getInt(0);
                        String noiDung = csr.getString(1);
                        int dungSai = csr.getInt(2);
                        int maCauHoi = csr.getInt(3);
                        int vitriDung = csr.getInt(4);
                        arr.add(new DapAn(maDapAn, noiDung, dungSai, maCauHoi,vitriDung));
                    } while (csr.moveToNext());
                }
            }
        }
        databaseAccess.close();
        return arr;
    }
}
