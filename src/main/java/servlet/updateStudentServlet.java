package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StudentDao;
import entity.Student;

/**
 * Servlet implementation class updateStudentServlet
 */
@WebServlet("/updateStudentServlet")
public class updateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateStudentServlet() {
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
		
		Student s = (Student)session.getAttribute("updStu");
		String sno = request.getParameter("sno");
		for(int i=0; i<sno.length();i++) {
			char num[] = sno.toCharArray();
			if(!Character.isDigit(num[i])) {
				response.sendRedirect("../stuDetail.jsp?error=sno");
				return;
			}
		}
		String sname = request.getParameter("sname");
		String budno = request.getParameter("budno");
		for(int i=0; i<budno.length();i++) {
			char num[] = budno.toCharArray();
			if(!Character.isDigit(num[i])) {
				response.sendRedirect("../stuDetail.jsp?error=budno");
				return;
			}
		}
		String dor = request.getParameter("dor");
		for(int i=0; i<dor.length();i++) {
			char num[] = dor.toCharArray();
			if(!Character.isDigit(num[i])) {
				response.sendRedirect("../stuDetail.jsp?error=dor");
				return;
			}
		}
		String bed = request.getParameter("bed");
		for(int i=0; i<bed.length();i++) {
			char num[] = bed.toCharArray();
			if(!Character.isDigit(num[i])) {
				response.sendRedirect("../stuDetail.jsp?error=bed");
				return;
			}
		}
		String cno = request.getParameter("cno");
		for(int i=0; i<cno.length();i++) {
			char num[] = cno.toCharArray();
			if(!Character.isDigit(num[i])) {
				response.sendRedirect("../stuDetail.jsp?error=cno");
				return;
			}
		}
		if(sno.length()>0&&sname.length()>0&&budno.length()>0&&dor.length()>0&&bed.length()>0&&cno.length()>0) {
			s.setSno(Integer.parseInt(sno));
			s.setSname(sname);
			s.setBudno(Integer.parseInt(budno));
			s.setDor(Integer.parseInt(dor));
			s.setBed(Integer.parseInt(bed));
			s.setCno(Integer.parseInt(cno));
			
			StudentDao sd = new StudentDao();
			try {
				sd.updStudent(s);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("upsStu", s);
			response.sendRedirect("../stuDetail.jsp?error=no");
		}else {
			response.sendRedirect("../stuDetail.jsp?error=allnull");
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
