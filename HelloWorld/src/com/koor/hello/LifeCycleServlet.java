package com.koor.hello;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */
@WebServlet( urlPatterns="/lifecycle", loadOnStartup=1)
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String databaseURL;
	private int counter;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    /*public LifeCycleServlet() {
        super();
    	System.out.println( "Servlet created " );
    }*/

    
    @Override
    public void init() throws ServletException {
    	super.init();
    	databaseURL = this.getServletContext().getInitParameter( "DATABASE_URL" );
    	System.out.println( "In init " + databaseURL );
    	counter = 0;
    }
    
    /*@Override
    protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
    	super.service(arg0, arg1);
    }*/
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader( "Demo", "A Value" );
		response.getWriter().append("Served at: ").append(request.getContextPath());
		counter++;
		System.out.println( "In doGet " + counter );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void destroy() {
    	System.out.println( "In destroy" );
		super.destroy();
	}
}
