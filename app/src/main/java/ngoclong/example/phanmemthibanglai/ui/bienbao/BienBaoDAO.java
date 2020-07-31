package ngoclong.example.phanmemthibanglai.ui.bienbao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;

import ngoclong.example.phanmemthibanglai.ui.thisathach.DatabaseAccess;


public class BienBaoDAO {
    Cursor csr = null;
    DatabaseAccess databaseAccess;
    public BienBaoDAO(Context context){
        databaseAccess = DatabaseAccess.getInstance(context);
    }

    public ArrayList<BienBao> getAllBienBaoCam(){
        databaseAccess.open();
        ArrayList<BienBao> arr = new ArrayList<>();

        String sql = "select * from BienBao where LoaiBB = 0";
        csr = databaseAccess.getDb().rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    String maBB = csr.getString(0);
                    String tenBB = csr.getString(1);
                    String noiDung = csr.getString(2);
                    String hinh = csr.getString(3);
                    String loaiBB = csr.getString(4);
                    arr.add(new BienBao(maBB,tenBB, hinh, noiDung,loaiBB));
                } while (csr.moveToNext());
            }
        }
        databaseAccess.close();
        return arr;
    }

    public int getSoBienBaoCam()
    {
        databaseAccess.open();
        String countQuery = "SELECT  * FROM BienBao where LoaiBB = 0" ;
        Cursor cursor = databaseAccess.getDb().rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        databaseAccess.close();
        return count;
    }
    public int getSoBienBaoHieuLenh()
    {
        databaseAccess.open();
        String countQuery = "SELECT  * FROM BienBao where LoaiBB = 2" ;
        Cursor cursor = databaseAccess.getDb().rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        databaseAccess.close();
        return count;
    }


    public ArrayList<BienBao> getAllBienBaoHieuLenh(){
        databaseAccess.open();
        ArrayList<BienBao> arr = new ArrayList<>();
        String sql = "select * from BienBao where LoaiBB = 2";
        csr = databaseAccess.getDb().rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    String maBB = csr.getString(0);
                    String tenBB = csr.getString(1);
                    String noiDung = csr.getString(2);
                    String hinh = csr.getString(3);
                    String loaiBB = csr.getString(4);
                    arr.add(new BienBao(maBB,tenBB, hinh, noiDung,loaiBB));
                } while (csr.moveToNext());
            }
        }
        databaseAccess.close();
        return arr;
    }
    public int getSoBienBaoChiDan()
    {
        databaseAccess.open();
        String countQuery = "SELECT  * FROM BienBao where LoaiBB = 1" ;
        Cursor cursor = databaseAccess.getDb().rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        databaseAccess.close();
        return count;
    }

    public ArrayList<BienBao> getAllBienBaoChiDan(){
        databaseAccess.open();
        ArrayList<BienBao> arr = new ArrayList<>();
        String sql = "select * from BienBao where LoaiBB = 1";
        csr = databaseAccess.getDb().rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    String maBB = csr.getString(0);
                    String tenBB = csr.getString(1);
                    String noiDung = csr.getString(2);
                    String hinh = csr.getString(3);
                    String loaiBB = csr.getString(4);
                    arr.add(new BienBao(maBB,tenBB, hinh, noiDung,loaiBB));
                } while (csr.moveToNext());
            }
        }
        databaseAccess.close();
        return arr;
    }

    public int getSoBienBaoNguyHiem()
    {
        databaseAccess.open();
        String countQuery = "SELECT  * FROM BienBao where LoaiBB = 3" ;
        Cursor cursor = databaseAccess.getDb().rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        databaseAccess.close();
        return count;
    }


    public ArrayList<BienBao> getAllBienBaoNguyHiem(){
        databaseAccess.open();
        ArrayList<BienBao> arr = new ArrayList<>();
        String sql = "select * from BienBao where LoaiBB = 3";
        csr = databaseAccess.getDb().rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    String maBB = csr.getString(0);
                    String tenBB = csr.getString(1);
                    String noiDung = csr.getString(2);
                    String hinh = csr.getString(3);
                    String loaiBB = csr.getString(4);
                    arr.add(new BienBao(maBB,tenBB, hinh, noiDung,loaiBB));
                } while (csr.moveToNext());
            }
        }
        databaseAccess.close();
        return arr;
    }
}
