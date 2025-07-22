

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		Emp e=EmpDao.getEmployeeById(id);
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Update Employee</title>");
		out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
		out.println("</head>");
		out.println("<body class='bg-light'>");

		out.println("<div class='container mt-5'>");
		out.println("<div class='card shadow p-4'>");
		out.println("<h2 class='mb-4 text-primary'>Update Employee</h2>");

		out.print("<form action='EditServlet2' method='get'>");

		out.print("<input type='hidden' name='id' value='" + e.getId() + "'/>");

		out.print("<div class='mb-3'>");
		out.print("<label class='form-label'>Name:</label>");
		out.print("<input type='text' class='form-control' name='name' value='" + e.getName() + "'/>");
		out.print("</div>");

		out.print("<div class='mb-3'>");
		out.print("<label class='form-label'>Password:</label>");
		out.print("<input type='password' class='form-control' name='password' value='" + e.getPassword() + "'/>");
		out.print("</div>");

		out.print("<div class='mb-3'>");
		out.print("<label class='form-label'>Email:</label>");
		out.print("<input type='email' class='form-control' name='email' value='" + e.getEmail() + "'/>");
		out.print("</div>");

		out.print("<div class='mb-4'>");
		out.print("<label class='form-label'>Country:</label>");
		out.print("<select class='form-select w-auto' name='country'>");

		String[] countries = {"India", "USA", "UK", "Other"};
		for (String country : countries) {
			if (country.equalsIgnoreCase(e.getCountry())) {
				out.print("<option selected value='" + country + "'>" + country + "</option>");
			} else {
				out.print("<option value='" + country + "'>" + country + "</option>");
			}
		}

		out.print("</select>");
		out.print("</div>");

		out.print("<button type='submit' class='btn btn-success'>Edit &amp; Save</button>");

		out.print("</form>");
		out.println("</div>"); // card
		out.println("</div>"); // container

		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
