package net.study.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Parser")
public class Parser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Parser() {
        super();
     }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> params = request.getParameterMap();
		Iterator<String> i = params.keySet().iterator();
		
		while ( i.hasNext() )
		{
			String key = (String) i.next();
			String[] values = params.get(key);
			String allValues = "";
			
			for(String value : values){
				allValues += " " + value;
			}
			
			out(response.getWriter(), key + ": " + allValues);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	private void out(PrintWriter printWriter, String str){
			printWriter.println(str + "<br/>");
	}
}
