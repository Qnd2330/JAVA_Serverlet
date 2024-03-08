package quachngocduc.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import quachngocduc.beans.QuachNgocDuc_2110900011_Product;

public class quachngocduc_ProductUtils {
	public static List<QuachNgocDuc_2110900011_Product> queryProduct(Connection conn) throws SQLException {
		String sql = "Select a.MaSP_2110900011, a.TenSP_2110900011, a.SoLuong_2110900011,a.DonGia_2110900011,a.Anh_2110900011   from QuachNgocDuc_Product a";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<QuachNgocDuc_2110900011_Product> list = new ArrayList<QuachNgocDuc_2110900011_Product>();
		while (rs.next()) {
			int MaSP_2110900011 = rs.getInt("MaSP_2110900011");
			String TenSP_2110900011 = rs.getString("TenSP_2110900011");
			int SoLuong_2110900011 = rs.getInt("SoLuong_2110900011");
			float DonGia_2110900011 = rs.getFloat("DonGia_2110900011");
			String Anh_2110900011 = rs.getString("Anh_2110900011");
			QuachNgocDuc_2110900011_Product product = new QuachNgocDuc_2110900011_Product();
			product.setMaSP_2110900011(MaSP_2110900011);
			product.setTenSP_2110900011(TenSP_2110900011);
			product.setSoLuong_2110900011(SoLuong_2110900011);
			product.setDonGia_2110900011(DonGia_2110900011);
			product.setAnh_2110900011(Anh_2110900011);
			list.add(product);
		}
		return list;
	}

	public static QuachNgocDuc_2110900011_Product findProduct(Connection conn, int code) throws SQLException {
		String sql = "Select a.MaSP_2110900011, a.TenSP_2110900011, a.SoLuong_2110900011,a.DonGia_2110900011,a.Anh_2110900011 from QuachNgocDuc_Product a where a.MaSP_2110900011 =?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, code);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			String TenSP_2110900011 = rs.getString("TenSP_2110900011");
			int SoLuong_2110900011 = rs.getInt("SoLuong_2110900011");
			float DonGia_2110900011= rs.getFloat("DonGia_2110900011");
			String Anh_2110900011= rs.getString("TenSP_2110900011");
			QuachNgocDuc_2110900011_Product product = new QuachNgocDuc_2110900011_Product(TenSP_2110900011,SoLuong_2110900011,DonGia_2110900011,Anh_2110900011);
			return product;
		}
		return null;
	}

	public static void insertProduct(Connection conn, QuachNgocDuc_2110900011_Product product) throws SQLException {
		String sql = "Insert into QuachNgocDuc_Product(MaSP_2110900011,TenSP_2110900011,SoLuong_2110900011,DonGia_2110900011,Anh_2110900011) values (?,?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, product.getMaSP_2110900011());
		pstm.setString(2, product.getTenSP_2110900011());
		pstm.setInt(3, product.getSoLuong_2110900011());
		pstm.setFloat(4, product.getDonGia_2110900011());
		pstm.setString(5, product.getAnh_2110900011());
		pstm.executeUpdate();

	}

	public static void UpdateProduct(Connection conn, QuachNgocDuc_2110900011_Product product) throws SQLException {
		String sql = "Update QuachNgocDuc_Product set TenSP_2110900011 = ?, SoLuong_2110900011= ?, DonGia_2110900011=?,Anh_2110900011=?  where MaSP_2110900011 =?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, product.getTenSP_2110900011());
		pstm.setInt(2, product.getSoLuong_2110900011());
		pstm.setFloat(3, product.getDonGia_2110900011());
		pstm.setString(4, product.getAnh_2110900011());
		pstm.setInt(5, product.getMaSP_2110900011());
		pstm.executeUpdate();

	}

	public static void deleteProduct(Connection conn, int code) throws SQLException {
		String sql = "Delete From QuachNgocDuc_Product where MaSP_2110900011 =?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, code);
		pstm.executeUpdate();

	}
}
