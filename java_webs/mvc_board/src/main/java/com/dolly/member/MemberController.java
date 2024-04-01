package com.dolly.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/*")
public class MemberController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    MemberDAO memberDAO = null;
    MemberVO member = null;

    public void init(ServletConfig config) throws ServletException {
       System.out.println("1");
       memberDAO = new MemberDAO();
    }
    
   protected void doGet(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
      doHandle(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
      doHandle(request, response);
   }
   

   protected void doHandle(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
      String nextPage = null; // 다른 화면으로 이동, 다른 화면 요청..
      
      request.setCharacterEncoding("utf-8");
      response.setContentType("test/html; charset=utf-8");
      
      String action = request.getPathInfo(); // 용청 주소 추출
      
      System.out.println("action : " + action );// 요청 주소 확인
      
      if(action == null | action.equals("/listMembers.do")) { // 회원 목록 처리
    	 memberDAO = new MemberDAO();
         List<MemberVO> membersList = memberDAO.listMembers();
         request.setAttribute("membersList", membersList);     
         nextPage = "/members/listMembers.jsp";
         
      } else if(action.equals("/idcheck.do")) {   // 아이디 중복
			PrintWriter out = response.getWriter();
			
			String id = (String) request.getParameter("id");
			memberDAO = new MemberDAO(); 
			boolean result = memberDAO.overlappedID(id);
			
			if (result == true) { // result가 true면 기존 id
				out.write("not_usable");
			} else {
				out.write("usable");
			}
			return;
       } else if(action.equals("/addMember.do")) {   // 실제 회원가입 처리
    	 member = new MemberVO();

    	 member.setId(request.getParameter("id"));
    	 member.setPwd(request.getParameter("pwd"));
    	 member.setName(request.getParameter("name"));
    	 member.setEmail(request.getParameter("email"));
    	 memberDAO = new MemberDAO();
    	 memberDAO.addMember(member);
    	 
         nextPage = "/member/listMembers.do";
         
      } else if(action.equals("/memberForm.do")) {   // 회원가입 화면 처리
    	
         nextPage = "/members/memberForm.jsp";
         
      } else if(action.equals("/modMemberForm.do")) { // 회원 수정 화면 처리
    	 String id = (String) request.getParameter("id");
    	 System.out.println(id);
     	 memberDAO = new MemberDAO();
     	 member = memberDAO.findMember(id);
     	 System.out.println(member.getEmail());
     	 request.setAttribute("member", member);
    	  
    	  nextPage = "/members/modMemberForm.jsp";
    	  
      }  else if(action.equals("/modMember.do")) {   // 회원수정 처리
     	 member = new MemberVO();
     	 
     	 member.setId(request.getParameter("id"));
     	 member.setPwd(request.getParameter("pwd"));
     	 member.setName(request.getParameter("name"));
     	 member.setEmail(request.getParameter("email"));

     	 memberDAO = new MemberDAO();
     	 memberDAO.modeMember(member);
     	 
         nextPage = "/member/listMembers.do";
         
      } else if(action.equals("/delMember.do")) {   // 회원삭제 처리
    	  String id = (String) request.getParameter("id");
    	  System.out.println(id);
    	  memberDAO = new MemberDAO();
    	  memberDAO.delMember(id);
         nextPage = "/member/listMembers.do";
         
      }else {
         nextPage = "/member/listMembers.do";
      }
      
      RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
      dispatcher.forward(request, response);
   }
   
}
