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
 * Servlet implementation class addStu_Servlet
 */
@WebServlet("/addStudentServlet")
public class addStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//添加学生信息
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String sno = request.getParameter("sno");
		for(int i=0; i<sno.length();i++) {
			char num[] = sno.toCharArray();
			if(!Character.isDigit(num[i])) {
				response.sendRedirect("../addStudent.jsp?error=sno");
				return;
			}
		}
		String sname = request.getParameter("sname");
		String budno = request.getParameter("budno");
		for(int i=0; i<budno.length();i++) {
			char num[] = budno.toCharArray();
			if(!Character.isDigit(num[i])) {
				response.sendRedirect("../addStudent.jsp?error=budno");
				return;
			}
		}
		String dor = request.getParameter("dor");
		for(int i=0; i<dor.length();i++) {
			char num[] = dor.toCharArray();
			if(!Character.isDigit(num[i])) {
				response.sendRedirect("../addStudent.jsp?error=dor");
				return;
			}
		}
		String bed = request.getParameter("bed");
		for(int i=0; i<bed.length();i++) {
			char num[] = bed.toCharArray();
			if(!Character.isDigit(num[i])) {
				response.sendRedirect("../addStudent.jsp?error=bed");
				return;
			}
		}
		String cno = request.getParameter("cno");
		for(int i=0; i<cno.length();i++) {
			char num[] = cno.toCharArray();
			if(!Character.isDigit(num[i])) {
				response.sendRedirect("../addStudent.jsp?error=cno");
				return;
			}
		}
		if(sno.length()>0&&sname.length()>0&&budno.length()>0&&dor.length()>0&&bed.length()>0&&cno.length()>0) {
			Student stu = new Student();
			stu.setSno(Integer.parseInt(sno));
			stu.setSname(sname);
			stu.setBudno(Integer.parseInt(budno));
			stu.setDor(Integer.parseInt(dor));
			stu.setBed(Integer.parseInt(bed));
			stu.setCno(Integer.parseInt(cno));
			
			try {
				StudentDao stuD = new StudentDao();
				int m = stuD.query_sno(Integer.parseInt(sno));
	            if(m==Integer.parseInt(sno)){
	                response.sendRedirect("../addStudent.jsp?error=no");//已有学生添加失败并跳转
	            }
	            else {
	            	stuD.addStudent(stu);
	                response.sendRedirect("../addStudent.jsp?error=yes");//添加成功
	            }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			response.sendRedirect("../addStudent.jsp?error=allnull");
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
