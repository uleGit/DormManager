package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import entity.User;

/**
 * Servlet implementation class updateUserServlet
 */
@WebServlet("/updateUserServlet")
public class updateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();

		User u = (User)session.getAttribute("updUser");
		
		String userNum = request.getParameter("userNum");
		for(int i=0; i<userNum.length();i++) {
			char num[] = userNum.toCharArray();
			if(!Character.isDigit(num[i])) {
				response.sendRedirect("../userDetail.jsp?error=userNum");
				return;
			}
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String identity = request.getParameter("identity");
		
		if(userNum.length()>0&&username.length()>0&&password.length()>0&&identity.length()>0) {
		u.setUserNum(Integer.parseInt(userNum));
		u.setUsername(username);
		u.setPassword(password);
		u.setIdentity(identity);
		
		UserDao ud = new UserDao();
		try {
			ud.updUser(u);
			session.setAttribute("updUser", u);
			response.sendRedirect("../userDetail.jsp?error=no");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else {
			response.sendRedirect("../userDetail.jsp?error=allnull");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
