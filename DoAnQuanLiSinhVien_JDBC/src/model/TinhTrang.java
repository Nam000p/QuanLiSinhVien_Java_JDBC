package model;

public enum TinhTrang {
	DANG_HOC("Đang học"),
    DA_TOT_NGHIEP("Đã tốt nghiệp"),
    BAO_LUU("Bảo lưu"),
    THOI_HOC("Thôi học");

    private final String tenTinhTrang;

    TinhTrang(String tenTinhTrang) {
        this.tenTinhTrang = tenTinhTrang;
    }

    public String getTenTinhTrang() {
        return tenTinhTrang;
    }
    
    public static TinhTrang fromString(String tenTinhTrang) {
        if (tenTinhTrang != null) {
            for (TinhTrang tinhTrang : TinhTrang.values()) {
                if (tenTinhTrang.equalsIgnoreCase(tinhTrang.tenTinhTrang)) { // Sửa ở đây
                    return tinhTrang;
                }
            }
        }
        return TinhTrang.DANG_HOC; // Giá trị mặc định
    }
}
