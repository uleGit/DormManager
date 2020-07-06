package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RepairsDao;
import entity.Repairs;

/**
 * Servlet implementation class addRepairServlet
 */
@WebServlet("/addRepairServlet")
public class addRepairServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addRepairServlet() {
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
		
		String budno = request.getParameter("budno");
		for(int i=0; i<budno.length();i++) {
			char num[] = budno.toCharArray();
			if(!Character.isDigit(num[i])) {
				response.sendRedirect("../addRepair.jsp?error=budno");
				return;
			}
		}
		String dor = request.getParameter("dor");
		for(int i=0; i<dor.length();i++) {
			char num[] = dor.toCharArray();
			if(!Character.isDigit(num[i])) {
				response.sendRedirect("../addRepair.jsp?error=dor");
				return;
			}
		}
		String detail = request.getParameter("detail");
		String result = request.getParameter("result");
		
		Repairs r = new Repairs();
		RepairsDao rd = new RepairsDao();
		
		if(budno!=null&&budno.length()>0) {
			r.setBudno(Integer.parseInt(budno));
			if(dor!=null&&dor.length()>0) {
				r.setDor(Integer.parseInt(dor));
				if(detail!=null&&detail.length()>0) {
					r.setDetail(detail);
					if(result!=null&&result.length()>0) {
						r.setResult(result);
						try {
							rd.addRepair(r);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						response.sendRedirect("../addRepair.jsp?error=no");//成功
					}else {
						response.sendRedirect("../addRepair.jsp?error=resultnull");//结果为空
					}
				}else {
					response.sendRedirect("../addRepair.jsp?error=detailnull");//详情为空
				}
			}else {
				response.sendRedirect("../addRepair.jsp?error=dornull");//宿舍号为空
			}
			
		}else {
			response.sendRedirect("../addRepair.jsp?error=budnonull");//楼号为空
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
