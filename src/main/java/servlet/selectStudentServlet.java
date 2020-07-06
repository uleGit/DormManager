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
import entity.Student;

/**
 * Servlet implementation class selectStudentServlet
 */
@WebServlet("/selectStudentServlet")
public class selectStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectStudentServlet() {
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
		
		String sT = request.getParameter("selectType");
		String sN = request.getParameter("selectNo");
		ArrayList<Student> stus = new ArrayList<Student>();
		StudentDao sd = new StudentDao();
		
		if(sT!=null&&sT.equals("sno")&&sN!=null&&sN.length()>0) {
			for(int j=0; j<sN.length();j++) {
				char num[] = sN.toCharArray();
				if(!Character.isDigit(num[j])) {
					response.sendRedirect("../selectStudent.jsp?error=yes");
					return;
				}
			}
			stus = sd.querySno(Integer.parseInt(sN));
		}else if(sT!=null&&sT.equals("sname")&&sN!=null&&sN.length()>0) {
			stus = sd.querySname(sN);
		}else if(sT!=null&&sT.equals("dor")&&sN!=null&&sN.length()>0) {
			stus = sd.queryDor(Integer.parseInt(sN));
		}else if(sT!=null&&sT.equals("cno")&&sN!=null&&sN.length()>0) {
			stus = sd.queryCno(Integer.parseInt(sN));
		}else {
			response.sendRedirect("../selectStudent.jsp?error=yes");
			return;
		}
	
		if(stus!=null&&stus.size()>0) {
			session.setAttribute("stus", stus);
			response.sendRedirect("../student.jsp");
		}else {
			response.sendRedirect("../selectStudent.jsp?error=yes");
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
