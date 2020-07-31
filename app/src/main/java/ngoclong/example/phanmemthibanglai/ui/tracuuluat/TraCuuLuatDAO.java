package ngoclong.example.phanmemthibanglai.ui.tracuuluat;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;


import ngoclong.example.phanmemthibanglai.ui.bienbao.BienBao;
import ngoclong.example.phanmemthibanglai.ui.thisathach.DatabaseAccess;

public class TraCuuLuatDAO {
    Cursor csr = null;
    DatabaseAccess databaseAccess;
    public TraCuuLuatDAO(Context context){
        databaseAccess = DatabaseAccess.getInstance(context);
    }

    public ArrayList<Luat> getAllLuatXeMay(){
        databaseAccess.open();
        ArrayList<Luat> arr = new ArrayList<>();

        String sql = "select * from TraCuuLuatXeMay";
        csr = databaseAccess.getDb().rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {

                    String noiDung = csr.getString(0);
                    String mucPhat = csr.getString(1);
                    String hinh = csr.getString(2);
                    arr.add(new Luat(noiDung, mucPhat, hinh));
                } while (csr.moveToNext());
            }
        }
        databaseAccess.close();
        return arr;
    }
    public int getSoLuatxeMay()
    {
        databaseAccess.open();
        String countQuery = "SELECT  * FROM TraCuuLuatXeMay" ;
        Cursor cursor = databaseAccess.getDb().rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        databaseAccess.close();
        return count;
    }

}
