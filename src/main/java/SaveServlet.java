

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String country=request.getParameter("country");
		
		Emp e=new Emp();
		e.setName(name);
		e.setPassword(password);
		e.setEmail(email);
		e.setCountry(country);
		
		int status=EmpDao.save(e);
		if(status>0) {
			out.print("<!DOCTYPE HTML>");
			out.print("<html>");
			out.print("<head>");
			out.print("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
			out.print("</head>");
			out.print("<body>");
			out.print("<div class='alert alert-success'>");
			out.print("<p>Record saved successfully</p>");
			out.print("</div>");
			request.getRequestDispatcher("index.html").include(request, response);
		}
	
	else {
		out.print("<div class='alert alert-danger'>");
		out.print("Sorry, Unable to save record");
		out.print("</div");
		out.print("</body");
		out.print("</html>");
	}
	}

}
