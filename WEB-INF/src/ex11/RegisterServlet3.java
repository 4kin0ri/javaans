package ex11;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet3
 */
@WebServlet("/ex11/RegisterServlet3")
public class RegisterServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet3() {
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
		//パスワードを取得
		String pass = request.getParameter("password");

		//nameを設定
		request.setAttribute("result_name", name);
		//性別の数値を設定
		request.setAttribute("result_gender", str_gender);
		//パスワードを設定
		request.setAttribute("result_password", pass);

		RequestDispatcher dispatcher = request.
				getRequestDispatcher("/WEB-INF/ex11/result2.jsp");
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
