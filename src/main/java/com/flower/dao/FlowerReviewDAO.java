package com.flower.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.flower.unit.DBManager;
import com.flower.vo.FlowerReviewVO;

public class FlowerReviewDAO {
	private static FlowerReviewDAO instance = new FlowerReviewDAO();
	
	public static FlowerReviewDAO getInstance() {
		return instance;
	}
	
	public ArrayList<FlowerReviewVO> selectReview(String code) {
		ArrayList<FlowerReviewVO> list = new ArrayList<>();

		String sql = "select * from flower_review where code=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				FlowerReviewVO rvo = new FlowerReviewVO();
				
				rvo.setNum(rs.getInt("num"));
				rvo.setScore(rs.getInt("score"));
				rvo.setId(rs.getString("id"));
				rvo.setCode(rs.getString("code"));
				rvo.setContents(rs.getString("contents"));
				rvo.setImage(rs.getString("image"));
				rvo.setWritedate(rs.getDate("writedate"));
				
				list.add(rvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}
	
	// 리뷰 등록 메소드
		public void insertReview(FlowerReviewVO rvo) {
			String sql = "insert into flower_review(num, score, id, code, contents, image) values(null, ?,?,?,?,?)";
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, rvo.getScore());
				pstmt.setString(2, rvo.getId());
				pstmt.setString(3, rvo.getCode());
				pstmt.setString(4, rvo.getContents());
				pstmt.setString(5, rvo.getImage());
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}

	}
