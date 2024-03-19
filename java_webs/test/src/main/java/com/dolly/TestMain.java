package com.dolly;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestMain
 */
// 사용자가 웹 브라우저를 통해 얘에게 어떤 요청을 하기 위해 필요한 이름을 써두는 부분(어노테이션)
// 이렇게 요청을 전달해줄 때는 all 소문자가 많음
// 웹 요청할 때는 모든 대소문자가 다 구분되니 주의
// 요청한 내용과 servlet 내용이 mapping 되어 있어야 함
// 웹 서블릿 이름은 클래스 만들기 전에 수정하던가, 만들고 수정하던가 뭐 맘대로
@WebServlet("/TestMain")
public class TestMain extends HttpServlet {
	// 이 부분은 개발자가 수정&삭제 불가
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestMain() {
    	// super?
    	// 부모의 생성자를 호출하므로서 객체를 일단 초기화시켜주는 부분
    	// 자바 웹은 대부분 super()가 들어감
    	// 이 위에는 어떤 코드도 오면 암됨
    	// 그냥 무조건 맨 처음 호출되도록 해야 함
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // servlet 생성 과정에서 체크박스 클릭해서 만들어진 메서드 선언부 전부 수정 불가
    // 부모 메서드 재정의한 거기 때문에 ㄴㄴ....
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Serverd at: 서버에 대한 요청 사항을 내보내겠다는 의미의 메서드
		// 얘를 무지하게 많이 만나게 될 거임
		// 특히 서블렛에 관계된 내용은 다 외워야 함
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
