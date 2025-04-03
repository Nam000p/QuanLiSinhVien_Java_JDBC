package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import controller.QuanLiSinhVienController;
import dao.SinhVienDAO;
import model.BacDaoTao;
import model.Khoa;
import model.LoaiHinhDaoTao;
import model.QuanLiSinhVienModel;
import model.SinhVien;
import model.Tinh;
import model.TinhTrang;

public class QuanLiSinhVienView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_MaSinhVienCanTim;
	private JTextField textField_MaSinhVien;
	private JTextField textField_HoTenSinhVien;
	private JTextField textField_NgaySinh;
	private JTextField textField_NamNhapHoc;
	private JTable table;

	public QuanLiSinhVienModel quanLiSinhVienModel;
	private JComboBox<String> comboBox_ChuyenNganh;
	private JComboBox<String> comboBox_Tinh;
	private JComboBox<String> comboBox_BacDaoTao;
	private JComboBox<String> comboBox_LoaiHinhDaoTao;
	private JComboBox<String> comboBox_Khoa;
	private JComboBox<String> comboBox_TinhTrang;
	private ButtonGroup buttonGroup_GioiTinh;
	private JRadioButton radionButton_Nam;
	private JRadioButton radionButton_Nu;
	private JComboBox<String> comboBox_TimKhoa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLiSinhVienView frame = new QuanLiSinhVienView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QuanLiSinhVienView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1095, 765);

		quanLiSinhVienModel = new QuanLiSinhVienModel();
		ActionListener actionListener = new QuanLiSinhVienController(this);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu jMenu_File = new JMenu("File");
		jMenu_File.setMnemonic(KeyEvent.VK_F);
		jMenu_File.setIcon(new ImageIcon(
				"D:\\eclipse-workspace\\DoAnQuanLiSinhVien\\src\\Image\\Hopstarter-Sleek-Xp-Basic-Document-Blank.24.png"));
		jMenu_File.setFont(new Font("Segoe UI", Font.BOLD, 22));
		jMenu_File.setDisplayedMnemonicIndex(0);
		menuBar.add(jMenu_File);

		JMenuItem jMenuItem_Open = new JMenuItem("Open", KeyEvent.VK_O);
		jMenuItem_Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		jMenuItem_Open.setIcon(new ImageIcon(
				"D:\\eclipse-workspace\\DoAnQuanLiSinhVien\\src\\Image\\Hopstarter-Sleek-Xp-Basic-Folder-Open.24.png"));
		jMenuItem_Open.setFont(new Font("Segoe UI", Font.BOLD, 22));
		jMenu_File.add(jMenuItem_Open);
		jMenuItem_Open.addActionListener(actionListener);

		JMenuItem jMenuItem_Save = new JMenuItem("Save", KeyEvent.VK_S);
		jMenuItem_Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		jMenuItem_Save.setIcon(new ImageIcon(
				"D:\\eclipse-workspace\\DoAnQuanLiSinhVien\\src\\Image\\Oxygen-Icons.org-Oxygen-Actions-document-save.24.png"));
		jMenuItem_Save.setFont(new Font("Segoe UI", Font.BOLD, 22));
		jMenu_File.add(jMenuItem_Save);
		jMenuItem_Save.addActionListener(actionListener);

		JSeparator separator_1 = new JSeparator();
		jMenu_File.add(separator_1);

		JMenuItem jMenuItem_Upload = new JMenuItem("Upload");
		jMenuItem_Upload.setFont(new Font("Segoe UI", Font.BOLD, 20));
		jMenuItem_Upload.addActionListener(actionListener);
		jMenu_File.add(jMenuItem_Upload);

		JMenuItem jMenuItem_Download = new JMenuItem("Download");
		jMenuItem_Download.setFont(new Font("Segoe UI", Font.BOLD, 20));
		jMenuItem_Download.addActionListener(actionListener);
		jMenu_File.add(jMenuItem_Download);

		JSeparator separator = new JSeparator();
		jMenu_File.add(separator);

		JMenuItem jMenuItem_Exit = new JMenuItem("Exit");
		jMenuItem_Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));
		jMenuItem_Exit.setIcon(new ImageIcon(
				"D:\\eclipse-workspace\\DoAnQuanLiSinhVien\\src\\Image\\Hopstarter-Sleek-Xp-Software-Windows-Turn-Off.24.png"));
		jMenuItem_Exit.setFont(new Font("Segoe UI", Font.BOLD, 22));
		jMenu_File.add(jMenuItem_Exit);
		jMenuItem_Exit.addActionListener(actionListener);

		JMenu jMenu_Help = new JMenu("Help");
		jMenu_Help.setMnemonic(KeyEvent.VK_H);
		jMenu_Help.setIcon(new ImageIcon(
				"D:\\eclipse-workspace\\DoAnQuanLiSinhVien\\src\\Image\\Hopstarter-Sleek-Xp-Basic-Help.24.png"));
		jMenu_Help.setFont(new Font("Segoe UI", Font.BOLD, 22));
		menuBar.add(jMenu_Help);

		JMenuItem jMenuItem_AboutMe = new JMenuItem("About me");
		jMenuItem_AboutMe.setIcon(new ImageIcon(
				"D:\\eclipse-workspace\\DoAnQuanLiSinhVien\\src\\Image\\Hopstarter-Sleek-Xp-Basic-Administrator.24.png"));
		jMenuItem_AboutMe.setFont(new Font("Segoe UI", Font.BOLD, 22));
		jMenu_Help.add(jMenuItem_AboutMe);
		jMenuItem_AboutMe.addActionListener(actionListener);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_TimKiem = new JPanel();
		panel_TimKiem.setBackground(new Color(128, 128, 255));
		panel_TimKiem.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(0, 64, 128), null, null, null));
		panel_TimKiem.setBounds(10, 126, 1061, 51);
		contentPane.add(panel_TimKiem);
		panel_TimKiem.setLayout(null);

