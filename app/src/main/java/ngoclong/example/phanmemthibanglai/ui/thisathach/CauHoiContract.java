package ngoclong.example.phanmemthibanglai.ui.thisathach;

import android.provider.BaseColumns;

public final class CauHoiContract {

    private CauHoiContract() {}

    public static class  BangCauHoi implements BaseColumns {
        public static final String TEN_BANG = "CauHoi";
        public static final String MA = "maCauHoi";
        public static final String NOI_DUNG_ = "noiDung";
        public static final String HINH_ANH = "hinh";

    }
    public static class  BangDapAn implements BaseColumns {
        public static final String TEN_BANG = "DapAn";
        public static final String MA = "maDapAn";
        public static final String NOI_DUNG_ = "noiDung";
        public static final String DUNG_SAI = "dungSai";
        public static final String MA_CAU_HOI = "maCauHoi";

    }
}
