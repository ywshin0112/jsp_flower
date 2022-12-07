package com.flower.dao;

import java.sql.*;
import javax.sql.*;

import com.flower.unit.DBManager;
import com.flower.vo.FlowerClientVO;

import java.util.*;

public class FlowerClientDAO {
	private FlowerClientDAO() {
	}

	private static FlowerClientDAO instance = new FlowerClientDAO();

	public static FlowerClientDAO getInstance() {
		return instance;
	}

	public List<FlowerClientVO> SelectAllFlowerClient() {
		String sql = "select * from flower_client order by enter desc";
		ArrayList<FlowerClientVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				FlowerClientVO fcvo = new FlowerClientVO();
				fcvo.setId(rs.getString("id"));
				fcvo.setPass(rs.getString("pass"));
				fcvo.setName(rs.getString("name"));
				fcvo.setPhone(rs.getString("phone"));
				fcvo.setEmail(rs.getString("email"));
				fcvo.setAddress(rs.getString("address"));
				fcvo.setLev(rs.getString("lev"));
				list.add(fcvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 회원등록 메소드
	public void insertflowerClient(FlowerClientVO fvo) {
		String sql = "insert into flower_Client(lev, id, pass, name, phone, email, address) values(?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fvo.getLev());
			pstmt.setString(2, fvo.getId());
			pstmt.setString(3, fvo.getPass());
			pstmt.setString(4, fvo.getName());
			pstmt.setString(5, fvo.getPhone());
			pstmt.setString(6, fvo.getEmail());
			pstmt.setString(7, fvo.getAddress());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public int userCheck(String id, String pass) {
		int result = 0;
		Connection conn = null;
		String sql = "select * from flower_client where id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) { // 아이디는 존재함
				if (pass.equals(rs.getString("pass"))) { // 비밀번호도 일치하고
						result = 1; // 로그인 성공
				}else { // 비밀번호가 다르다면
					result = 2;
				}
			} else { // 아이디가 불일치
				result = 3;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
	}

	public FlowerClientVO getFlowerClient(String id) {
		FlowerClientVO member = null;
		Connection conn = null;
		String sql = "select * from flower_client where id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new FlowerClientVO();
				member.setId(rs.getString("id"));
				member.setPass(rs.getString("pass"));
				member.setName(rs.getString("name"));
				member.setLev(rs.getString("lev"));
				member.setPhone(rs.getString("phone"));
				member.setEmail(rs.getString("email"));
				member.setAddress(rs.getString("address"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}

		}

		return member;
	}
	
	// 아이디 중복 체크 메소드
	public int confrmID(String userid) {
		int result = 0;
		String sql = "select id from flower_client where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = 1; // 아이디가 존재할
			} else {
				result = -1; // 아이디가 존재하지 않을 때
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close(); // close 하는 이유 : 커넥션 풀 연동, 포트가 열림, 내가 작업이 끝나야 다른 사람이 들어오고 빠져 나갈 수 있음
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
	}
	// 수정
		public void updateFlowerClient(FlowerClientVO fvo) {
			String sql = "update flower_client set lev=?, id=?, pass=?, name=?, phone=?, email=?, address=? where id=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, fvo.getLev());
				pstmt.setString(2, fvo.getId());
				pstmt.setString(3, fvo.getPass());
				pstmt.setString(4, fvo.getName());
				pstmt.setString(5, fvo.getPhone());
				pstmt.setString(6, fvo.getEmail());
				pstmt.setString(7, fvo.getAddress());
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
		
		public void deleteFlowerClient(String id) {
			String sql = "delete from flower_client where id=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	
}
