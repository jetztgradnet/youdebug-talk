package net.jetztgrad.buggyweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("name");
		PrintWriter out = response.getWriter();
		try {
			out.println("<html><head><title>Hello</title></head><body>");
			out.println("<h1>Hello, " + (name != null ? name : "stranger") + "</h1>");
			if (age != null && age.length() > 0) {
				out.println("<p>In " + (100 - Integer.parseInt(age)) + " years you'll be 100!</p>");
			}
			out.println("<p><form>");
			out.println("Name: <input type='text' name='name' value='" + (name != null ? name : "") + "'></input><br>");
			out.println("Age: <input type='text' name='age' value='" + (age != null ? age : "") + "'></input><br>");
			out.println("<input type='submit' name='Send'></input><br>");
			out.println("</form></p>");
			out.println("</body></html>");
		}
		catch (Exception e) {
			out.println("<h3>An error occured:</h3>");
			out.println("<p><pre>");
			out.println(e.getClass().getSimpleName() + " " + e.getMessage());
//			e.printStackTrace(out);
			out.println("</pre></p>");
		}
		finally {
			try {
				out.close();
			}
			catch (Throwable t) {
				t.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