//		JLabel label_TimSinhVien = new JLabel("Tim kiem sinh vien");
//		label_TimSinhVien.setForeground(new Color(0, 0, 128));
//		label_TimSinhVien.setBounds(10, 11, 160, 25);
//		label_TimSinhVien.setFont(new Font("Segoe UI", Font.BOLD, 20));
//		panel_TimKiem.add(label_TimSinhVien);

		JLabel label_MaSinhVienCanTim = new JLabel("Mã sinh viên");
		label_MaSinhVienCanTim.setForeground(new Color(0, 0, 128));
		label_MaSinhVienCanTim.setBounds(10, 11, 160, 25);
		label_MaSinhVienCanTim.setFont(new Font("Segoe UI", Font.BOLD, 20));
		panel_TimKiem.add(label_MaSinhVienCanTim);

		textField_MaSinhVienCanTim = new JTextField();
		textField_MaSinhVienCanTim.setBounds(145, 11, 174, 32);
		textField_MaSinhVienCanTim.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		panel_TimKiem.add(textField_MaSinhVienCanTim);
		textField_MaSinhVienCanTim.setColumns(10);

		JButton button_TimKiem = new JButton("Tìm kiếm");
		button_TimKiem.setIcon(new ImageIcon(
				"D:\\eclipse-workspace\\DoAnQuanLiSinhVien\\src\\Image\\Hopstarter-Sleek-Xp-Basic-Zoom.24.png"));
		button_TimKiem.setForeground(Color.RED);
		button_TimKiem.setFont(new Font("Segoe UI", Font.BOLD, 20));
		button_TimKiem.setBounds(670, 11, 160, 32);
		button_TimKiem.addActionListener(actionListener);
		panel_TimKiem.add(button_TimKiem);

		JButton button_HuyTim = new JButton("Hủy tìm");
		button_HuyTim.setIcon(new ImageIcon(
				"D:\\eclipse-workspace\\DoAnQuanLiSinhVien\\src\\Image\\Hopstarter-Sleek-Xp-Basic-Close-2.24.png"));
		button_HuyTim.setFont(new Font("Segoe UI", Font.BOLD, 20));
		button_HuyTim.setForeground(new Color(255, 0, 0));
		button_HuyTim.setBounds(860, 11, 160, 32);
		button_HuyTim.addActionListener(actionListener);
		panel_TimKiem.add(button_HuyTim);

		JLabel label_TimKhoa = new JLabel("Khoa");
		label_TimKhoa.setForeground(new Color(0, 0, 128));
		label_TimKhoa.setFont(new Font("Segoe UI", Font.BOLD, 20));
		label_TimKhoa.setBounds(369, 11, 73, 25);
		panel_TimKiem.add(label_TimKhoa);

		comboBox_TimKhoa = new JComboBox<String>();
		comboBox_TimKhoa.setBounds(425, 10, 174, 32);
		comboBox_TimKhoa.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		List<String> danhSachKhoa = Stream.of(Khoa.values()).map(Khoa::getNganhDaoTao).collect(Collectors.toList());
		for (String khoa : danhSachKhoa) {
			comboBox_TimKhoa.addItem(khoa);
		}
		comboBox_TimKhoa.setSelectedIndex(-1);
		panel_TimKiem.add(comboBox_TimKhoa);

		JPanel panel_DanhSachSinhVien = new JPanel();
		panel_DanhSachSinhVien.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_DanhSachSinhVien.setBounds(10, 187, 1061, 495);
		contentPane.add(panel_DanhSachSinhVien);
		panel_DanhSachSinhVien.setLayout(null);

