package com.flower.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.flower.unit.DBManager;
import com.flower.vo.FlowerProductVO;

public class FlowerProductDAO {
	private FlowerProductDAO() {}

	private static FlowerProductDAO instance = new FlowerProductDAO();

	public static FlowerProductDAO getInstance() {
		return instance;
	}

	public ArrayList<FlowerProductVO> selectAllCategory() {

		ArrayList<FlowerProductVO> list = new ArrayList<>();

		String sql = "select * from flower_category order by category";

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
				pvo.setName(rs.getString("setname"));
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
}
