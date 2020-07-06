package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StudentDao;
import dao.UserDao;
import entity.User;

/**
 * Servlet implementation class addUserServlet
 */
@WebServlet("/addUserServlet")
public class addUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addUserServlet() {
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
		
		String userNum = request.getParameter("userNum");
		for(int i=0; i<userNum.length();i++) {
			char num[] = userNum.toCharArray();
			if(!Character.isDigit(num[i])) {
				response.sendRedirect("../addUser.jsp?submit=userNum");
				return;
			}
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String identity = request.getParameter("identity");
		if(userNum.length()>0&&username.length()>0&&password.length()>0&&identity.length()>0) {
			User u = new User();
			u.setUserNum(Integer.parseInt(userNum));
			u.setUsername(username);
			u.setPassword(password);
			u.setIdentity(identity);
			
			try {
				UserDao uD = new UserDao();
				int m = uD.queryUser(Integer.parseInt(userNum));
	            if(m==Integer.parseInt(userNum)){
	                response.sendRedirect("../addUser.jsp?submit=no");//已有用户添加失败并跳转
	            }
	            else {
	            	uD.addUser(u);
	                response.sendRedirect("../addUser.jsp?submit=yes");//添加成功
	            }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			response.sendRedirect("../addUser.jsp?submit=allnull");
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
