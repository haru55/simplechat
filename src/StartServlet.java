package project.simplechat;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/project/simplechat/start")
public class StartServlet extends ActionServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();		
		
		String name = request.getParameter("name");
		
		ServletContext context = this.getServletContext();		
		Chat chat = (Chat)context.getAttribute("chat");
		User user = chat.getUserByName(name);
		if(user == null) {
			user = new User();
			user.setName(name);
			chat.addUser(user);
		}
		session.setAttribute("user", user);
		
		response.sendRedirect("main.html");
	}

}
