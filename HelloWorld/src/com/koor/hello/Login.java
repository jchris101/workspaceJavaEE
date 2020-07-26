package com.koor.hello;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter( "txtLogin" );
		String password = request.getParameter( "txtPassword" );
		if ( login == null ) login = "";
		if ( password == null ) password = "";
		
		HttpSession session = request.getSession( true );
		session.setAttribute( "login", login );
		session.setAttribute( "password", password );
		
		request.getRequestDispatcher( "/Login.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter( "txtLogin" );
		String password = request.getParameter( "txtPassword" );

		HttpSession session = request.getSession( true );
		session.setAttribute( "login", login );
		session.setAttribute( "password", password );

		System.out.println( "in the doPost" );
		
		if ( login.equals( "bond" ) && password.equals( "007" ) ) {
			session.setAttribute( "isConnected", true );
			request.getRequestDispatcher( "/Connected.jsp" ).forward( request, response );
		} else {
			session.setAttribute( "isConnected", false );
			request.getRequestDispatcher( "/Login.jsp" ).forward( request, response );
		}
	}

}
