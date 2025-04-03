package model;

import java.util.ArrayList;

public class QuanLiSinhVienModel {
	private ArrayList<SinhVien> danhSachSinhVien;
	private String tenFile;

	/**
	 * @param danhSachSinhVien
	 * @param luaChon
	 * @param tenFile
	 */
	public QuanLiSinhVienModel() {
		this.danhSachSinhVien = new ArrayList<SinhVien>();
		this.tenFile = "";
	}

	/**
	 * @return the danhSachSinhVien
	 */
	public ArrayList<SinhVien> getDanhSachSinhVien() {
		return danhSachSinhVien;
	}

	/**
	 * @param danhSachSinhVien the danhSachSinhVien to set
	 */
	public void setDanhSachSinhVien(ArrayList<SinhVien> danhSachSinhVien) {
		this.danhSachSinhVien = danhSachSinhVien;
	}

	/**
	 * @return the tenFile
	 */
	public String getTenFile() {
		return tenFile;
	}

	/**
	 * @param tenFile the tenFile to set
	 */
	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

	public boolean kiemTraTonTai(SinhVien sinhVien) {
		for (SinhVien sv : danhSachSinhVien) {
			if (sv.getMaSinhVien().equals(sinhVien.getMaSinhVien()))
				return true;
		}
		return false;
	}
	
	public void themSinhVien(SinhVien sinhVien) {
		this.danhSachSinhVien.add(sinhVien);
	}
	
	public void xoaSinhVien(SinhVien sinhVien) {
		this.danhSachSinhVien.remove(sinhVien);
	}
	
	public void chinhSuaSinhVien(SinhVien sinhVien) {
		this.danhSachSinhVien.remove(sinhVien);
		this.danhSachSinhVien.add(sinhVien);
	}
}
