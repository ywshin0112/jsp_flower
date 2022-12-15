package com.flower.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.flower.unit.DBManager;
import com.flower.vo.FlowerProductImageVO;

public class FlowerProductImageDAO {
	private static FlowerProductImageDAO instance = new FlowerProductImageDAO();

	public static FlowerProductImageDAO getInstance() {
		return instance;
	}
	// 코드번호로 모든 이미지 불러오기

	public ArrayList<FlowerProductImageVO> selectProductImage(String code) {
		ArrayList<FlowerProductImageVO> list = new ArrayList<>();

		String sql = "select * from flower_image where code=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				FlowerProductImageVO ivo = new FlowerProductImageVO();

				ivo.setCode(rs.getString("code"));
				ivo.setImage(rs.getString("image"));
				ivo.setMain(rs.getString("main"));
				ivo.setNum(rs.getInt("num"));

				list.add(ivo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}

	// 상품 이미지 업로드
	public void insertProductImage(String code, String image) {

		String sql = "insert into flower_image values(?,?,null,null)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			pstmt.setString(2, image);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 상품 이미지 메인변경
	public void updateProductMainImage(FlowerProductImageVO ivo) {

		String sql = "update flower_image set main=? where code=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "0");
			pstmt.setString(2, ivo.getCode());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		sql = "update flower_image set main=? where code=? and num=?";

		conn = null;
		pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "1");
			pstmt.setString(2, ivo.getCode());
			pstmt.setInt(3, ivo.getNum());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}

	// 상품 이미지 삭제
	public void deleteProductMainImage(int num) {

		String sql = "delete from flower_image where num=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// 첫번째 상세페이지에서 메인 이미지 가져오기

		public ArrayList<FlowerProductImageVO> selectMainImage(ArrayList<FlowerProductImageVO> list0, String code) {
			ArrayList<FlowerProductImageVO> list = list0;

			String sql = "select * from flower_image where code=? and main=?";

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, code);
				pstmt.setString(2, "1");
				rs = pstmt.executeQuery();
				if (rs.next()) {
					FlowerProductImageVO ivo = new FlowerProductImageVO();

					ivo.setCode(rs.getString("code"));
					ivo.setImage(rs.getString("image"));
					list.add(ivo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}

			return list;
		}
}
