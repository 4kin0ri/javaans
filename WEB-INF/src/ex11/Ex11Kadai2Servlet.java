package ex11;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex11Kadai2Servlet
 */
@WebServlet("/ex11/Ex11Kadai2Servlet")
public class Ex11Kadai2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * ログインIDで正しい値
	 */
	private static String USERID = "kouka";

	private static String PASSWORD = "teu";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex11Kadai2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");

		//お菓子の値を取得
		/**
		 * ポイント: kadai2register.jspにて入力されたログインID値を取得するように，requestからパラメータ
		 * を取得して格納させてください（1行で）
		 */
		String id = request.getParameter("loginid");
		//果物の値を取得
		/**
		 * ポイント: kadai2register.jspにて入力されたパスワードの値を取得するように，requestからパラメータ
		 * を取得して格納させてください（1行で）
		 */
		String password = request.getParameter("loginpassword");

		//転送先のページのパス
		String path;

		//ログインチェック
		/**
		 * ポイント: idが，USERID(行22で定義)の値と等しい，かつ passwordが，PASSWORD(行24で定義)
		 * の値と等しい場合は，という判別式をifの中に書いてください．==は使わないでください．
		 */
		if((id.equals(USERID)) && (password.equals(PASSWORD))) {
			//正しければ正解用のパスを設定
			/**
			 * ポイント: WebContentにある，WEB-INFのex11の，kadai2success.jspを呼び出すように，
			 * ここでの適切なpathを設定してください．
			 */
			path = "/WEB-INF/ex11/kadai2success.jsp";
		}else {
			//ログイン失敗時は，失敗用のパスを設定
			/**
			 * ポイント: WebContentにある，WEB-INFのex11の，kadai2failure.jspを呼び出すように，
			 * ここでの適切なpathを設定してください．
			 */
			path = "/WEB-INF/ex11/kadai2failure.jsp";
		}

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
