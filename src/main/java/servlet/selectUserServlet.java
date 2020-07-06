package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import entity.User;

/**
 * Servlet implementation class selectUserServlet
 */
@WebServlet("/selectUserServlet")
public class selectUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public selectUserServlet() {
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

		String s1 = request.getParameter("selectType");

		UserDao ud = new UserDao();
		ArrayList<User> users = new ArrayList<User>();
		if (s1!=null&&s1.length()>0&&s1.equals("0")) {
			String s2 = request.getParameter("usernum");
			if (s2 != null && s2.length() > 0) {
				for(int i=0; i<s2.length();i++) {
					char num[] = s2.toCharArray();
					if(!Character.isDigit(num[i])) {
						response.sendRedirect("../selectUser.jsp?error=no");
						return;
					}
				}
						try {
							int j = ud.queryUser(Integer.parseInt(s2));
							if (j == Integer.parseInt(s2)) {
								users = ud.queruser1(j);
								session.setAttribute("selectType", s1);
								session.setAttribute("users", users);
								response.sendRedirect("../user.jsp");
							} else {
								response.sendRedirect("../selectUser.jsp?error=no");
							}
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			} else {
				response.sendRedirect("../selectUser.jsp?error=usernumnull");
			}
		} else if (s1!=null&&s1.length()>0&&s1.equals("1")) {
			String s3 = request.getParameter("selectIdentity");
			if (s3 != null && s3.length() > 0) {
				try {
					users = ud.queruser2(s3);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				session.setAttribute("selectType", s1);
				session.setAttribute("users", users);
				response.sendRedirect("../user.jsp");
			}
		}else {
			response.sendRedirect("../selectUser.jsp?error=usernumnull");
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
