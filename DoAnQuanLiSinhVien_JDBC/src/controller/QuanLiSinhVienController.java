package controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import view.QuanLiSinhVienView;

public class QuanLiSinhVienController implements ActionListener {
	public QuanLiSinhVienView quanLiSinhVienView;

	/**
	 * @param quanLiSinhVienView
	 */
	public QuanLiSinhVienController(QuanLiSinhVienView quanLiSinhVienView) {
		this.quanLiSinhVienView = quanLiSinhVienView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String luaChon = e.getActionCommand();
		if (luaChon.equals("Thêm")) {
			// this.quanLiSinhVienView.quanLiSinhVienModel.setLuaChon("Them sinh vien");
			this.quanLiSinhVienView.themSinhVien();
			this.quanLiSinhVienView.clearThongTinChiTiet();
		} else if (luaChon.equals("Xem")) {
			this.quanLiSinhVienView.hienThiSinhVienDaChon();
		} else if (luaChon.equals("Sửa")) {
			this.quanLiSinhVienView.chinhSuaSinhVien();
			this.quanLiSinhVienView.clearThongTinChiTiet();
		} else if (luaChon.equals("Xóa")) {
			this.quanLiSinhVienView.xoaSinhVien();
			this.quanLiSinhVienView.clearThongTinChiTiet();
		} else if (luaChon.equals("Tìm kiếm")) {
			this.quanLiSinhVienView.timSinhVien();
		} else if (luaChon.equals("Hủy tìm")) {
			this.quanLiSinhVienView.clearTim();
			this.quanLiSinhVienView.taiLaiDuLieuTrongTable();
		} else if (luaChon.equals("Save")) {
			this.quanLiSinhVienView.luuFile();
		} else if (luaChon.equals("Open")) {
			this.quanLiSinhVienView.moFile();
		} else if (luaChon.equals("Exit")) {
			this.quanLiSinhVienView.thoatChuongTrinh();
		} else if (luaChon.equals("About me")) {
			this.quanLiSinhVienView.hienThiAboutMe();
		} else if (luaChon.equals("Upload")) {
			this.quanLiSinhVienView.uploadDatabase();
		} else if (luaChon.equals("Download")) {
			this.quanLiSinhVienView.downloadDatabase();
		}
	}

}
