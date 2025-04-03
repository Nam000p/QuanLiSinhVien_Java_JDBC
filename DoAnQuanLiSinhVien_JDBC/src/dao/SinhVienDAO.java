package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import database.JDBCUtil;
import model.SinhVien;
import model.Tinh;
import model.Khoa;
import model.BacDaoTao;
import model.LoaiHinhDaoTao;
import model.TinhTrang;

public class SinhVienDAO implements DAOInterface<SinhVien> {

	public static SinhVienDAO getInstance() {
		return new SinhVienDAO();
	}

	public boolean exist(SinhVien t) {
		Connection connection = JDBCUtil.getConnection();
		String sql = "SELECT * FROM SinhVien WHERE maSinhVien = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getMaSinhVien());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public int insert(SinhVien t) {
		// TODO Auto-generated method stub
		// Buoc 1: Tao ket noi den CSDL
		Connection connection = JDBCUtil.getConnection();
		int rowsAffected = 0;
		// Buoc 2: Tao ra Statement
		String sql = "INSERT INTO SinhVien(maSinhVien, hoTenSinhVien, ngaySinh, gioiTinh, queQuan, namNhapHoc, bacDaoTao, loaiHinhDaoTao, khoa, chuyenNganh, tinhTrang) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, t.getMaSinhVien());
			prepareStatement.setString(2, t.getHoTenSinhVien());
			java.sql.Date ngaySinh = java.sql.Date.valueOf(t.getNgaySinh());
			prepareStatement.setDate(3, ngaySinh);
			prepareStatement.setInt(4, (t.isGioiTinh() ? 1 : 0));
			prepareStatement.setString(5, t.getQueQuan().getTenTinh());
			prepareStatement.setInt(6, t.getNamNhapHoc());
			prepareStatement.setString(7, t.getBacDaoTao().getTenBacDaoTao());
			prepareStatement.setString(8, t.getLoaiHinhDaoTao().getTenLoaiHinh());
			prepareStatement.setString(9, t.getKhoa().getNganhDaoTao());
			prepareStatement.setString(10, t.getChuyenNganh());
			prepareStatement.setString(11, t.getTinhTrang().getTenTinhTrang());

			rowsAffected = prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return rowsAffected;
	}

	@Override
	public int update(SinhVien t) {
		// Buoc 1: Tao ket noi den CSDL
		Connection connection = JDBCUtil.getConnection();
		int rowsAffected = 0;
		String sql = "UPDATE SinhVien SET hoTenSinhVien = ?, ngaySinh = ?, gioiTinh = ?, queQuan = ?, namNhapHoc = ?, bacDaoTao = ?, loaiHinhDaoTao = ?, khoa = ?, chuyenNganh = ?, tinhTrang = ? WHERE maSinhVien = ?";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);

			// Set parameters in the correct order as defined in the SQL query.
			prepareStatement.setString(1, t.getHoTenSinhVien());

			java.sql.Date ngaySinh = java.sql.Date.valueOf(t.getNgaySinh());
			prepareStatement.setDate(2, ngaySinh);

			prepareStatement.setInt(3, (t.isGioiTinh() ? 1 : 0));
			prepareStatement.setString(4, t.getQueQuan().getTenTinh());
			prepareStatement.setInt(5, t.getNamNhapHoc());
			prepareStatement.setString(6, t.getBacDaoTao().getTenBacDaoTao());
			prepareStatement.setString(7, t.getLoaiHinhDaoTao().getTenLoaiHinh());
			prepareStatement.setString(8, t.getKhoa().getNganhDaoTao());
			prepareStatement.setString(9, t.getChuyenNganh());
			prepareStatement.setString(10, t.getTinhTrang().getTenTinhTrang());
			prepareStatement.setString(11, t.getMaSinhVien()); // Set maSinhVien for the WHERE clause

