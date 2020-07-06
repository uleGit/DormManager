package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MessageDao;
import entity.Message;

/**
 * Servlet implementation class addMessageServlet
 */
@WebServlet("/addMessageServlet")
public class addMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addMessageServlet() {
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
		String userNum = request.getParameter("usernum");
		for(int i=0; i<userNum.length();i++) {
			char num[] = userNum.toCharArray();
			if(!Character.isDigit(num[i])) {
				response.sendRedirect("../addMessage.jsp?submit=userNum");
				return;
			}
		}
		String messNo = request.getParameter("messno");
		for(int i=0; i<messNo.length();i++) {
			char num[] = messNo.toCharArray();
			if(!Character.isDigit(num[i])) {
				response.sendRedirect("../addMessage.jsp?submit=messNo");
				return;
			}
		}
		String outLine = request.getParameter("outline");
		String content = request.getParameter("content");
		if(userNum.length()>0&&messNo.length()>0&&outLine.length()>0&&content.length()>0) {
			Message mess = new Message();
			mess.setUserNum(Integer.parseInt(userNum));
			mess.setMessno(Integer.parseInt(messNo));
			mess.setOutline(outLine);
			mess.setContent(content);
			
			try {
				MessageDao md = new MessageDao();
				md.addMessage(mess);
				response.sendRedirect("../addMessage.jsp?submit=yes");
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			response.sendRedirect("../addMessage.jsp?submit=no");
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
