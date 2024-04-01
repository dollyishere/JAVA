package com.dolly.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dolly.common.MySQLConnector;

public class MemberDAO {
	private Connection connector = null;
	private MySQLConnector datasource = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public MemberDAO() {
		datasource = new MySQLConnector();
	}
	
	/** 회원 목록(정보) 조회 **/
	public List<MemberVO> listMembers() {
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		System.out.println("여기서 오류");
		try {
			connector = datasource.getConnection();
			String query = "select * from t_member order by joindate desc";
			
			pstmt = connector.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			MemberVO member = null;
			while(rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setPwd(rs.getString("pwd"));
				member.setEmail(rs.getString("email"));
				member.setName(rs.getString("name"));
				member.setJoindate(rs.getDate("joindate"));
				System.out.println(member.getEmail());
				memberList.add(member);
			}
			
		} catch (SQLException e) {
			System.err.println("listMembers() ERR: " + e.getMessage());
		}  finally {
			datasource.close(rs, pstmt, connector);
		}
		return memberList;
	}
	
	/** 회원 가입 처리 **/
	public void addMember(MemberVO member) {
		try {
			connector = datasource.getConnection();
			
			String query = "insert into t_member values (?, ?, ?, ?, now())";
			
			pstmt = connector.prepareStatement(query);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			
			pstmt.executeUpdate();
			
			
		} catch(SQLException e) {
			System.err.println("addMember(): " + e.getMessage());
		} finally {
			datasource.close(pstmt, connector);
		}
	}
	
	/** 한 사람의 정보 처리 (수정링크 클릭 시: 목록에서) **/
	public MemberVO findMember(String _id) {
		MemberVO member = new MemberVO();
		try {
			connector = datasource.getConnection();
			String query = "select * from t_member where id=?";
			pstmt = connector.prepareStatement(query);
			pstmt.setString(1, _id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member.setId(rs.getString("id"));
				member.setPwd(rs.getString("pwd"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setJoindate(rs.getDate("joindate"));
				System.out.println(member.getEmail());
			}
		} catch (SQLException e) {
			System.err.println("findMember() ERR : " + e.getMessage());
		} finally {
			datasource.close(rs, pstmt, connector);
		}
		return member;
	}
	
	/** 회원정보 수정 처리 **/
	public void modeMember(MemberVO member) {
		try {
			connector = datasource.getConnection();
			String query = "update t_member set name=?, email=?, pwd=? where id=?";
			
			pstmt = connector.prepareStatement(query);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getPwd());
			pstmt.setString(4, member.getId());
			
			System.out.println(pstmt);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("modMember() ERR : " + e.getMessage());
		} finally {
			datasource.close(pstmt, connector);
		}
	}
	
	/** 회원정보 삭제 처리 **/
	public void delMember(String _id) {
		try {
			connector = datasource.getConnection();
			String query = "delete from t_member where id=?";
			pstmt = connector.prepareStatement(query);
			pstmt.setString(1, _id);
			System.out.println(pstmt);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("delMember() ERR : " + e.getMessage());
		} finally {
			datasource.close(pstmt, connector);
		}
	}
	
	/** 아이디 중복 처리 **/
	public boolean overlappedID(String _id) {
		boolean result = false;
		
		try {
			connector = datasource.getConnection();
			String query = "select id from t_member where id=?";
			pstmt = connector.prepareStatement(query);
			pstmt.setString(1, _id);
			
			rs = pstmt.executeQuery();
			result = rs.next();
		} catch (Exception e) {
			System.err.println("overlappedID() ERR : " + e.getMessage());
		} finally {
			datasource.close(rs, pstmt, connector);
		}
		return result;
	}
}	
