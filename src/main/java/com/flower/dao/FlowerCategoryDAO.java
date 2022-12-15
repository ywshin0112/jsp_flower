package com.flower.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.flower.unit.DBManager;
import com.flower.vo.FlowerCategoryVO;

public class FlowerCategoryDAO {
	private FlowerCategoryDAO() {
	}

	private static FlowerCategoryDAO instance = new FlowerCategoryDAO();

	public static FlowerCategoryDAO getInstance() {
		return instance;
	}

	// 전체 카테고리 불러오기

	public ArrayList<FlowerCategoryVO> selectAllCategory(String option) {

		ArrayList<FlowerCategoryVO> list = new ArrayList<>();

		String sql = "select * from flower_category " + option + "order by selected";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				FlowerCategoryVO cvo = new FlowerCategoryVO();
				cvo.setCategory(rs.getString("category"));
				cvo.setImage(rs.getString("image"));
				cvo.setSelected(rs.getString("selected"));

				list.add(cvo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}

	public FlowerCategoryVO selectedCategory(String beforeName) {

		FlowerCategoryVO cvo = new FlowerCategoryVO();

		String sql = "select * from flower_category where category = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, beforeName);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				cvo.setCategory(rs.getString("category"));
				cvo.setImage(rs.getString("image"));
				cvo.setSelected(rs.getString("selected"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return cvo;
	}

	// 카테고리 추가

	public void insertCategory(FlowerCategoryVO fvo) {

		String sql = "insert into flower_category values (?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fvo.getCategory());
			pstmt.setString(2, fvo.getImage());
			pstmt.setString(3, "8");
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	// 카테고리 수정
	public void updateImageAndCategory(FlowerCategoryVO cvo, String beforeName) {

		String sql = "update flower_category set category=?, image=? where category=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cvo.getCategory());
			pstmt.setString(2, cvo.getImage());
			pstmt.setString(3, beforeName);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void updateCategoryOnly(FlowerCategoryVO cvo, String beforeName) {

		String sql = "update flower_category set category=? where category=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cvo.getCategory());
			pstmt.setString(2, beforeName);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void deleteCategory(String category) {

		String sql = "delete from flower_category where category=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 메인 카테고리 초기화
	public void resetMainCategory() {

		String sql = "update flower_category set selected=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "0");
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	// 선택항목만 selected로 변경
	public void updateMainCategory(String image, String order) {

		String sql = "update flower_category set selected=? where image=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, order);
			pstmt.setString(2, image);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// 메인 선택한 항목 불러오기
	public ArrayList<FlowerCategoryVO> selectMainCategory() {

		ArrayList<FlowerCategoryVO> list = new ArrayList<>();

		String sql = "select * from flower_category where selected!=? order by selected";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "8");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				FlowerCategoryVO cvo = new FlowerCategoryVO();
				cvo.setCategory(rs.getString("category"));
				cvo.setImage(rs.getString("image"));
				cvo.setSelected(rs.getString("selected"));

				list.add(cvo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}
}
