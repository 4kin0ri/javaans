package ex13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class EmployeesDAO2 {
	private Connection con;



	/**
	 * コンストラクタ
	 * インスタンス化時に，予め問い合わせ可能状態としておく．
	 */
	public EmployeesDAO2() {
		try {
			//認証ファイルから，DB接続用IDを取得．
			String db_id = "projava";
			//パスワードを取得
			String db_password = "projava";

			//JDBCドライバのロード
			Class.forName("com.mysql.cj.jdbc.Driver");
			//DBの接続
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javab_db?serverTimezone=JST", db_id, db_password);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * SQL実行部
	 * @param sql
	 * @return
	 */
	public ArrayList<EmployeesDTO> selectBasicInfo() {
		//SQL文オブジェクト
		PreparedStatement stmt = null;
		//DB取得結果
		ResultSet rs = null;
		/**
		 * ポイント:
		 * 下記のSQLで，employee_id, first_name, last_nameの3つを取得する
		 * SQLにしてください．WHERE条件は不要です．
		 */
		String sql = "SELECT employee_id, first_name, last_name from employees";
		//DTOへ格納するためのループ
		ArrayList<EmployeesDTO> dtoList = new ArrayList<EmployeesDTO>();
		try {
			// SQL実行準備
			stmt = con.prepareStatement(sql);
			// 実行結果取得
			rs = stmt.executeQuery();

			while(rs.next()) {
				/**
				 * ポイント:
				 * EmployeesDTOをインスタンス化してください．空のコンストラクタ
				 * を呼び出す感じです．
				 */
				EmployeesDTO dto = new EmployeesDTO();
				String employee_id = rs.getString("employee_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				/**
				 * ポイント:
				 * dtoに，employee_id, first_name, last_name
				 * をそれぞれsetterメソッドによってsetさせてください．
				 */
				dto.setEmployee_id(employee_id);
				dto.setFirst_name(first_name);
				dto.setLast_name(last_name);
				/**
				 * ポイント:
				 * dtoListに，dtoを追加させてください．addメソッドです．
				 */
				dtoList.add(dto);
			}

			return dtoList;

		} catch (Exception e) {
			e.printStackTrace();


		}
		return null;

	}


}
