package ngoclong.example.phanmemthibanglai.ui.caccauhaysai;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import ngoclong.example.phanmemthibanglai.ui.thisathach.CauHoi;
import ngoclong.example.phanmemthibanglai.ui.thisathach.DatabaseAccess;

public class CacCauHaySaiDAO {
    Cursor csr = null;
    DatabaseAccess databaseAccess;
    public CacCauHaySaiDAO(Context context){
        databaseAccess = DatabaseAccess.getInstance(context);
    }



}
