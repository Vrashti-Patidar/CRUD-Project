

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		List<Emp> list=EmpDao.getAllEmployee();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Employee List</title>");
		out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
		out.println("</head>");
		out.println("<body class='bg-light'>");

		out.println("<div class='container mt-5'>");
		out.println("<div class='d-flex justify-content-between align-items-center mb-4'>");
		out.println("<h2 class='text-primary'>Employee List</h2>");
		out.println("<a href='index.html' class='btn btn-success'>Add New Employee</a>");
		out.println("</div>");

		if (list.isEmpty()) {
			out.println("<div class='alert alert-warning'>No employee records found.</div>");
		} else {
			out.println("<div class='table-responsive'>");
			out.println("<table class='table table-bordered table-striped'>");
			out.println("<thead class='table-dark'>");
			out.println("<tr><th>ID</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
			out.println("</thead>");
			out.println("<tbody>");

			for (Emp e : list) {
				out.println("<tr>");
				out.println("<td>" + e.getId() + "</td>");
				out.println("<td>" + e.getName() + "</td>");
				out.println("<td>" + e.getPassword() + "</td>");
				out.println("<td>" + e.getEmail() + "</td>");
				out.println("<td>" + e.getCountry() + "</td>");
				out.println("<td><a href='EditServlet?id=" + e.getId() + "' class='btn btn-warning btn-sm'>Edit</a></td>");
				out.println("<td><a href='DeleteServlet?id=" + e.getId() + "' class='btn btn-danger btn-sm'>Delete</a></td>");
				out.println("</tr>");
			}

			out.println("</tbody>");
			out.println("</table>");
			out.println("</div>");
		}

		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}

}
