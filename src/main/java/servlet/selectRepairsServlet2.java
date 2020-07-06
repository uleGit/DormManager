package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RepairsDao;
import entity.Repairs;

/**
 * Servlet implementation class selectRepairsServlet
 */
@WebServlet("/selectRepairsServlet2")
public class selectRepairsServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectRepairsServlet2() {
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
		
		String s1 = request.getParameter("selectType");
		Repairs re = new Repairs();
		RepairsDao rd = new RepairsDao();
		ArrayList<Repairs> res = new ArrayList<Repairs>();
		
		if(s1!=null&&s1.length()>0&&s1.equals("0")) {
			String s2 = request.getParameter("budNo");
			for(int j=0; j<s2.length();j++) {
				char num[] = s2.toCharArray();
				if(!Character.isDigit(num[j])) {
					response.sendRedirect("../selectRepair2.jsp?error=budno");
					return;
				}
			}
			if(s2!=null&&s2.length()>0) {
				try {
					int i = rd.querybud(Integer.parseInt(s2));
					if(i==Integer.parseInt(s2)) {
						res = rd.queryRepairs(Integer.parseInt(s2));
						session.setAttribute("res", res);
						response.sendRedirect("../repairs2.jsp");
					}else {
						response.sendRedirect("../selectRepair2.jsp?error=budno");
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("../selectRepair2.jsp?error=budnonull");
			}
		}else if(s1!=null&&s1.length()>0&&s1.equals("1")){
			String s3 = request.getParameter("budNo2");
			for(int i=0; i<s3.length();i++) {
				char num[] = s3.toCharArray();
				if(!Character.isDigit(num[i])) {
					response.sendRedirect("../selectRepair2.jsp?error=budno");
					return;
				}
			}
			if(s3!=null&&s3.length()>0) {
				try {
					int i = rd.querybud(Integer.parseInt(s3));
					if(i==Integer.parseInt(s3)) {
						String s4 = request.getParameter("dorNo");
						for(int j=0; j<s4.length();j++) {
							char num[] = s4.toCharArray();
							if(!Character.isDigit(num[j])) {
								response.sendRedirect("../selectRepair2.jsp?error=dor");
								return;
							}
						}
						if(s4!=null&&s4.length()>0) {
							int j = rd.querydor(Integer.parseInt(s4));
							if(j==Integer.parseInt(s4)) {
								res = rd.queryRepairs(Integer.parseInt(s3),Integer.parseInt(s4));
								session.setAttribute("res", res);
								response.sendRedirect("../repairs2.jsp");
							}else {
								response.sendRedirect("../selectRepair2.jsp?error=dor");
							}
						}else {
							response.sendRedirect("../selectRepair2.jsp?error=dornull");
						}
					}else {
						response.sendRedirect("../selectRepair2.jsp?error=budno");
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("../selectRepair2.jsp?error=budnonull");
			}
			
		}else {
			response.sendRedirect("../selectRepair.jsp?error=budnonull");
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
