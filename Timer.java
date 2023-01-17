package com.timer;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.util.Calendar;

/**
 * Servlet implementation class Timer
 */
@WebServlet("/Timer")
public class Timer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Timer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		String store = request.getParameter("option");
		
		SimpleDateFormat date = new SimpleDateFormat();
		date.setTimeZone(TimeZone.getTimeZone(store));
		date.applyPattern("DD MM YYYY hh:mm:ss z");
		String time = date.format(Calendar.getInstance().getTime());
		
		RequestDispatcher rd = request.getRequestDispatcher("/index.html");
		rd.include(request, response);
		pw.println(("<div>"+"<h1>TIME</h1>"+"<h1>"+ time +"</h1>"+"</div>"));
		
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
