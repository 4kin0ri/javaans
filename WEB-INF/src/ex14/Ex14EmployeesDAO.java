package ex14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Ex14EmployeesDAO {


	private Connection con;



	/**
	 * コンストラクタ
	 * インスタンス化時に，予め問い合わせ可能状態としておく．
	 */
	public Ex14EmployeesDAO() {
		try {
            //Connectionを取得する．
            //JDBCドライバのロード
			Class.forName("com.mysql.cj.jdbc.Driver");
			//DBの接続
			this.con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/javab_db?serverTimezone=JST","projava","projava");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 検索キーワードで，first_nameの一部がそれを含んでいる
	 * ものをSELECTします．
	 * @param sql
	 * @return
	 */
	public ResultSet selectByFirstName(String keyword) {
		//SQL文オブジェクト
		PreparedStatement stmt = null;
		//DB取得結果
		ResultSet rs = null;
		/**
		 * first_nameに，keywordを含むレコードを取得する．
		 */
		String sql = "SELECT * from employees WHERE first_name LIKE '%"+ keyword + "%'";
		try {
			/**
			 * ポイント:
			 * conから，stmtに，sqlを指定して格納してください．
			 */
			stmt = con.prepareStatement(sql);
			/**
			 * ポイント: stmtによって，SQLを実行させてrsへ結果を格納させてください．
			 */
			rs = stmt.executeQuery();
			System.out.println("test");

			return rs;

		} catch (Exception e) {
			e.printStackTrace();


		}
		return rs;
	}

}
