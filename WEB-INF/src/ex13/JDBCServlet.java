package ex13;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JDBCServlet
 */
@WebServlet("/ex13/JDBCServlet")
public class JDBCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public JDBCServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		try {
			/**
			 * ポイント: employee_id, first_name, last_nameを，employeesテーブルから取得するSQL文
			 * この3つのカラムだけを取得させる
			 */
			ResultSet rs = this.executeSelectSQL("SELECT employee_id, first_name, last_name from employees");
			out.println("<table><tr><td>employee_id</td><td>first_name</td><td>last_name</tr>");
			while(rs.next()) {
				/**
				 * employee_id, first_name, last_nameをそれぞれ，rsのgetStringメソッドによってそれぞれ
				 * 取得して格納させる．
				 */
				String id = rs.getString("employee_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				out.println("<table><tr><td>"+id+"</td><td>"+first_name+"</td><td>"+last_name+"</td></tr>");

			}
			out.println("</table>");
		}catch(Exception e) {
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

	public ResultSet executeSelectSQL(String sql) {

		//接続オブジェクト
		Connection con = null;
		//SQL文オブジェクト
		PreparedStatement stmt = null;
		//DB取得結果
		ResultSet rs = null;

		try {
			//認証ファイルから，DB接続用IDを取得．
			//VSCodeの場合は，ID/passを，projava/projavaにしてください．
			String db_id = "projava";
			//パスワードを取得
			String db_password = "projava";

			//SQL文の用意
			//String sql = "SELECT * FROM employees";
			//JDBCドライバのロード
			Class.forName("com.mysql.cj.jdbc.Driver");
			//DBの接続
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javab_db?serverTimezone=JST",
					db_id, db_password);
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

}
