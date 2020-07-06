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
 * Servlet implementation class updateRepairsServlet
 */
@WebServlet("/updateRepairsServlet")
public class updateRepairsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateRepairsServlet() {
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
		
		Repairs re = (Repairs)session.getAttribute("updRe");
		
		String handler = request.getParameter("handler");
		String result = request.getParameter("result");
		
		re.setHandler(handler);
		re.setResult(result);
		
		RepairsDao rd = new RepairsDao();
		try {
			rd.updRepair(re);
			session.setAttribute("updRe", re);
			response.sendRedirect("../repairDetail.jsp?error=no");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
