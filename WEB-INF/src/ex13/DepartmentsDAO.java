package ex13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class DepartmentsDAO {

	private Connection con;


	/**
	 * コンストラクタ
	 * インスタンス化時に，予め問い合わせ可能状態としておく．
	 */
	public DepartmentsDAO() {
		try {
			//認証ファイルから，DB接続用IDを取得．
			//VSCodeの場合は，ID/passを，projava/projavaにしてください．
			String db_id = "projava";
			//パスワードを取得
			String db_password = "projava";

			//JDBCドライバのロード
			Class.forName("com.mysql.cj.jdbc.Driver");
			//DBの接続
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javab_db?serverTimezone=JST",
					db_id, db_password);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * SQL実行部
	 * @param sql
	 * @return
	 */
	public ResultSet selectBasics() {
		//SQL文オブジェクト
		PreparedStatement stmt = null;
		//DB取得結果
		ResultSet rs = null;
		/**
		 * ポイント:
		 * departmentsテーブルから，department_id, department_name, location_id
		 * を取得するSQL文を作ってください．
		 */
		String sql = "SELECT department_id, department_name, location_id from departments";
		try {
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
