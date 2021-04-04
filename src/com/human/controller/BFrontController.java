package com.human.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.command.BCommand;
import com.human.command.BContentViewCommand;
import com.human.command.BDelete;
import com.human.command.BListCommand;
import com.human.command.BWriteCommand;
import com.human.command.BwriteViewCommand;
import com.human.dao.BDao;
import com.human.dto.BDto;

/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String viewPage = "list.do";
		BCommand command = null;
		
		//사용자가 요청한 .do 파일 URI 가져오기
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		System.out.println(uri);
		System.out.println(conPath);
		System.out.println(com);//.do 페이지정보
		
		if(com.equals("/list.do")) {
			viewPage = "list.jsp";
			command = new BListCommand();
			command.execute(request, response);
		}else if(com.equals("/write_view.do")) {
			viewPage ="write_view.jsp";
			command = new BwriteViewCommand();
			command.execute(request, response);
		}else if(com.equals("/write.do")) {
			viewPage = "list.do";
			command = new BWriteCommand();
			command.execute(request, response);
		}else if(com.equals("/content_view.do")) {
			viewPage = "content_view.jsp";
			command = new BContentViewCommand();
			command.execute(request, response);
		}else if(com.equals("/delete.do")) {
			viewPage = "list.do";
			command = new BDelete();
			command.execute(request, response);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