			rowsAffected = prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(); // Important: Print the stack trace for debugging!
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return rowsAffected;
	}

	@Override
	public int delete(SinhVien t) {
		// TODO Auto-generated method stub
		// Buoc 1: Tao ket noi den CSDL
		Connection connection = JDBCUtil.getConnection();
		int rowsAffected = 0;
		String sql = "DELETE SinhVien FROM WHERE maSinhVien = ?";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, t.getMaSinhVien()); // Set maSinhVien for the WHERE clause

			rowsAffected = prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(); // Important: Print the stack trace for debugging!
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return rowsAffected;
	}

	@Override
	public ArrayList<SinhVien> selectAll() {
		// TODO Auto-generated method stub
		// Buoc 1: Tao ket noi den CSDL
		ArrayList<SinhVien> danhSachSinhVien = new ArrayList<SinhVien>();
		Connection connection = JDBCUtil.getConnection();
		String sql = "SELECT * FROM SinhVien";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				String maSinhVien = rs.getString("maSinhVien");
				String hoTenSinhVien = rs.getString("hoTenSinhVien");
				LocalDate ngaySinh = rs.getDate("ngaySinh").toLocalDate();
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				Tinh queQuan = Tinh.fromString(rs.getString("queQuan"));
				int namNhapHoc = rs.getInt("namNhapHoc");
				BacDaoTao bacDaoTao = BacDaoTao.fromString(rs.getString("bacDaoTao"));
				LoaiHinhDaoTao loaiHinhDaoTao = LoaiHinhDaoTao.fromString(rs.getString("loaiHinhDaoTao"));
				Khoa khoa = Khoa.fromString(rs.getString("khoa"));
				String chuyenNganh = rs.getNString("chuyenNganh");
				TinhTrang tinhTrang = TinhTrang.fromString(rs.getString("tinhTrang"));

				SinhVien sinhVien = new SinhVien(maSinhVien, hoTenSinhVien, ngaySinh, gioiTinh, queQuan, namNhapHoc,
						bacDaoTao, loaiHinhDaoTao, khoa, chuyenNganh, tinhTrang);
				danhSachSinhVien.add(sinhVien);
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Important: Print the stack trace for debugging!
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return danhSachSinhVien;
	}

	@Override
	public SinhVien selectById(SinhVien t) {
		// TODO Auto-generated method stub
		SinhVien sinhVien = null;
		Connection connection = JDBCUtil.getConnection();
		String sql = "SELECT * FROM SinhVien WHERE maSinhVien = ?";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, t.getMaSinhVien());

			ResultSet rs = prepareStatement.executeQuery();

			if (rs.next()) {
				String maSinhVien = rs.getString("maSinhVien");
				String hoTenSinhVien = rs.getString("hoTenSinhVien");
				LocalDate ngaySinh = rs.getDate("ngaySinh").toLocalDate();
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				Tinh queQuan = Tinh.fromString(rs.getString("queQuan"));
				int namNhapHoc = rs.getInt("namNhapHoc");
				BacDaoTao bacDaoTao = BacDaoTao.fromString(rs.getString("bacDaoTao"));
				LoaiHinhDaoTao loaiHinhDaoTao = LoaiHinhDaoTao.fromString(rs.getString("loaiHinhDaoTao"));
				Khoa khoa = Khoa.fromString(rs.getString("khoa"));
				String chuyenNganh = rs.getNString("chuyenNganh");
				TinhTrang tinhTrang = TinhTrang.fromString(rs.getString("tinhTrang"));

				sinhVien = new SinhVien(maSinhVien, hoTenSinhVien, ngaySinh, gioiTinh, queQuan, namNhapHoc, bacDaoTao,
						loaiHinhDaoTao, khoa, chuyenNganh, tinhTrang);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return sinhVien;
	}

	@Override
	public ArrayList<SinhVien> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		ArrayList<SinhVien> danhSachSinhVien = new ArrayList<SinhVien>();
		Connection connection = JDBCUtil.getConnection();
		String sql = "SELECT * FROM SinhVien WHERE ?";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, condition);
			
			ResultSet rs = prepareStatement.executeQuery();
			
			while (rs.next()) {
				String maSinhVien = rs.getString("maSinhVien");
				String hoTenSinhVien = rs.getString("hoTenSinhVien");
				LocalDate ngaySinh = rs.getDate("ngaySinh").toLocalDate();
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				Tinh queQuan = Tinh.fromString(rs.getString("queQuan"));
				int namNhapHoc = rs.getInt("namNhapHoc");
				BacDaoTao bacDaoTao = BacDaoTao.fromString(rs.getString("bacDaoTao"));
				LoaiHinhDaoTao loaiHinhDaoTao = LoaiHinhDaoTao.fromString(rs.getString("loaiHinhDaoTao"));
				Khoa khoa = Khoa.fromString(rs.getString("khoa"));
				String chuyenNganh = rs.getNString("chuyenNganh");
				TinhTrang tinhTrang = TinhTrang.fromString(rs.getString("tinhTrang"));

				SinhVien sinhVien = new SinhVien(maSinhVien, hoTenSinhVien, ngaySinh, gioiTinh, queQuan, namNhapHoc,
						bacDaoTao, loaiHinhDaoTao, khoa, chuyenNganh, tinhTrang);
				danhSachSinhVien.add(sinhVien);
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Important: Print the stack trace for debugging!
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return danhSachSinhVien;
	}
}
