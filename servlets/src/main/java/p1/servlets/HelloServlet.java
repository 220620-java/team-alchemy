package p1.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// our servlets should extend HttpServlet
public class HelloServlet extends HttpServlet {
	// the servlet container (tomcat catalina) will call this method when
	// a GET request comes in to the right path and it will create the objects
	// for the request and response and pass those in
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// gets the response body writer object so that we can write to the response
		// body
		
		StringBuilder uriString = new StringBuilder(req.getRequestURI()); // /p1/hello/id
		uriString.replace(0, req.getContextPath().length()+1, "");
		
		//if slash
		if(uriString.indexOf("/") != 1){
			uriString.replace(0, uriString.indexOf("/"), "");
			
			PrintWriter writer = resp.getWriter();
			writer.write("Path: " + uriString.toString());
		} else {
			
			PrintWriter writer = resp.getWriter();
			writer.write("Hi");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String lang = req.getParameter("lang");
		String chosenLang = "";
		PrintWriter writer = resp.getWriter();
		
		if(lang.equals("en")) {
			chosenLang = "Hello, ";
		}else if(lang.equals("fr")) {
			chosenLang = "Bonjour, ";
		}
			
	

		BufferedReader reader = req.getReader();
		String reqBody = "";
		String line = "";
		while ((line = reader.readLine()) != null) {
			reqBody += line;
		}

		writer.write(chosenLang + reqBody + "! :)");
	}

}
