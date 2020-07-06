package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MessageDao;
import dao.StudentDao;
import entity.Message;
import entity.Student;

/**
 * Servlet implementation class selectMessageServlet
 */
@WebServlet("/selectMessageServlet")
public class selectMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectMessageServlet() {
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
		String mess = request.getParameter("messno");
		for(int i=0; i<mess.length();i++) {
			char num[] = mess.toCharArray();
			if(!Character.isDigit(num[i])) {
				response.sendRedirect("../selectMessage.jsp?error=yes");
				return;
			}
		}
		MessageDao md = new MessageDao();
		if(mess!=null&&mess.length()>0) {
			int messno = md.query_messno(Integer.parseInt(mess));
				if(messno == Integer.parseInt(mess)&&messno!=0) {
				session.setAttribute("messno", messno);
				response.sendRedirect("../message.jsp");
				}else {
					response.sendRedirect("../selectMessage.jsp?error=yes");
				}
		}else {
			response.sendRedirect("../selectMessage.jsp?error=yes");
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
