package model;

public enum LoaiHinhDaoTao {
	CHINH_QUY("Chính quy"),
    LIEN_THONG("Liên thông"),
    VUA_LAM_VUA_HOC("Vừa làm vừa học");

    private final String tenLoaiHinh;

    LoaiHinhDaoTao(String tenLoaiHinh) {
        this.tenLoaiHinh = tenLoaiHinh;
    }

    public String getTenLoaiHinh() {
        return tenLoaiHinh;
    }
    
    public static LoaiHinhDaoTao fromString(String tenLoaiHinh) {
        if (tenLoaiHinh != null) {
            for (LoaiHinhDaoTao loaiHinh : LoaiHinhDaoTao.values()) {
                if (tenLoaiHinh.equalsIgnoreCase(loaiHinh.tenLoaiHinh)) { // Sửa ở đây
                    return loaiHinh;
                }
            }
        }
        return LoaiHinhDaoTao.CHINH_QUY; // Giá trị mặc định
    }
}
