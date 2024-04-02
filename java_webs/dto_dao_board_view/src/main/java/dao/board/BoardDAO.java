package dao.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.board.BoardModel;

public class BoardDAO {
	// 사용할 객체 초기화
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// 데이터베이스 접속 설정 정보
	/** JDBC DRIVER 패키지 정보 **/
	private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	/** 데이터베이스 URL **/
	private final String DB_URL ="jdbc:mysql://127.0.0.1:3306/test";
	/** 데이터베이스 아이디 **/
	private final String DB_ID = "root";
	/** 데이터베이스 암호 **/
	private final String DB_PWD = "1234";
			
	public BoardDAO() {
		
	} // BoardDAO() END
	
	/**
	 * 게시판 목록 조회
	 * @param boardModel
	 * @return
	 */
	public List<BoardModel> selectList(BoardModel boardModel) {
		int pageNum = Integer.parseInt(boardModel.getPageNum()); // "1" => 1
		int listCount = boardModel.getListCount(); // 한 페이지 게시물 갯수
		String searchType = boardModel.getSearchType(); // 검색 종류
		String searchText = boardModel.getSearchText(); // 검색어
		// 처음 호출되었을 때, selectCount()에 의해 "" 값으로 초기화...
		
		String whereSQL = ""; // 조건 부분 쿼리만 저장
		List<BoardModel> boardList = null; // 결과 값들ㅇ르 각각 BoardModel 객체로
		// 저장한 후, 한 번에 반환시키기 위한 ArrayList<BoardModel>을 저장
		// ArrayList는 List 인터페이스를 구현받았기 때문에 List<BoardModel> 타입도 가능
		
		try {
			if (!"".equals(searchType)) {
				if ("ALL".equals(searchType)) {
					whereSQL = "WHERE SUBJECT LICK CONCAT('%', ?, '%') OR WRITER LIKE CONCAT('%', ?, '%') OR CONTENTS LIKE CONCAT('%', ?, '%')";
				} else if ("SUBJECT".equals(searchType)) {
					whereSQL = "WHERE SUBJECT LIKE CONCAT('%', ?, '%')";
				} else if ("WRITER".equals(searchType)) {
					whereSQL = "WHERE WRITER LIKE CONCAT('%', ?, '%') OR CONTENTS LIKE CONCAT('%', ?, '%')";
				} else if ("CONTENTS".equals(searchType)) {
					whereSQL = "WHERE CONTENTS LIKE CONCAT('%', ?, '%')";
				}
			}
			// 데이터베이스 객체 생성
			Class.forName(this.JDBC_DRIVER);
			this.conn = DriverManager.getConnection(this.DB_URL, this.DB_ID, this.DB_PWD);
			
			// 게시물 목록 조회 (목록 화면에 필요한 필드만)
			String end="ORDER BY NUM DESC LIMIT ?, ?";
			String first="SELECT NUM, SUBJECT, WRITER, REG_DATE, HIT FROM board_table";
			String query=first + whereSQL + end;
			this.pstmt = this.conn.prepareStatement(query);
			
			if (!"".equals(whereSQL)) { // 검색 쿼리가 있을 경우에만
				if ("ALL".equals(searchType)) { // 전체 겁색일 경우 ? 다섯개
					this.pstmt.setString(1, searchText);
					this.pstmt.setString(2, searchText);
					this.pstmt.setString(3, searchText);
					this.pstmt.setInt(4, listCount * (pageNum-1)); //  페이지의 시작 번호
					this.pstmt.setInt(5, listCount); // 조회 갯수
				} else { // 그 외 검색일 경우 ? 세 개
					this.pstmt.setString(1, searchText);
					this.pstmt.setInt(2, listCount * (pageNum-1)); //  페이지의 시작 번호
					this.pstmt.setInt(3, listCount); // 조회 갯수
				}
			} else { // 검색 쿼리(검색어)가 없을 경우
				this.pstmt.setInt(1, listCount * (pageNum-1)); //  페이지의 시작 번호
				this.pstmt.setInt(2, listCount); // 조회 갯수
			} // if (!"".equals(whereSQL)) { ~~ } else { ~~ } END 
			
			// 조회 실행
			this.rs = this.pstmt.executeQuery();
			
			// LIST 객체에 저장하기 위한 객체 생성
			boardList = new ArrayList<BoardModel>();
			
			while(this.rs.next()) {
				boardModel = new BoardModel();
				boardModel.setNum(this.rs.getInt("NUM"));
				boardModel.setSubject(this.rs.getString("SUBJECT"));
				boardModel.setWriter(this.rs.getString("WRITER"));
				boardModel.setHit(this.rs.getInt("HIT"));
				boardModel.setRegDate(this.rs.getString("REG_DATE"));
				
				boardList.add(boardModel); // ArrayList에 추가
			} // while() END
		} catch (Exception e) { // SQLException
			e.printStackTrace(); // System.out.println(e.getMessage())
		} finally {
			// 사용한 객체 종료
			close(this.rs, this.pstmt, this.conn);
		}
		return boardList;
	}
	
	/**
	 * 게시글 총 갯수 조회
	 * @param boardModel
	 * @return
	 */
	public int selectCount(BoardModel boardModel) {
		return 0;
	}
	
	/**
	 * 게시판 상세 조회
	 * @param boardModel
	 * @return
	 */
	public BoardModel selectOne(BoardModel boardModel) {
		return null;
	}
	
	/**
	 * 게시판 등록 처리
	 * @param boardModel
	 * **/
	public void insert(BoardModel boardModel) {
		
	}
	
	/**
	 * 게시판 수정 처리
	 * @param boardModel
	 * **/
	public void update(BoardModel boardModel) {
		
	}
	
	/**
	 * 게시판 조회수 증가 수정 처리
	 * @param boardModel
	 * **/
	public void updateHit(BoardModel boardModel) {
		
	}
	
	/**
	 * 게시판 삭제 처리
	 * @param boardModel
	 * **/
	public void delete(BoardModel boardModel) {
		
	}
	
	/**
	 * 사용한 객체를 닫음
	 * @param rs
	 * @param pstmt
	 * @param conn
	 * **/
	public void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		
	}
}
