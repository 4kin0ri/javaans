package ex14;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ex14Kadai22Servlet
 */
@WebServlet("/ex14/Ex14Kadai22Servlet")
public class Ex14Kadai22Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex14Kadai22Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		/**
		 * ポイント:
		 * requestから，セッションを取得させて，sessionへ格納してください．
		 */
		HttpSession session = request.getSession();
		/**
		 * ポイント: sessionから，"userList"という属性名の値を取得させてるように，session. の後に適切な内容を書いてください．
		 */
		ArrayList<HashMap<String, Object>> userList = (ArrayList<HashMap<String, Object>>)session.getAttribute("userList");

		/**
		 * ポイント:
		 * userListを，salaryの降順になるように，SalaryComparator()を用いてソートさせてください．
		 * 一行で書いてください．4回目の授業内容を参考に．
		 */
		Collections.sort(userList, new SalaryComparator());


		/**
		 * ポイント: sessionに，"userList"という属性名で，userList自体をセットさせてください．
		 */
		session.setAttribute("userList", userList);

		String path = "/WEB-INF/ex14/in_page3.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
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
