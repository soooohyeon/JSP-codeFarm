package com.farmer.app.index;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.farmer.app.Result;

public class IndexFrontController extends HttpServlet {
	
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
	    
	      if(target.equals("/index/main.ix")) { //경로 적기 
	    	  result = new IndexOkController().execute(req, resp);
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
