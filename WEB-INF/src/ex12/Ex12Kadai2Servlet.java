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
 * Servlet implementation class Ex12Kadai1Servlet
 */
@WebServlet("/ex12/Ex12Kadai2Servlet")
public class Ex12Kadai2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * ログインIDで正しい値
	 */
	private static String USERID = "kouka";

	private static String PASSWORD = "teu";


    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex12Kadai2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				response.setContentType("text/html; charset=UTF-8");

				//kadai1login.jspにて入力されたログインID値を取得
				String id = request.getParameter("loginid");

				//パスワード取得
				String password = request.getParameter("loginpassword");

				//転送先のページのパス
				String path;
				/**
				 * ポイント: sessionを取得する処理を1行で書いてください．
				 * どこから取得するのでしたかね？
				 */
				HttpSession session = request.getSession();

				//ログインチェック
				if((id.equals(USERID)) && (password.equals(PASSWORD))) {
					//正しければ正解用のパスを設定
					/**
					 * ポイント: WEB-INF/ex12/kadai2success.jspを呼び出すように，
					 * ここでの適切なpathを設定してください．
					 */
					path = "/WEB-INF/ex12/kadai2success.jsp";

					/**
					 * ポイント: HashMapを，ジェネリクス無しでインスタンス化してください．変数名はmapということで．
					 * そして，
					 * id: 入力されたidの値
					 * password: 入力されたpasswordの値,
					 * name: 工科太郎
					 * address: 東京都八王子市片倉町
					 * gender: 男性
					 * というkey/valueをmapへputさせてください．
					 */
					HashMap map = new HashMap();
					map.put("id", id);
					map.put("password", password);
					map.put("name", "工科太郎");
					map.put("address", "東京都八王子市片倉町");
					map.put("gender", "男性");

					/**
					 * ポイント: sessionに，キーとして"info", 値としてmapをセットする処理を1行で書いてください．
					 *
					 */
					session.setAttribute("info", map);

					RequestDispatcher dispatcher = request.getRequestDispatcher(path);
					dispatcher.forward(request, response);

				}else {
					//ログイン失敗時は，失敗用のパスを設定
					/**
					 * ポイント: WEB-INF/ex12/kadai2failure.jspを呼び出すように，
					 * ここでの適切なpathを設定してください．
					 */
					path = "/WEB-INF/ex12/kadai2failure.jsp";
					/**
					 * ポイント: ログインに失敗すれば，セッションを無効化（破棄）する処理
					 * を書いてください．一行で．
					 */
					session.invalidate();

					RequestDispatcher dispatcher = request.getRequestDispatcher(path);
					dispatcher.forward(request, response);
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
