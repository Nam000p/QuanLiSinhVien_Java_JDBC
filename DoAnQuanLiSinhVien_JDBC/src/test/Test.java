package test;

import javax.swing.UIManager;

import view.QuanLiSinhVienView;

public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new QuanLiSinhVienView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}