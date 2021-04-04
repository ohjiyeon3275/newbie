package com.human.ex;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class wServlet
 */
@WebServlet("/wServlet")
public class wServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public wServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  response.setContentType("text/xml;charset=UTF-8");
	  PrintWriter out = response.getWriter();
	  
	  HttpURLConnection conn=null;
	  String str="http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108";
	  
	  //사이트연결 객체 생성
	  URL url=new URL(str);
	  //사이트 연결해서 결과값리턴
	  conn=(HttpURLConnection)url.openConnection();
	  
	  BufferedInputStream is = new BufferedInputStream(conn.getInputStream());
	  byte[] b =new byte[4096];//2 4 8 16 1024 2048 4096
	  StringBuffer buffer=new StringBuffer();
	   int i;
	   while( (i = is.read(b)) != -1){ 
	        buffer.append(new String(b, 0, i)); 
	   }
	      String str2 = buffer.toString();
	      out.println(str2);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
