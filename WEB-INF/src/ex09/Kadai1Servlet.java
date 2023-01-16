package ex09;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Kadai1Servlet
 */
/**
 * ポイント:
 * http://localhost:8080/javabweb/kadai1/Kadai1Servlet で
 * アクセスできるように，@WebServlet内のURLパターンを設定してください．
 */
@WebServlet("/kadai1/Kadai1Servlet")

/**
 * ポイント:
 * Kadai1Servletがサーブレットとして動作させるために，
 * extends以降に，継承すべきスーパークラスのクラス名(javax内で提供されているクラス）
 * を書いてください．
 *
 */
public class Kadai1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Kadai1Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * ポイント:
		 * responseのコンテンツタイプを
		 * text/html; charset=UTF-8
		 * として設定してください．
		 */
		response.setContentType("text/html; charset=UTF-8");
		/**
		 * ポイント: ↓の空白を埋めてください(request or responseから，PrintWriterオブジェクトを取得する処理）
		 */
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		/**
		 * ポイント: 自分の情報に変えてください
		 */
		out.println("学籍番号:C0A21145:" + "氏名:内野彰紀");
		out.println("<br>");
		// 1~6のサイコロの目を決める．
		Random random = new Random();
		int randomValue = random.nextInt(6) + 1;
		out.println("サイコロの目は" + randomValue + "です");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
