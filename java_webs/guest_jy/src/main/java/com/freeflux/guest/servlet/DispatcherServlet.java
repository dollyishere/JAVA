package com.freeflux.guest.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freeflux.dto.GuestClass;
import com.freeflux.guest.controller.DeleteController;
import com.freeflux.guest.controller.DetailController;
import com.freeflux.guest.controller.InsertController;
import com.freeflux.guest.controller.ListController;
import com.freeflux.guest.controller.UpdateController;
import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

// url 패턴 명을 지정해주는 annotation => webServlet
@WebServlet("/guest")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		RequestDispatcher rd = null;
		String cmd = null;
		String status = ""; // 글 목록에서 제목 클릭 or 글 상세에서 수정화면 이동 클릭
		GuestClass guest = new GuestClass();
		String idx = "";
		
		if (request.getParameter("command") != null) {
			cmd = request.getParameter("command");
			switch (cmd) {
			case "L": // 글목록
				ListController list = new ListController();
				ArrayList<GuestClass> guestList = new ArrayList<GuestClass>();
				guestList = list.list();
				if (guestList.size() >= 1) {
					System.out.println(guestList.get(0).getName());
				}
				
				request.setAttribute("guestList", guestList);
				rd = request.getRequestDispatcher("list.jsp");
				// request.setAttribute(" ", )
				rd.forward(request, response);
				break;

			case "W": // 글쓰기
				guest.setName(request.getParameter("name"));
				guest.setTitle(request.getParameter("title"));
				guest.setContent(request.getParameter("content"));
				
				InsertController insert = new InsertController();
				insert.insert(guest);
				
				// 글 목록 다시 받아와야 list.jsp 갈 수 있으니 일단 main.jsp로 이동
				rd = request.getRequestDispatcher("main.jsp");
				rd.forward(request, response);
				
				break;

			case ("D"): // 글상세
				status = request.getParameter("status");
				idx = request.getParameter("idx");
				DetailController detail = new DetailController();
				guest = detail.detail(Integer.parseInt(idx));
				request.setAttribute("guest", guest);
				
				if(status.equals("detail")) {
					UpdateController update = new UpdateController();
					update.update(guest.getHit(), guest.getIdx());
					rd = request.getRequestDispatcher("detail.jsp");
				} else {
					rd = request.getRequestDispatcher("modify.jsp");
				}
				
				rd.forward(request, response);
				break;

			case "U": // 글수정
				UpdateController update = new UpdateController();
				
				guest.setName(request.getParameter("name"));
				guest.setTitle(request.getParameter("title"));
				guest.setContent(request.getParameter("content"));
				guest.setIdx(Integer.parseInt(request.getParameter("idx")));
				
				update.update(guest);
				
				rd = request.getRequestDispatcher("main.jsp");
				rd.forward(request, response);

				break;

			case "DEL": // 글삭제
				DeleteController delete = new DeleteController();
				idx = request.getParameter("idx");
				delete.delete(Integer.parseInt(idx));
				
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
