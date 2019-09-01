package ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/plain");
		PrintWriter pw = response.getWriter();

		String emailValidator = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$"; // regex to check validity of email
		Pattern pattern = Pattern.compile(emailValidator);

		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String address = request.getParameter("address");

		Matcher matcher = pattern.matcher(email);

		if (!fullname.isEmpty() && !email.isEmpty() && !address.isEmpty()) {

			if (!matcher.matches()) { // if user enters invalid email id then print below message!
				pw.println("Invalid email id!");

			} else {
				pw.println(fullname + "'s information is successfully saved!"); // if all three information (name, email and address is given then print this!)
			}

		} else {
			pw.println("Name, email and address of person is needed!"); // if user doesn't provide any one of the information then print this.
		}

	}

}
