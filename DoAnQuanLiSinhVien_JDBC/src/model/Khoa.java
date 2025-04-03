package model;

import java.util.Arrays;
import java.util.List;

public enum Khoa {
	CONG_NGHE_THONG_TIN("Công nghệ thông tin",
			Arrays.asList("Khoa học máy tính", "Kỹ thuật phần mềm", "Hệ thống thông tin")),
	DIEN_TU_VIEN_THONG("Điện tử - Viễn thông", Arrays.asList("Điện tử", "Máy tính - Hệ thống nhúng", "Viễn thông")),
	XAY_DUNG("Xây dựng", Arrays.asList("Kỹ thuật xây dựng dân dụng và công nghiệp", "Kỹ thuật xây dựng cầu đường")),
	KINH_TE("Kinh tế", Arrays.asList("Kinh tế học", "Quản trị kinh doanh")),
	NGOAI_NGU("Ngoại ngữ", Arrays.asList("Ngôn ngữ Anh", "Ngôn ngữ Nhật"));

	private final String nganhDaoTao;
	private final List<String> chuyenNganh;

	Khoa(String nganhDaoTao, List<String> chuyenNganh) {
		this.nganhDaoTao = nganhDaoTao;
		this.chuyenNganh = chuyenNganh;
	}

	public String getNganhDaoTao() {
		return nganhDaoTao;
	}

	public List<String> getChuyenNganh() {
		return chuyenNganh;
	}

	public static Khoa fromString(String nganhDaoTao) {
		if (nganhDaoTao != null) {
			for (Khoa khoa : Khoa.values()) {
				if (nganhDaoTao.equalsIgnoreCase(khoa.nganhDaoTao)) { // Sửa ở đây
					return khoa;
				}
			}
		}
		return Khoa.CONG_NGHE_THONG_TIN; // Giá trị mặc định
	}
}