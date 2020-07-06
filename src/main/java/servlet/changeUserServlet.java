package servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.StringUtils;

import dao.UserDao;
import entity.User;

/**
 * Servlet implementation class changeUserServlet
 */
@WebServlet("/changeUserServlet")
public class changeUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		Integer userNum = Integer.parseInt((session.getAttribute("userNum").toString()));
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		
		
		if(password!=null&&password.length()>0&&password.equals(password2)) {
			User u = new User();
			UserDao ud = new UserDao();
			u.setUserNum(userNum);
			u.setPassword(password);
			
			try {
				ud.updPassword(u);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.sendRedirect("../changePassword.jsp?submit=yes");
		}else {
			
			response.sendRedirect("../changePassword.jsp?submit=no");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
