package ex13;

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

/**
 * Servlet implementation class Ex13Kadai2Servlet
 */
@WebServlet("/ex13/Ex13Kadai2Servlet")
public class Ex13Kadai2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex13Kadai2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * ポイント: DeaprtmentsDAOを空の引数のコンストラクタを呼び出してインスタンス化してください．
		 */
		DepartmentsDAO dao = new DepartmentsDAO();
		/**
		 * ポイント: daoから，department_id, department_name, location_id
		 * を取得するメソッドを呼び出してrsへ格納させてください．
		 */
		ResultSet rs = dao.selectBasics();
		try {
			/**
			 * ポイント: 結果格納用リストArrayList<HashMap<String, String>>をインスタンス化してください．
			 */
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

			while(rs.next()) {
				/**
				 * department_id, department_name, location_idをそれぞれ，rsのgetStringメソッドによってそれぞれ
				 * 取得して格納させる．
				 */
				HashMap<String, String> map = new HashMap<String, String>();
				/**
				 * ポイント: department_id, department_name, location_idそれぞれを，rsからStringとして
				 * 取得して格納させてください．
				 */
				String department_id = rs.getString("department_id");
				String department_name = rs.getString("department_name");
				String location_id = rs.getString("location_id");

				/**
				 * ポイント: department_id, department_name, location_idそれぞれの値を
				 * mapへ格納させてください．名前は，"department_id", "department_name",
				 * "location_id"としてください．
				 */
				map.put("department_id", department_id);
				map.put("department_name", department_name);
				map.put("location_id", location_id);
				//Mapをlistへ追加する．
				list.add(map);

			}
			/**
			 * ポイント: requestにおいて，"retList"という名前で，listをセット
			 * させてください．(setAttributeメソッドを呼び出す）
			 */
			request.setAttribute("retList", list);
			String path = "/WEB-INF/ex13/ex13kadai2result.jsp";
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
