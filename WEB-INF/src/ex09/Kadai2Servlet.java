package ex09;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import java.util.Properties;
import java.sql.DriverManager;

/**
 * Servlet implementation class Kadai2Servlet
 */
/**
 * ポイント:
 * http://localhost:8080/javabweb/kadai2/Kadai2Servlet で
 * アクセスできるように，@WebServlet内のURLパターンを設定してください．
 */
@WebServlet("/kadai2/Kadai2Servlet")
/**
 * ポイント:
 * Kadai2Servletがサーブレットとして動作させるために，
 * extends以降に，継承すべきスーパークラスのクラス名(javax内で提供されているクラス）
 * を書いてください．
 *
 */
public class Kadai2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Kadai2Servlet() {
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
		try {
			/**
			 * ポイント: employee_id, first_name, last_nameを，employeesテーブルから取得するSQL文をかいてください．
			 * この3つのカラムだけを取得させるようにしてください．
			 */
			ResultSet rs = this.executeSelectSQL("SELECT employee_id, first_name, last_name from employees");
			out.println("<table><tr><td>employee_id</td><td>first_name</td><td>last_name</tr>");
			while (rs.next()) {
				/**
				 * ポイント: employee_id, first_name, last_nameをそれぞれ，reのgetStringメソッドによってそれぞれ
				 * 取得して格納させてください．
				 */
				String id = rs.getString("employee_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				out.println("<table><tr><td>" + id + "</td><td>" + first_name + "</td><td>" + last_name + "</td></tr>");

			}
			out.println("</table>");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ResultSet executeSelectSQL(String sql) {

		// プロパティ
		Properties prop = null;
		// 接続オブジェクト
		Connection con = null;
		// SQL文オブジェクト
		PreparedStatement stmt = null;
		// DB取得結果
		ResultSet rs = null;

		try {

			// JDBCドライバのロード
			Class.forName("com.mysql.cj.jdbc.Driver");
			// データベース接続
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/javab_db?serverTimezone=JST",
					"root", "");
			// SQL実行準備
			stmt = con.prepareStatement(sql);

			// 実行結果取得
			rs = stmt.executeQuery();

			return rs;

		} catch (Exception e) {
			e.printStackTrace();

		}
		return rs;
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
