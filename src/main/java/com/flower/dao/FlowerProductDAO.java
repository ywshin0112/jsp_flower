package com.flower.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.flower.unit.DBManager;
import com.flower.vo.FlowerProductVO;

public class FlowerProductDAO {
	private FlowerProductDAO() {
	}

	private static FlowerProductDAO instance = new FlowerProductDAO();

	public static FlowerProductDAO getInstance() {
		return instance;
	}

	public ArrayList<FlowerProductVO> selectAllCategory() {

		ArrayList<FlowerProductVO> list = new ArrayList<>();

		String sql = "select * from flower_product order by category";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				FlowerProductVO pvo = new FlowerProductVO();
				pvo.setCategory(rs.getString("category"));
				pvo.setCode(rs.getString("code"));
				pvo.setInformation(rs.getString("information"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice(rs.getInt("price"));
				pvo.setText1(rs.getString("text1"));
				pvo.setText2(rs.getString("text2"));

				list.add(pvo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}

	// 상품 등록

	public void insertProduct(FlowerProductVO pvo) {

		String sql = "insert into flower_product values(?,?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pvo.getCode());
			pstmt.setString(2, pvo.getName());
			pstmt.setInt(3, pvo.getPrice());
			pstmt.setString(4, pvo.getCategory());
			pstmt.setString(5, pvo.getInformation());
			pstmt.setString(6, pvo.getText1());
			pstmt.setString(7, pvo.getText2());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 상품 삭제
	public void deleteProduct(String code) {

		String sql = "delete from flower_product where code=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 단일상품 불러오기(수정용)
	public FlowerProductVO selectProduct(String code) {
		FlowerProductVO pvo = new FlowerProductVO();
		String sql = "select * from flower_product where code=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				pvo.setCategory(rs.getString("category"));
				pvo.setCode(rs.getString("code"));
				pvo.setInformation(rs.getString("information"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice(rs.getInt("price"));
				pvo.setText1(rs.getString("text1"));
				pvo.setText2(rs.getString("text2"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return pvo;
	}
	
	// 상품코드 중복확인
	public ArrayList<String> selectProductCode(String code) {
		ArrayList<String> list = new ArrayList<>();
		
		String sql = "select code from flower_product where code not in (?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				list.add("'"+rs.getString("code")+"'");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}
	
	
	
	
	// 상품 수정
	public void updateProduct(FlowerProductVO pvo, String constCode) {

		String sql = "update flower_product set code=?, name=?, price=?, category=?, information=?, text1=?, text2=? where code=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pvo.getCode());
			pstmt.setString(2, pvo.getName());
			pstmt.setInt(3, pvo.getPrice());
			pstmt.setString(4, pvo.getCategory());
			pstmt.setString(5, pvo.getInformation());
			pstmt.setString(6, pvo.getText1());
			pstmt.setString(7, pvo.getText2());
			pstmt.setString(8, constCode);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	
}
