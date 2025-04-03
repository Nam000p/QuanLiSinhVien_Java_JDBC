package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class SinhVien implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maSinhVien;
    private String hoTenSinhVien;
    private LocalDate ngaySinh;
    private boolean gioiTinh;
    private Tinh queQuan;
    private int namNhapHoc;
    private BacDaoTao bacDaoTao;
    private LoaiHinhDaoTao loaiHinhDaoTao;
    private Khoa khoa;
    private String chuyenNganh;
    private TinhTrang tinhTrang;
	/**
	 * @param maSinhVien
	 * @param hoTenSinhVien
	 * @param ngaySinh
	 * @param gioiTinh
	 * @param queQuan
	 * @param namNhapHoc
	 * @param bacDaoTao
	 * @param loaiHinhDaoTao
	 * @param khoa
	 * @param tinhTrang
	 */
    public SinhVien() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param maSinhVien
	 * @param hoTenSinhVien
	 * @param ngaySinh
	 * @param gioiTinh
	 * @param queQuan
	 * @param namNhapHoc
	 * @param bacDaoTao
	 * @param loaiHinhDaoTao
	 * @param khoa
	 * @param chuyenNganh
	 * @param tinhTrang
	 */
	public SinhVien(String maSinhVien, String hoTenSinhVien, LocalDate ngaySinh, boolean gioiTinh, Tinh queQuan,
			int namNhapHoc, BacDaoTao bacDaoTao, LoaiHinhDaoTao loaiHinhDaoTao, Khoa khoa, String chuyenNganh,
			TinhTrang tinhTrang) {
		this.maSinhVien = maSinhVien;
		this.hoTenSinhVien = hoTenSinhVien;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.queQuan = queQuan;
		this.namNhapHoc = namNhapHoc;
		this.bacDaoTao = bacDaoTao;
		this.loaiHinhDaoTao = loaiHinhDaoTao;
		this.khoa = khoa;
		this.chuyenNganh = chuyenNganh;
		this.tinhTrang = tinhTrang;
	}
	/**
	 * @return the maSinhVien
	 */
	public String getMaSinhVien() {
		return maSinhVien;
	}
	/**
	 * @param maSinhVien the maSinhVien to set
	 */
	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	/**
	 * @return the hoTenSinhVien
	 */
	public String getHoTenSinhVien() {
		return hoTenSinhVien;
	}
	/**
	 * @param hoTenSinhVien the hoTenSinhVien to set
	 */
	public void setHoTenSinhVien(String hoTenSinhVien) {
		this.hoTenSinhVien = hoTenSinhVien;
	}
	/**
	 * @return the ngaySinh
	 */
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	/**
	 * @param ngaySinh the ngaySinh to set
	 */
	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	/**
	 * @return the gioiTinh
	 */
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	/**
	 * @param gioiTinh the gioiTinh to set
	 */
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	/**
	 * @return the queQuan
	 */
	public Tinh getQueQuan() {
		return queQuan;
	}
	/**
	 * @param queQuan the queQuan to set
	 */
	public void setQueQuan(Tinh queQuan) {
		this.queQuan = queQuan;
	}
	/**
	 * @return the namNhapHoc
	 */
	public int getNamNhapHoc() {
		return namNhapHoc;
	}
	/**
	 * @param namNhapHoc the namNhapHoc to set
	 */
	public void setNamNhapHoc(int namNhapHoc) {
		this.namNhapHoc = namNhapHoc;
	}
	/**
	 * @return the bacDaoTao
	 */
	public BacDaoTao getBacDaoTao() {
		return bacDaoTao;
	}
	/**
	 * @param bacDaoTao the bacDaoTao to set
	 */
	public void setBacDaoTao(BacDaoTao bacDaoTao) {
		this.bacDaoTao = bacDaoTao;
	}
	/**
	 * @return the loaiHinhDaoTao
	 */
	public LoaiHinhDaoTao getLoaiHinhDaoTao() {
		return loaiHinhDaoTao;
	}
	/**
	 * @param loaiHinhDaoTao the loaiHinhDaoTao to set
	 */
	public void setLoaiHinhDaoTao(LoaiHinhDaoTao loaiHinhDaoTao) {
		this.loaiHinhDaoTao = loaiHinhDaoTao;
	}
	/**
	 * @return the khoa
	 */
	public Khoa getKhoa() {
		return khoa;
	}
	/**
	 * @param khoa the khoa to set
	 */
	public void setKhoa(Khoa khoa) {
		this.khoa = khoa;
	}
	/**
	 * @return the chuyenNganh
	 */
	public String getChuyenNganh() {
		return chuyenNganh;
	}
	/**
	 * @param chuyenNganh the chuyenNganh to set
	 */
	public void setChuyenNganh(String chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}
	/**
	 * @return the tinhTrang
	 */
	public TinhTrang getTinhTrang() {
		return tinhTrang;
	}
	/**
	 * @param tinhTrang the tinhTrang to set
	 */
	public void setTinhTrang(TinhTrang tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	@Override
	public String toString() {
		return "SinhVien [maSinhVien=" + maSinhVien + ", hoTenSinhVien=" + hoTenSinhVien + ", ngaySinh=" + ngaySinh
				+ ", gioiTinh=" + gioiTinh + ", queQuan=" + queQuan + ", namNhapHoc=" + namNhapHoc + ", bacDaoTao="
				+ bacDaoTao + ", loaiHinhDaoTao=" + loaiHinhDaoTao + ", khoa=" + khoa + ", chuyenNganh=" + chuyenNganh
				+ ", tinhTrang=" + tinhTrang + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(bacDaoTao, chuyenNganh, gioiTinh, hoTenSinhVien, khoa, loaiHinhDaoTao, maSinhVien,
				namNhapHoc, ngaySinh, queQuan, tinhTrang);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinhVien other = (SinhVien) obj;
		return bacDaoTao == other.bacDaoTao && Objects.equals(chuyenNganh, other.chuyenNganh)
				&& gioiTinh == other.gioiTinh && Objects.equals(hoTenSinhVien, other.hoTenSinhVien)
				&& khoa == other.khoa && loaiHinhDaoTao == other.loaiHinhDaoTao
				&& Objects.equals(maSinhVien, other.maSinhVien) && namNhapHoc == other.namNhapHoc
				&& Objects.equals(ngaySinh, other.ngaySinh) && queQuan == other.queQuan && tinhTrang == other.tinhTrang;
	}
}
