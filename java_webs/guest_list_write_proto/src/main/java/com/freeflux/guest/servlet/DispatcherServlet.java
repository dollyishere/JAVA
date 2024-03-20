package com.freeflux.guest.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freeflux.guest.controller.DeleteController;
import com.freeflux.guest.controller.DetailController;
import com.freeflux.guest.controller.InsertController;
import com.freeflux.guest.controller.ListController;
import com.freeflux.guest.controller.UpdateController;
import com.freeflux.guest.dto.Guest;

@WebServlet("/guest")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = null;
		String cmd = null;
		String status = "";  // 글목록에서 제목 클릭, 글상세에서 수정화면이동 클릭 
		
		if (request.getParameter("command") != null) {
			
			cmd = request.getParameter("command");
			
			switch (cmd) {
			case "L": // 글목록
				ListController list = new ListController();
				List<Guest> glist = list.list();
				
				rd = request.getRequestDispatcher("list.jsp");
//				request.setAttribute("glist", glist);
				rd.forward(request, response);
				
				break;

			case "W": // 글쓰기

				InsertController insert = new InsertController();

				rd = request.getRequestDispatcher("main.jsp");
				rd.forward(request, response);
				
				break;

			case "D": // 글상세
				status = request.getParameter("status");
				
				DetailController detail = new DetailController();
				detail.detail();
				
				if(status.equals("detail")) {
					rd = request.getRequestDispatcher("detail.jsp");
				}else {
					rd = request.getRequestDispatcher("modify.jsp");
				}
				rd.forward(request, response);
				
				break;

			case "U": // 글수정
				UpdateController update = new UpdateController();
				update.update();
				
				rd = request.getRequestDispatcher("main.jsp");
				rd.forward(request, response);

				break;

			case "DEL": // 글삭제
				DeleteController delete = new DeleteController();
				delete.delete();
				
				rd = request.getRequestDispatcher("main.jsp");
				rd.forward(request, response);
				
				break;
			} // switch (cmd) END
		} // if () END
	} // doGet() END

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
