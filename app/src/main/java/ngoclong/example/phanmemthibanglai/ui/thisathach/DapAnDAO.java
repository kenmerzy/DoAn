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
        String countQuery = "SELECT  * FROM CauHoi" ;
        Cursor cursor = databaseAccess.getDb().rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }
    public ArrayList<ArrayList<DapAn>> getAllDapAn(){
        databaseAccess.open();
        ArrayList<ArrayList<DapAn>> arrBig = new ArrayList<ArrayList<DapAn>>();
        ArrayList<DapAn> arrSmall;
        String sql;
        int soCauHoi = getSoCauHoi();
        for (int i = 1; i <= soCauHoi ; i++) {
            arrSmall = new ArrayList<DapAn>();
            sql = "select * from DapAn where maCauHoi = " + i;
            csr = databaseAccess.getDb().rawQuery(sql, null);
            if (csr != null) {
                if (csr.moveToFirst()) {
                    do {
                        int maDapAn = csr.getInt(0);
                        String noiDung = csr.getString(1);
                        int dungSai = csr.getInt(2);
                        int maCauHoi = csr.getInt(3);

                        arrSmall.add(new DapAn(maDapAn, noiDung, dungSai, maCauHoi));

                    } while (csr.moveToNext());
                }
            }
            arrBig.add(arrSmall);
        }
        databaseAccess.close();
        return arrBig;
    }
}
