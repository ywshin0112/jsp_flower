package com.flower.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.flower.unit.DBManager;
import com.flower.vo.FlowerInquiryVO;

public class FlowerInquiryDAO {
	private FlowerInquiryDAO() {
	}

	private static FlowerInquiryDAO instance = new FlowerInquiryDAO();

	public static FlowerInquiryDAO getInstance() {
		return instance;
	}

	// 전체 게시글 불러오기

	public ArrayList<FlowerInquiryVO> selectAllInquiry(String code) {
		String sql = "select * from flower_inquiry where code=?";
		ArrayList<FlowerInquiryVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				FlowerInquiryVO ivo = new FlowerInquiryVO();
				ivo.setCode(rs.getString("code"));
				ivo.setNum(rs.getInt("num"));
				ivo.setCount(rs.getInt("count"));
				ivo.setSecret(rs.getString("secret"));
				ivo.setTitle(rs.getString("title"));
				ivo.setId(rs.getString("id"));
				ivo.setContents(rs.getString("contents"));
				ivo.setWritedate(rs.getDate("writedate"));

				list.add(ivo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}
	
	// 문의 등록 메소드
			public void insertInquiry(FlowerInquiryVO ivo) {
				String sql = "insert into flower_inquiry(num, id, code, title, contents, secret) values(null, ?, ?, ?, ?, ?)";
				Connection conn = null;
				PreparedStatement pstmt = null;
				try {
					conn = DBManager.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, ivo.getId());
					pstmt.setString(2, ivo.getCode());
					pstmt.setString(3, ivo.getTitle());
					pstmt.setString(4, ivo.getContents());
					pstmt.setString(5, ivo.getSecret());
					pstmt.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					DBManager.close(conn, pstmt);
				}
			}
}
