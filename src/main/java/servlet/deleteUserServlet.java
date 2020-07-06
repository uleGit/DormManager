package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;

/**
 * Servlet implementation class deleteUserServlet
 */
@WebServlet("/deleteUserServlet")
public class deleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteUserServlet() {
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
		
		UserDao ud = new UserDao();
		String s = request.getParameter("deleteNo");
		for(int i=0; i<s.length();i++) {
			char num[] = s.toCharArray();
			if(!Character.isDigit(num[i])) {
				response.sendRedirect("../deleteUser.jsp?error=s");
				return;
			}
		}
		
		if(s!=null&&s.length()>0) {
			Integer i = 0;
			try {
				i = ud.queryUser(Integer.parseInt(s));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==Integer.parseInt(s)) {
				response.sendRedirect("../deleteUser.jsp?error=no");
			} else {
				response.sendRedirect("../deleteUser.jsp?error=yes");
			}
		} else {
			response.sendRedirect("../deleteUser.jsp?error=yesnull");
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
