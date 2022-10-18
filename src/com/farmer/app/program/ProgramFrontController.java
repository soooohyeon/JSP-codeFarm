package com.farmer.app.program;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.farmer.app.Result;

public class ProgramFrontController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
	    String contextPath = req.getContextPath();
	    String target = requestURI.substring(contextPath.length());
	    Result result = null;
	    
	      if(target.equals("/program/apply01.pg")) {//프로그램 신청상세페이지 1로 이동
	    	  result = new Result();
	    	  result.setPath("/app/program/programDetailPage_1.jsp");
	          
	       }
	      else if(target.equals("/program/applyListOk.pg")) {//프로그램 목록페이지 들어갔을 때, DB에서 프로그램 전체목록 가져오기(SELECT)
	          result = new ApplyListOkController().execute(req, resp);
	       }
	      else if(target.equals("/program/viewCountOk.pg")) {//프로그램 목록페이지 조회순 정렬
	    	  
	      }
	      else if(target.equals("/program/registerOk.pg")) {//프로그램 가장최근등록일순 정렬
		   		
	       }
	      else if(target.equals("/program/deadlineOk.pg")) {//프로그램목록 최근 마감일로 정렬
		   		
	       }
	      else if(target.equals("/program/apply02.pg")) {//프로그램 신청상세페이지2로 이동
	   		
	       }
	      else if(target.equals("/program/applyCancel.pg")) {//프로그램 신청상세페이지2에서 취소 , 프로그램목록페이지로 이동
	    	  
	      }
	      else if(target.equals("/program/programWrite.pg")) { //프로그램 등록페이지로 이동
	    	  result = new Result();
	          result.setPath("/app/program/programRegister.jsp");
	      }
	      else if(target.equals("/program/programWriteOk.pg")) { //프로그램 등록하기(INSERT)
	    	  
	      }

	
	    if(result != null) {
	         if(result.isRedirect()) {
	            resp.sendRedirect(result.getPath());
	         }else {
	            RequestDispatcher dispatcher = req.getRequestDispatcher(result.getPath());
	            dispatcher.forward(req, resp);
	         }
	    }
	}
}