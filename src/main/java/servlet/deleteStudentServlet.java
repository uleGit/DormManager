package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StudentDao;
import entity.Student;

/**
 * Servlet implementation class deleteStudentServlet
 */
@WebServlet("/deleteStudentServlet")
public class deleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteStudentServlet() {
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
		
		String dT = request.getParameter("deleteType");
		String dN = request.getParameter("deleteNo");
		for(int i=0; i<dN.length();i++) {
			char num[] = dN.toCharArray();
			if(!Character.isDigit(num[i])) {
				response.sendRedirect("../deleteStudent.jsp?submit=dt");
				return;
			}
		}
		StudentDao sd = new StudentDao();
		
		if(dN!=null&&dN.length()>0) {
			if(dT!=null&&dT.equals("sno")) {
				try {
					int sno = sd.query_sno(Integer.parseInt(dN));
					if(sno==Integer.parseInt(dN)) {
						sd.delStudent(sno);
						response.sendRedirect("../deleteStudent.jsp?submit=yes");
					}else {
						response.sendRedirect("../deleteStudent.jsp?submit=no");
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if(dT!=null&&dT.equals("dor")) {
				try {
					int dor = sd.query_dor(Integer.parseInt(dN));
					if(dor==Integer.parseInt(dN)) {
						sd.delStudent_dor(dor);
						response.sendRedirect("../deleteStudent.jsp?submit=yes");
					}else {
						response.sendRedirect("../deleteStudent.jsp?submit=no");
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if(dT!=null&&dT.equals("cno")) {
				try {
					int cno = sd.query_cno(Integer.parseInt(dN));
					if(cno==Integer.parseInt(dN)) {
						sd.delStudent_cno(cno);
						response.sendRedirect("../deleteStudent.jsp?submit=yes");
					}else {
						response.sendRedirect("../deleteStudent.jsp?submit=no");
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else {
			response.sendRedirect("../deleteStudent.jsp?submit=nonull");
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
