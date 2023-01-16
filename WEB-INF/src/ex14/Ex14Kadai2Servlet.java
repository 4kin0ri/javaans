package ex14;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 期末課題2:
 * ブラウザ上で，指定の条件で顧客情報を出力します．さらに，
 * セッションにて保持された情報を，特定条件でソートした結果を出力します．
 * 関連する授業内容: 第11~13回
 *
 */
@WebServlet("/ex14/Ex14Kadai2Servlet")
public class Ex14Kadai2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex14Kadai2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");


		/**
		 * ポイント: page1.jspから渡された検索キーワード値を取得する
		 * ように，request以降に，適切なものを書いてください．
		 */
		String f_name = request.getParameter("first_name");

		Ex14EmployeesDAO dao = new Ex14EmployeesDAO();

		/**
		 * ポイント: Ex14EmployeesDAO.javaを見て，first_nameに関する検索結果を
		 * rs内に格納させるように適切なメソッドを呼び出してください．
		 */
		ResultSet rs = dao.selectByFirstName(f_name);

		/**
		 * ポイント: <HashMap<String, Object>を要素にもつArrayListをインスタンス化してください．
		 */
		ArrayList<HashMap<String, Object>> userList = new ArrayList<>();

		/**
		 * ポイント: requestから，HttpSessionを取得してsessionへ格納させるようにしてください．
		 */
		HttpSession session = request.getSession();

		try {
			while(rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();

				/**
				 * ポイント:
				 * employee_idの値を，int型として取得して"int employee_id"へ格納させてください．
				 */
				int employee_id = rs.getInt("employee_id");

				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");

				/**
				 * ポイント:
				 * salaryの値を，int型として取得して"int salary"へ格納させてください．
				 */
				int salary = rs.getInt("salary");

				/**
				 * ポイント: mapに対して，それぞれ"employee_id"はemployee_idの値,
				 * "first_name"はfirst_nameの値，"last_name"はlast_nameの値，
				 * "salary"はsalaryの値を設定させてください．
				 *
				 */
				map.put("employee_id", employee_id);
				map.put("first_name", first_name);
				map.put("last_name", last_name);
				map.put("salary", salary);

				/**
				 * ポイント: userListに対して，mapを追加させてください．
				 */
				userList.add(map);
			}
			/**
			 * ポイント: userListを，"userList"という名前でsessionに格納してください．
			 */
			session.setAttribute("userList", userList);

			String path = "/WEB-INF/ex14/in_page2.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);


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

}