//		JLabel label_DanhSachSinhVien = new JLabel("Danh sach sinh vien");
//		label_DanhSachSinhVien.setBounds(10, 10, 110, 13);
//		panel_DanhSachSinhVien.add(label_DanhSachSinhVien);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 1042, 185);
		panel_DanhSachSinhVien.add(scrollPane);

		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã sinh viên", "Họ và tên", "Năm nhập học", "Khoa", "Tình trạng" }));
		table.getColumnModel().getColumn(2).setPreferredWidth(99);
		table.setFont(new Font("Segoe UI", Font.BOLD, 20));
		table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
		table.setRowHeight(30);
		scrollPane.setViewportView(table);

		JPanel panel_ThongTinChiTiet = new JPanel();
		panel_ThongTinChiTiet.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_ThongTinChiTiet.setBounds(10, 256, 1042, 229);
		panel_ThongTinChiTiet.setBackground(new Color(128, 128, 255));
		panel_ThongTinChiTiet.setLayout(null);
		panel_DanhSachSinhVien.add(panel_ThongTinChiTiet);

//		JLabel label_ThongTinChiTiet = new JLabel("Thong tin chi tiet");
//		label_ThongTinChiTiet.setBounds(10, 10, 83, 13);
//		panel_ThongTinChiTiet.add(label_ThongTinChiTiet);

		JLabel label_MaSinhVien = new JLabel("Mã sinh viên");
		label_MaSinhVien.setHorizontalAlignment(SwingConstants.RIGHT);
		label_MaSinhVien.setForeground(new Color(0, 0, 128));
		label_MaSinhVien.setFont(new Font("Segoe UI", Font.BOLD, 20));
		label_MaSinhVien.setBounds(0, 16, 125, 32);
		panel_ThongTinChiTiet.add(label_MaSinhVien);

		textField_MaSinhVien = new JTextField();
		textField_MaSinhVien.setBounds(144, 16, 174, 32);
		textField_MaSinhVien.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		panel_ThongTinChiTiet.add(textField_MaSinhVien);
		textField_MaSinhVien.setColumns(10);

		JLabel label_HoTenSinhVien = new JLabel("Họ và tên");
		label_HoTenSinhVien.setForeground(new Color(0, 0, 128));
		label_HoTenSinhVien.setHorizontalAlignment(SwingConstants.RIGHT);
		label_HoTenSinhVien.setFont(new Font("Segoe UI", Font.BOLD, 20));
		label_HoTenSinhVien.setBounds(0, 58, 125, 32);
		panel_ThongTinChiTiet.add(label_HoTenSinhVien);

		textField_HoTenSinhVien = new JTextField();
		textField_HoTenSinhVien.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		textField_HoTenSinhVien.setBounds(144, 58, 174, 32);
		panel_ThongTinChiTiet.add(textField_HoTenSinhVien);
		textField_HoTenSinhVien.setColumns(10);

		JLabel label_NgaySinh = new JLabel("Ngày sinh");
		label_NgaySinh.setForeground(new Color(0, 0, 128));
		label_NgaySinh.setHorizontalAlignment(SwingConstants.RIGHT);
		label_NgaySinh.setFont(new Font("Segoe UI", Font.BOLD, 20));
		label_NgaySinh.setBounds(17, 100, 108, 32);
		panel_ThongTinChiTiet.add(label_NgaySinh);

		textField_NgaySinh = new JTextField();
		textField_NgaySinh.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		textField_NgaySinh.setBounds(144, 100, 174, 32);
		panel_ThongTinChiTiet.add(textField_NgaySinh);
		textField_NgaySinh.setText("yyyy-MM-dd");
		textField_NgaySinh.setColumns(10);

		JLabel label_GioiTinh = new JLabel("Giới tính");
		label_GioiTinh.setForeground(new Color(0, 0, 128));
		label_GioiTinh.setHorizontalAlignment(SwingConstants.RIGHT);
		label_GioiTinh.setFont(new Font("Segoe UI", Font.BOLD, 20));
		label_GioiTinh.setBounds(37, 183, 88, 32);
		panel_ThongTinChiTiet.add(label_GioiTinh);

		radionButton_Nam = new JRadioButton("Nam");
		radionButton_Nam.setHorizontalAlignment(SwingConstants.CENTER);
		radionButton_Nam.setFont(new Font("Segoe UI", Font.BOLD, 20));
		radionButton_Nam.setBounds(144, 183, 82, 32);
		panel_ThongTinChiTiet.add(radionButton_Nam);

		radionButton_Nu = new JRadioButton("Nữ");
		radionButton_Nu.setHorizontalAlignment(SwingConstants.CENTER);
		radionButton_Nu.setFont(new Font("Segoe UI", Font.BOLD, 20));
		radionButton_Nu.setBounds(236, 183, 82, 32);
		panel_ThongTinChiTiet.add(radionButton_Nu);

		buttonGroup_GioiTinh = new ButtonGroup();
		buttonGroup_GioiTinh.add(radionButton_Nam);
		buttonGroup_GioiTinh.add(radionButton_Nu);

		JLabel label_QueQuan = new JLabel("Quê quán");
		label_QueQuan.setForeground(new Color(0, 0, 128));
		label_QueQuan.setHorizontalAlignment(SwingConstants.RIGHT);
		label_QueQuan.setFont(new Font("Segoe UI", Font.BOLD, 20));
		label_QueQuan.setBounds(10, 141, 115, 31);
		panel_ThongTinChiTiet.add(label_QueQuan);

		comboBox_Tinh = new JComboBox<String>();
		comboBox_Tinh.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		comboBox_Tinh.setBounds(144, 142, 174, 32);
		List<String> danhSachTinh = Stream.of(Tinh.values()).map(Tinh::getTenTinh).collect(Collectors.toList());
		for (String tinh : danhSachTinh) {
			comboBox_Tinh.addItem(tinh);
		}
		comboBox_Tinh.setSelectedIndex(-1);
		panel_ThongTinChiTiet.add(comboBox_Tinh);

		JLabel label_NamNhapHoc = new JLabel("Năm nhập học");
		label_NamNhapHoc.setForeground(new Color(0, 0, 160));
		label_NamNhapHoc.setFont(new Font("Segoe UI", Font.BOLD, 20));
		label_NamNhapHoc.setHorizontalAlignment(SwingConstants.RIGHT);
		label_NamNhapHoc.setBounds(332, 16, 174, 32);
		panel_ThongTinChiTiet.add(label_NamNhapHoc);

		textField_NamNhapHoc = new JTextField();
		textField_NamNhapHoc.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		textField_NamNhapHoc.setBounds(516, 16, 174, 32);
		panel_ThongTinChiTiet.add(textField_NamNhapHoc);
		textField_NamNhapHoc.setColumns(10);

		JLabel label_BacDaoTao = new JLabel("Bậc đào tạo");
		label_BacDaoTao.setForeground(new Color(0, 0, 160));
		label_BacDaoTao.setFont(new Font("Segoe UI", Font.BOLD, 20));
		label_BacDaoTao.setHorizontalAlignment(SwingConstants.RIGHT);
		label_BacDaoTao.setBounds(374, 58, 131, 32);
		panel_ThongTinChiTiet.add(label_BacDaoTao);

		comboBox_BacDaoTao = new JComboBox<String>();
		comboBox_BacDaoTao.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		comboBox_BacDaoTao.setBounds(516, 58, 174, 32);
		List<String> danhSachBacDaoTao = Stream.of(BacDaoTao.values()).map(BacDaoTao::getTenBacDaoTao)
				.collect(Collectors.toList());
		for (String bacDaoTao : danhSachBacDaoTao) {
			comboBox_BacDaoTao.addItem(bacDaoTao);
		}
		comboBox_BacDaoTao.setSelectedIndex(-1);
		panel_ThongTinChiTiet.add(comboBox_BacDaoTao);

		JLabel label_LoaiHinhDaoTao = new JLabel("Loại hình đào tạo");
		label_LoaiHinhDaoTao.setForeground(new Color(0, 0, 160));
		label_LoaiHinhDaoTao.setFont(new Font("Segoe UI", Font.BOLD, 20));
		label_LoaiHinhDaoTao.setHorizontalAlignment(SwingConstants.RIGHT);
		label_LoaiHinhDaoTao.setBounds(316, 100, 190, 32);
		panel_ThongTinChiTiet.add(label_LoaiHinhDaoTao);

		comboBox_LoaiHinhDaoTao = new JComboBox<String>();
		comboBox_LoaiHinhDaoTao.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		comboBox_LoaiHinhDaoTao.setBounds(516, 100, 174, 32);
		List<String> danhSachLoaiHinhDaoTao = Stream.of(LoaiHinhDaoTao.values()).map(LoaiHinhDaoTao::getTenLoaiHinh)
				.collect(Collectors.toList());
		for (String loaiHinhDaoTao : danhSachLoaiHinhDaoTao) {
			comboBox_LoaiHinhDaoTao.addItem(loaiHinhDaoTao);
		}
		comboBox_LoaiHinhDaoTao.setSelectedIndex(-1);
		panel_ThongTinChiTiet.add(comboBox_LoaiHinhDaoTao);

		JLabel label_Khoa = new JLabel("Khoa");
		label_Khoa.setForeground(new Color(0, 0, 160));
		label_Khoa.setFont(new Font("Segoe UI", Font.BOLD, 20));
		label_Khoa.setHorizontalAlignment(SwingConstants.RIGHT);
		label_Khoa.setBounds(773, 16, 70, 32);
		panel_ThongTinChiTiet.add(label_Khoa);

		comboBox_Khoa = new JComboBox<String>();
		comboBox_Khoa.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		comboBox_Khoa.setBounds(853, 16, 174, 32);
		for (String khoa : danhSachKhoa) {
			comboBox_Khoa.addItem(khoa);
		}
		comboBox_Khoa.setSelectedIndex(-1);
		panel_ThongTinChiTiet.add(comboBox_Khoa);

		JLabel label_ChuyenNganh = new JLabel("Chuyên ngành");
		label_ChuyenNganh.setForeground(new Color(0, 0, 160));
		label_ChuyenNganh.setFont(new Font("Segoe UI", Font.BOLD, 20));
		label_ChuyenNganh.setHorizontalAlignment(SwingConstants.RIGHT);
		label_ChuyenNganh.setBounds(655, 58, 188, 32);
		panel_ThongTinChiTiet.add(label_ChuyenNganh);
		comboBox_ChuyenNganh = new JComboBox<String>();
		comboBox_ChuyenNganh.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		comboBox_ChuyenNganh.setBounds(853, 58, 174, 32);
		comboBox_Khoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String tenKhoaDuocChon = (String) comboBox_Khoa.getSelectedItem();
				capNhatComboBox_ChuyenNganh(tenKhoaDuocChon);
			}
		});
		panel_ThongTinChiTiet.add(comboBox_ChuyenNganh);

		JLabel label_TinhTrang = new JLabel("Tình trạng");
		label_TinhTrang.setHorizontalAlignment(SwingConstants.RIGHT);
		label_TinhTrang.setForeground(new Color(0, 0, 160));
		label_TinhTrang.setFont(new Font("Segoe UI", Font.BOLD, 20));
		label_TinhTrang.setBounds(712, 100, 131, 32);
		panel_ThongTinChiTiet.add(label_TinhTrang);

		comboBox_TinhTrang = new JComboBox<String>();
		comboBox_TinhTrang.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		comboBox_TinhTrang.setBounds(853, 100, 174, 32);
		List<String> danhSachTinhTrang = Stream.of(TinhTrang.values()).map(TinhTrang::getTenTinhTrang)
				.collect(Collectors.toList());
		for (String tinhTrang : danhSachTinhTrang) {
			comboBox_TinhTrang.addItem(tinhTrang);
		}
		comboBox_TinhTrang.setSelectedIndex(-1);
		panel_ThongTinChiTiet.add(comboBox_TinhTrang);

		JPanel panel_Button = new JPanel();
		panel_Button.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_Button.setBackground(new Color(128, 128, 255));
		panel_Button.setBounds(336, 142, 691, 74);
		panel_ThongTinChiTiet.add(panel_Button);
		panel_Button.setLayout(null);

		JButton button_ThemSinhVien = new JButton("Thêm");
		button_ThemSinhVien.setIcon(new ImageIcon(
				"D:\\eclipse-workspace\\DoAnQuanLiSinhVien\\src\\Image\\Hopstarter-Sleek-Xp-Basic-Add.24.png"));
		button_ThemSinhVien.setFont(new Font("Segoe UI", Font.BOLD, 20));
		button_ThemSinhVien.setForeground(new Color(255, 0, 0));
		button_ThemSinhVien.setBounds(20, 14, 132, 50);
		button_ThemSinhVien.addActionListener(actionListener);
		panel_Button.add(button_ThemSinhVien);

		JButton button_XoaSinhVien = new JButton("Xóa");
		button_XoaSinhVien.setIcon(new ImageIcon(
				"D:\\eclipse-workspace\\DoAnQuanLiSinhVien\\src\\Image\\Hopstarter-Sleek-Xp-Basic-Close.24.png"));
		button_XoaSinhVien.setFont(new Font("Segoe UI", Font.BOLD, 20));
		button_XoaSinhVien.setForeground(new Color(255, 0, 0));
		button_XoaSinhVien.setBounds(192, 14, 132, 50);
		button_XoaSinhVien.addActionListener(actionListener);
		panel_Button.add(button_XoaSinhVien);

		JButton button_SuaSinhVien = new JButton("Sửa");
		button_SuaSinhVien.setIcon(new ImageIcon(
				"D:\\eclipse-workspace\\DoAnQuanLiSinhVien\\src\\Image\\Hopstarter-Sleek-Xp-Basic-Document-Write.24.png"));
		button_SuaSinhVien.setFont(new Font("Segoe UI", Font.BOLD, 20));
		button_SuaSinhVien.setForeground(new Color(255, 0, 0));
		button_SuaSinhVien.setBounds(363, 14, 132, 50);
		button_SuaSinhVien.addActionListener(actionListener);
		panel_Button.add(button_SuaSinhVien);

		JButton button_XemThongTin = new JButton("Xem");
		button_XemThongTin.setIcon(new ImageIcon(
				"D:\\eclipse-workspace\\DoAnQuanLiSinhVien\\src\\Image\\Fatcow-Farm-Fresh-Application-view-detail.32.png"));
		button_XemThongTin.setFont(new Font("Segoe UI", Font.BOLD, 20));
		button_XemThongTin.setForeground(new Color(255, 0, 0));
		button_XemThongTin.setBounds(535, 14, 132, 50);
		button_XemThongTin.addActionListener(actionListener);
		panel_Button.add(button_XemThongTin);

		JLabel label_ThongTinChiTiet = new JLabel("DANH SÁCH SINH VIÊN");
		label_ThongTinChiTiet.setBounds(326, 10, 411, 46);
		panel_DanhSachSinhVien.add(label_ThongTinChiTiet);
		label_ThongTinChiTiet.setForeground(new Color(255, 255, 255));
		label_ThongTinChiTiet.setHorizontalAlignment(SwingConstants.CENTER);
		label_ThongTinChiTiet.setFont(new Font("Segoe UI", Font.BOLD, 34));

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 1042, 46);
		panel_DanhSachSinhVien.add(panel);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(0, 0, 255));

		JLabel label_Banner = new JLabel();
		label_Banner.setIcon(new ImageIcon("D:\\eclipse-workspace\\DoAnQuanLiSinhVien\\src\\Image\\banner.png"));
		label_Banner.setBounds(10, 10, 1061, 106);
		contentPane.add(label_Banner);

		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	protected void capNhatComboBox_ChuyenNganh(String tenKhoaDuocChon) {
		// TODO Auto-generated method stub
		comboBox_ChuyenNganh.removeAllItems();
		if (tenKhoaDuocChon != null) {
			for (Khoa khoa : Khoa.values()) {
				if (khoa.getNganhDaoTao().equals(tenKhoaDuocChon)) {
					List<String> danhSachChuyenNganh = khoa.getChuyenNganh();
					for (String chuyenNganh : danhSachChuyenNganh) {
						comboBox_ChuyenNganh.addItem(chuyenNganh);
					}
					comboBox_ChuyenNganh.setSelectedIndex(-1);
					break;
				}
			}
		}
	}

	public void clearThongTinChiTiet() {
		// TODO Auto-generated method stub
		textField_MaSinhVien.setText(null);
		textField_HoTenSinhVien.setText(null);
		textField_NgaySinh.setText("yyyy-MM-dd");
		comboBox_Tinh.setSelectedIndex(-1);
		buttonGroup_GioiTinh.clearSelection();
		textField_NamNhapHoc.setText(null);
		comboBox_BacDaoTao.setSelectedIndex(-1);
		comboBox_LoaiHinhDaoTao.setSelectedIndex(-1);
		comboBox_Khoa.setSelectedIndex(-1);
		comboBox_ChuyenNganh.setSelectedIndex(-1);
		comboBox_TinhTrang.setSelectedIndex(-1);
	}

	public SinhVien getSinhVienTuField() {
		String maSinhVien = this.textField_MaSinhVien.getText();
		String hoTenSinhVien = this.textField_HoTenSinhVien.getText();
		LocalDate ngaySinh = LocalDate.parse(this.textField_NgaySinh.getText());
		boolean gioiTinh = true;
		if (radionButton_Nam.isSelected()) {
			gioiTinh = true;
		} else if (radionButton_Nu.isSelected()) {
			gioiTinh = false;
		}
		Tinh queQuan = Tinh.values()[this.comboBox_Tinh.getSelectedIndex()];
		int namNhapHoc = Integer.parseInt(this.textField_NamNhapHoc.getText());
		BacDaoTao bacDaoTao = BacDaoTao.values()[this.comboBox_BacDaoTao.getSelectedIndex()];
		LoaiHinhDaoTao loaiHinhDaoTao = LoaiHinhDaoTao.values()[this.comboBox_LoaiHinhDaoTao.getSelectedIndex()];
		Khoa khoa = Khoa.values()[this.comboBox_Khoa.getSelectedIndex()];
		String chuyenNganh = this.comboBox_ChuyenNganh.getSelectedItem() + "";
		TinhTrang tinhTrang = TinhTrang.values()[this.comboBox_TinhTrang.getSelectedIndex()];
		SinhVien sinhVien = new SinhVien(maSinhVien, hoTenSinhVien, ngaySinh, gioiTinh, queQuan, namNhapHoc, bacDaoTao,
				loaiHinhDaoTao, khoa, chuyenNganh, tinhTrang);
		return sinhVien;
	}

	public void themSinhVienVaoTable(SinhVien sinhVien) {
		DefaultTableModel model_table = (DefaultTableModel) this.table.getModel();
		model_table
				.addRow(new Object[] { sinhVien.getMaSinhVien(), sinhVien.getHoTenSinhVien(), sinhVien.getNamNhapHoc(),
						sinhVien.getKhoa().getNganhDaoTao(), sinhVien.getTinhTrang().getTenTinhTrang() });
	}

	public void themSinhVien() {
		// TODO Auto-generated method stub
		SinhVien sinhVien = this.getSinhVienTuField();
		if (this.quanLiSinhVienModel.kiemTraTonTai(sinhVien)) {
			JOptionPane.showMessageDialog(this, "Thêm sinh viên thất bại! (Mã sinh viên bị trùng)", "Thông báo",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		this.quanLiSinhVienModel.themSinhVien(sinhVien);
		this.themSinhVienVaoTable(sinhVien);
		JOptionPane.showMessageDialog(this, "Thêm sinh viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	}

	public SinhVien getSinhVienDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		String maSinhVien = model_table.getValueAt(i_row, 0) + "";
		SinhVien sinhVien = new SinhVien();
		for (SinhVien sv : this.quanLiSinhVienModel.getDanhSachSinhVien()) {
			if (sv.getMaSinhVien().equals(maSinhVien)) {
				sinhVien = sv;
			}
		}
		return sinhVien;
	}

	public void hienThiSinhVienDaChon() {
		SinhVien sinhVien = getSinhVienDangChon();

		this.textField_MaSinhVien.setText(sinhVien.getMaSinhVien());
		this.textField_HoTenSinhVien.setText(sinhVien.getHoTenSinhVien());
		LocalDate ngaySinh = sinhVien.getNgaySinh();
		this.textField_NgaySinh
				.setText(ngaySinh.getYear() + "-" + ngaySinh.getMonthValue() + "-" + ngaySinh.getDayOfMonth());
		this.comboBox_Tinh.setSelectedItem(sinhVien.getQueQuan().getTenTinh());
		if (sinhVien.isGioiTinh()) {
			radionButton_Nam.setSelected(true);
		} else {
			radionButton_Nu.setSelected(true);
		}
		this.textField_NamNhapHoc.setText(sinhVien.getNamNhapHoc() + "");
		this.comboBox_BacDaoTao.setSelectedItem(sinhVien.getBacDaoTao().getTenBacDaoTao());
		this.comboBox_LoaiHinhDaoTao.setSelectedItem(sinhVien.getLoaiHinhDaoTao().getTenLoaiHinh());
		this.comboBox_Khoa.setSelectedItem(sinhVien.getKhoa().getNganhDaoTao());
		this.capNhatComboBox_ChuyenNganh(sinhVien.getKhoa().getNganhDaoTao());
		this.comboBox_ChuyenNganh.setSelectedItem(sinhVien.getChuyenNganh());
		this.comboBox_TinhTrang.setSelectedItem(sinhVien.getTinhTrang().getTenTinhTrang());
	}

	public void chinhSuaSinhVien() {
		// TODO Auto-generated method stub
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		SinhVien sinhVien = getSinhVienTuField();
		if (!this.quanLiSinhVienModel.kiemTraTonTai(getSinhVienTuField())) {
			JOptionPane.showMessageDialog(this, "Chỉnh sửa sinh viên thất bại! (Sinh viên không tồn tại)", "Thông báo",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		this.quanLiSinhVienModel.chinhSuaSinhVien(sinhVien);
		int soLuongDong = model_table.getRowCount();
		for (int i = 0; i < soLuongDong; i++) {
			String id = model_table.getValueAt(i, 0) + "";
			if (id.equals(sinhVien.getMaSinhVien())) {
				model_table.setValueAt(sinhVien.getMaSinhVien(), i, 0);
				model_table.setValueAt(sinhVien.getHoTenSinhVien(), i, 1);
				model_table.setValueAt(sinhVien.getNamNhapHoc() + "", i, 2);
				model_table.setValueAt(sinhVien.getKhoa().getNganhDaoTao(), i, 3);
				model_table.setValueAt(sinhVien.getTinhTrang().getTenTinhTrang(), i, 4);
			}
		}
		JOptionPane.showMessageDialog(this,
				"Chỉnh sửa sinh viên thành công! (Mã sinh viên: " + sinhVien.getMaSinhVien() + ")", "Thông báo",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void xoaSinhVien() {
		// TODO Auto-generated method stub
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa sinh viên đã chọn?", "Xác nhận xóa",
				JOptionPane.OK_CANCEL_OPTION);
		if (luaChon == JOptionPane.OK_OPTION) {
			SinhVien sinhVien = this.getSinhVienDangChon();
			this.quanLiSinhVienModel.xoaSinhVien(sinhVien);
			;
			model_table.removeRow(i_row);
		}
	}

	public void timSinhVien() {
		// TODO Auto-generated method stub
		this.taiLaiDuLieuTrongTable();

		Khoa khoaCanTim = null;
		if (this.comboBox_TimKhoa.getSelectedIndex() >= 0) {
			khoaCanTim = Khoa.values()[this.comboBox_TimKhoa.getSelectedIndex()];
		}
		String maSinhVienCanTim = this.textField_MaSinhVienCanTim.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();

		Set<String> maSinhVienCanAn = new TreeSet<String>();
		if (khoaCanTim != null) {
			for (int i = 0; i < soLuongDong; i++) {
				String tenKhoaCanTim = model_table.getValueAt(i, 3) + "";
				String maSinhVien = model_table.getValueAt(i, 0) + "";
				if (!tenKhoaCanTim.equals(khoaCanTim.getNganhDaoTao())) {
					maSinhVienCanAn.add(maSinhVien);
				}
			}
		}
		if (maSinhVienCanTim.length() > 0) {
			for (int i = 0; i < soLuongDong; i++) {
				String maSinhVien = model_table.getValueAt(i, 0) + "";
				if (!maSinhVien.equals(maSinhVienCanTim)) {
					maSinhVienCanAn.add(maSinhVien);
				}
			}
		}
		for (String maSinhVien : maSinhVienCanAn) {
			soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String maSinhVienTrongTable = model_table.getValueAt(i, 0) + "";
				if (maSinhVienTrongTable.equals(maSinhVien)) {
					model_table.removeRow(i);
					break;
				}
			}
		}
	}

	public void taiLaiDuLieuTrongTable() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if (soLuongDong == 0) {
				break;
			} else {
				model_table.removeRow(0);
			}
		}
		for (SinhVien sinhVien : this.quanLiSinhVienModel.getDanhSachSinhVien()) {
			this.themSinhVienVaoTable(sinhVien);
		}
	}

	public void save(String path) throws IOException {
		this.quanLiSinhVienModel.setTenFile(path);
		try (FileOutputStream fos = new FileOutputStream(path)) {
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this.quanLiSinhVienModel.getDanhSachSinhVien());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new IOException("Error saving file: " + e.getMessage());
		}
	}

	public void luuFile() {
		// TODO Auto-generated method stub
		if (this.quanLiSinhVienModel.getTenFile() != null && !this.quanLiSinhVienModel.getTenFile().isEmpty()) {
			try {
				save(this.quanLiSinhVienModel.getTenFile());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			JFileChooser fc = new JFileChooser();
			fc.setSelectedFile(new File("sinhvien.dat")); // default
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				String filePath = file.getAbsolutePath();
				if (!filePath.toLowerCase().endsWith(".dat")) {
					filePath = filePath + ".dat";
				}
				try {
					save(filePath);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Lưu File đã bị hủy.");
			}
		}
	}

	public void open(File file) {
		ArrayList<SinhVien> danhSachSinhVien = new ArrayList<SinhVien>();
		this.quanLiSinhVienModel.setTenFile(file.getAbsolutePath());
		try (FileInputStream fis = new FileInputStream(file);) {
			ObjectInputStream ois = new ObjectInputStream(fis);
			danhSachSinhVien = (ArrayList<SinhVien>) ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.quanLiSinhVienModel.setDanhSachSinhVien(danhSachSinhVien);
	}

	public void moFile() {
		// TODO Auto-generated method stub
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			open(file);
			taiLaiDuLieuTrongTable();
		} else {
			System.out.println("Mở file đã bị hủy.");
		}
	}

	public void thoatChuongTrinh() {
		// TODO Auto-generated method stub
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn muốn thoát khỏi chương trình?", "Exit",
				JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void hienThiAboutMe() {
		// TODO Auto-generated method stub
		JOptionPane
				.showMessageDialog(
						this, "Project Director: Đặng Xuân Nam - 22200106\n"
								+ "Designer: Nguyễn Minh Phước - 22200128\n" + "Tester: Trần Thế Pháp - 22200120",
						"About me", JOptionPane.INFORMATION_MESSAGE);
	}

	public void clearTim() {
		// TODO Auto-generated method stub
		this.textField_MaSinhVienCanTim.setText("");
		this.comboBox_TimKhoa.setSelectedIndex(-1);
	}

	public void uploadDatabase() {
		if (this.quanLiSinhVienModel.getDanhSachSinhVien() != null) {
			ArrayList<SinhVien> danhSachSinhVien = this.quanLiSinhVienModel.getDanhSachSinhVien();
			for (SinhVien sinhVien : danhSachSinhVien) {
				if (SinhVienDAO.getInstance().exist(sinhVien)) {
					SinhVienDAO.getInstance().update(sinhVien);
				} else {
					SinhVienDAO.getInstance().insert(sinhVien);
				}
			}
			JOptionPane.showMessageDialog(this, "Đã cập nhật lên cơ sở dữ liệu!",
					"Thông báo", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void downloadDatabase() {
		// TODO Auto-generated method stub
		this.quanLiSinhVienModel.setDanhSachSinhVien(SinhVienDAO.getInstance().selectAll());
		this.taiLaiDuLieuTrongTable();
		int rowsAffected = this.quanLiSinhVienModel.getDanhSachSinhVien().size();
		JOptionPane.showMessageDialog(this, "Đã tải xuống từ cơ sở dữ liệu " + rowsAffected + " sinh viên!",
				"Thông báo", JOptionPane.INFORMATION_MESSAGE);
	}
}