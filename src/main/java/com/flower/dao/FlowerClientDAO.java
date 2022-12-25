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

	// 전체 회원 불러오기
	public List<FlowerClientVO> SelectAllFlowerClient() {
		String sql = "select * from flower_client order by id desc";
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
				fcvo.setZip_code(rs.getInt("zip_code"));
				fcvo.setAddress(rs.getString("address"));
				fcvo.setDetailed_address(rs.getString("detailed_address"));
				fcvo.setRefer(rs.getString("refer"));
				//fcvo.setLev(rs.getString("lev"));
				list.add(fcvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 전화번호 중복확인
	public ArrayList<String> selectPhone() {
		ArrayList<String> list = new ArrayList<>();

		String sql = "select phone from flower_client";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				list.add("'" + rs.getString("phone") + "'");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}

	// 이메일 중복확인
	public ArrayList<String> selectEmail() {
		ArrayList<String> list = new ArrayList<>();

		String sql = "select email from flower_client";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				list.add("'" + rs.getString("email") + "'");

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
		String sql = "insert into flower_Client(id, pass, name, phone, email, zip_code, address, detailed_address, refer) values(?,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, fvo.getLev());
			pstmt.setString(1, fvo.getId());
			pstmt.setString(2, fvo.getPass());
			pstmt.setString(3, fvo.getName());
			pstmt.setString(4, fvo.getPhone());
			pstmt.setString(5, fvo.getEmail());
			pstmt.setInt(6, fvo.getZip_code());
			pstmt.setString(7, fvo.getAddress());
			pstmt.setString(8, fvo.getDetailed_address());
			pstmt.setString(9, fvo.getRefer());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 로그인 체크 메소드
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
				} else { // 비밀번호가 다르다면
					result = 2;
				}
			} else { // 아이디가 불일치
				result = 0;
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

	// 아이디로 개인정보 소환
	public FlowerClientVO getFlowerClient(String id) {
		FlowerClientVO fvo = null;
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
				fvo = new FlowerClientVO();
				fvo.setId(rs.getString("id"));
				fvo.setPass(rs.getString("pass"));
				fvo.setName(rs.getString("name"));
				fvo.setLev(rs.getString("lev"));
				fvo.setPhone(rs.getString("phone"));
				fvo.setEmail(rs.getString("email"));
				fvo.setZip_code(rs.getInt("zip_code"));
				fvo.setAddress(rs.getString("address"));
				fvo.setDetailed_address(rs.getString("detailed_address"));
				fvo.setRefer(rs.getString("refer"));
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

		return fvo;
	}

	// 아이디로 비밀번호 찾기
	public FlowerClientVO FlowerClientPassCk(String id) {
		FlowerClientVO member = null;
		Connection conn = null;
		String sql = "select pass from flower_client where id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new FlowerClientVO();
				member.setPass(rs.getString("pass"));
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
	public int confrmID(String id) {
		int result = 0;
		String sql = "select id from flower_client where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = 1; // 아이디가 존재할 때
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

	// 회원 정보 수정 메소드
	public void updateFlowerClient(FlowerClientVO fvo) {
		String sql = "update flower_client set pass=?, name=?, phone=?, email=?, zip_code=?, address=?, detailed_address=?, refer=? where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, fvo.getLev());
			pstmt.setString(1, fvo.getPass());
			pstmt.setString(2, fvo.getName());
			pstmt.setString(3, fvo.getPhone());
			pstmt.setString(4, fvo.getEmail());
			pstmt.setInt(5, fvo.getZip_code());
			pstmt.setString(6, fvo.getAddress());
			pstmt.setString(7, fvo.getDetailed_address());
			pstmt.setString(8, fvo.getRefer());
			pstmt.setString(9, fvo.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 회원 탈퇴 메소드
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

	// 성함, 전화번호 일치하면 아이디 내놓기
	public FlowerClientVO FindId(String name, String phone) {
		FlowerClientVO fvo = null;
		Connection conn = null;
		String sql = "select id from flower_client where name=? and phone=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				fvo = new FlowerClientVO();
				fvo.setId(rs.getString("id"));
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

		return fvo;
	}

	// 성함, 전화번호 일치하면 아이디 내놓기
	public FlowerClientVO FindPass(String id, String email) {
		FlowerClientVO fvo = null;
		Connection conn = null;
		String sql = "select pass from flower_client where id=? and email=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				fvo = new FlowerClientVO();
				fvo.setPass(rs.getString("pass"));
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

		return fvo;
	}

}
