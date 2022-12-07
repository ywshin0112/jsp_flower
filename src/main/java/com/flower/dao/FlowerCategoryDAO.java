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

	public ArrayList<FlowerCategoryVO> selectAllCategory(String str) {

		ArrayList<FlowerCategoryVO> list = new ArrayList<>();

		String sql = "select * from flower_category " + str;

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
				System.out.println(rs.getString("category"));
				cvo.setImage(rs.getString("image"));

				list.add(cvo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}
	
	// 카테고리 추가

	public void insertCategory(FlowerCategoryVO fvo) {

		String sql = "insert into flower_category values (?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fvo.getCategory());
			pstmt.setString(2, fvo.getImage());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

		
	}
	
	
	
	// 카테고리 수정
	public void updateCategory(FlowerCategoryVO fvo, String beforeName) {
		String sql = "update flower_category set category=?, image=? where category=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fvo.getCategory());
			pstmt.setString(2, fvo.getImage());
			pstmt.setString(3, beforeName);
			pstmt.executeUpdate();
			System.out.println("성공");

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
	

}
