package ex12;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionBeanServlet
 */
@WebServlet("/ex12/SessionMapServlet")
public class SessionMapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionMapServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		//nameの値を取得
		String name = request.getParameter("name");
		//genderの値を取得．Stringで取得するので，それをint型に変換しておく．
		int gender = Integer.valueOf(request.getParameter("gender")).intValue();
		String str_gender = null;
		switch(gender) {
		case 0:
			str_gender = "男性";
			break;
		case 1:
			str_gender = "女性";
			break;
		default:
			break;

		}

		//セッションを取得
		HttpSession session = request.getSession();
		//HashMapをインスタンス化
		HashMap map = new HashMap();
		map.put("name", name);
		map.put("gender", str_gender);

		//セッションにJavaBean自体を設定
		session.setAttribute("userinfo", map);

		RequestDispatcher dispatcher = request.
				getRequestDispatcher("/WEB-INF/ex12/result3.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
