package servlets.board;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.board.BoardDAO;
import model.board.BoardModel;

/**
 * 게시판 삭제 서블릿 클래스
 */
@WebServlet("/board/boardDeleteServlet")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/** BOARD DAO */
	private BoardDAO boardDAO = null;
	
    public BoardDeleteServlet() {
        super();
    }
    
    /**
     * get 접근 시 (상세 조회 접근 시)
     * **/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터
		int n=Integer.parseInt(request.getParameter("num"));
		
		// 모델
		BoardModel boardModel = new BoardModel();
		boardModel.setNum(n);
		
		// 게시물 삭제
		boardDAO = new BoardDAO();
		boardDAO.delete(boardModel);
		
		// 페이지 이동
		response.sendRedirect("boardListServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
