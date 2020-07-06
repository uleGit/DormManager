 package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;

public class Login extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public Login() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String s1 = request.getParameter("userNum");
		String s2 = request.getParameter("password");
		String s3 = request.getParameter("user");
		
		UserDao ud = new UserDao();
		
		try {
			if(s1!=null&&s1.length()>0) {
				for(int j=0; j<s1.length();j++) {
					char num[] = s1.toCharArray();
					if(!Character.isDigit(num[j])) {
						response.sendRedirect("../login.jsp?error=userNum");
						return;
					}
				}
				int i1 = Integer.parseInt(s1);
				int usernum = ud.queryUser(i1);
				if(usernum==i1) {
					if(s2!=null&&s2.length()>0) {
						String password = ud.queryPassword(usernum);
						if(password.equals(s2)) {
							if(s3!=null&&s3.length()>0) {
								String user = ud.queryIdentity(usernum);
								if (s3.equals(user)&&user.equals("Student")) {
									String username = ud.queryUsername(usernum);
									session.setAttribute("userNum", usernum);
									session.setAttribute("userName", username);
									response.sendRedirect("../indexStudent.jsp");//登录学生成功
								}
								else if (s3.equals(user)&&user.equals("DorMan")) {
									String username = ud.queryUsername(usernum);
									session.setAttribute("userNum", usernum);
									session.setAttribute("userName", username);
									response.sendRedirect("../indexDorMan.jsp");//登录宿管成功
								}
								else if (s3.equals(user)&&user.equals("Instructor")) {
									String username = ud.queryUsername(usernum);
									session.setAttribute("userNum", usernum);
									session.setAttribute("userName", username);
									response.sendRedirect("../indexInstructor.jsp");//登录导员成功
								}
								else if (s3.equals(user)&&user.equals("Manager")) {
									String username = ud.queryUsername(usernum);
									session.setAttribute("userNum", usernum);
									session.setAttribute("userName", username);
									response.sendRedirect("../indexManager.jsp");//登录管理员成功
								}
								else {
									response.sendRedirect("../login.jsp?error=user");//用户身份错误
								}
							}
							else {
								response.sendRedirect("../login.jsp?error=usernull");//未选身份
							}
						}
						else {
							response.sendRedirect("../login.jsp?error=password");//密码错误
						}
					} 
					else {
						response.sendRedirect("../login.jsp?error=passwordnull");//密码为空
					}
				} 
				else {
					response.sendRedirect("../login.jsp?error=userNum");//用户名不正确
				}
			} 
			else {
				response.sendRedirect("../login.jsp?error=userNumnull");//用户名为空
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
